package net.thegaminghuskymc.futopia.item.block;

import cofh.core.block.ItemBlockCore;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.reference.Refs;

public class ItemBlockEngine extends ItemBlockCore {

    public ItemBlockEngine(Block block) {

        super(block);
        setHasSubtypes(false);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile." + Refs.MODID + ".engine.name";
    }

}
