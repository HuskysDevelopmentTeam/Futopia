package net.thegaminghuskymc.futopia.items;

import keri.ninetaillib.lib.item.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

/**
 * Created by TheGamingHuskyMC on 27.05.2017.
 */
public class ItemFutopia extends ItemBase {

    public ItemFutopia(String itemName) {
        super(itemName);
    }

    public ItemFutopia(String itemName, String... subNames) {
        super(itemName, subNames);
    }

    @Override
    public CreativeTabs getCreativeTab() {
        return FTCreativeTabs.materials;
    }

}
