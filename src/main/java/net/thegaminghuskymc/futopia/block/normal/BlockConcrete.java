package net.thegaminghuskymc.futopia.block.normal;

import keri.ninetaillib.block.IMetaBlock;
import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.block.BlockFutopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumConcreteType;
import net.thegaminghuskymc.futopia.network.FutopiaProperties;
import net.thegaminghuskymc.futopia.reference.Refs;

public class BlockConcrete extends BlockFutopia implements IMetaBlock {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockConcrete() {
        super("concrete", Material.ROCK);
        setCreativeTab(FTCreativeTabs.worldgen);
        setDefaultState(blockState.getBaseState().withProperty(FutopiaProperties.CONCRETE, EnumConcreteType.NORMAL));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FutopiaProperties.CONCRETE);
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FutopiaProperties.CONCRETE, EnumConcreteType.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FutopiaProperties.CONCRETE).getID();
    }

    @Override
    public String[] getSubNames() {
        return EnumConcreteType.toStringArray();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegistrar registrar) {
        texture = new TextureAtlasSprite[8];

        for (int i = 0; i < EnumConcreteType.values().length; i++) {
            texture[i] = registrar.registerIcon(Refs.MODID + ":blocks/decoration/concrete/concrete_" + EnumConcreteType.values()[i].getName());
        }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        return this.texture[meta];
    }

}
