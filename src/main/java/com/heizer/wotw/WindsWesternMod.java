package com.heizer.wotw;

import com.heizer.wotw.block.WindsWesternModBlocks;
import com.heizer.wotw.item.WindsWesternModItems;
import com.heizer.wotw.item.util.WindsWesternModItemsProperties;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(WindsWesternMod.MOD_ID)
public class WindsWesternMod {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "wotw";

    public WindsWesternMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        WindsWesternModItems.register(eventBus);
        WindsWesternModBlocks.register(eventBus);


        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        WindsWesternModItemsProperties.addCustomItemPrperties();
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}