package net.thegaminghuskymc.futopia.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMachineOutput extends Slot {

    public SlotMachineOutput(IInventory inv, int slotNum, int x, int y) {

        super(inv, slotNum, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {

        return false;
    }
}
