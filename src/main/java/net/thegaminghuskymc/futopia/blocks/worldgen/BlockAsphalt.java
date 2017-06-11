package net.thegaminghuskymc.futopia.blocks.worldgen;

import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.blocks.BlockFutopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.Refs;

public class BlockAsphalt extends BlockFutopia {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite texture;

    public BlockAsphalt() {
        super("asphalt", Material.ROCK);
        setCreativeTab(FTCreativeTabs.main);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registrar) {
        texture = registrar.registerIcon(Refs.MODID + ":blocks/decoration/asphalt/asphalt");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        return texture;
    }

}
