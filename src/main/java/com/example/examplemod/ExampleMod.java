package com.example.examplemod;

import com.example.examplemod.proxy.IExampleProxy;
import keri.ninetaillib.lib.logger.ModLogger;
import keri.ninetaillib.lib.mod.ModHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.example.examplemod.Refs.CSIDE;
import static com.example.examplemod.Refs.SSIDE;

@Mod(modid = Refs.MODID, name = Refs.NAME, version = Refs.VERSION, dependencies = Refs.DEPS, acceptedMinecraftVersions = Refs.ACC_MC)
public class ExampleMod{

    public static ExampleMod INSTANCE = new ExampleMod();
    private static ModHandler MOD_HANDLER = new ModHandler(INSTANCE);
    @SidedProxy(clientSide = CSIDE, serverSide = SSIDE)
    public static IExampleProxy PROXY;
    @ModLogger
    public static IExampleLogger LOGGER;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MOD_HANDLER.handlePreInit(event);
        PROXY.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MOD_HANDLER.handleInit(event);
        PROXY.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MOD_HANDLER.handlePostInit(event);
        PROXY.postInit(event);
    }
}