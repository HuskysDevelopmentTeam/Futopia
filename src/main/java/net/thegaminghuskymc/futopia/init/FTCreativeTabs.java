package net.thegaminghuskymc.futopia.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FTCreativeTabs {

    public static CreativeTabs blocks;
    public static CreativeTabs worldgen;
    public static CreativeTabs decoration;
    public static CreativeTabs machines;
    public static CreativeTabs items;
    public static CreativeTabs tools;
    public static CreativeTabs armor;
    public static CreativeTabs fluids;

    static {
        blocks = new CreativeTabs("blocks") {

            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Item.getItemFromBlock(FTBlocks.storage);
            }

        };

        worldgen = new CreativeTabs("worldgen") {

            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Item.getItemFromBlock(FTBlocks.ores);
            }

            @Override
            public boolean isTabInFirstRow() {
                return true;
            }

        };

        decoration = new CreativeTabs("decoration") {
            @Override
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Item.getItemFromBlock(FTBlocks.asphalt);
            }
        };

        machines = new CreativeTabs("machines") {
            @Override
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Item.getItemFromBlock(FTBlocks.particle_block);
            }
        };

        tools = new CreativeTabs("tools") {

            @Override
            public Item getTabIconItem() {
                return FTItems.toolsBlue[3];
            }

        };

        armor = new CreativeTabs("armor") {

            @Override
            public Item getTabIconItem() {
                return FTItems.armorBlue[0];
            }

        };

        items = new CreativeTabs("futopia_materials") {

            @Override
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return FTItems.ingots;
            }
        };
    }

}
