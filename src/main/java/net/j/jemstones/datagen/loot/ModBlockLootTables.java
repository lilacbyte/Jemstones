package net.j.jemstones.datagen.loot;

import net.j.jemstones.block.ModBlocks;
import net.j.jemstones.item.ModItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
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
        dropOther(ModBlocks.ROCK_MELT.get(), Items.BLAZE_POWDER);
        add(ModBlocks.RUTILE_TRAIL.get(), noDrop());
        dropSelf(ModBlocks.WAVY_PINK_SANDSTONE_STAIRS.get());
        add(ModBlocks.GIANT_STRAWBERRY_STEM.get(), block -> createStemDrops(block, ModItems.STRAWBERRY_SEEDS.get()));
        add(ModBlocks.ATTACHED_GIANT_STRAWBERRY_STEM.get(), block -> createAttachedStemDrops(block, ModItems.STRAWBERRY_SEEDS.get()));
        dropSelf(ModBlocks.DRAINED_GRAVEL.get());
        add(ModBlocks.GIANT_STRAWBERRY.get(), block -> createSilkTouchDispatchTable(block,
                applyExplosionDecay(block, LootItem.lootTableItem(ModItems.STRAWBERRY_SLICE.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                        .apply(LimitCount.limitCount(IntRange.upperBound(9))))));
        dropSelf(ModBlocks.MOON_BLESSED_STONE.get());
        dropSelf(ModBlocks.DRAINED_BLOCK.get());
        dropSelf(ModBlocks.DRAINED_BLOCK_2.get());
        dropSelf(ModBlocks.DRAINED_BANDS.get());
        dropSelf(ModBlocks.SMOOTH_CARBONITE.get());
        dropSelf(ModBlocks.CHISELED_CARBONITE.get());
        dropSelf(ModBlocks.PINK_SANDSTONE.get());
        dropSelf(ModBlocks.WAVY_PINK_SANDSTONE.get());
        dropSelf(ModBlocks.SMOOTH_PINK_SANDSTONE.get());
        dropSelf(ModBlocks.CHISELED_PINK_SANDSTONE.get());
        dropSelf(ModBlocks.PINK_SANDSTONE_STAIRS.get());
        add(ModBlocks.PINK_SANDSTONE_SLAB.get(), this::createSlabItemTable);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
