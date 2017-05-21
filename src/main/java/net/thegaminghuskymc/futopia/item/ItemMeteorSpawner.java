package net.thegaminghuskymc.futopia.item;

import cofh.lib.util.helpers.StringHelper;
import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.reference.Refs;

import java.util.List;

public class ItemMeteorSpawner extends ItemFutopia {

    private TextureAtlasSprite texture;

    public ItemMeteorSpawner() {
        super("meteor_spawner");
        setCreativeTab(FTCreativeTabs.materials);
    }

    @Override
    public void registerIcons(IIconRegistrar registrar) {
        this.texture = registrar.registerIcon(Refs.RESOURSE_PREFIX + "items/meteor_spawner");
    }

    @Override
    public TextureAtlasSprite getIcon(int meta) {
        return this.texture;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add("Hold " + StringHelper.getDeactivationText("Shift") + StringHelper.getFlavorText(" for information."));
        } else {
            tooltip.add(StringHelper.getActivationText("This is used to spawn meteors"));
            tooltip.add(StringHelper.getActivationText("Do not abuse it!"));
        }
    }

}