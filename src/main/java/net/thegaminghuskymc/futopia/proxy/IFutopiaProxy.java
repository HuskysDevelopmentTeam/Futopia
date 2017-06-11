package net.thegaminghuskymc.futopia.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.futopia.blocks.IModelRegister;

/**
 * Created by TheGamingHuskyMC on 26.05.2017.
 */
public interface IFutopiaProxy {

    void preInit(FMLPreInitializationEvent event);

    void init(FMLInitializationEvent event);

    void postInit(FMLPostInitializationEvent event);
    
    boolean addIModelRegister(IModelRegister modelRegister);

}
