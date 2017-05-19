package net.thegaminghuskymc.futopia.init;

import cofh.core.item.ItemArmorCore;
import cofh.core.item.tool.*;
import cofh.core.render.IModelRegister;
import cofh.lib.util.helpers.StringHelper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.reference.Refs;

import java.util.Locale;

import static cofh.lib.util.helpers.ItemHelper.ShapedRecipe;
import static cofh.lib.util.helpers.ItemHelper.addRecipe;

public class TFEquipment {

	private TFEquipment() {

	}

	public static boolean preInit() {

		for (ArmorSet e : ArmorSet.values()) {
			e.preInit();
			Futopia.proxy.addIModelRegister(e);
		}
		for (ToolSet e : ToolSet.values()) {
			e.preInit();
			Futopia.proxy.addIModelRegister(e);
		}
		for (ToolSetVanilla e : ToolSetVanilla.values()) {
			e.preInit();
			Futopia.proxy.addIModelRegister(e);
		}
		return true;
	}

	public static boolean initialize() {

		return true;
	}

	public static boolean postInit() {

		for (ArmorSet e : ArmorSet.values()) {
			e.postInit();
		}
		for (ToolSet e : ToolSet.values()) {
			e.postInit();
		}
		for (ToolSetVanilla e : ToolSetVanilla.values()) {
			e.postInit();
		}
		return true;
	}

