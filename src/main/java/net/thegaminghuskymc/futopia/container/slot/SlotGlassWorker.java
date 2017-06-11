package net.thegaminghuskymc.futopia.container.slot;

import keri.ninetaillib.slot.SlotBase;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SlotGlassWorker extends SlotBase {

    public SlotGlassWorker(IInventory inventory, int idx, int x, int y) {
        super(inventory, idx, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        if (Block.getBlockFromItem(stack.getItem()) != null) {

        }

        return false;
    }

}