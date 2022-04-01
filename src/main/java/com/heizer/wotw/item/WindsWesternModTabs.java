package com.heizer.wotw.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class WindsWesternModTabs {

    public static final CreativeModeTab WINDS_OF_THE_WEST = new CreativeModeTab("winds_of_the_westtab") {
        @Override
        public ItemStack makeIcon() {
            return new  ItemStack(WindsWesternModItems.IRON_SPEAR.get());
        }
    };
}
