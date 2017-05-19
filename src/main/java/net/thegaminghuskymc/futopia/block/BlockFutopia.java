package net.thegaminghuskymc.futopia.block;

import keri.ninetaillib.block.BlockBase;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.reference.Refs;

public class BlockFutopia<T extends TileEntity> extends BlockBase<T> {

    public BlockFutopia(String blockName, Material material, MapColor mapColor) {
        super(Refs.MODID, blockName, material, mapColor);
    }

    public BlockFutopia(String blockName, Material material) {
        super(Refs.MODID, blockName, material);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public CreativeTabs getCreativeTab() {
        return FTCreativeTabs.blocks;
    }

    @Override
    public IRenderingRegistry getRenderingRegistry() {
        return Futopia.proxy.getRenderingRegistry();
    }
}
