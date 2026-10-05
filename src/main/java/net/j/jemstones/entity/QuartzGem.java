package net.j.jemstones.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public abstract class QuartzGem extends GemEntity {
    protected QuartzGem(EntityType<? extends QuartzGem> type, Level level) {
        super(type, level);
    }

    protected static AttributeSupplier.Builder createQuartzAttributes(double damage) {
        return createGemAttributes(150.0D, damage)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
    }
}
