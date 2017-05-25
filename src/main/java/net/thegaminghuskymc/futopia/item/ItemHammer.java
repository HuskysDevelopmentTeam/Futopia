package net.thegaminghuskymc.futopia.item;

import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.reference.Refs;

public class ItemHammer extends ItemFutopia {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public ItemHammer() {
        super("hammer", EnumMaterialType.toStringArray());
        setCreativeTab(FTCreativeTabs.tools);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegistrar registrar) {
        this.texture = new TextureAtlasSprite[EnumMaterialType.values().length];

        for (int i = 0; i < EnumMaterialType.values().length; i++) {
            this.texture[i] = registrar.registerIcon(Refs.MODID + ":items/tool/hammer_" + EnumMaterialType.values()[i].getName());
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {

        if(playerIn.isGlowing())
            playerIn.addExperience(100);

        return ActionResult.newResult(EnumActionResult.PASS, itemStackIn);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta) {
        return this.texture[meta];
    }

}
