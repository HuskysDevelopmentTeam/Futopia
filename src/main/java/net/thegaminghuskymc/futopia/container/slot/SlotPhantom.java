package net.thegaminghuskymc.futopia.container.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotPhantom extends Slot implements IPhantomSlot {

    // used for filters
    public SlotPhantom(IInventory par2IInventory, int par3, int par4, int par5) {

        super(par2IInventory, par3, par4, par5);
    }

    @Override
    public boolean canTakeStack(EntityPlayer par1EntityPlayer) {

        return false;
    }

    @Override
    public boolean canAdjust() {

        return true;
    }

}
