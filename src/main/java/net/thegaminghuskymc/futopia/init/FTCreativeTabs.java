package net.thegaminghuskymc.futopia.init;

import keri.ninetaillib.lib.mod.ContentLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;

/**
 * Created by TheGamingHuskyMC on 27.05.2017.
 */

@ContentLoader(modid = Refs.MODID)
public class FTCreativeTabs {

    public static CreativeTabs main;
    public static CreativeTabs materials;
    public static CreativeTabs tools;

    static {
        main = new CreativeTabs("main") {
        	@Override
            public ItemStack getTabIconItem() {
                return new ItemStack(FTBlocks.ores);
            }
        };

        materials = new CreativeTabs("materials") {
            /*@Override
            public ItemStack getTabIconItem() {
                return new ItemStack(FTItems.plates.setFull3D());
            }*/
        	@Override
        	public ItemStack getTabIconItem() {
        		return null;
        	}
        };

        tools = new CreativeTabs("tools") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.IRON_HOE);
            }
        };
    }

}
