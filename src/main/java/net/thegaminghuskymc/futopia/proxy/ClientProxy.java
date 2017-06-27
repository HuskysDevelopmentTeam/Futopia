package net.thegaminghuskymc.futopia.proxy;

import java.util.ArrayList;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.blocks.IModelRegister;
import net.thegaminghuskymc.futopia.client.IconHandler;
import net.thegaminghuskymc.futopia.client.render.AnimatedTextureFX;
import net.thegaminghuskymc.futopia.client.render.tesr.TESRFabricator;
import net.thegaminghuskymc.futopia.tiles.TileEntityFabricator;

public class ClientProxy implements IFutopiaProxy {
	
	private static AnimatedTextureFX ANIMATED_TEXTURE;
	private static ArrayList<IModelRegister> modelList = new ArrayList<>();

    @Override
    public void preInit(FMLPreInitializationEvent event) {
//    	int animatinResolution = (Integer)Futopia.CONFIG.getProperty("animationResolution").getValue();
        ANIMATED_TEXTURE = new AnimatedTextureFX(64);
        Futopia.MOD_HANDLER.handleClientPreInit(event);
        this.registerRenderers();
        IconHandler.INSTANCE.preInit();
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

    @Override
    public TextureAtlasSprite getAnimatedTexture() {
        return ANIMATED_TEXTURE.texture;
    }

    private void registerRenderers(){
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFabricator.class, new TESRFabricator());
    }

}
