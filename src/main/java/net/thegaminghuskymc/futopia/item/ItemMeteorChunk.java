package net.thegaminghuskymc.futopia.item;

import cofh.lib.util.helpers.StringHelper;
import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.reference.Refs;

import java.util.List;

public class ItemMeteorChunk extends ItemFutopia {

    private TextureAtlasSprite texture;

    public ItemMeteorChunk() {
        super("meteor_chunk");
        setCreativeTab(FTCreativeTabs.items);
    }

    @Override
    public void registerIcons(IIconRegistrar registrar) {
        this.texture = registrar.registerIcon(Refs.RESOURSE_PREFIX + "items/battery");
    }

    @Override
    public TextureAtlasSprite getIcon(int meta) {
        return super.getIcon(meta);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add("Hold " + StringHelper.getDeactivationText("Shift") + StringHelper.getFlavorText(" for information."));
        } else {
            tooltip.add(StringHelper.getInfoText("Drops frome meteor blocks"));
            tooltip.add(StringHelper.getInfoText("Can be used to craft meteor blocks"));
        }
    }

}