	/* MATERIALS */
	public static final ArmorMaterial ARMOR_MATERIAL_COPPER = EnumHelper.addArmorMaterial(Refs.RESOURSE_PREFIX + "copper", "copper_armor", 6, new int[] { 1, 3, 3, 1 }, 6, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0F);
	public static final ArmorMaterial ARMOR_MATERIAL_TIN = EnumHelper.addArmorMaterial(Refs.RESOURSE_PREFIX + "tin", "tin_armor", 8, new int[] { 1, 4, 3, 1 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0F);
	public static final ArmorMaterial ARMOR_MATERIAL_SILVER = EnumHelper.addArmorMaterial(Refs.RESOURSE_PREFIX + "silver", "silver_armor", 11, new int[] { 2, 4, 4, 1 }, 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0F);
	public static final ArmorMaterial ARMOR_MATERIAL_LEAD = EnumHelper.addArmorMaterial(Refs.RESOURSE_PREFIX + "lead", "lead_armor", 15, new int[] { 2, 5, 4, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0F);
	public static final ArmorMaterial ARMOR_MATERIAL_NICKEL = EnumHelper.addArmorMaterial(Refs.RESOURSE_PREFIX + "nickel", "nickel_armor", 15, new int[] { 2, 5, 5, 2 }, 18, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0F);
	public static final ArmorMaterial ARMOR_MATERIAL_PLATINUM = EnumHelper.addArmorMaterial(Refs.RESOURSE_PREFIX + "platinium", "platinum_armor", 40, new int[] { 3, 8, 6, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2F);
	public static final ArmorMaterial ARMOR_MATERIAL_ELECTRUM = EnumHelper.addArmorMaterial(Refs.RESOURSE_PREFIX + "electrum", "electrum_armor", 8, new int[] { 2, 4, 4, 2 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0F);
	public static final ArmorMaterial ARMOR_MATERIAL_INVAR = EnumHelper.addArmorMaterial(Refs.RESOURSE_PREFIX + "invar", "invar_armor", 21, new int[] { 2, 7, 5, 2 }, 16, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1F);
	public static final ArmorMaterial ARMOR_MATERIAL_BRONZE = EnumHelper.addArmorMaterial(Refs.RESOURSE_PREFIX + "bronze", "bronze_armor", 18, new int[] { 3, 6, 6, 2 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1F);

	public static final ToolMaterial TOOL_MATERIAL_COPPER = EnumHelper.addToolMaterial(Refs.RESOURSE_PREFIX + "copper", 1, 175, 4.0F, 0.75F, 6);
	public static final ToolMaterial TOOL_MATERIAL_TIN = EnumHelper.addToolMaterial(Refs.RESOURSE_PREFIX + "tin", 1, 200, 4.5F, 1.0F, 7);
	public static final ToolMaterial TOOL_MATERIAL_SILVER = EnumHelper.addToolMaterial(Refs.RESOURSE_PREFIX + "silver", 2, 200, 6.0F, 1.5F, 20);
	public static final ToolMaterial TOOL_MATERIAL_LEAD = EnumHelper.addToolMaterial(Refs.RESOURSE_PREFIX + "lead", 1, 150, 5.0F, 1.0F, 9);
	public static final ToolMaterial TOOL_MATERIAL_NICKEL = EnumHelper.addToolMaterial(Refs.RESOURSE_PREFIX + "nickel", 2, 300, 6.5F, 2.5F, 18);
	public static final ToolMaterial TOOL_MATERIAL_PLATINUM = EnumHelper.addToolMaterial(Refs.RESOURSE_PREFIX + "platinium", 4, 1700, 9.0F, 4.0F, 9);
	public static final ToolMaterial TOOL_MATERIAL_ELECTRUM = EnumHelper.addToolMaterial(Refs.RESOURSE_PREFIX + "electrum", 0, 100, 14.0F, 0.5F, 30);
	public static final ToolMaterial TOOL_MATERIAL_INVAR = EnumHelper.addToolMaterial(Refs.RESOURSE_PREFIX + "invar", 2, 450, 7.0F, 3.0F, 16);
	public static final ToolMaterial TOOL_MATERIAL_BRONZE = EnumHelper.addToolMaterial(Refs.RESOURSE_PREFIX + "bronze", 2, 500, 6.0F, 2.0F, 15);

	/* ARMOR */
	public enum ArmorSet implements IModelRegister {

		// @formatter:off
		COPPER("copper", ARMOR_MATERIAL_COPPER, "ingotCopper"),
		TIN("tin", ARMOR_MATERIAL_TIN, "ingotTin"),
		SILVER("silver", ARMOR_MATERIAL_SILVER, "ingotSilver"),
		LEAD("lead", ARMOR_MATERIAL_LEAD, "ingotLead"),
		NICKEL("nickel", ARMOR_MATERIAL_NICKEL, "ingotNickel"),
		PLATINUM("platinum", ARMOR_MATERIAL_PLATINUM, "ingotPlatinum"),
		ELECTRUM("electrum", ARMOR_MATERIAL_ELECTRUM, "ingotElectrum"),
		INVAR("invar", ARMOR_MATERIAL_INVAR, "ingotInvar"),
		BRONZE("bronze", ARMOR_MATERIAL_BRONZE, "ingotBronze");
		// @formatter: on

		private final String name;
		private final String ingot;
		private final ArmorMaterial ARMOR_MATERIAL;

		public ItemArmorCore itemHelmet;
		public ItemArmorCore itemChestplate;
		public ItemArmorCore itemLegs;
		public ItemArmorCore itemBoots;

		public ItemStack armorHelmet;
		public ItemStack armorChestplate;
		public ItemStack armorLegs;
		public ItemStack armorBoots;

		public boolean[] enable = new boolean[4];

		ArmorSet(String name, ArmorMaterial material, String ingot) {

			this.name = name.toLowerCase(Locale.US);
			this.ingot = ingot;
			ARMOR_MATERIAL = material;
		}

		protected void create() {
			itemHelmet = new ItemArmorCore(ARMOR_MATERIAL, EntityEquipmentSlot.HEAD);
			itemChestplate = new ItemArmorCore(ARMOR_MATERIAL, EntityEquipmentSlot.CHEST);
			itemLegs = new ItemArmorCore(ARMOR_MATERIAL, EntityEquipmentSlot.LEGS);
			itemBoots = new ItemArmorCore(ARMOR_MATERIAL, EntityEquipmentSlot.FEET);
		}

		protected void preInit() {

			final String ARMOR = "futopia.armor." + name;
			final String PATH_ARMOR = Refs.RESOURSE_PREFIX + "textures/armor/";
			final String[] TEXTURE = { PATH_ARMOR + name + "_1.png", PATH_ARMOR + name + "_2.png" };

			String category = "Equipment.Armor." + StringHelper.titleCase(name);

			enable[0] = Futopia.CONFIG2.getConfiguration().get(category, "Helmet", true).getBoolean(true);
			enable[1] = Futopia.CONFIG2.getConfiguration().get(category, "Chestplate", true).getBoolean(true);
			enable[2] = Futopia.CONFIG2.getConfiguration().get(category, "Leggings", true).getBoolean(true);
			enable[3] = Futopia.CONFIG2.getConfiguration().get(category, "Boots", true).getBoolean(true);

			for (int i = 0; i < enable.length; i++) {
				enable[i] &= !TFProps.disableAllArmor;
			}
			create();

			/* HELMET */
			itemHelmet.setArmorTextures(TEXTURE).setUnlocalizedName(ARMOR + "Helmet").setCreativeTab(Futopia.tabArmor);
			itemHelmet.setShowInCreative(enable[0]);
			itemHelmet.setRegistryName("armor.helmet_" + name);
			GameRegistry.register(itemHelmet);

			/* PLATE */
			itemChestplate.setArmorTextures(TEXTURE).setUnlocalizedName(ARMOR + "Chestplate").setCreativeTab(Futopia.tabArmor);
			itemChestplate.setShowInCreative(enable[1]);
			itemChestplate.setRegistryName("armor.plate_" + name);
			GameRegistry.register(itemChestplate);

			/* LEGS */
			itemLegs.setArmorTextures(TEXTURE).setUnlocalizedName(ARMOR + "Legs").setCreativeTab(Futopia.tabArmor);
			itemLegs.setShowInCreative(enable[2]);
			itemLegs.setRegistryName("armor.legs_" + name);
			GameRegistry.register(itemLegs);

			/* BOOTS */
			itemBoots.setArmorTextures(TEXTURE).setUnlocalizedName(ARMOR + "Boots").setCreativeTab(Futopia.tabArmor);
			itemBoots.setShowInCreative(enable[3]);
			itemBoots.setRegistryName("armor.boots_" + name);
			GameRegistry.register(itemBoots);

			/* REFERENCES */
			armorHelmet = new ItemStack(itemHelmet);
			armorChestplate = new ItemStack(itemChestplate);
			armorLegs = new ItemStack(itemLegs);
			armorBoots = new ItemStack(itemBoots);
		}

		protected void postInit() {

			if (enable[0]) {
				addRecipe(ShapedRecipe(armorHelmet, "III", "I I", 'I', ingot));
			}
			if (enable[1]) {
				addRecipe(ShapedRecipe(armorChestplate, "I I", "III", "III", 'I', ingot));
			}
			if (enable[2]) {
				addRecipe(ShapedRecipe(armorLegs, "III", "I I", "I I", 'I', ingot));
			}
			if (enable[3]) {
				addRecipe(ShapedRecipe(armorBoots, "I I", "I I", 'I', ingot));
			}
		}

		/* HELPERS */
		@SideOnly (Side.CLIENT)
		public void registerModel(Item item, String stackName) {

			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Refs.MODID + ":armor/" + name + "/" + stackName, "inventory"));
		}

		/* IModelRegister */
		@Override
		@SideOnly (Side.CLIENT)
		public void registerModels() {

			registerModel(itemHelmet, name + "_helmet");
			registerModel(itemChestplate, name + "_chestplate");
			registerModel(itemLegs, name + "_leggings");
			registerModel(itemBoots, name + "_boots");
		}
	}

	/* TOOLS */
	public enum ToolSet implements IModelRegister {

		// @formatter:off
		COPPER("copper", TOOL_MATERIAL_COPPER, "ingotCopper"),
		TIN("tin", TOOL_MATERIAL_TIN, "ingotTin"),
		SILVER("silver", TOOL_MATERIAL_SILVER, "ingotSilver"),
		LEAD("lead", TOOL_MATERIAL_LEAD, "ingotLead"),
		NICKEL("nickel", TOOL_MATERIAL_NICKEL, "ingotNickel"),
		PLATINUM("platinum", TOOL_MATERIAL_PLATINUM, "ingotPlatinum"),
		ELECTRUM("electrum", TOOL_MATERIAL_ELECTRUM, "ingotElectrum"),
		INVAR("invar",TOOL_MATERIAL_INVAR, "ingotInvar"),
		BRONZE("bronze", TOOL_MATERIAL_BRONZE, "ingotBronze");
		// @formatter: on

		private final String name;
		private final String ingot;
		private final ToolMaterial material;

		/* BOW */
		private float arrowDamage = 1000F;
		private float arrowSpeed = 500F;

		/* FISHING ROD */
		private int luckModifier = 500;
		private int speedModifier = 100;

		/* TOOLS */
		public ItemSwordCore itemSword;
		public ItemShovelCore itemShovel;
		public ItemPickaxeCore itemPickaxe;
		public ItemAxeCore itemAxe;
		public ItemHoeCore itemHoe;
		public ItemBowCore itemBow;
		public ItemFishingRodCore itemFishingRod;
		public ItemShearsCore itemShears;
		public ItemSickleCore itemSickle;
		public ItemHammerCore itemHammer;
		public ItemShieldCore itemShield;

		public ItemStack toolSword;
		public ItemStack toolShovel;
		public ItemStack toolPickaxe;
		public ItemStack toolAxe;
		public ItemStack toolHoe;
		public ItemStack toolBow;
		public ItemStack toolFishingRod;
		public ItemStack toolShears;
		public ItemStack toolSickle;
		public ItemStack toolHammer;
		public ItemStack toolShield;

		public boolean[] enable = new boolean[11];

		ToolSet(String name, ToolMaterial materialIn, String ingot) {

			this.name = name.toLowerCase(Locale.US);
			this.ingot = ingot;
			this.material = materialIn;

			arrowDamage = material.getDamageVsEntity() / 4;
			arrowSpeed = material.getEfficiencyOnProperMaterial() / 20;

			luckModifier = material.getHarvestLevel() / 2;
			speedModifier = (int) material.getEfficiencyOnProperMaterial() / 3;
		}

		protected void create() {

			itemSword = new ItemSwordCore(material);
			itemShovel = new ItemShovelCore(material);
			itemPickaxe = new ItemPickaxeCore(material);
			itemAxe = new ItemAxeCore(material);
			itemHoe = new ItemHoeCore(material);
			itemBow = new ItemBowCore(material);
			itemFishingRod = new ItemFishingRodCore(material);
			itemShears = new ItemShearsCore(material);
			itemSickle = new ItemSickleCore(material);
			itemHammer = new ItemHammerCore(material);
			itemShield = new ItemShieldCore(material);
		}

		protected void preInit() {

			final String TOOL = "futopia.tool." + name;

			String category = "Equipment.Tools." + StringHelper.titleCase(name);

			enable[0] = Futopia.CONFIG2.getConfiguration().get(category, "Sword", true).getBoolean(true);
			enable[1] = Futopia.CONFIG2.getConfiguration().get(category, "Shovel", true).getBoolean(true);
			enable[2] = Futopia.CONFIG2.getConfiguration().get(category, "Pickaxe", true).getBoolean(true);
			enable[3] = Futopia.CONFIG2.getConfiguration().get(category, "Axe", true).getBoolean(true);
			enable[4] = Futopia.CONFIG2.getConfiguration().get(category, "Hoe", true).getBoolean(true);
			enable[5] = Futopia.CONFIG2.getConfiguration().get(category, "Bow", true).getBoolean(true);
			enable[6] = Futopia.CONFIG2.getConfiguration().get(category, "FishingRod", true).getBoolean(true);
			enable[7] = Futopia.CONFIG2.getConfiguration().get(category, "Shears", true).getBoolean(true);
			enable[8] = Futopia.CONFIG2.getConfiguration().get(category, "Sickle", true).getBoolean(true);
			enable[9] = Futopia.CONFIG2.getConfiguration().get(category, "Hammer", true).getBoolean(true);
			enable[10] = Futopia.CONFIG2.getConfiguration().get(category, "Shield", true).getBoolean(true);

			create();

			/* SWORD */
			itemSword.setUnlocalizedName(TOOL + "Sword").setCreativeTab(Futopia.tabTools);
			itemSword.setShowInCreative(enable[0]);
			itemSword.setRegistryName("tool.sword_" + name);
			GameRegistry.register(itemSword);

			/* SHOVEL */
			itemShovel.setUnlocalizedName(TOOL + "Shovel").setCreativeTab(Futopia.tabTools);
			itemShovel.setShowInCreative(enable[1]);
			itemShovel.setRegistryName("tool.shovel_" + name);
			GameRegistry.register(itemShovel);

			/* PICKAXE */
			itemPickaxe.setUnlocalizedName(TOOL + "Pickaxe").setCreativeTab(Futopia.tabTools);
			itemPickaxe.setShowInCreative(enable[2]);
			itemPickaxe.setRegistryName("tool.pickaxe_" + name);
			GameRegistry.register(itemPickaxe);

			/* AXE */
			itemAxe.setUnlocalizedName(TOOL + "Axe").setCreativeTab(Futopia.tabTools);
			itemAxe.setShowInCreative(enable[3]);
			itemAxe.setRegistryName("tool.axe_" + name);
			GameRegistry.register(itemAxe);

			/* HOE */
			itemHoe.setRepairIngot(ingot).setUnlocalizedName(TOOL + "Hoe").setCreativeTab(Futopia.tabTools);
			itemHoe.setShowInCreative(enable[4]);
			itemHoe.setRegistryName("tool.hoe_" + name);
			GameRegistry.register(itemHoe);

			/* BOW */
			itemBow.setUnlocalizedName(TOOL + "Bow").setCreativeTab(Futopia.tabTools);
			itemBow.setArrowDamage(arrowDamage).setArrowSpeed(arrowSpeed);
			itemBow.setShowInCreative(enable[5]);
			itemBow.setRegistryName("tool.bow_" + name);
			GameRegistry.register(itemBow);

			/* FISHING ROD */
			itemFishingRod.setUnlocalizedName(TOOL + "FishingRod").setCreativeTab(Futopia.tabTools);
			itemFishingRod.setLuckModifier(luckModifier).setSpeedModifier(speedModifier);
			itemFishingRod.setShowInCreative(enable[6]);
			itemFishingRod.setRegistryName("tool.fishing_rod_" + name);
			GameRegistry.register(itemFishingRod);

			/* SHEARS */
			itemShears.setRepairIngot(ingot).setUnlocalizedName(TOOL + "Shears").setCreativeTab(Futopia.tabTools);
			itemShears.setShowInCreative(enable[7]);
			itemShears.setRegistryName("tool.shears_" + name);
			GameRegistry.register(itemShears);

			/* SICKLE */
			itemSickle.setUnlocalizedName(TOOL + "Sickle").setCreativeTab(Futopia.tabTools);
			itemSickle.setShowInCreative(enable[8]);
			itemSickle.setRegistryName("tool.sickle_" + name);
			GameRegistry.register(itemSickle);

			/* HAMMER */
			itemHammer.setUnlocalizedName(TOOL + "Hammer").setCreativeTab(Futopia.tabTools);
			itemHammer.setShowInCreative(enable[9]);
			itemHammer.setRegistryName("tool.hammer_" + name);
			GameRegistry.register(itemHammer);

			/* SHIELD */
			itemShield.setUnlocalizedName(TOOL + "Shield").setCreativeTab(Futopia.tabTools);
			itemShield.setShowInCreative(enable[10]);
			itemShield.setRegistryName("tool.shield_" + name);
			GameRegistry.register(itemShield);


			/* REFERENCES */
			toolSword = new ItemStack(itemSword);
			toolShovel = new ItemStack(itemShovel);
			toolPickaxe = new ItemStack(itemPickaxe);
			toolAxe = new ItemStack(itemAxe);
			toolHoe = new ItemStack(itemHoe);
			toolBow = new ItemStack(itemBow);
			toolFishingRod = new ItemStack(itemFishingRod);
			toolShears = new ItemStack(itemShears);
			toolSickle = new ItemStack(itemSickle);
			toolHammer = new ItemStack(itemHammer);
			toolShield = new ItemStack(itemShield);
		}

		protected void postInit() {

			if (enable[0]) {
				addRecipe(ShapedRecipe(toolSword, "I", "I", "S", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[1]) {
				addRecipe(ShapedRecipe(toolShovel, "I", "S", "S", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[2]) {
				addRecipe(ShapedRecipe(toolPickaxe, "III", " S ", " S ", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[3]) {
				addRecipe(ShapedRecipe(toolAxe, "II", "IS", " S", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[4]) {
				addRecipe(ShapedRecipe(toolHoe, "II", " S", " S", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[5]) {
				addRecipe(ShapedRecipe(toolBow, " I#", "S #", " I#", 'I', ingot, 'S', "stickWood", '#', Items.STRING));
			}
			if (enable[6]) {
				addRecipe(ShapedRecipe(toolFishingRod, "  I", " I#", "S #", 'I', ingot, 'S', "stickWood", '#', Items.STRING));
			}
			if (enable[7]) {
				addRecipe(ShapedRecipe(toolShears, " I", "I ", 'I', ingot));
			}
			if (enable[8]) {
				addRecipe(ShapedRecipe(toolSickle, " I ", "  I", "SI ", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[9]) {
				addRecipe(ShapedRecipe(toolHammer, "III", "ISI", " S ", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[10]) {
				addRecipe(ShapedRecipe(toolShield, "III", "ISI", " I ", 'I', ingot, 'S', Items.SHIELD));
			}
		}

		/* HELPERS */
		@SideOnly (Side.CLIENT)
		public void registerModel(Item item, String stackName) {

			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Refs.MODID + ":tool/" + name + "/" + stackName, "inventory"));
		}

		/* IModelRegister */
		@Override
		@SideOnly (Side.CLIENT)
		public void registerModels() {

			registerModel(itemSword, name + "_sword");
			registerModel(itemShovel, name + "_shovel");
			registerModel(itemPickaxe, name + "_pickaxe");
			registerModel(itemAxe, name + "_axe");
			registerModel(itemHoe, name + "_hoe");
			registerModel(itemBow, name + "_bow");
			registerModel(itemFishingRod, name + "_fishing_rod");
			registerModel(itemShears, name + "_shears");
			registerModel(itemSickle, name + "_sickle");
			registerModel(itemHammer, name + "_hammer");
			registerModel(itemShield, name + "_shield");
		}
	}

	/* VANILLA */
	public enum ToolSetVanilla implements IModelRegister {

		// @formatter:off
    	WOOD("wood", ToolMaterial.WOOD, "plankWood") {

    		@Override
    		protected void create() {

    			itemBow = Items.BOW;
    			itemFishingRod = Items.FISHING_ROD;
				itemShears = new ItemShearsCore(material);
    			itemSickle = new ItemSickleCore(material);
    			itemHammer = new ItemHammerCore(material);
    			itemShield = Items.SHIELD;
    		}
    	},
    	STONE("stone", ToolMaterial.STONE, "cobblestone"),
    	IRON("iron", ToolMaterial.IRON, "ingotIron") {

    		@Override
    		protected void create() {

				itemBow = new ItemBowCore(material);
    			itemFishingRod = new ItemFishingRodCore(material);
				itemShears = Items.SHEARS;
    			itemSickle = new ItemSickleCore(material);
				itemHammer = new ItemHammerCore(material);
				itemShield = new ItemShieldCore(material);

    		}
    	},
    	DIAMOND("diamond", ToolMaterial.DIAMOND, "gemDiamond"),
    	GOLD("gold", ToolMaterial.GOLD, "ingotGold");
		// @formatter:on

		private final String name;
		private final String ingot;
		public final ToolMaterial material;

		/* BOW */
		private float arrowSpeed = 0.0F;
		private float arrowDamage = 0.0F;

		/* FISHING ROD */
		private int luckModifier = 0;
		private int speedModifier = 0;

		/* TOOLS */
		public ItemBow itemBow;
		public ItemFishingRod itemFishingRod;
		public ItemShears itemShears;
		public ItemSickleCore itemSickle;
		public ItemHammerCore itemHammer;
		public Item itemShield;

		public ItemStack toolBow;
		public ItemStack toolFishingRod;
		public ItemStack toolShears;
		public ItemStack toolSickle;
		public ItemStack toolHammer;
		public ItemStack toolShield;

		public boolean[] enable = new boolean[6];

		ToolSetVanilla(String name, ToolMaterial materialIn, String ingot) {

			this.name = name.toLowerCase(Locale.US);
			this.ingot = ingot;
			this.material = materialIn;

			/* BOW */
			arrowDamage = material.getDamageVsEntity() / 4;
			arrowSpeed = material.getEfficiencyOnProperMaterial() / 20;

			/* FISHING ROD */
			luckModifier = material.getHarvestLevel() / 2;
			speedModifier = (int) material.getEfficiencyOnProperMaterial() / 3;
		}

		protected void create() {

			itemBow = new ItemBowCore(material);
			itemFishingRod = new ItemFishingRodCore(material);
			itemShears = new ItemShearsCore(material);
			itemSickle = new ItemSickleCore(material);
			itemHammer = new ItemHammerCore(material);
			itemShield = new ItemShieldCore(material);
		}

		protected boolean enableDefault(ToolSetVanilla type) {

			return type != WOOD && type != STONE;
		}

		protected void preInit() {

			final String TOOL = "futopia.tool." + name;

			String category = "Equipment.Tool." + StringHelper.titleCase(name);

			if (this != WOOD) {
				enable[0] = Futopia.CONFIG2.getConfiguration().get(category, "Bow", enableDefault(this)).getBoolean(enableDefault(this)) & !TFProps.disableAllBows;
				enable[1] = Futopia.CONFIG2.getConfiguration().get(category, "FishingRod", enableDefault(this)).getBoolean(enableDefault(this)) & !TFProps.disableAllFishingRods;
			}
			if (this != IRON) {
				enable[2] = Futopia.CONFIG2.getConfiguration().get(category, "Shears", enableDefault(this)).getBoolean(enableDefault(this)) & !TFProps.disableAllShears;
			}
			enable[3] = Futopia.CONFIG2.getConfiguration().get(category, "Sickle", enableDefault(this)).getBoolean(enableDefault(this));
			enable[4] = Futopia.CONFIG2.getConfiguration().get(category, "Hammer", enableDefault(this)).getBoolean(enableDefault(this));

			if (this != WOOD) {
				enable[5] = Futopia.CONFIG2.getConfiguration().get(category, "Shield", enableDefault(this)).getBoolean(enableDefault(this));
			}

			for (int i = 0; i < enable.length; i++) {
				enable[i] &= !TFProps.disableAllTools;
				enable[i] &= !TFProps.disableVanillaTools;
			}
			create();

			/* BOW */
			if (itemBow instanceof ItemBowCore) {
				ItemBowCore itemBow = (ItemBowCore) this.itemBow;
				itemBow.setRepairIngot(ingot).setArrowSpeed(arrowSpeed).setArrowDamage(arrowDamage).setUnlocalizedName(TOOL + "Bow").setCreativeTab(CreativeTabs.COMBAT);
				itemBow.setShowInCreative(enable[0]);
				itemBow.setRegistryName("tool.bow_" + name);
				GameRegistry.register(itemBow);
			}

			/* FISHING ROD */
			if (itemFishingRod instanceof ItemFishingRodCore) {
				ItemFishingRodCore itemFishingRod = (ItemFishingRodCore) this.itemFishingRod;
				itemFishingRod.setRepairIngot(ingot).setUnlocalizedName(TOOL + "FishingRod").setCreativeTab(CreativeTabs.TOOLS);
				itemFishingRod.setLuckModifier(luckModifier).setSpeedModifier(speedModifier);
				itemFishingRod.setShowInCreative(enable[1]);
				itemFishingRod.setRegistryName("tool.fishing_rod_" + name);
				GameRegistry.register(itemFishingRod);
			}

			/* SHEARS */
			if (itemShears instanceof ItemShearsCore) {
				ItemShearsCore itemShears = (ItemShearsCore) this.itemShears;
				itemShears.setRepairIngot(ingot).setUnlocalizedName(TOOL + "Shears").setCreativeTab(CreativeTabs.TOOLS);
				itemShears.setShowInCreative(enable[2]);
				itemShears.setRegistryName("tool.shears_" + name);
				GameRegistry.register(itemShears);
			}

			/* SICKLE */
			itemSickle.setRepairIngot(ingot).setUnlocalizedName(TOOL + "Sickle").setCreativeTab(CreativeTabs.TOOLS);
			itemSickle.setShowInCreative(enable[3]);
			itemSickle.setRegistryName("tool.sickle_" + name);
			GameRegistry.register(itemSickle);

			/* HAMMER */
			itemHammer.setRepairIngot(ingot).setUnlocalizedName(TOOL + "Hammer").setCreativeTab(CreativeTabs.TOOLS);
			itemHammer.setShowInCreative(enable[4]);
			itemHammer.setRegistryName("tool.hammer_" + name);
			GameRegistry.register(itemHammer);

			/* SHIELD */
			if (itemShield instanceof ItemShieldCore) {
				((ItemShieldCore) itemShield).setRepairIngot(ingot).setUnlocalizedName(TOOL + "Shield").setCreativeTab(CreativeTabs.COMBAT);
				((ItemShieldCore) itemShield).setShowInCreative(enable[5]);
				itemShield.setRegistryName("tool.shield_" + name);
				GameRegistry.register(itemShield);
			}

			toolBow = new ItemStack(itemBow);
			toolFishingRod = new ItemStack(itemFishingRod);
			toolShears = new ItemStack(itemShears);
			toolSickle = new ItemStack(itemSickle);
			toolHammer = new ItemStack(itemHammer);
			toolShield = new ItemStack(itemShield);
		}

		protected void postInit() {

			if (enable[0]) {
				addRecipe(ShapedRecipe(toolBow, " I#", "S #", " I#", 'I', ingot, 'S', "stickWood", '#', Items.STRING));
			}
			if (enable[1]) {
				addRecipe(ShapedRecipe(toolFishingRod, "  I", " I#", "S #", 'I', ingot, 'S', "stickWood", '#', Items.STRING));
			}
			if (enable[2]) {
				addRecipe(ShapedRecipe(toolShears, " I", "I ", 'I', ingot));
			}
			if (enable[3]) {
				addRecipe(ShapedRecipe(toolSickle, " I ", "  I", "SI ", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[4]) {
				addRecipe(ShapedRecipe(toolHammer, "III", "ISI", " S ", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[5]) {
				addRecipe(ShapedRecipe(toolShield, "III", "ISI", " I ", 'I', ingot, 'S', Items.SHIELD));
			}
		}

		/* HELPERS */
		@SideOnly (Side.CLIENT)
		public void registerModel(Item item, String stackName) {

			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Refs.MODID + ":tool/" + name + "/" + stackName, "inventory"));
		}

		/* IModelRegister */
		@Override
		@SideOnly (Side.CLIENT)
		public void registerModels() {

			if (itemBow instanceof ItemBowCore) {
				registerModel(itemBow, name + "_bow");
			}
			if (itemFishingRod instanceof ItemFishingRodCore) {
				registerModel(itemFishingRod, name + "_fishing_rod");
			}
			if (itemShears instanceof ItemShearsCore) {
				registerModel(itemShears, name + "_shears");
			}
			registerModel(itemSickle, name + "_sickle");
			registerModel(itemHammer, name + "_hammer");

			if (itemShield instanceof ItemShieldCore) {
				registerModel(itemShield, name + "_shield");
			}
		}
	}

}
