package net.thegaminghuskymc.futopia.init;

import cofh.core.item.tool.ItemHammerCore;
import cofh.core.item.tool.ItemShieldCore;
import cofh.thermalfoundation.ThermalFoundation;
import cofh.thermalfoundation.init.TFProps;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.item.*;
import net.thegaminghuskymc.futopia.reference.Refs;

@GameRegistry.ObjectHolder(Refs.MODID)
public class FTItems {


    public static ItemSaw saw;
    public static ItemHammer hammer;

    public static ItemWindowsWasher windows_washer;
    public static ItemMeteorSpawner meteor_spawner;
    public static ItemBaseDust dusts;
    public static ItemBaseIngot ingots;
    public static ItemBaseNugget nuggets;
    public static ItemBaseGear gears;
    public static ItemBasePlate plates;
    public static ItemBaseShard shards;

    public static ItemIronStick ironStick;

    public static Item[] toolsBlue;
    public static Item[] toolsGreen;
    public static Item[] toolsRed;
    public static Item[] toolsPurple;
    public static Item[] toolsTungsten;
    public static Item[] toolsZinc;
    public static Item[] armorBlue;
    public static Item[] armorGreen;
    public static Item[] armorRed;
    public static Item[] armorPurple;
    public static Item[] armorTungsten;
    public static Item[] armorZinc;

    public static Item.ToolMaterial toolMaterialBlue = EnumHelper.addToolMaterial("blue", 2, 700, 6.1F, 2.1F, 15);
    private static Item.ToolMaterial toolMaterialGreen = EnumHelper.addToolMaterial("green", 2, 700, 6.1F, 2.1F, 15);
    private static Item.ToolMaterial toolMaterialRed = EnumHelper.addToolMaterial("red", 2, 700, 6.1F, 2.1F, 15);
    private static Item.ToolMaterial toolMaterialPurple = EnumHelper.addToolMaterial("purple", 2, 700, 6.1F, 2.1F, 15);
    private static Item.ToolMaterial toolMaterialTungsten = EnumHelper.addToolMaterial("tungsten", 2, 700, 6.1F, 2.1F, 15);
    private static Item.ToolMaterial toolMaterialZinc = EnumHelper.addToolMaterial("zinc", 2, 700, 6.1F, 2.1F, 15);
    private static ItemToolHelperFutopia toolHelper = new ItemToolHelperFutopia();

    private static ItemArmorHelperFutopia armorHelper = new ItemArmorHelperFutopia();

    public static ItemShieldCore shieldHelperRed;
    public static ItemShieldCore shieldHelperBlue;
    public static ItemShieldCore shieldHelperGreen;
    public static ItemShieldCore shieldHelperPurple;
    public static ItemShieldCore shieldHelperTungsten;
    public static ItemShieldCore shieldHelperZinc;

    public static ItemHammerCore hammerHelperRed;
    public static ItemHammerCore hammerHelperBlue;
    public static ItemHammerCore hammerHelperGreen;
    public static ItemHammerCore hammerHelperPurple;
    public static ItemHammerCore hammerHelperTungsten;
    public static ItemHammerCore hammerHelperZinc;

    public static ItemStack toolHammerRed;
    public static ItemStack toolHammerBlue;
    public static ItemStack toolHammerGreen;
    public static ItemStack toolHammerPurple;
    public static ItemStack toolHammerTungsten;
    public static ItemStack toolHammerZinc;

    public static ItemStack toolShieldRed;
    public static ItemStack toolShieldBlue;
    public static ItemStack toolShieldGreen;
    public static ItemStack toolShieldPurple;
    public static ItemStack toolShieldTungsten;
    public static ItemStack toolShieldZinc;

    public static void init() {
        instantiateItems();
    }

