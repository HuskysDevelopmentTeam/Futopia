package net.thegaminghuskymc.futopia.client.render;

import codechicken.lib.render.CCModel;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.vec.Cuboid6;
import keri.ninetaillib.render.registry.IBlockRenderingHandler;
import keri.ninetaillib.util.CommonUtils;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.stream.IntStream;

public class RenderTestGlass implements IBlockRenderingHandler {

    private static CCModel[] model;

    static {
        Cuboid6[] bounds = new Cuboid6[]{
                new Cuboid6(0D, 0D, 0D, 2D, 2D, 16D), //frame_bottom_west
                new Cuboid6(2D, 0D, 0D, 14D, 2D, 2D), //frame_buttom_east
                new Cuboid6(0D, 14D, 0D, 2D, 16D, 16D), //frame_top_west
                new Cuboid6(2D, 14D, 14D, 14D, 16D, 16D), //frame_top_south
                new Cuboid6(14D, 14D, 0D, 16D, 16D, 16D), //frame_top_east
                new Cuboid6(2D, 14D, 0D, 14D, 16D, 2D), //frame_top_north
                new Cuboid6(0.5000000074505806D, 2D, 14D, 2D, 14D, 15.49999999254942D), //frame_sw
                new Cuboid6(0.5000000074505806D, 2D, 0.5000000074505806D, 2.000000014901161D, 14D, 2.000000014901161D), //frame_nw
                new Cuboid6(14D, 2D, 0.5000000074505806D, 15.50000000745058D, 14D, 2.000000014901161D), //frame_ne
                new Cuboid6(14D, 2D, 14D, 15.49999999254942D, 14D, 15.49999999254942D), //frame_se
                new Cuboid6(2D, 2D, 2D, 14D, 14D, 14D) //middle
        };

        model = new CCModel[bounds.length];
        IntStream.range(0, bounds.length).forEach(index -> model[index] = CCModel.quadModel(24).generateBlock(0, CommonUtils.devide(bounds[index], 16D)).computeNormals());
    }

    private TextureAtlasSprite texture;

    @Override
    public boolean renderBlock(CCRenderState renderState, IBlockAccess world, BlockPos pos, BlockRenderLayer layer) {
        return false;
    }

    @Override
    public void renderBlockDamage(CCRenderState renderState, IBlockAccess world, BlockPos pos, TextureAtlasSprite texture) {

    }

    @Override
    public void renderItem(CCRenderState renderState, ItemStack stack) {

    }

}
