package net.j.jemstones.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.j.jemstones.Jemstones;
import net.j.jemstones.entity.QuartzGem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class QuartzGemRenderer extends MobRenderer<QuartzGem, QuartzGemModel> {
    private final String kind;

    public QuartzGemRenderer(EntityRendererProvider.Context context, String kind, int skin, int hair,
                             int uniform, int gemColor, boolean markings) {
        super(context, new QuartzGemModel(context.bakeLayer(QuartzGemModel.LAYER)), 0.5F);
        this.kind = kind;
        // one original look for now
        addLayer(new TextureLayer(this, "skin", skin));
        if (markings) addLayer(new TextureLayer(this, "mark1_0_0", 0xED4A3C));
        addLayer(new TextureLayer(this, "uniform", uniform));
        addLayer(new TextureLayer(this, "insignia", 0x664C33));
        addLayer(new TextureLayer(this, "hair_0", hair));
        addLayer(new TextureLayer(this, "gems/3_1", gemColor));
    }

    private ResourceLocation texture(String name) {
        return ResourceLocation.tryBuild(Jemstones.MOD_ID, "textures/entities/" + kind + "/" + name + ".png");
    }

    @Override
    public ResourceLocation getTextureLocation(QuartzGem gem) {
        return texture(kind);
    }

    private static class TextureLayer extends RenderLayer<QuartzGem, QuartzGemModel> {
        private final ResourceLocation texture;
        private final int color;

        TextureLayer(QuartzGemRenderer renderer, String name, int color) {
            super(renderer);
            this.texture = renderer.texture(name);
            this.color = color;
        }

        @Override
        public void render(PoseStack pose, MultiBufferSource buffers, int light, QuartzGem gem,
                           float limbSwing, float limbAmount, float partialTick, float age,
                           float headYaw, float headPitch) {
            if (gem.isInvisible()) return;
            getParentModel().renderToBuffer(pose, buffers.getBuffer(RenderType.entityCutoutNoCull(texture)),
                    light, LivingEntityRenderer.getOverlayCoords(gem, 0.0F),
                    ((color >> 16) & 255) / 255.0F, ((color >> 8) & 255) / 255.0F,
                    (color & 255) / 255.0F, 1.0F);
        }
    }
}
