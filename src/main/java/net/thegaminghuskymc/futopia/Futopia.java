package net.thegaminghuskymc.futopia;

import static net.thegaminghuskymc.futopia.Refs.CSIDE;
import static net.thegaminghuskymc.futopia.Refs.SSIDE;

import keri.ninetaillib.lib.config.IModConfig;
import keri.ninetaillib.lib.config.ModConfig;
import keri.ninetaillib.lib.logger.ModLogger;
import keri.ninetaillib.lib.mod.ModHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.thegaminghuskymc.futopia.client.gui.GuiHandler;
import net.thegaminghuskymc.futopia.init.FutopiaOreDictionary;
import net.thegaminghuskymc.futopia.init.OtherBlocks;
import net.thegaminghuskymc.futopia.init.Recipies;
import net.thegaminghuskymc.futopia.proxy.IFutopiaProxy;

@Mod(modid = Refs.MODID, name = Refs.NAME, version = Refs.VERSION, dependencies = Refs.DEPS, acceptedMinecraftVersions = Refs.ACC_MC)
public class Futopia {

    @Instance(value = Refs.MODID)
    public static Futopia INSTANCE = new Futopia();
    public static ModHandler MOD_HANDLER = new ModHandler(INSTANCE);
    public static final GuiHandler GUI_HANDLER = new GuiHandler();

    @SidedProxy(clientSide = CSIDE, serverSide = SSIDE)
    public static IFutopiaProxy PROXY;
    @ModLogger
    public static IFutopiaLogger LOGGER;
    /*@ModConfig
    public static IModConfig CONFIG;*/

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MOD_HANDLER.handlePreInit(event);
        OtherBlocks.preInit();
        Recipies.init();
        PROXY.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MOD_HANDLER.handleInit(event);
        OtherBlocks.initialize();
        FutopiaOreDictionary.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());
        PROXY.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MOD_HANDLER.handlePostInit(event);
        OtherBlocks.postInit();
        PROXY.postInit(event);
    }
}