package net.j.jemstones.client;

import net.j.jemstones.Jemstones;
import net.j.jemstones.entity.Ruby;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class RubyModel extends HumanoidModel<Ruby> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(
            ResourceLocation.tryBuild(Jemstones.MOD_ID, "ruby"), "main");

    public RubyModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-6, -4, -4, 12, 12, 8), PartPose.ZERO);
        root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 20)
                .addBox(-4, 8, -2, 8, 8, 4), PartPose.ZERO);
        root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 32)
                .addBox(-3, 0, -2, 4, 8, 4), PartPose.offset(-5, 8, 0));
        root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 20)
                .addBox(-1, 0, -2, 4, 8, 4), PartPose.offset(5, 8, 0));
        root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 20)
                .addBox(-2, 0, -2, 4, 8, 4), PartPose.offset(-2, 16, 0));
        root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 32)
                .addBox(-2, 0, -2, 4, 8, 4), PartPose.offset(2, 16, 0));
        return LayerDefinition.create(mesh, 64, 64);
    }
}
