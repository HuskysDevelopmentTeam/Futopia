package net.thegaminghuskymc.futopia.block.computer;

import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.block.BlockMachineBase;
import net.thegaminghuskymc.futopia.reference.Refs;

public class BlockDiskDrive extends BlockMachineBase {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockDiskDrive() {
        super(Refs.BLOCKDISKDRIVE_NAME);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegistrar registrar) {
        this.texture = new TextureAtlasSprite[4];
        this.texture[0] = registrar.registerIcon(Refs.MODID + ":blocks/machines/disk_drive/disk_drive_top");
        this.texture[1] = registrar.registerIcon(Refs.MODID + ":blocks/machines/disk_drive/disk_drive_bottom");
        this.texture[2] = registrar.registerIcon(Refs.MODID + ":blocks/machines/disk_drive/disk_drive_side");
        this.texture[3] = registrar.registerIcon(Refs.MODID + ":blocks/machines/disk_drive/disk_drive_front");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        switch (side) {
            case 0:
                return this.texture[1];
            case 1:
                return this.texture[0];
            case 2:
                return this.texture[3];
            case 3:
                return this.texture[2];
            case 4:
                return this.texture[2];
            case 5:
                return this.texture[2];
        }

        return null;
    }

}