package net.heizer.examplemod.item;

import net.heizer.examplemod.Winds_of_the_Western;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, Winds_of_the_Western.MOD_ID);


    public static final RegistryObject<Item> RAW_AGATE = ITEMS.register("raw_agate",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> AGATE_GEMGOT = ITEMS.register("agate_gemgot",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));



    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}