package net.j.jemstones;

import net.j.jemstones.block.ModBlocks;
import net.j.jemstones.item.ModCreativeModeTabs;
import net.j.jemstones.item.ModItems;
import net.j.jemstones.entity.ModEntities;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Jemstones.MOD_ID)
public class Jemstones {
    public static final String MOD_ID = "jemstones";

    public Jemstones(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
    }
}
