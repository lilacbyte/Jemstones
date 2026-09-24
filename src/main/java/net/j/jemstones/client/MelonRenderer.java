package net.j.jemstones.client;

import net.j.jemstones.Jemstones;
import net.j.jemstones.entity.Melon;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MelonRenderer extends MobRenderer<Melon, PepoModel<Melon>> {
    private static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(
            Jemstones.MOD_ID, "textures/entities/pepo/melon.png");

    public MelonRenderer(EntityRendererProvider.Context context) {
        super(context, new PepoModel<>(context.bakeLayer(PepoModel.LAYER)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(Melon melon) {
        return TEXTURE;
    }
}
