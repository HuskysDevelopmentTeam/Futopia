package net.thegaminghuskymc.futopia.init;

import keri.ninetaillib.lib.mod.ContentLoader;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;

@ContentLoader(modid = Refs.MODID)
public class Recipies {

    public static void init() {
        addSawRecipes();
        addHammerRecipes();
        addDustRecipes();
        addPlateRecipes();
        addBlockRecipes();
        addItemRecipes();
//        addArmorRecipies();
//        addToolRecipies();
    }

    private static void addSawRecipes() {
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.RED.ordinal()), "ingotRed");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.BLUE.ordinal()), "ingotBlue");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.PURPLE.ordinal()), "ingotPurple");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.GREEN.ordinal()), "ingotGreen");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.ZINC.ordinal()), "ingotZinc");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.TUNGSTEN.ordinal()), "ingotTungsten");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.BRASS.ordinal()), "ingotBrass");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.TESSELITE.ordinal()), "ingotTesselite");

        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTungsten");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.TESSELITE.ordinal()), "alloyFutopiaTesselite");
    }

    private static void addHammerRecipes() {
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.RED.ordinal()), "ingotRed");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.BLUE.ordinal()), "ingotBlue");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.PURPLE.ordinal()), "ingotPurple");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.GREEN.ordinal()), "ingotGreen");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.ZINC.ordinal()), "ingotZinc");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.TUNGSTEN.ordinal()), "ingotTungsten");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.BRASS.ordinal()), "ingotBrass");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.TESSELITE.ordinal()), "ingotTesselite");

        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTungsten");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.TESSELITE.ordinal()), "alloyFutopiaTesselite");
    }

    private static void addPlateRecipes() {
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.RED.ordinal()),  "alloyFutopiaRed");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.BLUE.ordinal()),  "alloyFutopiaBlue");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.TUNGSTEN.ordinal()),  "alloyFutopiaTungsten");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.BRASS.ordinal()),  "alloyFutopiaBrass");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.TESSELITE.ordinal()), "alloyFutopiaTesselite");
    }

    private static void addDustRecipes() {
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.PURPLE.ordinal()),"alloyFutopiaPurple");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.TUNGSTEN.ordinal()),"alloyFutopiaTungsten");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.BRASS.ordinal()),"alloyFutopiaBrass");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.TESSELITE.ordinal()),"alloyFutopiaTesselite");
    }

    private static void addNuggetRecipes() {
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.PURPLE.ordinal()),"alloyFutopiaPurple");
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.TUNGSTEN.ordinal()),"alloyFutopiaTungsten");
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.BRASS.ordinal()),"alloyFutopiaBrass");
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.TESSELITE.ordinal()),"alloyFutopiaTesselite");
    }

    private static void addItemRecipes() {
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTungsten");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.TESSELITE.ordinal()), "alloyFutopiaTesselite");

        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.RED.ordinal()), "ingotRed");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.BLUE.ordinal()), "ingotBlue");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.PURPLE.ordinal()), "ingotPurple");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.GREEN.ordinal()), "ingotGreen");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.ZINC.ordinal()), "ingotZinc");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.TUNGSTEN.ordinal()), "ingotTungsten");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.BRASS.ordinal()), "ingotBrass");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.TESSELITE.ordinal()), "ingotTesselite");

        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.RED.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.RED.ordinal()), 0.0F);
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.BLUE.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.BLUE.ordinal()), 0.0F);
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.PURPLE.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.PURPLE.ordinal()), 0.0F);
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.GREEN.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.GREEN.ordinal()), 0.0F);
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.ZINC.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.ZINC.ordinal()), 0.0F);
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.TUNGSTEN.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.TUNGSTEN.ordinal()), 0.0F);
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.BRASS.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.BRASS.ordinal()), 0.0F);
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.TESSELITE.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.TESSELITE.ordinal()), 0.0F);
    }

    private static void addBlockRecipes() {
        /*CraftingManager.getInstance().addRecipe(new ShapedOreRecipe(new ItemStack(FTBlocks.particle_block), "RBG", "GRB", "BGR", 'B', "ingotBlue",
                'R', "ingotRed", 'G', "ingotGreen"));

        CraftingManager.getInstance().addRecipe(new ShapedOreRecipe(new ItemStack(FTBlocks.particle_block), "RBG", "GRB", "BGR", 'B', "alloyFutopiaBlue",
                'R', "alloyFutopiaRed", 'G', "alloyFutopiaGreen"));*/

//        addSmelting(new ItemStack(FTItems.ingots, 1, EnumMaterialType.RED.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.RED.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems.ingots, 1, EnumMaterialType.BLUE.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.BLUE.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems.ingots, 1, EnumMaterialType.PURPLE.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.PURPLE.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems.ingots, 1, EnumMaterialType.GREEN.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.GREEN.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems.ingots, 1, EnumMaterialType.ZINC.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.ZINC.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems.ingots, 1, EnumMaterialType.TUNGSTEN.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.TUNGSTEN.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems.ingots, 1, EnumMaterialType.BRASS.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.BRASS.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems.ingots, 1, EnumMaterialType.TESSELITE.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.TESSELITE.ordinal()), 0.0F);
    }

    /*private static void addToolRecipies() {
        addToolsetRecipe(FTItems.toolsRed, "ingotRed");
        addToolsetRecipe(FTItems.toolsBlue, "ingotBlue");
        addToolsetRecipe(FTItems.toolsPurple, "ingotPurple");
        addToolsetRecipe(FTItems.toolsGreen, "ingotGreen");
        addToolsetRecipe(FTItems.toolsZinc, "ingotZinc");
        addToolsetRecipe(FTItems.toolsTungsten, "ingotTungsten");

        addToolsetRecipe(FTItems.toolsRed, "alloyFutopiaRed");
        addToolsetRecipe(FTItems.toolsBlue, "alloyFutopiaBlue");
        addToolsetRecipe(FTItems.toolsPurple, "alloyFutopiaPurple");
        addToolsetRecipe(FTItems.toolsGreen, "alloyFutopiaGreen");
        addToolsetRecipe(FTItems.toolsZinc, "alloyFutopiaZinc");
        addToolsetRecipe(FTItems.toolsTungsten, "alloyFutopiaTungsten");
    }

    private static void addArmorRecipies() {
        addArmorsetRecipe(FTItems.armorRed, "ingotRed");
        addArmorsetRecipe(FTItems.armorBlue, "ingotBlue");
        addArmorsetRecipe(FTItems.armorPurple, "ingotPurple");
        addArmorsetRecipe(FTItems.armorGreen, "ingotGreen");
        addArmorsetRecipe(FTItems.armorZinc, "ingotZinc");
        addArmorsetRecipe(FTItems.armorTungsten, "ingotTungsten");

        addArmorsetRecipe(FTItems.armorRed, "alloyFutopiaRed");
        addArmorsetRecipe(FTItems.armorBlue, "alloyFutopiaBlue");
        addArmorsetRecipe(FTItems.armorPurple, "alloyFutopiaPurple");
        addArmorsetRecipe(FTItems.armorGreen, "alloyFutopiaGreen");
        addArmorsetRecipe(FTItems.armorZinc, "alloyFutopiaZinc");
        addArmorsetRecipe(FTItems.armorTungsten, "alloyFutopiaTungsten");
    }*/

    private static void addToolsetRecipe(Item[] toolset, String material) {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[0]), " X ", " X ", " C ", 'X', material, 'C', FTItems.ironStick));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[1]), "XXX", " C ", " C ", 'X', material, 'C', FTItems.ironStick));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[2]), " X ", " C ", " C ", 'X', material, 'C', FTItems.ironStick));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[3]), "XX ", "XC ", " C ", 'X', material, 'C', FTItems.ironStick));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toolset[4]), "XX ", " C ", " C ", 'X', material, 'C', FTItems.ironStick));
    }

    private static void addGearRecipe(ItemStack gear, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(gear, " X ", "XCX", " X ", 'X', material, 'C', Items.IRON_INGOT));
    }

    private static void addPlateRecipe(ItemStack plates, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(plates, "XX ", "XX ", 'X', material));
    }

    private static void addDustRecipe(ItemStack dusts, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(dusts, " X ", 'X', material));
    }

    private static void addNuggetRecipe(ItemStack nuggets, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(nuggets, " X ", 'X', material));
    }

    private static void addHammerRecipe(ItemStack hammers, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(hammers, "XCX", "XCX", " C ",  'X', material, 'C', FTItems.ironStick));
    }

    private static void addSawRecipe(ItemStack saws, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(saws, "XX ", " XP", "  P",  'X', material, 'P', Blocks.PLANKS));
    }

    private static void addArmorsetRecipe(Item[] armorset, String material) {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(armorset[0]), "XXX", "X X", "   ", 'X', material));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(armorset[1]), "X X", "XXX", "XXX", 'X', material));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(armorset[2]), "XXX", "X X", "X X", 'X', material));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(armorset[3]), "   ", "X X", "X X", 'X', material));
    }
    
    public static ItemStack cloneStack(Item item, int stackSize)
    {
        if(item == null)
            return null;
        else
            return new ItemStack(item, stackSize);
    }

    public static ItemStack cloneStack(Block item, int stackSize)
    {
        if(item == null)
            return null;
        else
            return new ItemStack(item, stackSize);
    }

    public static ItemStack cloneStack(ItemStack stack, int stackSize)
    {
        if(stack == null)
        {
            return null;
        } else
        {
            ItemStack retStack = stack.copy();
            retStack.getCount();
            return retStack;
        }
    }

    public static ItemStack cloneStack(ItemStack stack)
    {
        return stack != null ? stack.copy() : null;
    }
    
    public static boolean addSmelting(ItemStack out, Item in)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.0F);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, Block in)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.0F);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, ItemStack in)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.0F);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, Item in, float XP)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, Block in, float XP)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, ItemStack in, float XP)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
            return true;
        }
    }

    // SMELTING{
    /*public static boolean addSmelting(ItemStack out, Item in) {

        if (out == null | in == null) {
            return false;
        }
        FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0);
        return true;
    }

    public static boolean addSmelting(ItemStack out, Block in) {

        if (out == null | in == null) {
            return false;
        }
        FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0);
        return true;
    }

    public static boolean addSmelting(ItemStack out, ItemStack in) {

        if (out == null | in == null) {
            return false;
        }
        FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0);
        return true;
    }

    public static boolean addSmelting(ItemStack out, Item in, float XP) {

        if (out == null | in == null) {
            return false;
        }
        FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
        return true;
    }

    public static boolean addSmelting(ItemStack out, Block in, float XP) {

        if (out == null | in == null) {
            return false;
        }
        FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
        return true;
    }

    public static boolean addSmelting(ItemStack out, ItemStack in, float XP) {

        if (out == null | in == null) {
            return false;
        }
        FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
        return true;
    }

    public static boolean addWeakSmelting(ItemStack out, Item in) {

        if (out == null | in == null) {
            return false;
        }
        FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.1f);
        return true;
    }

    public static boolean addWeakSmelting(ItemStack out, Block in) {

        if (out == null | in == null) {
            return false;
        }
        FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.1f);
        return true;
    }

    public static boolean addWeakSmelting(ItemStack out, ItemStack in) {

        if (out == null | in == null) {
            return false;
        }
        FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.1f);
        return true;
    }*/

}
