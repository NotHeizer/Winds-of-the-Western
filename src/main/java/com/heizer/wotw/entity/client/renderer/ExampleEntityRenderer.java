package com.heizer.wotw.entity.client.renderer;

import com.heizer.wotw.WotWMod;
import com.heizer.wotw.entity.client.model.ModelExampleEntity;
import com.heizer.wotw.entity.custom.ExampleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityRenderer extends MobRenderer<ExampleEntity, ModelExampleEntity<ExampleEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(WotWMod.MOD_ID,
            "textures/entity/example/example.png");

    protected static final ResourceLocation BABY = new ResourceLocation(WotWMod.MOD_ID,
            "textures/entity/example/example_baby.png");

    public ExampleEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ModelExampleEntity<>(context.bakeLayer(ModelExampleEntity.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(ExampleEntity entity)
    {
        if (entity.isBaby()) {
            return BABY;
        }
        return TEXTURE;
    }
}