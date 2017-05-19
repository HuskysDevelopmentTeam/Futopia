package net.thegaminghuskymc.futopia;

import cofh.core.render.IModelRegister;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.futopia.reference.Refs;

public class CommonProxy implements IFutopiaProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        OBJLoader.INSTANCE.addDomain(Refs.MODID);
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public IRenderingRegistry getRenderingRegistry() {
        return null;
    }

    @Override
    public IIconRegistrar getIconRegistrar() {
        return null;
    }

    @Override
    public TextureAtlasSprite getAnimationIcon() {
        return null;
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
    }

    @Override
    public boolean addIModelRegister(IModelRegister modelRegister) {
        return false;
    }

}
