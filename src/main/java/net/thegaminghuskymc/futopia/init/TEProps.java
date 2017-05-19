package net.thegaminghuskymc.futopia.init;

import codechicken.lib.block.property.unlisted.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.thegaminghuskymc.futopia.reference.Refs;

public class TEProps {

    /* GENERAL */
    public static final int MAX_FLUID_SMALL = Fluid.BUCKET_VOLUME * 4;
    public static final int MAX_FLUID_MEDIUM = Fluid.BUCKET_VOLUME * 8;
    public static final int MAX_FLUID_LARGE = Fluid.BUCKET_VOLUME * 10;
    public static final int MAGMATIC_TEMPERATURE = 1000;
    public static final int LEVEL_MIN = 0;
    public static final int LEVEL_MAX = 4;
    /* TEXTURES */
    public static final String PATH_GFX = Refs.MODID + "textures/";
    public static final String PATH_ARMOR = PATH_GFX + "armor/";
    public static final String PATH_GUI = PATH_GFX + "gui/";
    public static final String PATH_ENTITY = PATH_GFX + "entity/";
    public static final String PATH_RENDER = PATH_GFX + "blocks/";
    public static final String PATH_ELEMENTS = PATH_GUI + "elements/";
    public static final String PATH_GUI_AUTOMATON = PATH_GUI + "automaton/";
    public static final String PATH_GUI_DEVICE = PATH_GUI + "device/";
    public static final String PATH_GUI_DYNAMO = PATH_GUI + "dynamo/";
    public static final String PATH_GUI_MACHINE = PATH_GUI + "machine/";
    public static final String PATH_GUI_STORAGE = PATH_GUI + "storage/";
    public static final ResourceLocation PATH_COMMON = new ResourceLocation(PATH_ELEMENTS + "slots.png");
    public static final ResourceLocation PATH_COMMON_CB = new ResourceLocation(PATH_ELEMENTS + "slots_cb.png");
    public static final ResourceLocation PATH_CENTRIFUGE = new ResourceLocation(PATH_ELEMENTS + "slots_centrifuge.png");
    public static final ResourceLocation PATH_CENTRIFUGE_CB = new ResourceLocation(PATH_ELEMENTS + "slots_centrifuge_cb.png");
    public static final ResourceLocation PATH_CRAFTER = new ResourceLocation(PATH_ELEMENTS + "slots_crafter.png");
    public static final ResourceLocation PATH_CRAFTER_CB = new ResourceLocation(PATH_ELEMENTS + "slots_crafter_cb.png");
    public static final String PATH_ICON = PATH_GUI + "icons/";
    public static final String TEXTURE_DEFAULT = "config_";
    public static final String TEXTURE_CB = "config_cb_";
    /* BLOCKSTATE PROPERTIES */
    public static final UnlistedBooleanProperty ACTIVE = new UnlistedBooleanProperty("active");
    public static final UnlistedBooleanProperty CREATIVE = new UnlistedBooleanProperty("creative");
    public static final UnlistedEnumFacingProperty FACING = new UnlistedEnumFacingProperty("facing");
    public static final UnlistedIntegerProperty LEVEL = new UnlistedIntegerProperty("level");
    public static final UnlistedIntegerProperty LIGHT = new UnlistedIntegerProperty("light");
    public static final UnlistedIntegerProperty SCALE = new UnlistedIntegerProperty("scale_display");
    public static final UnlistedByteArrayProperty SIDE_CONFIG = new UnlistedByteArrayProperty("side_config");
    public static final UnlistedIntArrayProperty SIDE_TEX = new UnlistedIntArrayProperty("side_tex");
    public static final UnlistedFluidStackProperty FLUID = new UnlistedFluidStackProperty("fluid_stack");
    public static final UnlistedResourceLocationProperty ACTIVE_SPRITE_PROPERTY = new UnlistedResourceLocationProperty("active_texture");
    public static final UnlistedTileEntityProperty TILE = new UnlistedTileEntityProperty("tile");
    /* MACHINES */
    public static final String MACHINE_POWER = "machinePower";
    public static final String MACHINE_SECONDARY = "machineSecondary";
    public static final String MACHINE_SECONDARY_NULL = "machineSecondaryNull";
    public static final String MACHINE_FURNACE_FOOD = "machineFurnaceFood";
    public static final String MACHINE_FURNACE_ORE = "machineFurnaceOre";
    public static final String MACHINE_PULVERIZER_GEODE = "machinePulverizerGeode";
    public static final String MACHINE_PULVERIZER_PETROTHEUM = "machinePulverizerPetrotheum";
    public static final String MACHINE_SAWMILL_TAPPER = "machineSawmillTapper";
    public static final String MACHINE_SMELTER_PYROTHEUM = "machineSmelterPyrotheum";
    public static final String MACHINE_INSOLATOR_MYCELIUM = "machineInsolatorMycelium";
    public static final String MACHINE_INSOLATOR_NETHER = "machineInsolatorNether";
    public static final String MACHINE_INSOLATOR_END = "machineInsolatorEnd";
    public static final String MACHINE_COMPACTOR_MINT = "machineCompactorMint";
    public static final String MACHINE_CRUCIBLE_ALLOY = "machineCrucibleAlloy";
    public static final String MACHINE_CHARGER_THROUGHPUT = "machineChargerThroughput";
    public static final String MACHINE_EXTRUDER_BATCH_SIZE = "machineExtruderBatchSize";

	/* AUGMENT IDENTIFIERS */
    public static final String MACHINE_EXTRUDER_GRANITE = "machineExtruderGranite";
    public static final String MACHINE_EXTRUDER_DIORITE = "machineExtruderDiorite";
    public static final String MACHINE_EXTRUDER_ANDESITE = "machineExtruderAndesite";
    /* DYNAMOS */
    public static final String DYNAMO_POWER = "dynamoPower";
    public static final String DYNAMO_EFFICIENCY = "dynamoEfficiency";
    public static final String DYNAMO_COIL_DUCT = "dynamoCoilDuct";
    public static final String DYNAMO_THROTTLE = "dynamoThrottle";
    public static final String DYNAMO_STEAM_TURBINE = "dynamoSteamTurbine";
    public static final String DYNAMO_MAGMATIC_COOLANT = "dynamoMagmaticCoolant";
    public static final String DYNAMO_COMPRESSION_COOLANT = "dynamoCompressionCoolant";
    public static final String DYNAMO_COMPRESSION_FUEL = "dynamoCompressionFuel";
    /* AUTOMATA */
    public static final String AUTOMATON_DEPTH = "automatonDepth";
    public static final String AUTOMATON_RADIUS = "automatonRadius";
    public static boolean creativeTabShowAllLevels = true;
    public static boolean creativeTabShowCreative = true;
    public static int creativeTabLevel = 0;
    /* UPGRADE FEATURES */
    public static int levelAutoInput = 0;
    public static int levelAutoOutput = 0;
    public static int levelRedstoneControl = 0;
    public static ResourceLocation textureGuiCommon = PATH_COMMON;
    public static ResourceLocation textureGuiCentrifuge = PATH_CENTRIFUGE;
    public static ResourceLocation textureGuiCrafter = PATH_CRAFTER;
    public static String textureSelection = TEXTURE_DEFAULT;
    public static boolean useAlternateStarfieldShader = false;

    private TEProps() {

    }

    public static void preInit() {

        configCommon();
        configClient();
    }

    public static void loadComplete() {

    }

    /* HELPERS */
    private static void configCommon() {

        String category;
        String comment;
    }

    private static void configClient() {

        String category;
        String comment;
    }

}
