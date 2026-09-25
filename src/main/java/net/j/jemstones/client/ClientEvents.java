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
        event.registerLayerDefinition(QuartzGemModel.LAYER, QuartzGemModel::createBodyLayer);
        event.registerLayerDefinition(PepoModel.LAYER, PepoModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.RUBY.get(), RubyRenderer::new);
        event.registerEntityRenderer(ModEntities.JASPER.get(), context ->
                new QuartzGemRenderer(context, "jasper", 0xFFA351, 0xFFFCE8, 0xD87F33, 0xFF3F01, true));
        event.registerEntityRenderer(ModEntities.CARNELIAN.get(), context ->
                new QuartzGemRenderer(context, "carnelian", 0xE1764D, 0xF24807, 0x993333, 0xFF2D5D, false));
        event.registerEntityRenderer(ModEntities.AMETHYST.get(), context ->
                new QuartzGemRenderer(context, "amethyst", 0xB899CA, 0xF9E4FF, 0x999999, 0xDC64FD, false));
        event.registerEntityRenderer(ModEntities.MELON.get(), MelonRenderer::new);
        event.registerEntityRenderer(ModEntities.PUMPKIN.get(), PumpkinRenderer::new);
    }
}
