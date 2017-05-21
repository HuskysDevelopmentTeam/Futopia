package net.thegaminghuskymc.futopia.init;

import codechicken.lib.gui.SimpleCreativeTab;
import net.minecraft.creativetab.CreativeTabs;

public class FTCreativeTabs {

    public static CreativeTabs blocks;
    public static CreativeTabs worldgen;
    public static CreativeTabs decoration;
    public static CreativeTabs machines;
    public static CreativeTabs materials;
    public static CreativeTabs tools;
    public static CreativeTabs armor;
    public static CreativeTabs fluids;

    static {
        blocks = new SimpleCreativeTab("blocks", "futopia:storage", 0);

        worldgen = new SimpleCreativeTab("worldgen", "futopia:ore", 0);

        decoration = new SimpleCreativeTab("decoration", "futopia:asphalt");

        machines = new SimpleCreativeTab("machines", "futopia:particle_block");

        tools = new SimpleCreativeTab("tools", "futopia:sword_red");

        armor = new SimpleCreativeTab("armor", "futopia:armor_blue", 0);

        materials = new SimpleCreativeTab("futopia_materials", "futopia:ingot", 0);
    }

}
