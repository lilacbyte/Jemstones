package net.j.jemstones.client;

import net.j.jemstones.Jemstones;
import net.j.jemstones.entity.Pumpkin;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public class PumpkinRenderer extends MobRenderer<Pumpkin, PepoModel<Pumpkin>> {
    private static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(
            Jemstones.MOD_ID, "textures/entities/pepo/pumpkin.png");
    private static final ResourceLocation LIT_TEXTURE = ResourceLocation.tryBuild(
            Jemstones.MOD_ID, "textures/entities/pepo/pumpkin_lit.png");

    public PumpkinRenderer(EntityRendererProvider.Context context) {
        super(context, new PepoModel<>(context.bakeLayer(PepoModel.LAYER)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(Pumpkin pumpkin) {
        return pumpkin.isLit() ? LIT_TEXTURE : TEXTURE;
    }

    @Override
    protected int getBlockLightLevel(Pumpkin pumpkin, BlockPos pos) {
        return pumpkin.isLit() ? 15 : super.getBlockLightLevel(pumpkin, pos);
    }

    @Override
    protected int getSkyLightLevel(Pumpkin pumpkin, BlockPos pos) {
        return pumpkin.isLit() ? 15 : super.getSkyLightLevel(pumpkin, pos);
    }
}
