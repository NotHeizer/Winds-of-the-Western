package com.heizer.wotw.entity.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class ModelExampleEntity<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("WotWMod", "marcoon"), "main");
	//Marcoon
	private final ModelPart Marcoon;
	//Marcoon legs
	private ModelPart leg1;
	private ModelPart leg2;
	private ModelPart leg3;
	private ModelPart leg4;

	public ModelExampleEntity(ModelPart root) {
		this.Marcoon = root.getChild("Marcoon");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Marcoon = partdefinition.addOrReplaceChild("Marcoon", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = Marcoon.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 18).addBox(-3.5F, -5.0F, -9.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(25, 0).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition boump = head.addOrReplaceChild("boump", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, -2.0F));

		PartDefinition cube_r1 = boump.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 28).addBox(-2.0F, -17.5F, -10.0F, 4.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 10.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 8.0F));

		PartDefinition cube_r2 = tail.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(22, 8).addBox(0.0F, 2.75F, 6.55F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -8.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition leg1 = Marcoon.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(14, 34).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -5.0F, -5.5F));

		PartDefinition leg2 = Marcoon.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(38, 24).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -5.0F, -5.5F));

		PartDefinition leg3 = Marcoon.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(34, 9).addBox(-1.5F, 0.0F, -1.75F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -5.0F, 2.75F));

		PartDefinition leg4 = Marcoon.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 34).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -5.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg1.xRot = Mth.cos(limbSwing * 0.7F) * 0.5F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 0.7F) * -0.5F * limbSwingAmount;
		this.leg3.xRot = Mth.cos(limbSwing * 0.7F) * 0.5F * limbSwingAmount;
		this.leg4.xRot = Mth.cos(limbSwing * 0.7F) * -0.5F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Marcoon.render(poseStack, buffer, packedLight, packedOverlay);
	}
}