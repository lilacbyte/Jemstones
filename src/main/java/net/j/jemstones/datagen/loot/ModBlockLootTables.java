package net.j.jemstones.datagen.loot;

import net.j.jemstones.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)));
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.MOON_BLESSED_STONE.get());
        dropSelf(ModBlocks.DRAINED_BLOCK.get());
        dropSelf(ModBlocks.DRAINED_BLOCK_2.get());
        dropSelf(ModBlocks.DRAINED_BANDS.get());
        dropSelf(ModBlocks.SMOOTH_CARBONITE.get());
        dropSelf(ModBlocks.CHISELED_CARBONITE.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