    private static void instantiateItems() {
        windows_washer = new ItemWindowsWasher();
        meteor_spawner = new ItemMeteorSpawner();

        ironStick = new ItemIronStick();

        nuggets = new ItemBaseNugget();
        ingots = new ItemBaseIngot();
        dusts = new ItemBaseDust();
        plates = new ItemBasePlate();
        gears = new ItemBaseGear();
        shards = new ItemBaseShard();

        saw = new ItemSaw();
        hammer = new ItemHammer();

        toolsBlue = toolHelper.createToolset("blue", toolMaterialBlue);
        toolsGreen = toolHelper.createToolset("green", toolMaterialGreen);
        toolsRed = toolHelper.createToolset("red", toolMaterialRed);
        toolsPurple = toolHelper.createToolset("purple", toolMaterialPurple);
        toolsTungsten = toolHelper.createToolset("tungsten", toolMaterialTungsten);
        toolsZinc = toolHelper.createToolset("zinc", toolMaterialZinc);

        armorBlue = armorHelper.createArmorSet("blue", EnumHelper.addArmorMaterial("blue", Refs.MODID + ":blue", 16, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.1F));
        armorGreen = armorHelper.createArmorSet("green", EnumHelper.addArmorMaterial("green", Refs.MODID + ":green", 16, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.1F));
        armorRed = armorHelper.createArmorSet("red", EnumHelper.addArmorMaterial("red", Refs.MODID + ":red", 16, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.1F));
        armorPurple = armorHelper.createArmorSet("purple", EnumHelper.addArmorMaterial("purple", Refs.MODID + ":purple", 16, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.1F));
        armorTungsten = armorHelper.createArmorSet("tungsten", EnumHelper.addArmorMaterial("tungsten", Refs.MODID + ":tungsten", 16, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.1F));
        armorZinc = armorHelper.createArmorSet("zinc", EnumHelper.addArmorMaterial("zinc", Refs.MODID + ":zinc", 16, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.1F));

        /*//Shields
        shieldHelperRed = new ItemShieldCore(toolMaterialRed);
        shieldHelperRed.setUnlocalizedName("shield_red").setCreativeTab(FTCreativeTabs.tools);
        shieldHelperRed.setRegistryName("shield_red");
        GameRegistry.register(shieldHelperRed);

        shieldHelperBlue = new ItemShieldCore(toolMaterialBlue);
        shieldHelperBlue.setUnlocalizedName("shield_blue").setCreativeTab(FTCreativeTabs.tools);
        shieldHelperBlue.setRegistryName("shield_blue");
        GameRegistry.register(shieldHelperBlue);

        shieldHelperGreen = new ItemShieldCore(toolMaterialGreen);
        shieldHelperGreen.setUnlocalizedName("shield_green").setCreativeTab(FTCreativeTabs.tools);
        shieldHelperGreen.setRegistryName("shield_green");
        GameRegistry.register(shieldHelperGreen);

        shieldHelperPurple = new ItemShieldCore(toolMaterialPurple);
        shieldHelperPurple.setUnlocalizedName("shield_purple").setCreativeTab(FTCreativeTabs.tools);
        shieldHelperPurple.setRegistryName("shield_purple");
        GameRegistry.register(shieldHelperPurple);

        shieldHelperTungsten = new ItemShieldCore(toolMaterialTungsten);
        shieldHelperTungsten.setUnlocalizedName("shield_tungsten").setCreativeTab(FTCreativeTabs.tools);
        shieldHelperTungsten.setRegistryName("shield_tungsten");
        GameRegistry.register(shieldHelperTungsten);

        shieldHelperZinc = new ItemShieldCore(toolMaterialZinc);
        shieldHelperZinc.setUnlocalizedName("shield_zinc").setCreativeTab(FTCreativeTabs.tools);
        shieldHelperZinc.setRegistryName("shield_zinc");
        GameRegistry.register(shieldHelperZinc);

        //Hammers
        hammerHelperRed = new ItemHammerCore(toolMaterialRed);
        hammerHelperRed.setUnlocalizedName("hammer_red").setCreativeTab(FTCreativeTabs.tools);
        hammerHelperRed.setRegistryName("hammer_red");
        GameRegistry.register(hammerHelperRed);

        hammerHelperBlue = new ItemHammerCore(toolMaterialBlue);
        hammerHelperBlue.setUnlocalizedName("hammer_blue").setCreativeTab(FTCreativeTabs.tools);
        hammerHelperBlue.setRegistryName("hammer_blue");
        GameRegistry.register(hammerHelperBlue);

        hammerHelperGreen = new ItemHammerCore(toolMaterialGreen);
        hammerHelperGreen.setUnlocalizedName("hammer_green").setCreativeTab(FTCreativeTabs.tools);
        hammerHelperGreen.setRegistryName("hammer_green");
        GameRegistry.register(hammerHelperGreen);

        hammerHelperPurple = new ItemHammerCore(toolMaterialPurple);
        hammerHelperPurple.setUnlocalizedName("hammer_purple").setCreativeTab(FTCreativeTabs.tools);
        hammerHelperPurple.setRegistryName("hammer_purple");
        GameRegistry.register(hammerHelperPurple);

        hammerHelperTungsten = new ItemHammerCore(toolMaterialTungsten);
        hammerHelperTungsten.setUnlocalizedName("hammer_tungsten").setCreativeTab(FTCreativeTabs.tools);
        hammerHelperTungsten.setRegistryName("hammer_tungsten");
        GameRegistry.register(hammerHelperTungsten);

        hammerHelperZinc = new ItemHammerCore(toolMaterialZinc);
        hammerHelperZinc.setUnlocalizedName("hammer_zinc").setCreativeTab(FTCreativeTabs.tools);
        hammerHelperZinc.setRegistryName("hammer_zinc");
        GameRegistry.register(hammerHelperZinc);

        toolHammerRed = new ItemStack(hammerHelperRed);
        toolHammerBlue = new ItemStack(hammerHelperBlue);
        toolHammerGreen = new ItemStack(hammerHelperGreen);
        toolHammerPurple = new ItemStack(hammerHelperPurple);
        toolHammerTungsten = new ItemStack(hammerHelperTungsten);
        toolHammerZinc = new ItemStack(hammerHelperZinc);

        toolShieldRed = new ItemStack(shieldHelperRed);
        toolShieldBlue = new ItemStack(shieldHelperBlue);
        toolShieldGreen = new ItemStack(shieldHelperGreen);
        toolShieldPurple = new ItemStack(shieldHelperPurple);
        toolShieldTungsten = new ItemStack(shieldHelperTungsten);
        toolShieldZinc = new ItemStack(shieldHelperZinc);*/
    }
}
