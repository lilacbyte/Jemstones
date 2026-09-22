package net.j.jemstones.datagen;

import net.j.jemstones.Jemstones;
import net.j.jemstones.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup,
                                ExistingFileHelper existingFileHelper) {
        super(output, lookup, Jemstones.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.MOON_BLESSED_STONE.get(),
                ModBlocks.DRAINED_BLOCK.get(),
                ModBlocks.DRAINED_BLOCK_2.get(),
                ModBlocks.DRAINED_BANDS.get(),
                ModBlocks.SMOOTH_CARBONITE.get(),
                ModBlocks.CHISELED_CARBONITE.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(
                ModBlocks.DRAINED_BLOCK.get(),
                ModBlocks.DRAINED_BLOCK_2.get(),
                ModBlocks.DRAINED_BANDS.get(),
                ModBlocks.SMOOTH_CARBONITE.get(),
                ModBlocks.CHISELED_CARBONITE.get());
    }
}
