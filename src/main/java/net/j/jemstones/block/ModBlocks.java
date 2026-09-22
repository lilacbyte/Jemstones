package net.j.jemstones.block;

import net.j.jemstones.Jemstones;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Jemstones.MOD_ID);

    public static final RegistryObject<Block> MOON_BLESSED_STONE = BLOCKS.register("moon_blessed_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
