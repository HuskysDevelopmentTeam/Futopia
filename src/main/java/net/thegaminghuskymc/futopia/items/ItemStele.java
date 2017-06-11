package net.thegaminghuskymc.futopia.items;

import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;

/**
 * Created by TheGamingHuskyMC on 23.05.2017.
 */
public class ItemStele extends ItemFutopia {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite texture;

    public ItemStele() {
        super("stele");
    }

    @Override
    public void registerIcons(IIconRegister registrar) {
        texture = registrar.registerIcon(Refs.RESOURCE_PREFIX + "items/stele");
    }

    @Override
    public TextureAtlasSprite getIcon(int meta) {
        return texture;
    }

}
