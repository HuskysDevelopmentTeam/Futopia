package net.thegaminghuskymc.futopia.blocks.normal;

import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.BlockFutopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumConcreteType;
import net.thegaminghuskymc.futopia.network.FutopiaProperties;

public class BlockConcrete extends BlockFutopia {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockConcrete() {
        super("concrete", Material.ROCK, EnumConcreteType.toStringArray());
        setCreativeTab(FTCreativeTabs.main);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registrar) {
        texture = new TextureAtlasSprite[8];

        for (int i = 0; i < this.getSubNames().length; i++) {
            texture[i] = registrar.registerIcon(Refs.MODID + ":blocks/decoration/concrete/concrete_" + this.getSubNames()[i]);
        }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        return this.texture[meta];
    }

}
