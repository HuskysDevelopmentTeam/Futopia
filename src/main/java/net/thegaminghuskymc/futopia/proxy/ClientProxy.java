package net.thegaminghuskymc.futopia.proxy;

import java.util.ArrayList;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.blocks.IModelRegister;

public class ClientProxy implements IFutopiaProxy {
	
	private static ArrayList<IModelRegister> modelList = new ArrayList<>();

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        Futopia.MOD_HANDLER.handleClientPreInit(event);
        for (IModelRegister register : modelList) {
            register.registerModels();
        }
    }

    @Override
    public void init(FMLInitializationEvent event) {
//        Futopia.MOD_HANDLER.handleClientInit(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        Futopia.MOD_HANDLER.handleClientPostInit(event);
    }

    @Override
    public boolean addIModelRegister(IModelRegister modelRegister) {
        return modelList.add(modelRegister);
    }

}
