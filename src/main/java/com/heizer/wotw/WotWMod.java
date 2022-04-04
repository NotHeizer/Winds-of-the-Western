package com.heizer.wotw;

import com.heizer.wotw.block.WotWModBlocks;
import com.heizer.wotw.entity.WotWModEntityTypes;
import com.heizer.wotw.entity.client.model.BisonModel;
import com.heizer.wotw.entity.client.renderer.BisonRenderer;
import com.heizer.wotw.item.WotWModItems;
import com.heizer.wotw.item.util.WotWModItemsProperties;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(WotWMod.MOD_ID)
public class WotWMod {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "wotw";

    public WotWMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Register Classes
        WotWModItems.register(eventBus);
        WotWModBlocks.register(eventBus);
        WotWModEntityTypes.register(eventBus);

        //Client Setup
        eventBus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        WotWModItemsProperties.addCustomItemPrperties();
        EntityRenderers.register(WotWModEntityTypes.BISON.get(), BisonRenderer::new);
    }
}