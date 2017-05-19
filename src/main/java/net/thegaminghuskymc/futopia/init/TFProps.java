package net.thegaminghuskymc.futopia.init;

import cofh.thermalfoundation.ThermalFoundation;
import cofh.thermalfoundation.gui.CreativeTabTF;
import cofh.thermalfoundation.init.TFEquipment.ArmorSet;
import cofh.thermalfoundation.init.TFEquipment.ToolSet;
import cofh.thermalfoundation.util.LexiconManager;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.client.CreativeTabFT;

public class TFProps {

	private TFProps() {

	}

	public static void preInit() {
        configCommon();
        configClient();
	}

	public static void loadComplete() {

		LexiconManager.loadComplete();

		String prefix = "config.futopia.";
		String[] categoryNames = Futopia.CONFIG2.getCategoryNames().toArray(new String[Futopia.CONFIG2.getCategoryNames().size()]);
		for (int i = 0; i < categoryNames.length; i++) {
			Futopia.CONFIG2.getCategory(categoryNames[i]).setLanguageKey(prefix + categoryNames[i]).setRequiresMcRestart(true);
		}
		categoryNames = Futopia.CONFIG_CLIENT.getCategoryNames().toArray(new String[Futopia.CONFIG_CLIENT.getCategoryNames().size()]);
		for (int i = 0; i < categoryNames.length; i++) {
			Futopia.CONFIG_CLIENT.getCategory(categoryNames[i]).setLanguageKey(prefix + categoryNames[i]).setRequiresMcRestart(true);
		}
	}

	/* HELPERS */
	private static void configCommon() {

		String category;
		String comment;

		/* GENERAL */
		category = "General";

		comment = "If TRUE, Fire-Immune mobs have a chance to drop Sulfur.";
		dropSulfurFireImmuneMobs = Futopia.CONFIG2.getConfiguration().getBoolean("FireImmuneMobsDropSulfur", category, dropSulfurFireImmuneMobs, comment);

		/* EQUIPMENT */
		category = "Equipment";
		comment = "If TRUE, recipes for all Armor Sets are disabled.";
		disableAllArmor = Futopia.CONFIG2.getConfiguration().getBoolean("DisableAllArmorRecipes", category, disableAllArmor, comment);

		comment = "If TRUE, recipes for all Tools are disabled.";
		disableAllTools = Futopia.CONFIG2.getConfiguration().getBoolean("DisableAllToolRecipes", category, disableAllTools, comment);

		comment = "If TRUE, recipes for new Vanilla material (Wood, Stone, Iron, Gold, Diamond) Tools are disabled.";
		disableVanillaTools = Futopia.CONFIG2.getConfiguration().getBoolean("DisableVanillaToolRecipes", category, disableVanillaTools, comment);

		comment = "If TRUE, recipes for all new Bows will be disabled, leaving only the Vanilla Bow";
		disableAllBows = Futopia.CONFIG2.getConfiguration().getBoolean("DisableAllBows", category, disableAllBows, comment);

		comment = "If TRUE, recipes for all new Shears will be disabled, leaving only the Vanilla (Iron) Shears.";
		disableAllShears = Futopia.CONFIG2.getConfiguration().getBoolean("DisableAllShears", category, disableAllShears, comment);

		comment = "If TRUE, recipes for all new Fishing Rods will be disabled, leaving only the Vanilla (Wood) Fishing Rod";
		disableAllFishingRods = Futopia.CONFIG2.getConfiguration().getBoolean("DisableAllFishingRods", category, disableAllFishingRods, comment);

		comment = "If TRUE, recipes for all new Shields will be disabled, leaving only the Vanilla (Wood) Shield";
		disableAllShields = Futopia.CONFIG2.getConfiguration().getBoolean("DisableAllShields", category, disableAllShields, comment);

		comment = "If TRUE, items which have had their recipes disabled will show in the Creative Tab and JEI.";
		showDisabledEquipment = Futopia.CONFIG2.getConfiguration().getBoolean("ShowDisabledEquipment", category, showDisabledEquipment, comment);
	}

	private static void configClient() {

        String category;
        String comment;

		/* GRAPHICS */
        category = "Render";

        //		comment = "If TRUE, Blaze Powder uses a custom icon.";
        //		iconBlazePowder = ThermalFoundation.CONFIG_CLIENT.getConfiguration().getBoolean("BlazePowder", category, iconBlazePowder, comment);

        comment = "If TRUE, Ender devices will be a bit more Cagey year-round.";
        renderStarfieldCage = Futopia.CONFIG_CLIENT.getConfiguration().getBoolean("CageyEnder", category, renderStarfieldCage, comment);

        category = "Interface";
		boolean armorTabCommon = false;
		boolean toolTabCommon = false;

		/* CREATIVE TABS */
		Futopia.tabCommon = new CreativeTabFT();

		if (armorTabCommon) {
            Futopia.tabArmor = Futopia.tabCommon;
		} else {
            Futopia.tabArmor = new CreativeTabFT("Armor") {

				@Override
				protected ItemStack getStack() {

					return ArmorSet.INVAR.armorChestplate;
				}
			};
		}
		if (toolTabCommon) {
            Futopia.tabTools = ThermalFoundation.tabCommon;
		} else {
			Futopia.tabTools = new CreativeTabFT("Tools") {

				@Override
				protected ItemStack getStack() {

					return ToolSet.INVAR.toolPickaxe;
				}
			};
		}
	}

	/* INTERFACE */
	public static boolean disableAllTools = false;
	public static boolean disableAllArmor = false;
	public static boolean disableVanillaTools = false;

	public static boolean disableAllBows = true;
	public static boolean disableAllFishingRods = true;
	public static boolean disableAllShears = true;
	public static boolean disableAllShields = true;

	public static boolean showDisabledEquipment = false;

	public static boolean dropSulfurFireImmuneMobs = true;

	public static int gemCokeFuel = 3200;
	public static int globRosinFuel = 800;
	public static int globTarFuel = 800;
	public static int dustPyrotheumFuel = 24000;

	/* RENDER */
	public static boolean iconBlazePowder = true;
	public static boolean renderStarfieldCage = false;

}
