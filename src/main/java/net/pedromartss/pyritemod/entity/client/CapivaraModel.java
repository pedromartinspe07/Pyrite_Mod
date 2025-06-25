package net.pedromartss.pyritemod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.pedromartss.pyritemod.PyriteMod;
import net.pedromartss.pyritemod.entity.custom.CapivaraEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;


public class CapivaraModel<T extends CapivaraEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(PyriteMod.MOD_ID, "capivara"), "main");
	private final ModelPart body;
	private final ModelPart head;

	public CapivaraModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = body.getChild("upper").getChild("neck").getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 9.0F, 6.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition lower = body.addOrReplaceChild("lower", CubeListBuilder.create().texOffs(72, 103).addBox(-7.0F, -5.5F, -6.6667F, 14.0F, 11.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(78, 0).addBox(-6.0F, -6.5F, -6.6667F, 12.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(78, 44).addBox(-6.0F, 5.5F, -6.6667F, 12.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -0.3333F));

		PartDefinition rearlegL = lower.addOrReplaceChild("rearlegL", CubeListBuilder.create().texOffs(31, 54).addBox(-1.0F, -3.5F, -4.0F, 3.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -1.0F, 1.3333F, -0.0438F, -0.0872F, 0.0038F));

		PartDefinition upperlegL = rearlegL.addOrReplaceChild("upperlegL", CubeListBuilder.create().texOffs(70, 63).addBox(-1.5F, -0.5F, -3.0F, 3.0F, 9.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.5F, 2.0F, -1.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition lowerlegL = upperlegL.addOrReplaceChild("lowerlegL", CubeListBuilder.create().texOffs(30, 23).addBox(-1.5F, -0.5F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 8.0F, -0.5F, 0.3491F, 0.0F, 0.0F));

		PartDefinition footL = lowerlegL.addOrReplaceChild("footL", CubeListBuilder.create().texOffs(73, 33).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.2F, -0.5F));

		PartDefinition rearlegR = lower.addOrReplaceChild("rearlegR", CubeListBuilder.create().texOffs(46, 62).mirror().addBox(-2.0F, -3.5F, -4.0F, 3.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -1.0F, 1.3333F, -0.0436F, 0.0873F, 0.0F));

		PartDefinition upperlegR = rearlegR.addOrReplaceChild("upperlegR", CubeListBuilder.create().texOffs(89, 63).mirror().addBox(-1.5F, -0.5F, -3.0F, 3.0F, 9.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.0F, -1.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition lowerlegR = upperlegR.addOrReplaceChild("lowerlegR", CubeListBuilder.create().texOffs(14, 54).mirror().addBox(-1.5F, -0.5F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, -0.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition footR = lowerlegR.addOrReplaceChild("footR", CubeListBuilder.create().texOffs(80, 93).mirror().addBox(-1.5F, 0.7F, -3.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.5F, -0.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition tail = lower.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 7.3333F, -0.1745F, 0.0F, 0.0F));

		PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 7.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 7.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition tail5 = tail4.addOrReplaceChild("tail5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 8.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition upper = body.addOrReplaceChild("upper", CubeListBuilder.create().texOffs(0, 103).addBox(-7.0F, -5.5F, -12.0F, 14.0F, 11.0F, 14.0F, new CubeDeformation(-0.1F))
		.texOffs(80, 30).addBox(-6.0F, -6.3F, -11.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(-0.1F))
		.texOffs(80, 16).addBox(-6.0F, 5.3F, -11.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.5F, -7.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition armL = upper.addOrReplaceChild("armL", CubeListBuilder.create().texOffs(0, 46).addBox(-1.5F, -3.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 1.0F, -8.5F, 0.0F, -0.0873F, 0.0F));

		PartDefinition upperarmL = armL.addOrReplaceChild("upperarmL", CubeListBuilder.create().texOffs(61, 57).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.5F, 0.3491F, 0.0F, 0.0F));

		PartDefinition lowerarmL = upperarmL.addOrReplaceChild("lowerarmL", CubeListBuilder.create().texOffs(115, 107).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 4.5F, -0.5F, -0.6109F, 0.0F, 0.0F));

		PartDefinition handL = lowerarmL.addOrReplaceChild("handL", CubeListBuilder.create().texOffs(47, 82).addBox(-1.5F, 0.0F, -2.5F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition armR = upper.addOrReplaceChild("armR", CubeListBuilder.create().texOffs(112, 59).mirror().addBox(-1.5F, -3.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 1.0F, -8.5F, 0.0F, 0.0873F, 0.0F));

		PartDefinition upperarmR = armR.addOrReplaceChild("upperarmR", CubeListBuilder.create().texOffs(0, 89).mirror().addBox(-1.5F, -1.5F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.5F, 0.5F, 0.3491F, 0.0F, 0.0F));

		PartDefinition lowerarmR = upperarmR.addOrReplaceChild("lowerarmR", CubeListBuilder.create().texOffs(86, 81).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.5F, -0.5F, -0.6109F, 0.0F, 0.0F));

		PartDefinition handR = lowerarmR.addOrReplaceChild("handR", CubeListBuilder.create().texOffs(0, 82).mirror().addBox(-1.5F, 0.0F, -2.5F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition neck = upper.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(56, 99).addBox(-4.0F, -4.0F, -4.2F, 8.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -11.8F, 0.1309F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(18, 82).addBox(-5.0F, -5.0475F, -8.0281F, 10.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(1, 107).addBox(-2.0F, -3.0475F, -10.0281F, 4.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8525F, -3.1719F, -0.0873F, 0.0F, 0.0F));

		PartDefinition crest3_r1 = head.addOrReplaceChild("crest3_r1", CubeListBuilder.create().texOffs(61, 113).addBox(0.5F, 3.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -9.0475F, 0.4719F, -2.1556F, 1.4136F, -2.1613F));

		PartDefinition crest2_r1 = head.addOrReplaceChild("crest2_r1", CubeListBuilder.create().texOffs(61, 113).addBox(0.5F, 3.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -9.0475F, 0.4719F, -1.2509F, 1.4329F, -1.248F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.9525F, -8.0281F, 0.0873F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(CapivaraEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(CapivaraAnimations.ANIM_CAPIVARA_WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, CapivaraAnimations.ANIM_CAPIVARA_IDLE, ageInTicks, 1f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}
