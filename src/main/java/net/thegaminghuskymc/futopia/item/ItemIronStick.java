package net.thegaminghuskymc.futopia.item;

import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.reference.Refs;

public class ItemIronStick extends ItemFutopia {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite texture;

    public ItemIronStick() {
        super("iron_stick");
        setCreativeTab(FTCreativeTabs.items);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegistrar registrar) {
        this.texture = registrar.registerIcon(Refs.RESOURSE_PREFIX + "items/iron_stick");
    }

    @Override
    public TextureAtlasSprite getIcon(int meta) {
        return this.texture;
    }
}