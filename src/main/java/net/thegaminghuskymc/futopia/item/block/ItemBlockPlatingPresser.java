package net.thegaminghuskymc.futopia.item.block;

import cofh.core.block.ItemBlockCore;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.reference.Refs;

public class ItemBlockPlatingPresser extends ItemBlockCore {

    public ItemBlockPlatingPresser(Block block) {

        super(block);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile." + Refs.MODID + ".plating_presser.name";
    }

}
