package net.thegaminghuskymc.futopia.util.helpers;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * Created by TheGamingHuskyMC on 10.05.2017.
 */
public interface IBlockGlowVanilla {

    int getPackedLightmapCoords(IBlockState state, IBlockAccess source, BlockPos pos);

    ItemStack getSpecialSubBlock();

    boolean isOpaqueCube(IBlockState state);

    boolean isFullBlock(IBlockState state);

    boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer);

}
