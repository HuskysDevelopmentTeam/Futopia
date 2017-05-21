package net.thegaminghuskymc.futopia.block.worldgen;

import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.block.BlockFutopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.reference.Refs;

public class BlockAsphalt extends BlockFutopia {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite texture;

    public BlockAsphalt() {
        super("asphalt", Material.ROCK);
        setCreativeTab(FTCreativeTabs.decoration);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegistrar registrar) {
        texture = registrar.registerIcon(Refs.MODID + ":blocks/decoration/asphalt/asphalt");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        return texture;
    }

}
