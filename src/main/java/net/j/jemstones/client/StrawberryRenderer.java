package net.j.jemstones.client;

import net.j.jemstones.Jemstones;
import net.j.jemstones.entity.Strawberry;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StrawberryRenderer extends MobRenderer<Strawberry, PepoModel<Strawberry>> {
    private static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(
            Jemstones.MOD_ID, "textures/entities/pepo/strawberry.png");

    public StrawberryRenderer(EntityRendererProvider.Context context) {
        super(context, new PepoModel<>(context.bakeLayer(PepoModel.LAYER)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(Strawberry strawberry) {
        return TEXTURE;
    }
}
