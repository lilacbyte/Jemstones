package net.j.jemstones.item;

import net.j.jemstones.entity.GemEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class GemContractItem extends Item {
    private final boolean liberation;

    public GemContractItem(Properties properties, boolean liberation) {
        super(properties);
        this.liberation = liberation;
    }

    @Nullable
    public UUID getSigner(ItemStack stack) {
        var tag = stack.getTag();
        return tag != null && tag.hasUUID("ownerId") ? tag.getUUID("ownerId") : null;
    }

    private void sign(ItemStack stack, Player player) {
        if (getSigner(stack) != null) return;
        stack.getOrCreateTag().putUUID("ownerId", player.getUUID());
        stack.setHoverName(Component.translatable(getDescriptionId() + ".signedname", player.getName()));
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        super.onCraftedBy(stack, level, player);
        if (!level.isClientSide) sign(stack, player);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player == null || player.isSpectator()) return InteractionResult.FAIL;
        if (!context.getLevel().isClientSide) sign(context.getItemInHand(), player);
        return InteractionResult.sidedSuccess(context.getLevel().isClientSide);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        if (!(target instanceof GemEntity gem)) return InteractionResult.PASS;
        if (player.isSpectator() || !target.isAlive() || stack.isEmpty()) return InteractionResult.FAIL;
        UUID signer = getSigner(stack);
        if (!gem.isTame() || signer == null || !signer.equals(gem.getOwnerUUID())) {
            if (!player.level().isClientSide) {
                player.displayClientMessage(Component.translatable("message.jemstones.contract_wrong_owner"), true);
            }
            return InteractionResult.FAIL;
        }
        if (!player.level().isClientSide) {
            if (!liberation && player.getUUID().equals(gem.getOwnerUUID())) return InteractionResult.CONSUME;
            gem.setOwnerUUID(liberation ? null : player.getUUID());
            gem.setTame(!liberation);
            gem.setTarget(null);
            gem.setLastHurtByMob(null);
            gem.getNavigation().stop();
            if (!player.getAbilities().instabuild) stack.shrink(1);
            player.displayClientMessage(Component.translatable(liberation
                    ? "message.jemstones.gem_released" : "message.jemstones.gem_transferred", gem.getName()), true);
        }
        return InteractionResult.sidedSuccess(player.level().isClientSide);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return getSigner(stack) != null;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable(getSigner(stack) == null
                ? "tooltip.jemstones.contract_unsigned" : "tooltip.jemstones.contract_signed")
                .withStyle(ChatFormatting.GREEN));
    }
}
