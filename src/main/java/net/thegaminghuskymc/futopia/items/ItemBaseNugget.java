package net.thegaminghuskymc.futopia.items;

import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;

public class ItemBaseNugget extends ItemFutopia {

    private TextureAtlasSprite[] texture;

    public ItemBaseNugget() {
        super("nugget", EnumMaterialType.toStringArray());
    }

    @Override
    public void registerIcons(IIconRegister register) {
        this.texture = new TextureAtlasSprite[EnumMaterialType.VALUES.length];

        for (int i = 0; i < EnumMaterialType.VALUES.length; i++) {
            this.texture[i] = register.registerIcon(Refs.MODID + ":items/material/nugget_" + EnumMaterialType.VALUES[i].getName());
        }
    }

    @Override
    public TextureAtlasSprite getIcon(int meta) {
        return this.texture[meta];
    }

}
