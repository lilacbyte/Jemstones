package net.j.jemstones.entity.ai;

import net.j.jemstones.entity.Pepo;
import net.j.jemstones.entity.RoseQuartz;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import java.util.EnumSet;

public class FollowRoseGoal extends Goal {
    private final Pepo pepo;
    private RoseQuartz rose;
    private float oldWaterCost;

    public FollowRoseGoal(Pepo pepo) {
        this.pepo = pepo;
        setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        rose = pepo.getMaster();
        return rose != null && pepo.distanceToSqr(rose) > rose.getBbWidth() * 3 + 3;
    }

    @Override
    public boolean canContinueToUse() {
        return rose != null && rose.isAlive() && rose == pepo.getMaster()
                && !pepo.getNavigation().isDone()
                && pepo.distanceToSqr(rose) > rose.getBbWidth() * 3 + 3;
    }

    @Override
    public void start() {
        oldWaterCost = pepo.getPathfindingMalus(BlockPathTypes.WATER);
        pepo.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
    }

    @Override
    public void stop() {
        rose = null;
        pepo.getNavigation().stop();
        pepo.setPathfindingMalus(BlockPathTypes.WATER, oldWaterCost);
    }

    @Override
    public void tick() {
        if (rose != null) pepo.getNavigation().moveTo(rose, 1.0D);
    }
}
