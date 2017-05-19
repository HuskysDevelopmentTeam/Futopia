package net.thegaminghuskymc.futopia.item.block;

import cofh.core.block.ItemBlockCore;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.reference.Refs;

public class ItemBlockRefinery extends ItemBlockCore {

    public ItemBlockRefinery(Block block) {

        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile." + Refs.MODID + ".refinery.name";
    }

}
