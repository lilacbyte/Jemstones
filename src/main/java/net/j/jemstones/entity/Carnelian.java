package net.j.jemstones.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;

public class Carnelian extends QuartzGem {
    public Carnelian(EntityType<? extends Carnelian> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return createQuartzAttributes(12.0D);
    }
}
