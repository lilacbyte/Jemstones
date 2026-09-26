package net.j.jemstones.block;

import net.j.jemstones.Jemstones;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Jemstones.MOD_ID);

    public static final RegistryObject<Block> MOON_BLESSED_STONE = BLOCKS.register("moon_blessed_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> DRAINED_BLOCK = BLOCKS.register("drained_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_PURPLE)
                    .strength(40.0F, 0.6F).pushReaction(PushReaction.BLOCK)));

    public static final RegistryObject<Block> DRAINED_BLOCK_2 = BLOCKS.register("drained_block_2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_PURPLE)
                    .strength(40.0F, 0.6F).pushReaction(PushReaction.BLOCK)));

    public static final RegistryObject<Block> DRAINED_BANDS = BLOCKS.register("drained_bands",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_PURPLE)
                    .strength(40.0F, 0.6F).pushReaction(PushReaction.BLOCK)));

    public static final RegistryObject<Block> SMOOTH_CARBONITE = BLOCKS.register("smooth_carbonite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_PURPLE)
                    .strength(80.0F, 1.2F).pushReaction(PushReaction.BLOCK)));

    public static final RegistryObject<Block> CHISELED_CARBONITE = BLOCKS.register("chiseled_carbonite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_PURPLE)
                    .strength(80.0F, 1.2F).pushReaction(PushReaction.BLOCK)));

    public static final RegistryObject<Block> PINK_SANDSTONE = BLOCKS.register("pink_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).mapColor(MapColor.COLOR_PINK)
                    .strength(0.8F, 2.4F)));

    public static final RegistryObject<StairBlock> PINK_SANDSTONE_STAIRS = BLOCKS.register("pink_sandstone_stairs",
            () -> new StairBlock(() -> PINK_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(PINK_SANDSTONE.get())));

    public static final RegistryObject<SlabBlock> PINK_SANDSTONE_SLAB = BLOCKS.register("pink_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(PINK_SANDSTONE.get())));

    public static final RegistryObject<Block> CHISELED_PINK_SANDSTONE = BLOCKS.register("chiseled_pink_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(PINK_SANDSTONE.get())));

    public static final RegistryObject<Block> SMOOTH_PINK_SANDSTONE = BLOCKS.register("smooth_pink_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(PINK_SANDSTONE.get())));

    public static final RegistryObject<Block> WAVY_PINK_SANDSTONE = BLOCKS.register("wavy_pink_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(PINK_SANDSTONE.get())));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
