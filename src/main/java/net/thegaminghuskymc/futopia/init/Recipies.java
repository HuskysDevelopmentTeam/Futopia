package net.thegaminghuskymc.futopia.init;

import cofh.lib.util.helpers.ItemHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.thegaminghuskymc.futopia.item.ItemBaseGear;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.network.EnumXycroniumColor;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.IntStream;

public class Recipies {

    public static void init() {
        addSawRecipes();
        addHammerRecipes();
        addDustRecipes();
        addPlateRecipes();
        addBlockRecipes();
        addItemRecipes();
        addArmorRecipies();
        addToolRecipies();
    }

    private static void addSawRecipes() {
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTesselite");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.TESSELATION.ordinal()), "alloyFutopiaTesselite");
    }

    private static void addHammerRecipes() {
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTesselite");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.TESSELATION.ordinal()),  "alloyFutopiaTesselite");
    }

    private static void addPlateRecipes() {
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.RED.ordinal()),  "alloyFutopiaRed");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.BLUE.ordinal()),  "alloyFutopiaBlue");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.TUNGSTEN.ordinal()),  "alloyFutopiaTesselite");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.BRASS.ordinal()),  "alloyFutopiaBrass");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.TESSELATION.ordinal()), "alloyFutopiaTesselite");
    }

    private static void addDustRecipes() {
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.PURPLE.ordinal()),"alloyFutopiaPurple");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.TUNGSTEN.ordinal()),"alloyFutopiaTesselite");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.BRASS.ordinal()),"alloyFutopiaBrass");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.TESSELATION.ordinal()),"alloyFutopiaTesselite");
    }

    private static void addBlockRecipes() {
        CraftingManager.getInstance().addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(FTBlocks.particle_block)), "RBG", "GRB", "BGR", 'B', "alloyFutopiaBlue",
                'R', "alloyFutopiaRed", 'G', "alloyFutopiaGreen"));

        ItemHelper.addStorageRecipe(new ItemStack(FTBlocks.storage, 1, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        ItemHelper.addStorageRecipe(new ItemStack(FTBlocks.storage, 1, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        ItemHelper.addStorageRecipe(new ItemStack(FTBlocks.storage, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        ItemHelper.addStorageRecipe(new ItemStack(FTBlocks.storage, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        ItemHelper.addStorageRecipe(new ItemStack(FTBlocks.storage, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        ItemHelper.addStorageRecipe(new ItemStack(FTBlocks.storage, 1, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTungsten");
        ItemHelper.addStorageRecipe(new ItemStack(FTBlocks.storage, 1, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        ItemHelper.addStorageRecipe(new ItemStack(FTBlocks.storage, 1, EnumMaterialType.TESSELATION.ordinal()), "alloyFutopiaTesselite");
    }

    private static void addItemRecipes() {
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTungsten");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.TESSELATION.ordinal()), "alloyFutopiaTesselite");
    }

    private static void addToolRecipies(){
        addToolsetRecipe(FTItems.toolsRed, "alloyFutopiaRed");
        addToolsetRecipe(FTItems.toolsBlue, "alloyFutopiaBlue");
        addToolsetRecipe(FTItems.toolsPurple, "alloyFutopiaPurple");
        addToolsetRecipe(FTItems.toolsGreen, "alloyFutopiaGreen");
        addToolsetRecipe(FTItems.toolsZinc, "alloyFutopiaZinc");
        addToolsetRecipe(FTItems.toolsTungsten, "alloyFutopiaTungsten");
    }

    private static void addArmorRecipies(){
        addArmorsetRecipe(FTItems.armorRed, "alloyFutopiaRed");
        addArmorsetRecipe(FTItems.armorBlue, "alloyFutopiaBlue");
        addArmorsetRecipe(FTItems.armorPurple, "alloyFutopiaPurple");
        addArmorsetRecipe(FTItems.armorGreen, "alloyFutopiaGreen");
        addArmorsetRecipe(FTItems.armorZinc, "alloyFutopiaZinc");
        addArmorsetRecipe(FTItems.armorTungsten, "alloyFutopiaTungsten");
    }

    private static void addToolsetRecipe(Item[] toolset, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[0]), new Object[]{" X ", " X ", " C ", 'X', material, 'C', FTItems.ironStick}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[1]), new Object[]{"XXX", " C ", " C ", 'X', material, 'C', FTItems.ironStick}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[2]), new Object[]{" X ", " C ", " C ", 'X', material, 'C', FTItems.ironStick}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[3]), new Object[]{"XX ", "XC ", " C ", 'X', material, 'C', FTItems.ironStick}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[4]), new Object[]{"XX ", " C ", " C ", 'X', material, 'C', FTItems.ironStick}));
    }

    private static void addGearRecipe(ItemStack gear, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(gear, new Object[]{" X ", "XCX", " X ", 'X', material, 'C', Items.IRON_INGOT}));
    }

    private static void addPlateRecipe(ItemStack plates, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(plates, new Object[]{"XX ", "XX ", 'X', material}));
    }

    private static void addDustRecipe(ItemStack dusts, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(dusts, new Object[]{" X ", 'X', material}));
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
