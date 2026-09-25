package net.j.jemstones.client;

import net.j.jemstones.Jemstones;
import net.j.jemstones.entity.QuartzGem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class QuartzGemModel extends HumanoidModel<QuartzGem> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(
            ResourceLocation.tryBuild(Jemstones.MOD_ID, "quartz"), "main");

    public QuartzGemModel(ModelPart root) {
        super(root);
    }

    @Override
    public void setupAnim(QuartzGem gem, float limbSwing, float limbAmount, float age, float headYaw, float headPitch) {
        super.setupAnim(gem, limbSwing, limbAmount, age, headYaw, headPitch);
        // vanilla animation resets these to human proportions
        rightArm.y = leftArm.y = -4.0F;
        rightLeg.y = leftLeg.y = 12.0F;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-4, -12, -4, 8, 8, 8), PartPose.ZERO);
        root.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0)
                .addBox(-4, -12, -4, 8, 8, 8, new CubeDeformation(1.1F)), PartPose.ZERO);
        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16)
                .addBox(-5, -4, -3, 10, 16, 6), PartPose.ZERO);
        root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(48, 16)
                .addBox(-4, 0, -2, 4, 14, 4), PartPose.offset(-5, -4, 0));
        root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(48, 34)
                .addBox(0, 0, -2, 4, 14, 4), PartPose.offset(5, -4, 0));
        root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16)
                .addBox(-2, 0, -2, 4, 12, 4), PartPose.offset(-3, 12, 0));
        root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 32)
                .addBox(-2, 0, -2, 4, 12, 4), PartPose.offset(3, 12, 0));
        return LayerDefinition.create(mesh, 64, 64);
    }
}
