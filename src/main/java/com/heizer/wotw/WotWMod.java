package com.heizer.wotw;

import com.heizer.wotw.block.WotWModBlocks;
import com.heizer.wotw.entity.WotWModEntityTypes;
import com.heizer.wotw.entity.client.model.BisonModel;
import com.heizer.wotw.entity.client.model.ModelExampleEntity;
import com.heizer.wotw.entity.client.renderer.BisonRenderer;
import com.heizer.wotw.entity.client.renderer.ExampleEntityRenderer;
import com.heizer.wotw.entity.custom.BisonEntity;
import com.heizer.wotw.entity.custom.ExampleEntity;
import com.heizer.wotw.item.WotWModItems;
import com.heizer.wotw.item.util.WotWModItemsProperties;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(WotWMod.MOD_ID)
public class WotWMod {

    public static final String MOD_ID = "wotw";

    //Directly reference a slf4j logger
    private static final Logger LOGGER = LogManager.getLogger();

    public WotWMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Register Classes
        WotWModItems.register(eventBus);
        WotWModBlocks.register(eventBus);
        WotWModEntityTypes.register(eventBus);

        //Client Setup, Register Layer, Entity Attribute Event
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::registerLayers);
        eventBus.addListener(this::entityAttributeEvent);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        WotWModItemsProperties.addCustomItemPrperties();
        EntityRenderers.register(WotWModEntityTypes.BISON.get(), BisonRenderer::new);
        EntityRenderers.register(WotWModEntityTypes.EXAMPLE.get(), ExampleEntityRenderer::new);
    }
    private void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelExampleEntity.LAYER_LOCATION, ModelExampleEntity::createBodyLayer);
        event.registerLayerDefinition(BisonModel.LAYER_LOCATION, BisonModel::createBodyLayer);

    }

    private void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(WotWModEntityTypes.EXAMPLE.get(), ExampleEntity.setAttributes());
        event.put(WotWModEntityTypes.BISON.get(), BisonEntity.setAttributes());
    }

}