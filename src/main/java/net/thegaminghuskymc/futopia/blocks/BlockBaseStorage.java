package net.thegaminghuskymc.futopia.blocks;

import com.google.common.collect.Lists;

import keri.ninetaillib.lib.block.BlockBase;
import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTBlocks;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.network.FutopiaProperties;

import java.util.List;

public class BlockBaseStorage extends BlockBase {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockBaseStorage() {
        super("storage", Material.ROCK, EnumMaterialType.toStringArray());
        setHardness(1.6F);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(FTCreativeTabs.main);
    }

    /*@Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        return Lists.newArrayList(new ItemStack(FTBlocks.ores, 1 + fortune, getMetaFromState(state)));
    }*/

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registrar) {
        texture = new TextureAtlasSprite[8];

        for (int i = 0; i < this.getSubNames().length; i++) {
            texture[i] = registrar.registerIcon(Refs.MODID + ":blocks/worldgen/storage/storage_" + this.getSubNames()[i]);
        }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        return texture[meta];
    }

}
