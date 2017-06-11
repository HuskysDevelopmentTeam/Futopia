package net.thegaminghuskymc.futopia.blocks.machine;

import keri.ninetaillib.lib.block.BlockBase;
import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockSortron extends BlockBase {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockSortron() {
        super("sorton", Material.ROCK);
        setCreativeTab(FTCreativeTabs.main);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registrar) {
        this.texture = new TextureAtlasSprite[7];
        this.texture[0] = registrar.registerIcon(Refs.MODID + ":blocks/machines/sortron_front");
        this.texture[1] = registrar.registerIcon(Refs.MODID + ":blocks/machines/sortron_back");
        this.texture[2] = registrar.registerIcon(Refs.MODID + ":blocks/machines/sortron_side_off");
        this.texture[3] = registrar.registerIcon(Refs.MODID + ":blocks/machines/sortron_side_on");
        this.texture[4] = registrar.registerIcon(Refs.MODID + ":blocks/machines/sortron_side_on_1");
        this.texture[5] = registrar.registerIcon(Refs.MODID + ":blocks/machines/sortron_side");
        this.texture[6] = registrar.registerIcon(Refs.MODID + ":blocks/machines/sortron_side_active");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        switch (side) {
            case 0:
                return this.texture[2];
            case 1:
                return this.texture[2];
            case 2:
                return this.texture[0];
            case 3:
                return this.texture[1];
            case 4:
                return this.texture[2];
            case 5:
                return this.texture[2];
        }

        return null;
    }

}