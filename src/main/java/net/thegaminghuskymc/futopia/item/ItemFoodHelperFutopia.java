package net.thegaminghuskymc.futopia.item;

import keri.ninetaillib.item.ItemFoodBase;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.reference.Refs;

/**
 * Created by TheGamingHuskyMC on 08.05.2017.
 */
public class ItemFoodHelperFutopia extends ItemFoodBase {

    public ItemFoodHelperFutopia(String name, int amount, float saturation, boolean isWolfFood) {
        super(Refs.MODID, name, amount, saturation, isWolfFood);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public CreativeTabs getCreativeTab() {
        return FTCreativeTabs.materials;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IRenderingRegistry getRenderingRegistry() {
        return Futopia.proxy.getRenderingRegistry();
    }
}
