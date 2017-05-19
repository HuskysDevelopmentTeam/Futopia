package net.thegaminghuskymc.futopia.items;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.Material;
import net.thegaminghuskymc.futopia.network.MaterialType;

import java.util.List;

public class ItemSmallDust extends Item implements IItemColor {
    public ItemSmallDust() {
        setUnlocalizedName("smalldust");
        setRegistryName("smalldust");
        setCreativeTab(FTCreativeTabs.items);
        setHasSubtypes(true);
        GameRegistry.register(this);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return Material.getMaterial(stack.getMetadata()).translateServer() + " " + super.getItemStackDisplayName(stack);
    }

    @Override
    public int getColorFromItemstack(ItemStack stack, int tintIndex) {
        if (tintIndex == 0)
            return Material.getMaterial(stack.getMetadata()).ordinal();
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for (Material material : Material.values())
            if (material.canBe(MaterialType.SMALL_DUST))
                subItems.add(new ItemStack(itemIn, 1, material.ordinal()));
    }
}
