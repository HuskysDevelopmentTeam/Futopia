package net.thegaminghuskymc.futopia.container.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotLocked extends Slot {

    public SlotLocked(IInventory par1iInventory, int par2, int par3, int par4) {

        super(par1iInventory, par2, par3, par4);
    }

    @Override
    public boolean canTakeStack(EntityPlayer par1EntityPlayer) {

        return false;
    }
}
