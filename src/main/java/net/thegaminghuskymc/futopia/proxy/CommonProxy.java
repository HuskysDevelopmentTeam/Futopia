package net.thegaminghuskymc.futopia.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.futopia.blocks.IModelRegister;

/**
 * Created by TheGamingHuskyMC on 26.05.2017.
 */
public class CommonProxy implements IFutopiaProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

	@Override
	public boolean addIModelRegister(IModelRegister modelRegister) {
		return false;
	}

}
