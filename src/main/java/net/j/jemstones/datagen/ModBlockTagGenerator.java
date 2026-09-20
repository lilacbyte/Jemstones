package net.j.jemstones.datagen;

import net.j.jemstones.Jemstones;
import net.j.jemstones.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Jemstones.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ROX_BLOCK.get(),
                        ModBlocks.TILE.get(),
                        ModBlocks.ROX_ORE.get(),
                        ModBlocks.DEEPSLATE_ROX_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.GARDEN_SOIL.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ROX_BLOCK.get(),
                        ModBlocks.TILE.get(),
                        ModBlocks.ROX_ORE.get(),
                        ModBlocks.DEEPSLATE_ROX_ORE.get());
    }
}
