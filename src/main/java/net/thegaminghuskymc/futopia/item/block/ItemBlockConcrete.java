package net.thegaminghuskymc.futopia.item.block;

import cofh.core.block.ItemBlockCore;
import cofh.lib.util.helpers.ItemHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.block.decorativeBlocks.concrete.BlockConcrete;

public class ItemBlockConcrete extends ItemBlockCore {

    public ItemBlockConcrete(Block block) {

        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        return "tile.concrete_test." + BlockConcrete.Type.byMetadata(ItemHelper.getItemDamage(stack)).getName() + ".name";
    }

}