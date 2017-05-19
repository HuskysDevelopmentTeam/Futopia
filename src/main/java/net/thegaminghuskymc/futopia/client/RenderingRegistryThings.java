package net.thegaminghuskymc.futopia.client;

import keri.ninetaillib.render.registry.SimpleRenderingRegistry;
import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.reference.Refs;

@SideOnly(Side.CLIENT)
public class RenderingRegistryThings extends SimpleRenderingRegistry {

    @Override
    public String getModid() {
        return Refs.MODID;
    }

    @Override
    public IIconRegistrar getIconRegistrar() {
        return Futopia.proxy.getIconRegistrar();
    }

}