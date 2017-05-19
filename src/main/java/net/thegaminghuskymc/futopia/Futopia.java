package net.thegaminghuskymc.futopia;

import cofh.core.init.CoreProps;
import cofh.core.util.ConfigHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.thegaminghuskymc.futopia.client.GuiHandler;
import net.thegaminghuskymc.futopia.client.gui.GUIHandler;
import net.thegaminghuskymc.futopia.init.*;
import net.thegaminghuskymc.futopia.reference.Refs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = Refs.MODID, name = Refs.NAME, version = Refs.VERSION, dependencies = Refs.DEPS)
public class Futopia {

    public static final GUIHandler GUI_HANDLER = new GUIHandler();
    public static final GuiHandler GUI_HANDLER2 = new GuiHandler();
    @Instance(Refs.MODID)
    public static Futopia instance;
    @SidedProxy(clientSide = Refs.CLIENT_PROXY, serverSide = Refs.COMMON_PROXY)
    public static IFutopiaProxy proxy;
    public static FutopiaConfig CONFIG;
    public static Logger log = LogManager.getLogger(Refs.NAME);
    public static final ConfigHandler CONFIG2 = new ConfigHandler(Refs.VERSION);
    public static final ConfigHandler CONFIG_CLIENT = new ConfigHandler(Refs.VERSION);

    public static CreativeTabs tabCommon;
    public static CreativeTabs tabTools;
    public static CreativeTabs tabArmor;

    static {
        FluidRegistry.enableUniversalBucket();
        FluidRegistry.validateFluidRegistry();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CONFIG = new FutopiaConfig(event);
        CONFIG2.setConfiguration(new Configuration(new File(CoreProps.configDir, "/futopia/" + Refs.MODID + "/common.cfg"), true));
        CONFIG_CLIENT.setConfiguration(new Configuration(new File(CoreProps.configDir, "/futopia/" + Refs.MODID + "/client.cfg"), true));
        TFProps.preInit();
        FTBlocks.init();
        TFBlocks.preInit();
        FTItems.init();
        Recipies.init();
        TFEquipment.preInit();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        TFBlocks.initialize();
        FutopiaOreDictionary.init();
        TFEquipment.initialize();
        proxy.init(event);
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        TFBlocks.postInit();
        TFEquipment.postInit();
        proxy.postInit(event);
    }
}
