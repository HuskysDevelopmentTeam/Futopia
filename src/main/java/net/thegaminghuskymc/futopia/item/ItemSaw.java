package net.thegaminghuskymc.futopia.item;

import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.reference.Refs;

/**
 * Created by TheGamingHuskyMC on 27.04.2017.
 */
public class ItemSaw extends ItemFutopia {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public ItemSaw() {
        super("saw", EnumMaterialType.METADATA_LOOKUP.toString());
        setCreativeTab(FTCreativeTabs.tools);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegistrar registrar) {
        this.texture = new TextureAtlasSprite[EnumMaterialType.values().length];

        for (int i = 0; i < EnumMaterialType.values().length; i++) {
            this.texture[i] = registrar.registerIcon(Refs.MODID + ":items/tool/saw_" + EnumMaterialType.values()[i].getName());
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta) {
        return this.texture[meta];
    }

}
