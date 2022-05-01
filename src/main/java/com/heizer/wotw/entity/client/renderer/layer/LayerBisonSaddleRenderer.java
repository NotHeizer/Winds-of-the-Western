package com.heizer.wotw.entity.client.renderer.layer;

import com.heizer.wotw.WotWMod;
import com.heizer.wotw.entity.client.model.BisonModel;
import com.heizer.wotw.entity.client.renderer.BisonRenderer;
import com.heizer.wotw.entity.custom.BisonEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class LayerBisonSaddleRenderer extends RenderLayer<BisonEntity, BisonModel<BisonEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(WotWMod.MOD_ID,"textures/entity/bison/saddle/saddle.png");

    public LayerBisonSaddleRenderer(BisonRenderer aSuper) {
        super(aSuper);
    }

    public void render(PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn, BisonEntity boggord, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if(boggord.isSaddled()){
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityCutout(TEXTURE));
            this.getParentModel().renderToBuffer(poseStack, ivertexbuilder, packedLightIn, LivingEntityRenderer.getOverlayCoords( boggord, 0.3F), 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
