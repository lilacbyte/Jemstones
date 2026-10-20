package net.j.jemstones.entity.ai;

import net.j.jemstones.entity.Pepo;
import net.j.jemstones.entity.RoseQuartz;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

import java.util.EnumSet;

public class DefendRoseGoal extends TargetGoal {
    private final Pepo pepo;
    private LivingEntity attacker;
    private int timestamp;

    public DefendRoseGoal(Pepo pepo) {
        super(pepo, false);
        this.pepo = pepo;
        setFlags(EnumSet.of(Flag.TARGET));
    }

    @Override
    public boolean canUse() {
        RoseQuartz rose = pepo.getMaster();
        if (rose == null) return false;
        attacker = rose.getLastHurtByMob();
        return rose.getLastHurtByMobTimestamp() != timestamp
                && canAttack(attacker, TargetingConditions.DEFAULT);
    }

    @Override
    public void start() {
        pepo.setTarget(attacker);
        RoseQuartz rose = pepo.getMaster();
        if (rose != null) timestamp = rose.getLastHurtByMobTimestamp();
        super.start();
    }
}
