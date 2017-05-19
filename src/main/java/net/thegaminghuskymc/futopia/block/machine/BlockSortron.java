package net.thegaminghuskymc.futopia.block.machine;

import keri.ninetaillib.block.BlockBase;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.reference.Refs;

public class BlockSortron extends BlockBase {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockSortron() {

        super(Refs.MODID, Refs.BLOCKSORTRON_NAME, Material.ROCK);
        setCreativeTab(FTCreativeTabs.machines);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegistrar registrar) {
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

    @Override
    public IRenderingRegistry getRenderingRegistry() {
        return Futopia.proxy.getRenderingRegistry();
    }

}