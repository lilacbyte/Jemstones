package net.j.jemstones.item;

import net.j.jemstones.Jemstones;
import net.j.jemstones.block.ModBlocks;
import net.j.jemstones.entity.ModEntities;
import net.minecraftforge.common.ForgeSpawnEggItem;
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

    public static final RegistryObject<Item> MELON_SPAWN_EGG = ITEMS.register("melon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MELON, 0xB5B128, 0x5A671A, new Item.Properties()));

    public static final RegistryObject<Item> PUMPKIN_SPAWN_EGG = ITEMS.register("pumpkin_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.PUMPKIN, 0xD58116, 0x744E03, new Item.Properties()));

    public static final RegistryObject<Item> AMETHYST_GEM = ITEMS.register("amethyst_gem",
            () -> new QuartzGemItem(ModEntities.AMETHYST, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> CARNELIAN_GEM = ITEMS.register("carnelian_gem",
            () -> new QuartzGemItem(ModEntities.CARNELIAN, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> JASPER_GEM = ITEMS.register("jasper_gem",
            () -> new QuartzGemItem(ModEntities.JASPER, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> CHISELED_PINK_SANDSTONE = ITEMS.register("chiseled_pink_sandstone",
            () -> new BlockItem(ModBlocks.CHISELED_PINK_SANDSTONE.get(), new Item.Properties()));

    public static final RegistryObject<Item> SMOOTH_PINK_SANDSTONE = ITEMS.register("smooth_pink_sandstone",
            () -> new BlockItem(ModBlocks.SMOOTH_PINK_SANDSTONE.get(), new Item.Properties()));

    public static final RegistryObject<Item> WAVY_PINK_SANDSTONE = ITEMS.register("wavy_pink_sandstone",
            () -> new BlockItem(ModBlocks.WAVY_PINK_SANDSTONE.get(), new Item.Properties()));

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
