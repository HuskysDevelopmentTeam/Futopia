package net.thegaminghuskymc.futopia;

import cofh.core.render.IModelRegister;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import keri.ninetaillib.texture.DefaultIconRegistrar;
import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.client.RenderingRegistryThings;
import net.thegaminghuskymc.futopia.client.render.AnimationFX;

import java.util.ArrayList;

@SideOnly(Side.CLIENT)
public class ClientProxy implements IFutopiaProxy {

    private static final DefaultIconRegistrar iconRegistrar = new DefaultIconRegistrar();
    private static final RenderingRegistryThings renderingRegistry = new RenderingRegistryThings();
    private static AnimationFX animationFX;
    private static ArrayList<IModelRegister> modelList = new ArrayList<>();

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        animationFX = new AnimationFX(Futopia.CONFIG.animationResolution.getValue());
        iconRegistrar.preInit();
        renderingRegistry.preInit();
        for (IModelRegister register : modelList) {
            register.registerModels();
        }
    }

    @Override
    public void init(FMLInitializationEvent event) {
        renderingRegistry.init();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        renderingRegistry.postInit();
    }

    @Override
    public IRenderingRegistry getRenderingRegistry() {
        return renderingRegistry;
    }

    @Override
    public IIconRegistrar getIconRegistrar() {
        return iconRegistrar;
    }

    @Override
    public TextureAtlasSprite getAnimationIcon() {
        return animationFX.texture;
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {}

    @Override
    public boolean addIModelRegister(IModelRegister modelRegister) {
        return modelList.add(modelRegister);
    }
}