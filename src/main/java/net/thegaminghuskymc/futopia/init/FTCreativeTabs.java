package net.thegaminghuskymc.futopia.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.item.ItemMaterial;

public class FTCreativeTabs {

    public static CreativeTabs blocks;
    public static CreativeTabs worldgen;
    public static CreativeTabs decoration;
    public static CreativeTabs machines;
    public static CreativeTabs materials;
    public static CreativeTabs tools;
    public static CreativeTabs armor;

    static {
        blocks = new CreativeTabs("blocks_ft") {

            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(FTBlocks.storage);
            }

        };

        worldgen = new CreativeTabs("worldgen_ft") {
            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(FTBlocks.ores);
            }

        };

        decoration = new CreativeTabs("decoration_ft") {
            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(FTBlocks.asphalt);
            }
        };

        machines = new CreativeTabs("machines_ft") {
            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(FTBlocks.particle_block);
            }
        };

        tools = new CreativeTabs("tools_ft") {

            @Override
            public Item getTabIconItem() {
                return FTItems.hammer.setFull3D();
            }

        };

        armor = new CreativeTabs("armor_ft") {

            @Override
            public Item getTabIconItem() {
                return FTItems.armorBlue[0];
            }

        };

        materials = new CreativeTabs("items_ft") {

            @Override
            public Item getTabIconItem() {
                return FTItems.gears;
            }
        };
    }

}
