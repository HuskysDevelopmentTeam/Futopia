package net.thegaminghuskymc.futopia.blocks.idk;

import keri.ninetaillib.lib.texture.IIconRegister;
import keri.ninetaillib.lib.util.BlockAccessUtils;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.BlockFutopia;
import net.thegaminghuskymc.futopia.client.render.IAnimationHandler;
import net.thegaminghuskymc.futopia.client.render.RenderSimpleGlow;
import net.thegaminghuskymc.futopia.utils.EnumXycroniumColor;

public class BlockXycroniumBricks extends BlockFutopia implements IAnimationHandler {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite texture;

    public BlockXycroniumBricks() {
        super("xycronium_bricks", Material.ROCK, EnumXycroniumColor.toStringArray());
        this.setHardness(1.4F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        this.texture = register.registerIcon(Refs.MODID + ":blocks/xycronium_bricks");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        return this.texture;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorMultiplier(int meta, int side) {
        return EnumXycroniumColor.VALUES[meta].getColor().copy().multiplyC(0.8D).rgba();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getAnimationIcon(ItemStack stack, int side) {
        return Futopia.PROXY.getAnimatedTexture();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getAnimationIcon(IBlockAccess world, BlockPos pos, int side) {
        return Futopia.PROXY.getAnimatedTexture();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getAnimationColor(ItemStack stack, int side) {
        return EnumXycroniumColor.VALUES[stack.getMetadata()].getColor().rgba();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getAnimationColor(IBlockAccess world, BlockPos pos, int side) {
        return EnumXycroniumColor.VALUES[BlockAccessUtils.getBlockMetadata(world, pos)].getColor().rgba();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getAnimationBrightness(ItemStack stack, int side) {
        return 0x00F000F0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getAnimationBrightness(IBlockAccess world, BlockPos pos, int side) {
        return 0x00F000F0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return RenderSimpleGlow.RENDER_TYPE;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
        return layer == BlockRenderLayer.SOLID || layer == BlockRenderLayer.CUTOUT_MIPPED;
    }

}
