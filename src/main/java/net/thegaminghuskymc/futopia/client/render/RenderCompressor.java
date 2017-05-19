package net.thegaminghuskymc.futopia.client.render;

import codechicken.lib.render.CCRenderState;
import keri.ninetaillib.render.registry.IBlockRenderingHandler;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class RenderCompressor implements IBlockRenderingHandler {

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
