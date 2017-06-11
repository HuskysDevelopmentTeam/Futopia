package net.thegaminghuskymc.futopia.items;

import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class ItemMeteorChunk extends ItemFutopia {

    private TextureAtlasSprite texture;

    public ItemMeteorChunk() {
        super("meteor_chunk");
        setCreativeTab(FTCreativeTabs.main);
    }

    @Override
    public void registerIcons(IIconRegister registrar) {
        this.texture = registrar.registerIcon(Refs.RESOURCE_PREFIX + "items/battery");
    }

    @Override
    public TextureAtlasSprite getIcon(int meta) {
        return super.getIcon(meta);
    }

    /*@Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add("Hold " + StringHelper.getDeactivationText("Shift") + StringHelper.getFlavorText(" for information."));
        } else {
            tooltip.add(StringHelper.getInfoText("Drops frome meteor blocks"));
            tooltip.add(StringHelper.getInfoText("Can be used to craft meteor blocks"));
        }
    }*/

}
