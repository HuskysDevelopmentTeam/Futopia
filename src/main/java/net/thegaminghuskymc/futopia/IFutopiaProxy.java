package net.thegaminghuskymc.futopia;

import cofh.core.render.IModelRegister;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IFutopiaProxy {

    void preInit(FMLPreInitializationEvent event);

    void init(FMLInitializationEvent event);

    void postInit(FMLPostInitializationEvent event);

    IRenderingRegistry getRenderingRegistry();

    IIconRegistrar getIconRegistrar();

    TextureAtlasSprite getAnimationIcon();

    void registerItemRenderer(Item item, int meta, String id);

    boolean addIModelRegister(IModelRegister modelRegister);

}