package heizer.wotw;

import heizer.wotw.blocks.WotW_Blocks;
import heizer.wotw.items.WotW_Items;
import heizer.wotw.items.util.WotW_Item_Properties;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(Winds_of_the_Western.MOD_ID)
public class Winds_of_the_Western {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "wotw";

    public Winds_of_the_Western() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        WotW_Items.register(eventBus);
        WotW_Blocks.register(eventBus);


        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        WotW_Item_Properties.addCustomItemPrperties();

    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}