package net.j.jemstones.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MoonGoddessStatueBlock extends HorizontalDirectionalBlock {
    public static final IntegerProperty LIGHT = IntegerProperty.create("light", 0, 15);
    private static final VoxelShape NORTH = Block.box(5, 0, 6, 11, 15, 11);
    private static final VoxelShape SOUTH = Block.box(5, 0, 5, 11, 15, 10);
    private static final VoxelShape EAST = Block.box(5, 0, 5, 10, 15, 11);
    private static final VoxelShape WEST = Block.box(6, 0, 5, 11, 15, 11);

    public MoonGoddessStatueBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIGHT, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIGHT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SOUTH;
            case EAST -> EAST;
            case WEST -> WEST;
            default -> NORTH;
        };
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return rotate(state, mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos,
                        BlockState oldState, boolean moving) {
        if (!oldState.is(this)) {
            level.scheduleTick(pos, this, 1);
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        long time = level.getDayTime() % 24000;
        long fromMidnight = Math.abs(time - 18000);
        boolean fullMoon = level.getMoonPhase() == 0;
        int light = fullMoon && time >= 13800 && time <= 22200 ? (int) (15 - fromMidnight / 280) : 0;
        if (state.getValue(LIGHT) != light) {
            level.setBlock(pos, state.setValue(LIGHT, light), Block.UPDATE_ALL);
        }
        if (fullMoon && fromMidnight <= 280 && level.canSeeSky(pos)) {
            AABB range = new AABB(pos).inflate(16, level.getHeight(), 16);
            for (Player player : level.getEntitiesOfClass(Player.class, range)) {
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1, true, true));
            }
        }
        level.scheduleTick(pos, this, 1);
    }
}
