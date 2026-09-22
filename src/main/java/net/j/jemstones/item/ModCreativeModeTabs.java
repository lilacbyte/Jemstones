package net.j.jemstones.item;

import net.j.jemstones.Jemstones;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Jemstones.MOD_ID);

    public static final RegistryObject<CreativeModeTab> JEMSTONES_TAB = CREATIVE_MODE_TABS.register("jemstones_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ACTIVATED_GEM_SHARD.get()))
                    .title(Component.translatable("creativetab.jemstones_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RUBY_GEM.get());
                        output.accept(ModItems.ACTIVATED_GEM_SHARD.get());
                        output.accept(ModItems.ACTIVATED_GEM_BASE.get());
                        output.accept(ModItems.INACTIVE_GEM_BASE.get());
                        output.accept(ModItems.MOON_BLESSED_STONE.get());
                        output.accept(ModItems.DRAINED_BLOCK.get());
                        output.accept(ModItems.DRAINED_BLOCK_2.get());
                        output.accept(ModItems.DRAINED_BANDS.get());
                        output.accept(ModItems.SMOOTH_CARBONITE.get());
                        output.accept(ModItems.CHISELED_CARBONITE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
