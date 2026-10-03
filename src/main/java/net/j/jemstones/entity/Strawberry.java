package net.j.jemstones.entity;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.j.jemstones.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Strawberry extends Pepo {
    public Strawberry(EntityType<? extends Strawberry> type, Level level) {
        super(type, level);
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHit) {
        super.dropCustomDeathLoot(source, looting, recentlyHit);
        spawnAtLocation(new ItemStack(ModItems.STRAWBERRY_SLICE.get(), random.nextInt(5) + 3));
    }
}
