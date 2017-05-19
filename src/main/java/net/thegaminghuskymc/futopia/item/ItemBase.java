package net.thegaminghuskymc.futopia.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.reference.Refs;

public class ItemBase extends Item {

    public ItemBase() {

        super();
    }

    @Override
    public String getUnlocalizedName() {

        return String.format("item.%s:%s", Refs.MODID, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        return String.format("item.%s:%s", Refs.MODID, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String name) {

        return name.substring(name.indexOf(".") + 1);
    }
}