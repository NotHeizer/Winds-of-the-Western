package heizer.wotw.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class WotW_Creative_Mode_Tab {

    public static final CreativeModeTab WINDS_OF_THE_WEST = new CreativeModeTab("winds_of_the_westtab") {
        @Override
        public ItemStack makeIcon() {
            return new  ItemStack(WotW_Items.IRON_SPEAR.get());
        }
    };
}
