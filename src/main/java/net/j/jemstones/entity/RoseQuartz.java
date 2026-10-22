package net.j.jemstones.entity;

import net.j.jemstones.item.CrackedGemItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.Map;

public class RoseQuartz extends QuartzGem {
    private int regenerationTicks;
    private BlockPos lastSurgeLocation;
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
    public boolean hurt(DamageSource source, float amount) {
        boolean hurt = super.hurt(source, amount);
        if (hurt && !level().isClientSide) {
            if (isAlive()) awakenPepos();
            for (Pepo pepo : level().getEntitiesOfClass(Pepo.class,
                    getBoundingBox().inflate(16.0D, 4.0D, 16.0D), Pepo::isAlive)) {
                if (!pepo.hasMaster()) pepo.setMaster(this);
            }
        }
        return hurt;
    }

    private void awakenPepos() {
        BlockPos origin = blockPosition();
        boolean moved = lastSurgeLocation == null || origin.distSqr(lastSurgeLocation) > 16;
        lastSurgeLocation = origin;
        if (!moved || !ForgeEventFactory.getMobGriefingEvent(level(), this)) return;
        for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-8, -2, -8), origin.offset(8, 2, 8))) {
            if (!level().hasChunkAt(pos)) continue;
            var state = level().getBlockState(pos);
            Pepo pepo;
            if (state.is(Blocks.MELON)) {
                pepo = ModEntities.MELON.get().create(level());
            } else if (state.is(Blocks.PUMPKIN) || state.is(Blocks.CARVED_PUMPKIN)
                    || state.is(Blocks.JACK_O_LANTERN)) {
                Pumpkin pumpkin = ModEntities.PUMPKIN.get().create(level());
                if (pumpkin == null) continue;
                pumpkin.setLit(state.is(Blocks.JACK_O_LANTERN));
                pepo = pumpkin;
            } else {
                continue;
            }
            if (pepo == null) continue;
            pepo.setPos(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D);
            pepo.setHealth(pepo.getMaxHealth());
            pepo.setMaster(this);
            if (level().addFreshEntity(pepo) && !level().destroyBlock(pos, false, this)) {
                pepo.discard();
            }
        }
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
