package net.thegaminghuskymc.futopia.item;

import cofh.lib.util.helpers.StringHelper;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.reference.Refs;

import java.util.List;

public class ItemWindowsWasher extends ItemFutopia {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite texture;

    public ItemWindowsWasher() {
        super("windows_washer");
        setCreativeTab(FTCreativeTabs.materials);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegistrar registrar) {
        this.texture = registrar.registerIcon(Refs.MODID + ":items/windows_washer");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta) {
        return this.texture;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add("Hold " + StringHelper.getDeactivationText("Shift") + StringHelper.getFlavorText(" for information."));
        } else {
            tooltip.add(StringHelper.getNoticeText("This is used to clean your windows"));
            tooltip.add(StringHelper.getNoticeText("Expirience the POWER of THE FUTURE!"));
            tooltip.add(StringHelper.getNoticeText("It can get the TOUGH STRAINS OUT!"));
            tooltip.add(StringHelper.getNoticeText("Get it at the store for $19.99."));
            tooltip.add(StringHelper.getNoticeText("Please don't drink the contents of this bottle."));
            tooltip.add(StringHelper.getNoticeText("Like serioustly, are you that retarded?"));
        }
    }

}