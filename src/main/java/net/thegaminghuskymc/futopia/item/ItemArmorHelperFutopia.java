package net.thegaminghuskymc.futopia.item;

import keri.ninetaillib.item.ItemArmorHelper;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.reference.Refs;

public class ItemArmorHelperFutopia extends ItemArmorHelper {

    public ItemArmorHelperFutopia() {
        super(Refs.MODID);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public CreativeTabs getCreativeTab() {
        return FTCreativeTabs.armor;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IRenderingRegistry getRenderingRegistry() {
        return Futopia.proxy.getRenderingRegistry();
    }

}
