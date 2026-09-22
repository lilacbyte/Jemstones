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
        simpleBlockWithItem(ModBlocks.DRAINED_BLOCK_2.get(), models().cubeColumn("drained_block_2",
                modLoc("block/drained_block_2_side"), modLoc("block/drained_block_2_top")).texture("particle", modLoc("block/drained_block_2_top")));
        simpleBlockWithItem(ModBlocks.DRAINED_BLOCK.get(), models().cubeColumn("drained_block",
                modLoc("block/drained_block_side"), modLoc("block/drained_block_top")).texture("particle", modLoc("block/drained_block_top")));
    }
}
