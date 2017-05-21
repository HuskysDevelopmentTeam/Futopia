package net.thegaminghuskymc.futopia.block.worldgen;

import com.google.common.collect.Lists;
import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.block.BlockFutopia;
import net.thegaminghuskymc.futopia.init.FTBlocks;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.network.FutopiaProperties;
import net.thegaminghuskymc.futopia.reference.Refs;

import java.util.List;

public class BlockBaseStorage extends BlockFutopia {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockBaseStorage() {
        super("storage", Material.ROCK);
        setHardness(1.6F);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(FTCreativeTabs.blocks);
        setDefaultState(blockState.getBaseState().withProperty(FutopiaProperties.MATERIALS, EnumMaterialType.BLUE));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FutopiaProperties.MATERIALS);
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FutopiaProperties.MATERIALS, EnumMaterialType.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FutopiaProperties.MATERIALS).getMetadata();
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        return Lists.newArrayList(new ItemStack(FTBlocks.ores, 1 + fortune, getMetaFromState(state)));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegistrar registrar) {
        texture = new TextureAtlasSprite[8];

        for (int i = 0; i < EnumMaterialType.values().length; i++) {
            texture[i] = registrar.registerIcon(Refs.MODID + ":blocks/worldgen/storage/storage_" + EnumMaterialType.values()[i].getName());
        }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        return texture[meta];
    }

}
