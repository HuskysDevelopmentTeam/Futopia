package net.thegaminghuskymc.futopia.items;

import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;

/**
 * Created by TheGamingHuskyMC on 27.04.2017.
 */
public class ItemSaw extends ItemFutopia {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public ItemSaw() {
        super("saw", EnumMaterialType.toStringArray());
        setCreativeTab(FTCreativeTabs.main);
    }

    @Override
    public void registerIcons(IIconRegister register) {
        this.texture = new TextureAtlasSprite[EnumMaterialType.VALUES.length];

        for (int i = 0; i < EnumMaterialType.VALUES.length; i++) {
            this.texture[i] = register.registerIcon(Refs.MODID + ":items/tool/saw_" + EnumMaterialType.VALUES[i].getName());
        }
    }

    @Override
    public TextureAtlasSprite getIcon(int meta) {
        return this.texture[meta];
    }

}
