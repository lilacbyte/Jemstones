package net.j.jemstones.datagen;

import net.j.jemstones.Jemstones;
import net.j.jemstones.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Jemstones.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.MOON_BLESSED_STONE.get(), cubeAll(ModBlocks.MOON_BLESSED_STONE.get()));
        simpleBlockWithItem(ModBlocks.DRAINED_BLOCK.get(), models().cubeColumn("drained_block",
                modLoc("block/drained_block_side"), modLoc("block/drained_block_top"))
                .texture("particle", modLoc("block/drained_block_top")));
        simpleBlockWithItem(ModBlocks.DRAINED_BLOCK_2.get(), models().cubeColumn("drained_block_2",
                modLoc("block/drained_block_2_side"), modLoc("block/drained_block_2_top"))
                .texture("particle", modLoc("block/drained_block_2_top")));
        simpleBlockWithItem(ModBlocks.DRAINED_BANDS.get(), models().cubeColumn("drained_bands",
                modLoc("block/drained_bands_side"), modLoc("block/drained_block_top"))
                .texture("particle", modLoc("block/drained_block_top")));
        simpleBlockWithItem(ModBlocks.SMOOTH_CARBONITE.get(), cubeAll(ModBlocks.SMOOTH_CARBONITE.get()));
        simpleBlockWithItem(ModBlocks.CHISELED_CARBONITE.get(), models().cubeColumn("chiseled_carbonite",
                modLoc("block/chiseled_carbonite"), modLoc("block/smooth_carbonite"))
                .texture("particle", modLoc("block/smooth_carbonite")));
        simpleBlockWithItem(ModBlocks.PINK_SANDSTONE.get(), models().cubeBottomTop("pink_sandstone",
                modLoc("block/pink_sandstone_normal"), modLoc("block/pink_sandstone_bottom"),
                modLoc("block/pink_sandstone_top")));
        stairsBlock(ModBlocks.PINK_SANDSTONE_STAIRS.get(), modLoc("block/pink_sandstone_normal"),
                modLoc("block/pink_sandstone_bottom"), modLoc("block/pink_sandstone_top"));
        simpleBlockItem(ModBlocks.PINK_SANDSTONE_STAIRS.get(), models().getExistingFile(modLoc("block/pink_sandstone_stairs")));
        slabBlock(ModBlocks.PINK_SANDSTONE_SLAB.get(), modLoc("block/pink_sandstone"),
                modLoc("block/pink_sandstone_normal"), modLoc("block/pink_sandstone_bottom"),
                modLoc("block/pink_sandstone_top"));
        simpleBlockItem(ModBlocks.PINK_SANDSTONE_SLAB.get(), models().getExistingFile(modLoc("block/pink_sandstone_slab")));
    }
}
