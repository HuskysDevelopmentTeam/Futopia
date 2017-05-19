package net.thegaminghuskymc.futopia.block.normal;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

/**
 * @author LatvianModder
 */
public class BlockBase extends Block {
    public static final PropertyDirection DIRECTION = PropertyDirection.create("direction");

    public BlockBase(String id, Material blockMaterialIn, MapColor blockMapColorIn) {
        super(blockMaterialIn, blockMapColorIn);
        setUnlocalizedName(id);
        setRegistryName(id);
        setCreativeTab(FTCreativeTabs.blocks);
    }
}