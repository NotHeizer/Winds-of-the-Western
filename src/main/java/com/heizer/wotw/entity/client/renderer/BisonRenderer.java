package com.heizer.wotw.entity.client.renderer;

import com.heizer.wotw.WotWMod;
import com.heizer.wotw.entity.client.model.BisonModel;
import com.heizer.wotw.entity.custom.BisonEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BisonRenderer extends MobRenderer<BisonEntity, BisonModel<BisonEntity>> {
        protected static final ResourceLocation TEXTURE = new ResourceLocation(WotWMod.MOD_ID,
                "textures/entity/bison/bison.png");

        protected static final ResourceLocation BABY = new ResourceLocation(WotWMod.MOD_ID,
                "textures/entity/bison/bison_baby.png");

        public BisonRenderer(EntityRendererProvider.Context context) 
        {
            super(context, new BisonModel<>(context.bakeLayer(BisonModel.LAYER_LOCATION)), 0.7F);
        }

        @Override
        public ResourceLocation getTextureLocation(BisonEntity entity)
        {
            if (entity.isBaby()) {
                return BABY;
            }
            return TEXTURE;
        }
}