package net.thegaminghuskymc.futopia.init;

import keri.ninetaillib.lib.mod.ContentLoader;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.items.ItemBaseDust;
import net.thegaminghuskymc.futopia.items.ItemBaseGear;
import net.thegaminghuskymc.futopia.items.ItemBaseIngot;
import net.thegaminghuskymc.futopia.items.ItemBaseNugget;
import net.thegaminghuskymc.futopia.items.ItemBasePlate;
import net.thegaminghuskymc.futopia.items.ItemBaseShard;
import net.thegaminghuskymc.futopia.items.ItemGlowingSword;
import net.thegaminghuskymc.futopia.items.ItemHammer;
import net.thegaminghuskymc.futopia.items.ItemIronStick;
import net.thegaminghuskymc.futopia.items.ItemMeteorSpawner;
import net.thegaminghuskymc.futopia.items.ItemSaw;
import net.thegaminghuskymc.futopia.items.ItemStele;
import net.thegaminghuskymc.futopia.items.ItemWindowsWasher;

@ContentLoader(modid = Refs.MODID)
public class FTItems {
	
	public static ToolMaterial toolMaterialBlue = EnumHelper.addToolMaterial("blue", 2, 700, 6.1F, 2.1F, 15);
	public static ToolMaterial toolMaterialGreen = EnumHelper.addToolMaterial("green", 2, 700, 6.1F, 2.1F, 15);
	public static ToolMaterial toolMaterialRed = EnumHelper.addToolMaterial("red", 2, 700, 6.1F, 2.1F, 15);
	public static ToolMaterial toolMaterialPurple = EnumHelper.addToolMaterial("purple", 2, 700, 6.1F, 2.1F, 15);
	public static ToolMaterial toolMaterialTungsten = EnumHelper.addToolMaterial("tungsten", 2, 700, 6.1F, 2.1F, 15);
	public static ToolMaterial toolMaterialZinc = EnumHelper.addToolMaterial("zinc", 2, 700, 6.1F, 2.1F, 15);

    /*public static Item saw = new ItemSaw();
    public static Item hammer = new ItemHammer();
    public static Item windows_washer = new ItemWindowsWasher();
    public static Item meteor_spawner = new ItemMeteorSpawner();
    public static Item dusts = new ItemBaseDust();
    public static Item ingots = new ItemBaseIngot();
    public static Item nuggets = new ItemBaseNugget();
    public static Item gears = new ItemBaseGear();
    public static Item plates = new ItemBasePlate();
    public static Item shards = new ItemBaseShard();
    public static ItemIronStick ironStick = new ItemIronStick();
    public static ItemStele stele = new ItemStele();*/

}