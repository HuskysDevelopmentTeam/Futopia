package net.thegaminghuskymc.futopia.items;

import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class ItemIronStick extends ItemFutopia {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite texture;

    public ItemIronStick() {
        super("iron_stick");
        setCreativeTab(FTCreativeTabs.main);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registrar) {
        this.texture = registrar.registerIcon(Refs.RESOURCE_PREFIX + "items/iron_stick");
    }

    @Override
    public TextureAtlasSprite getIcon(int meta) {
        return this.texture;
    }

}