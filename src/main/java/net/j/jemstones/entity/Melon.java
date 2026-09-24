package net.j.jemstones.entity;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Melon extends Pepo {
    public Melon(EntityType<? extends Melon> type, Level level) {
        super(type, level);
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHit) {
        super.dropCustomDeathLoot(source, looting, recentlyHit);
        spawnAtLocation(new ItemStack(Items.MELON_SLICE, random.nextInt(5) + 3));
    }
}
