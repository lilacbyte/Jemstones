package net.j.jemstones.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DrainedGravelBlock extends FallingBlock {
    public DrainedGravelBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getDustColor(BlockState state, BlockGetter level, BlockPos pos) {
        return 4797768;
    }
}
