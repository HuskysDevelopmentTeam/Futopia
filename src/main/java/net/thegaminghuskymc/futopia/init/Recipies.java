package net.thegaminghuskymc.futopia.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;

public class Recipies {

    public static void init() {
        addSawRecipes();
        addHammerRecipes();
        addBlockRecipes();
        addArmorRecipies();
        addToolRecipies();
    }

    private static void addSawRecipes() {
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.RED.ordinal()), "ingotRed");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.BLUE.ordinal()), "ingotBlue");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.PURPLE.ordinal()), "ingotPurple");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.GREEN.ordinal()), "ingotGreen");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.ZINC.ordinal()), "ingotZinc");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.TUNGSTEN.ordinal()), "ingotTungsten");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.BRASS.ordinal()), "ingotBrass");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.TESSELATION.ordinal()), "ingotTesselite");
    }

    private static void addHammerRecipes() {
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.RED.ordinal()), "ingotRed");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.BLUE.ordinal()), "ingotBlue");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.PURPLE.ordinal()), "ingotPurple");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.GREEN.ordinal()), "ingotGreen");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.ZINC.ordinal()), "ingotZinc");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.TUNGSTEN.ordinal()), "ingotTungsten");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.BRASS.ordinal()), "ingotBrass");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.TESSELATION.ordinal()),  "ingotTesselite");
    }

    private static void addBlockRecipes() {
        CraftingManager.getInstance().addRecipe(new ShapedOreRecipe(new ItemStack(FTBlocks.particle_block), "RBG", "GRB", "BGR", 'B', "ingotBlue",
                'R', "ingotRed", 'G', "ingotGreen"));
    }

    private static void addToolRecipies(){
        addToolsetRecipe(FTItems.toolsRed, "ingotRed");
        addToolsetRecipe(FTItems.toolsBlue, "ingotBlue");
        addToolsetRecipe(FTItems.toolsPurple, "ingotPurple");
        addToolsetRecipe(FTItems.toolsGreen, "ingotGreen");
        addToolsetRecipe(FTItems.toolsZinc, "ingotZinc");
        addToolsetRecipe(FTItems.toolsTungsten, "ingotTungsten");
    }

    private static void addArmorRecipies(){
        addArmorsetRecipe(FTItems.armorRed, "ingotRed");
        addArmorsetRecipe(FTItems.armorBlue, "ingotBlue");
        addArmorsetRecipe(FTItems.armorPurple, "ingotPurple");
        addArmorsetRecipe(FTItems.armorGreen, "ingotGreen");
        addArmorsetRecipe(FTItems.armorZinc, "ingotZinc");
        addArmorsetRecipe(FTItems.armorTungsten, "ingotTungsten");
    }

    private static void addToolsetRecipe(Item[] toolset, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[0]), new Object[]{" X ", " X ", " C ", 'X', material, 'C', FTItems.ironStick}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[1]), new Object[]{"XXX", " C ", " C ", 'X', material, 'C', FTItems.ironStick}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[2]), new Object[]{" X ", " C ", " C ", 'X', material, 'C', FTItems.ironStick}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[3]), new Object[]{"XX ", "XC ", " C ", 'X', material, 'C', FTItems.ironStick}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[4]), new Object[]{"XX ", " C ", " C ", 'X', material, 'C', FTItems.ironStick}));
    }

    private static void addHammerRecipe(ItemStack hammers, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(hammers, new Object[]{"XCX", "XCX", " C ",  'X', material, 'C', FTItems.ironStick}));
    }

    private static void addSawRecipe(ItemStack saws, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(saws, new Object[]{"XX ", " XP", "  P",  'X', material, 'P', Blocks.PLANKS}));
    }

    private static void addArmorsetRecipe(Item[] armorset, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(armorset[0]), new Object[]{"XXX", "X X", "   ", 'X', material}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(armorset[1]), new Object[]{"X X", "XXX", "XXX", 'X', material}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(armorset[2]), new Object[]{"XXX", "X X", "X X", 'X', material}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(armorset[3]), new Object[]{"   ", "X X", "X X", 'X', material}));
    }

}
