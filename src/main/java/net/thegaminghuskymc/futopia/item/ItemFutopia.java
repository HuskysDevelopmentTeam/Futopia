package net.thegaminghuskymc.futopia.item;

import keri.ninetaillib.item.ItemBase;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.reference.Refs;

public class ItemFutopia extends ItemBase {

    public ItemFutopia(String itemName) {
        super(Refs.MODID, itemName);
    }

    public ItemFutopia(String itemName, String... subNames) {
        super(Refs.MODID, itemName, subNames);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IRenderingRegistry getRenderingRegistry() {
        return Futopia.proxy.getRenderingRegistry();
    }

    @Override
    public CreativeTabs getCreativeTab() {
        return FTCreativeTabs.items;
    }
}
