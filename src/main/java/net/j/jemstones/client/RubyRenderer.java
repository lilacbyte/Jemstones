package net.j.jemstones.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.j.jemstones.Jemstones;
import net.j.jemstones.entity.Ruby;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class RubyRenderer extends MobRenderer<Ruby, RubyModel> {
    public RubyRenderer(EntityRendererProvider.Context context) {
        super(context, new RubyModel(context.bakeLayer(RubyModel.LAYER)), 0.3F);
        // one original look for now
        addLayer(new TextureLayer(this, "skin", 0xE52C5C));
        addLayer(new TextureLayer(this, "uniform", 0x993333));
        addLayer(new TextureLayer(this, "insignia", 0x664C33));
        addLayer(new TextureLayer(this, "hair_forehead", 0x3A0015));
        addLayer(new TextureLayer(this, "gems/1_1", 0xFFFFFF));
    }

    private static ResourceLocation texture(String name) {
        return ResourceLocation.tryBuild(Jemstones.MOD_ID, "textures/entities/ruby/" + name + ".png");
    }

    @Override
    public ResourceLocation getTextureLocation(Ruby ruby) {
        return texture("ruby");
    }

    @Override
    protected void scale(Ruby ruby, PoseStack pose, float partialTick) {
        pose.scale(0.8F, 0.8F, 0.8F);
    }

    private static class TextureLayer extends RenderLayer<Ruby, RubyModel> {
        private final ResourceLocation texture;
        private final int color;

        TextureLayer(RubyRenderer renderer, String name, int color) {
            super(renderer);
            this.texture = texture(name);
            this.color = color;
        }

        @Override
        public void render(PoseStack pose, MultiBufferSource buffers, int light, Ruby ruby,
                           float limbSwing, float limbAmount, float partialTick, float age,
                           float headYaw, float headPitch) {
            if (ruby.isInvisible()) return;
            getParentModel().renderToBuffer(pose, buffers.getBuffer(RenderType.entityCutoutNoCull(texture)),
                    light, LivingEntityRenderer.getOverlayCoords(ruby, 0.0F),
                    ((color >> 16) & 255) / 255.0F, ((color >> 8) & 255) / 255.0F,
                    (color & 255) / 255.0F, 1.0F);
        }
    }
}
