package net.heizer.wotw.block;

import net.heizer.wotw.Winds_of_the_Western;
import net.heizer.wotw.item.WotW_Items;
import net.heizer.wotw.item.WotW_Creative_Mode_Tab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class WotW_Blocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Winds_of_the_Western.MOD_ID);



    //AGATE BLOCKS
    public static final RegistryObject<Block> AGATE_GEODE = registerBlocks("agate_geode",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(7f).requiresCorrectToolForDrops()), WotW_Creative_Mode_Tab.WINDS_OF_THE_WEST);

    public static final RegistryObject<Block> AGATE_BLOCK = registerBlocks("agate_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(9f).requiresCorrectToolForDrops()), WotW_Creative_Mode_Tab.WINDS_OF_THE_WEST);

    //CRATE BLOCKS
    public static final RegistryObject<Block> OAK_CRATE = registerBlocks("oak_crate",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops()), WotW_Creative_Mode_Tab.WINDS_OF_THE_WEST);




    private static <T extends Block> RegistryObject<T> registerBlocks(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {
        return WotW_Items.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));

    }

    public static void register (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}

