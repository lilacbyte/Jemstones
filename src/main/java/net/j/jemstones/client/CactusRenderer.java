package net.j.jemstones.client;

import net.j.jemstones.Jemstones;
import net.j.jemstones.entity.Cactus;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CactusRenderer extends MobRenderer<Cactus, PepoModel<Cactus>> {
    private static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(
            Jemstones.MOD_ID, "textures/entities/pepo/cactus.png");

    public CactusRenderer(EntityRendererProvider.Context context) {
        super(context, new PepoModel<>(context.bakeLayer(PepoModel.LAYER)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(Cactus cactus) {
        return TEXTURE;
    }
}
