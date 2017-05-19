package net.thegaminghuskymc.futopia.block.computer;

import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.block.BlockMachineBase;
import net.thegaminghuskymc.futopia.reference.Refs;

public class BlockIOExpander extends BlockMachineBase {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockIOExpander() {

        super(Refs.BLOCKIOEXPANDER_NAME);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegistrar registrar) {
        this.texture = new TextureAtlasSprite[5];
        this.texture[0] = registrar.registerIcon(Refs.MODID + ":blocks/machines/io_expander/io_expander_front");
        this.texture[1] = registrar.registerIcon(Refs.MODID + ":blocks/machines/cpu_side");
        this.texture[2] = registrar.registerIcon(Refs.MODID + ":blocks/machines/cpu_top");
        this.texture[3] = registrar.registerIcon(Refs.MODID + ":blocks/machines/io_expander_back");
        this.texture[4] = registrar.registerIcon(Refs.MODID + ":blocks/machines/cpu_bottom");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        switch (side) {
            case 0:
                return this.texture[4];
            case 1:
                return this.texture[2];
            case 2:
                return this.texture[0];
            case 3:
                return this.texture[3];
            case 4:
                return this.texture[1];
            case 5:
                return this.texture[1];
        }

        return null;
    }

}
