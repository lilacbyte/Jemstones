package net.j.jemstones.item;

import net.j.jemstones.Jemstones;
import net.j.jemstones.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Jemstones.MOD_ID);

    public static final RegistryObject<Item> RUBY_GEM = ITEMS.register("ruby_gem",
            () -> new RubyGemItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> MOON_BLESSED_STONE = ITEMS.register("moon_blessed_stone",
            () -> new BlockItem(ModBlocks.MOON_BLESSED_STONE.get(), new Item.Properties()));

    public static final RegistryObject<Item> DRAINED_BLOCK = ITEMS.register("drained_block",
            () -> new BlockItem(ModBlocks.DRAINED_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> DRAINED_BLOCK_2 = ITEMS.register("drained_block_2",
            () -> new BlockItem(ModBlocks.DRAINED_BLOCK_2.get(), new Item.Properties()));

    public static final RegistryObject<Item> DRAINED_BANDS = ITEMS.register("drained_bands",
            () -> new BlockItem(ModBlocks.DRAINED_BANDS.get(), new Item.Properties()));

    public static final RegistryObject<Item> SMOOTH_CARBONITE = ITEMS.register("smooth_carbonite",
            () -> new BlockItem(ModBlocks.SMOOTH_CARBONITE.get(), new Item.Properties()));

    public static final RegistryObject<Item> CHISELED_CARBONITE = ITEMS.register("chiseled_carbonite",
            () -> new BlockItem(ModBlocks.CHISELED_CARBONITE.get(), new Item.Properties()));

    public static final RegistryObject<Item> PINK_SANDSTONE = ITEMS.register("pink_sandstone",
            () -> new BlockItem(ModBlocks.PINK_SANDSTONE.get(), new Item.Properties()));

    public static final RegistryObject<Item> PINK_SANDSTONE_STAIRS = ITEMS.register("pink_sandstone_stairs",
            () -> new BlockItem(ModBlocks.PINK_SANDSTONE_STAIRS.get(), new Item.Properties()));

    public static final RegistryObject<Item> PINK_SANDSTONE_SLAB = ITEMS.register("pink_sandstone_slab",
            () -> new BlockItem(ModBlocks.PINK_SANDSTONE_SLAB.get(), new Item.Properties()));

    // behaviour comes later
    public static final RegistryObject<Item> ACTIVATED_GEM_SHARD = ITEMS.register("active_gem_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ACTIVATED_GEM_BASE = ITEMS.register("active_gem_base",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INACTIVE_GEM_BASE = ITEMS.register("inactive_gem_base",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
