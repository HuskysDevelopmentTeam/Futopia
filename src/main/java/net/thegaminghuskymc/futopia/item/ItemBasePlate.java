package net.thegaminghuskymc.futopia.item;

import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.reference.Refs;

public class ItemBasePlate extends ItemFutopia {

    private TextureAtlasSprite[] texture;

    public ItemBasePlate() {
        super("plate", EnumMaterialType.toStringArray());
        setCreativeTab(FTCreativeTabs.materials);
    }

    @Override
    public void registerIcons(IIconRegistrar registrar) {
        this.texture = new TextureAtlasSprite[EnumMaterialType.values().length];

        for (int i = 0; i < EnumMaterialType.values().length; i++) {
            this.texture[i] = registrar.registerIcon(Refs.MODID + ":items/material/plate_" + EnumMaterialType.values()[i].getName());
        }
    }

    @Override
    public TextureAtlasSprite getIcon(int meta) {
        return this.texture[meta];
    }

}
