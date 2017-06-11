package net.thegaminghuskymc.futopia;

import keri.ninetaillib.lib.logger.ModLogger;
import keri.ninetaillib.lib.mod.ModHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.init.OtherBlocks;
import net.thegaminghuskymc.futopia.proxy.IFutopiaProxy;

import static net.thegaminghuskymc.futopia.Refs.CSIDE;
import static net.thegaminghuskymc.futopia.Refs.SSIDE;

@Mod(modid = Refs.MODID, name = Refs.NAME, version = Refs.VERSION, dependencies = Refs.DEPS, acceptedMinecraftVersions = Refs.ACC_MC)
public class Futopia {

    @Mod.Instance(value = Refs.MODID)
    public static Futopia INSTANCE = new Futopia();
    public static ModHandler MOD_HANDLER = new ModHandler(INSTANCE);

    @SidedProxy(clientSide = CSIDE, serverSide = SSIDE)
    public static IFutopiaProxy PROXY;
    @ModLogger
    public static IFutopiaLogger LOGGER;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MOD_HANDLER.handlePreInit(event);
        OtherBlocks.preInit();
        PROXY.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MOD_HANDLER.handleInit(event);
        OtherBlocks.initialize();
        PROXY.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MOD_HANDLER.handlePostInit(event);
        OtherBlocks.postInit();
        PROXY.postInit(event);
    }
}