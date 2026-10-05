package net.j.jemstones.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;

public class Jasper extends QuartzGem {
    public Jasper(EntityType<? extends Jasper> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return createQuartzAttributes(16.0D);
    }
}
