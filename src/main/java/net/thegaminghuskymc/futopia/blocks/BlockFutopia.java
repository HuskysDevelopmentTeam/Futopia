package net.thegaminghuskymc.futopia.blocks;

import keri.ninetaillib.lib.block.BlockBase;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockFutopia<T extends TileEntity> extends BlockBase<T> {

	public BlockFutopia(String blockName, Material material, MapColor mapColor) {
        super(blockName, material, mapColor);
    }

    public BlockFutopia(String blockName, Material material) {
        super(blockName, material);
    }

    public BlockFutopia(String blockName, Material material, MapColor mapColor, String... subNames) {
        super(blockName, material, mapColor, subNames);
    }

    public BlockFutopia(String blockName, Material material, String... subNames) {
        super(blockName, material, subNames);
    }

    @Override
    public CreativeTabs getCreativeTab() {
        return FTCreativeTabs.main;
    }

}

