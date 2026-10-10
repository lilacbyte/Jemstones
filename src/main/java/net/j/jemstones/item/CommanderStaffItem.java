package net.j.jemstones.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class CommanderStaffItem extends Item {
    public CommanderStaffItem(Properties properties) {
        super(properties);
    }

    @Nullable
    public UUID getOwner(ItemStack stack) {
        var tag = stack.getTag();
        return tag != null && tag.hasUUID("ownerId") ? tag.getUUID("ownerId") : null;
    }

    private void bind(ItemStack stack, Player player) {
        if (getOwner(stack) != null) return;
        stack.getOrCreateTag().putUUID("ownerId", player.getUUID());
        stack.setHoverName(Component.translatable(getDescriptionId() + ".signedname", player.getName()));
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        super.onCraftedBy(stack, level, player);
        if (!level.isClientSide) bind(stack, player);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player == null || player.isSpectator()) return InteractionResult.FAIL;
        if (!context.getLevel().isClientSide) bind(context.getItemInHand(), player);
        return InteractionResult.sidedSuccess(context.getLevel().isClientSide);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return getOwner(stack) != null;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable(getOwner(stack) == null
                ? "tooltip.jemstones.staff_unbound" : "tooltip.jemstones.staff_bound")
                .withStyle(ChatFormatting.GREEN));
    }
}
