package com.heizer.wotw.item;

import com.heizer.wotw.WotWMod;
import com.heizer.wotw.entity.WotWModEntityTypes;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class WotWModItems {

    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, WotWMod.MOD_ID);


    //AGATE ORE RESOURCES
    public static final RegistryObject<Item> RAW_AGATE = ITEMS.register("raw_agate",
            () -> new Item(new Item.Properties().tab(WotWModTabs.WINDS_OF_THE_WEST)));

    public static final RegistryObject<Item> AGATE = ITEMS.register("agate",
            () -> new Item(new Item.Properties().tab(WotWModTabs.WINDS_OF_THE_WEST)));

    //SPEAR ITEMS
    public static final RegistryObject<Item> WOODEN_SPEAR = ITEMS.register("wooden_spear",
            () -> new Item(new Item.Properties().tab(WotWModTabs.WINDS_OF_THE_WEST)));

    public static final RegistryObject<Item> STONE_SPEAR = ITEMS.register("stone_spear",
            () -> new Item(new Item.Properties().tab(WotWModTabs.WINDS_OF_THE_WEST)));

    public static final RegistryObject<Item> GOLDEN_SPEAR = ITEMS.register("golden_spear",
            () -> new Item(new Item.Properties().tab(WotWModTabs.WINDS_OF_THE_WEST)));

    public static final RegistryObject<Item> IRON_SPEAR = ITEMS.register("iron_spear",
            () -> new Item(new Item.Properties().tab(WotWModTabs.WINDS_OF_THE_WEST)));

    public static final RegistryObject<Item> DIAMOND_SPEAR = ITEMS.register("diamond_spear",
            () -> new Item(new Item.Properties().tab(WotWModTabs.WINDS_OF_THE_WEST)));

    public static final RegistryObject<Item> NETHERITE_SPEAR = ITEMS.register("netherite_spear",
            () -> new Item(new Item.Properties().tab(WotWModTabs.WINDS_OF_THE_WEST)));

    //Long Bow Item
    public static final RegistryObject<Item> LONGBOW = ITEMS.register("longbow",
            () -> new BowItem(new Item.Properties().tab(WotWModTabs.WINDS_OF_THE_WEST).durability(465)));

    //Bullets
    public static final RegistryObject<Item> BIG_BULLET = ITEMS.register("big_bullet",
            () -> new ArrowItem(new Item.Properties().tab(WotWModTabs.WINDS_OF_THE_WEST)));

    public static final RegistryObject<Item> SMALL_BULLET = ITEMS.register("small_bullet",
            () -> new ArrowItem(new Item.Properties().tab(WotWModTabs.WINDS_OF_THE_WEST)));

    //Spawn Eggs
    public static final RegistryObject<Item> BISON_SPAWN_EGG = ITEMS.register("bison_spawn_egg",
            () -> new ForgeSpawnEggItem(WotWModEntityTypes.BISON,3498527, 8306817,
                    new Item.Properties().tab(WotWModTabs.WINDS_OF_THE_WEST)));




    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}