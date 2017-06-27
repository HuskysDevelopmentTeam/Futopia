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

public class BlockXycroniumNetherOre extends BlockFutopia implements IAnimationHandler {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockXycroniumNetherOre() {
        super("xycronium_nether_ore", Material.ROCK, EnumXycroniumColor.toStringArray());
        this.setHardness(1.4F);
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

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        this.texture = new TextureAtlasSprite[6];

        for(int i = 0; i < this.getSubNames().length; i++){
            this.texture[i] = register.registerIcon(Refs.MODID + ":blocks/xycronium_ore/xycronium_nether_ore_" + this.getSubNames()[i]);
        }

        this.texture[5] = register.registerIcon(Refs.MODID + ":blocks/xycronium_ore/xycronium_ore_effect");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        return this.texture[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getAnimationIcon(ItemStack stack, int side) {
        boolean animatedOres = true;
        return animatedOres ? Futopia.PROXY.getAnimatedTexture() : this.texture[5];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getAnimationIcon(IBlockAccess world, BlockPos pos, int side) {
        boolean animatedOres = true;
        return animatedOres ? Futopia.PROXY.getAnimatedTexture() : this.texture[5];
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

}