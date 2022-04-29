package com.heizer.wotw.entity.client.model;

import com.heizer.wotw.WotWMod;
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
import org.lwjgl.system.CallbackI;

public class BisonModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(WotWMod.MOD_ID, "bison"), "main");
	private final ModelPart root;
    private final ModelPart Bison;
	//Bison Legs
	private ModelPart leg0;
	private ModelPart leg1;
	private ModelPart leg2;
	private ModelPart leg3;

	public BisonModel(ModelPart root) {
        this.root = root;
		this.Bison = root.getChild("Bison");
        this.leg0 = Bison.getChild("leg0");
        this.leg1 = Bison.getChild("leg1");
        this.leg2 = Bison.getChild("leg2");
        this.leg3 = Bison.getChild("leg3");
    }

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Bison = partdefinition.addOrReplaceChild("Bison", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 2.0F));

		PartDefinition body = Bison.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-11.5F, -13.0F, -17.0F, 23.0F, 22.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(0, 39).addBox(-9.5F, -10.0F, 0.0F, 19.0F, 18.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(12, 39).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-3.0F, 7.0F, 0.5F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 21.0F));

		PartDefinition head = Bison.addOrReplaceChild("head", CubeListBuilder.create().texOffs(66, 25).addBox(-7.5F, -7.5F, -13.0F, 15.0F, 16.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(67, 65).addBox(-7.0F, -7.0F, -12.5F, 14.0F, 15.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -16.0F));

		PartDefinition beard = head.addOrReplaceChild("beard", CubeListBuilder.create().texOffs(0, 100).addBox(0.0F, 0.0F, -5.5F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, -6.0F));

		PartDefinition horn0 = head.addOrReplaceChild("horn0", CubeListBuilder.create().texOffs(0, 39).addBox(-9.0F, -31.5F, -22.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 15.0F));

		PartDefinition horn1 = head.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(0, 0).addBox(6.0F, -31.5F, -22.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 15.0F));

		PartDefinition leg0 = Bison.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(53, 93).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 8.0F, 16.0F));

		PartDefinition leg1 = Bison.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(80, 0).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 8.0F, 16.0F));

		PartDefinition leg2 = Bison.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(30, 78).addBox(-3.5F, -1.0F, -4.0F, 7.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 9.0F, -10.0F));

		PartDefinition leg3 = Bison.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 78).addBox(-3.5F, -1.0F, -4.0F, 7.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 9.0F, -10.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg0.xRot = Mth.cos(limbSwing * 0.7F) * 0.5F * limbSwingAmount;
		this.leg1.xRot = Mth.cos(limbSwing * 0.7F) * -0.5F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 0.7F) * 0.5F * limbSwingAmount;
		this.leg3.xRot = Mth.cos(limbSwing * 0.7F) * -0.5F * limbSwingAmount;
		this.Bison.zRot = Mth.cos(limbSwing * 1.4F) * -0.2F * limbSwingAmount;

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Bison.render(poseStack, buffer, packedLight, packedOverlay);
	}
}