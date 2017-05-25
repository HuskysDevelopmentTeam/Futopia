package net.thegaminghuskymc.futopia.item;

import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.reference.Refs;

public class ItemBaseDust extends ItemFutopia {

    private TextureAtlasSprite[] texture;

    public ItemBaseDust() {
        super("dust", EnumMaterialType.toStringArray());
    }

    @Override
    public void registerIcons(IIconRegistrar registrar) {
        this.texture = new TextureAtlasSprite[EnumMaterialType.values().length];

        for (int i = 0; i < EnumMaterialType.values().length; i++) {
            this.texture[i] = registrar.registerIcon(Refs.MODID + ":items/material/dust_" + EnumMaterialType.values()[i].getName());
        }
    }

    @Override
    public TextureAtlasSprite getIcon(int meta) {
        return this.texture[meta];
    }

}
