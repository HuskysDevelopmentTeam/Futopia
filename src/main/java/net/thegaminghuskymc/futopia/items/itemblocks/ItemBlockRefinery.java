package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.Refs;

public class ItemBlockRefinery extends ItemBlockCore {

    public ItemBlockRefinery(Block block) {

        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile.refinery.name";
    }

}
