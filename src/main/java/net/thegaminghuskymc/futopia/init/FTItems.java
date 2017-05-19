package net.thegaminghuskymc.futopia.init;

import cofh.core.item.tool.ItemHammerCore;
import cofh.core.item.tool.ItemShieldCore;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
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

        shieldHelperRed = new ItemShieldCore(toolMaterialRed);
        shieldHelperBlue = new ItemShieldCore(toolMaterialBlue);
        shieldHelperGreen = new ItemShieldCore(toolMaterialGreen);
        shieldHelperPurple = new ItemShieldCore(toolMaterialPurple);
        shieldHelperTungsten = new ItemShieldCore(toolMaterialTungsten);
        shieldHelperZinc = new ItemShieldCore(toolMaterialZinc);

        hammerHelperRed = new ItemHammerCore(toolMaterialRed);
        hammerHelperBlue = new ItemHammerCore(toolMaterialBlue);
        hammerHelperGreen = new ItemHammerCore(toolMaterialGreen);
        hammerHelperPurple = new ItemHammerCore(toolMaterialPurple);
        hammerHelperTungsten = new ItemHammerCore(toolMaterialTungsten);
        hammerHelperZinc = new ItemHammerCore(toolMaterialZinc);
    }
}
