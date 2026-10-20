package net.j.jemstones.entity;

import net.j.jemstones.item.CrackedGemItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.Map;

public class RoseQuartz extends QuartzGem {
    private int regenerationTicks;
    private static final Map<Item, Item> RECIPES = Map.of(
            Items.POISONOUS_POTATO, Items.POTATO,
            Items.ROTTEN_FLESH, Items.LEATHER,
            Items.WHEAT, Items.BREAD);

    public RoseQuartz(EntityType<? extends RoseQuartz> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return createQuartzAttributes(8.0D);
    }

    @Override
    public void aiStep() {
        if (!level().isClientSide && isAlive()) {
            if (regenerationTicks > 80) {
                healNearbyAllies();
                regenerationTicks = 0;
            }
            regenerationTicks++;
        }
        if (!onGround() && getDeltaMovement().y < 0.0D) {
            setDeltaMovement(getDeltaMovement().multiply(1.0D, 0.5D, 1.0D));
        }
        super.aiStep();
    }

    private void healNearbyAllies() {
        AABB area = new AABB(getX(), getY(), getZ(), getX() + 1, getY() + 1, getZ() + 1)
                .inflate(16.0D, level().getHeight(), 16.0D);
        for (LivingEntity entity : level().getEntitiesOfClass(LivingEntity.class, area, LivingEntity::isAlive)) {
            boolean ally = isOwnedBy(entity);
            if (entity instanceof GemEntity gem) {
                if (getOwnerUUID() != null) {
                    ally |= isOwnerId(gem.getOwnerUUID());
                } else {
                    ally |= gem.getOwnerUUID() == null && isTame() == gem.isTame();
                }
            }
            if (ally) entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100));
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        boolean repairing = stack.getItem() instanceof CrackedGemItem;
        Item result = repairing ? ((CrackedGemItem) stack.getItem()).getRepairedItem() : RECIPES.get(stack.getItem());
        if (hand != InteractionHand.MAIN_HAND || result == null) return super.mobInteract(player, hand);
        if (player.isSpectator() || !isAlive() || stack.isEmpty() || !isOwnedBy(player)) {
            return InteractionResult.FAIL;
        }
        if (!level().isClientSide) {
            ItemStack output = new ItemStack(result);
            if (repairing && stack.hasTag()) output.setTag(stack.getTag().copy());
            if (spawnAtLocation(output, 1.0F) == null) return InteractionResult.FAIL;
            if (!player.getAbilities().instabuild) stack.shrink(1);
        }
        return InteractionResult.sidedSuccess(level().isClientSide);
    }
}
