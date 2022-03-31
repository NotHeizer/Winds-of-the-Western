package heizer.wotw.blocks;

import heizer.wotw.Winds_of_the_Western;
import heizer.wotw.items.WotW_Creative_Mode_Tab;
import heizer.wotw.items.WotW_Items;
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

    public static final RegistryObject<Block> ACACIA_CRATE = registerBlocks("acacia_crate",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops()), WotW_Creative_Mode_Tab.WINDS_OF_THE_WEST);

    public static final RegistryObject<Block> BIRCH_CRATE = registerBlocks("birch_crate",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops()), WotW_Creative_Mode_Tab.WINDS_OF_THE_WEST);

    public static final RegistryObject<Block> DARK_OAK_CRATE = registerBlocks("dark_oak_crate",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops()), WotW_Creative_Mode_Tab.WINDS_OF_THE_WEST);

    public static final RegistryObject<Block> SPRUCE_CRATE = registerBlocks("spruce_crate",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops()), WotW_Creative_Mode_Tab.WINDS_OF_THE_WEST);

    public static final RegistryObject<Block> CRIMSON_CRATE = registerBlocks("crimson_crate",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops()), WotW_Creative_Mode_Tab.WINDS_OF_THE_WEST);

    public static final RegistryObject<Block> WARPED_CRATE = registerBlocks("warped_crate",
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

