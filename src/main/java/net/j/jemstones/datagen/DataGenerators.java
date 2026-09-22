package net.j.jemstones.datagen;

import net.j.jemstones.Jemstones;
import net.j.jemstones.datagen.loot.ModBlockLootTables;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Jemstones.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(event.includeServer(), ModBlockLootTables.create(generator.getPackOutput()));
        generator.addProvider(event.includeServer(), new ModBlockTagGenerator(generator.getPackOutput(),
                event.getLookupProvider(), event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(),
                new ModBlockStateProvider(generator.getPackOutput(), event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(),
                new ModItemModelProvider(generator.getPackOutput(), event.getExistingFileHelper()));
    }
}
