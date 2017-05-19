package net.thegaminghuskymc.futopia.client.gui.slots;

import codechicken.lib.util.ItemUtils;
import keri.ninetaillib.property.EnumDyeColor;
import keri.ninetaillib.slot.SlotBase;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SlotDye extends SlotBase {

    private EnumDyeColor color;

    public SlotDye(IInventory inventory, int idx, int x, int y, EnumDyeColor color) {
        super(inventory, idx, x, y);
        this.color = color;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return ItemUtils.areStacksSameType(stack, new ItemStack(Items.DYE, 1, this.color.getID()));
    }

}
