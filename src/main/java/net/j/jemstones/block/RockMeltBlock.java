package net.j.jemstones.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RockMeltBlock extends Block {
    public RockMeltBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos below = pos.below();
        return level.getBlockState(below).isSolidRender(level, below);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighbor,
                                BlockPos neighborPos, boolean moving) {
        if (!canSurvive(state, level, pos)) {
            level.removeBlock(pos, false);
        }
    }
}
