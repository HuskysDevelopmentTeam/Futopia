package net.thegaminghuskymc.futopia.client.gui.slots;

import codechicken.lib.util.ItemUtils;
import com.google.common.collect.Lists;
import keri.ninetaillib.slot.SlotBase;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import java.util.List;

public class SlotWhitelist extends SlotBase {

    private List<ItemStack> whitelist;

    public SlotWhitelist(IInventory inventory, int idx, int x, int y, ItemStack... whitelist) {
        super(inventory, idx, x, y);
        this.whitelist = Lists.newArrayList(whitelist);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        for (ItemStack currentStack : this.whitelist) {
            return ItemUtils.areStacksSameType(currentStack, stack);
        }

        return false;
    }

}
