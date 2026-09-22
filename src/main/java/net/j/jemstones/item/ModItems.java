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
