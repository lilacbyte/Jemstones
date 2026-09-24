package net.j.jemstones.client;

import net.j.jemstones.Jemstones;
import net.j.jemstones.entity.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Jemstones.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(RubyModel.LAYER, RubyModel::createBodyLayer);
        event.registerLayerDefinition(PepoModel.LAYER, PepoModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.RUBY.get(), RubyRenderer::new);
        event.registerEntityRenderer(ModEntities.MELON.get(), MelonRenderer::new);
        event.registerEntityRenderer(ModEntities.PUMPKIN.get(), PumpkinRenderer::new);
    }
}
