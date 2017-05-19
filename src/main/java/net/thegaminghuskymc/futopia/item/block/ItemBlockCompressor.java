package net.thegaminghuskymc.futopia.item.block;

import cofh.core.block.ItemBlockCore;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.reference.Refs;

public class ItemBlockCompressor extends ItemBlockCore {

    public ItemBlockCompressor(Block block) {

        super(block);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile." + Refs.MODID + ".compressor.name";
    }

}
