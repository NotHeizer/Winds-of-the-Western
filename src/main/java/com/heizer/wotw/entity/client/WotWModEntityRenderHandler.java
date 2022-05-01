package com.heizer.wotw.entity.client;

import com.heizer.wotw.WotWMod;
import com.heizer.wotw.entity.WotWModEntityTypes;
import com.heizer.wotw.entity.client.model.BisonModel;
import com.heizer.wotw.entity.client.renderer.BisonRenderer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = WotWMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class WotWModEntityRenderHandler
{
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(BisonModel.LAYER_LOCATION, BisonModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(WotWModEntityTypes.BISON.get(), BisonRenderer::new);
    }
}
