package net.thegaminghuskymc.futopia.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotExclude extends Slot {

    Item filter;

    public SlotExclude(IInventory par1iInventory, int par2, int par3, int par4, Item filter) {

        super(par1iInventory, par2, par3, par4);

        this.filter = filter;
    }

    @Override
    public boolean isItemValid(ItemStack par1ItemStack) {

        return par1ItemStack == null || !(par1ItemStack.getItem() == filter);
    }
}
