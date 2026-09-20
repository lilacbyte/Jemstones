package net.j.jemstones.datagen;

import net.j.jemstones.Jemstones;
import net.j.jemstones.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Jemstones.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ROX_BLOCK);
        blockWithItem(ModBlocks.TILE);
        blockWithItem(ModBlocks.GARDEN_SOIL);

        blockWithItem(ModBlocks.ROX_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ROX_ORE);

        simpleBlock(ModBlocks.LOVE_BERRIES.get(),
                models().cross(ModBlocks.LOVE_BERRIES.getId().getPath(), modLoc("block/love_berries")));


    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}