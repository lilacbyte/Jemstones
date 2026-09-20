package net.j.jemstones.datagen.loot;

import net.j.jemstones.block.ModBlocks;
import net.j.jemstones.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ROX_BLOCK.get());
        this.dropSelf(ModBlocks.TILE.get());
        this.dropSelf(ModBlocks.GARDEN_SOIL.get());
        this.dropSelf(ModBlocks.LOVE_BERRIES.get());

        this.add(ModBlocks.ROX_ORE.get(),
                block -> createOreDrop(ModBlocks.ROX_ORE.get(), ModItems.ROX.get()));
        this.add(ModBlocks.DEEPSLATE_ROX_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_ROX_ORE.get(), ModItems.ROX.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
