package net.j.jemstones.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public abstract class Pepo extends PathfinderMob {
    protected Pepo(EntityType<? extends Pepo> type, Level level) {
        super(type, level);
        setPersistenceRequired();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.6D);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
        goalSelector.addGoal(3, new MoveTowardsTargetGoal(this, 0.414D, 32.0F));
        // rose following comes with rose quartz
        goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        goalSelector.addGoal(7, new RandomStrollGoal(this, 0.6D));
        goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 16.0F));
        goalSelector.addGoal(8, new LookAtPlayerGoal(this, Monster.class, 16.0F));
        goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        targetSelector.addGoal(3, new HurtByTargetGoal(this));
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
}
