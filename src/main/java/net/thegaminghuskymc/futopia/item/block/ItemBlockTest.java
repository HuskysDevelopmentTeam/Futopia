package net.thegaminghuskymc.futopia.item.block;

import cofh.core.block.ItemBlockCore;
import cofh.lib.util.helpers.ItemHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.block.TestBlock;

public class ItemBlockTest extends ItemBlockCore {

    public ItemBlockTest(Block block) {

        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile.test_block." + TestBlock.Type.byMetadata(ItemHelper.getItemDamage(stack)).getName() + ".name";
    }

}