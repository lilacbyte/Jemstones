package net.j.jemstones.client;

import net.j.jemstones.Jemstones;
import net.j.jemstones.entity.Pepo;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class PepoModel<T extends Pepo> extends HumanoidModel<T> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(
            ResourceLocation.tryBuild(Jemstones.MOD_ID, "pepo"), "main");

    public PepoModel(ModelPart root) {
        super(root);
    }

    @Override
    public void setupAnim(T pepo, float limbSwing, float limbAmount, float age, float headYaw, float headPitch) {
        super.setupAnim(pepo, limbSwing, limbAmount, age, headYaw, headPitch);
        rightArm.y = leftArm.y = 8.0F;
        rightLeg.y = leftLeg.y = 16.0F;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-4, 0, -4, 8, 8, 8), PartPose.ZERO);
        root.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0)
                .addBox(-4, 0, -4, 8, 8, 8, new CubeDeformation(1.1F)), PartPose.ZERO);
        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16)
                .addBox(-4, 8, -4, 8, 8, 8), PartPose.ZERO);
        root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(48, 16)
                .addBox(-3, 0, -2, 4, 8, 4), PartPose.offset(-5, 8, 0));
        root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(48, 28)
                .addBox(-1, 0, -2, 4, 8, 4), PartPose.offset(5, 8, 0));
        root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16)
                .addBox(-2, 0, -2, 4, 8, 4), PartPose.offset(-2, 16, 0));
        root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16)
                .addBox(-2, 0, -2, 4, 8, 4), PartPose.offset(2, 16, 0));
        return LayerDefinition.create(mesh, 64, 64);
    }
}
