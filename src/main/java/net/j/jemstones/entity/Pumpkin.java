package net.j.jemstones.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class Pumpkin extends Pepo {
    private static final EntityDataAccessor<Boolean> LIT =
            SynchedEntityData.defineId(Pumpkin.class, EntityDataSerializers.BOOLEAN);

    public Pumpkin(EntityType<? extends Pumpkin> type, Level level) {
        super(type, level);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(LIT, false);
    }

    public boolean isLit() {
        return entityData.get(LIT);
    }

    public void setLit(boolean lit) {
        entityData.set(LIT, lit);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("isLit", isLit());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setLit(tag.getBoolean("isLit"));
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (player.isSpectator()) return InteractionResult.PASS;
        ItemStack stack = player.getItemInHand(hand);
        if (!isLit() && !stack.is(Items.TORCH)) return super.mobInteract(player, hand);
        if (!level().isClientSide) {
            if (isLit()) {
                setLit(false);
                spawnAtLocation(Items.TORCH);
            } else {
                setLit(true);
                if (!player.getAbilities().instabuild) stack.shrink(1);
            }
        }
        return InteractionResult.sidedSuccess(level().isClientSide);
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHit) {
        super.dropCustomDeathLoot(source, looting, recentlyHit);
        spawnAtLocation(isLit() ? Items.JACK_O_LANTERN : Items.CARVED_PUMPKIN);
    }
}
