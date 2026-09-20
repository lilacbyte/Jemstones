package net.j.jemstones.item;

import net.j.jemstones.Jemstones;
import net.j.jemstones.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Jemstones.MOD_ID);

    public static final RegistryObject<CreativeModeTab> JEMSTONES_TAB = CREATIVE_MODE_TABS.register("jemstones_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MOSHLING_EGG.get()))
                    .title(Component.translatable("creativetab.jemstones_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MOSHLING_EGG.get());
                        output.accept(ModItems.ROX.get());
                        output.accept(ModBlocks.ROX_BLOCK.get());
                        output.accept(ModBlocks.ROX_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_ROX_ORE.get());
                        output.accept(ModBlocks.TILE.get());
                        output.accept(ModBlocks.GARDEN_SOIL.get());
                        output.accept(ModBlocks.LOVE_BERRIES.get());


                            }
                            )
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
