package net.thegaminghuskymc.futopia.client.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.client.gui.GuiElectricalFurnace;
import net.thegaminghuskymc.futopia.tiles.TileEntityFurnace;

public class ContainerElectricalFurnace extends ContainerBase{
	
	private TileEntityFurnace tile;
	private InventoryPlayer inventoryPlayer;
	private GuiElectricalFurnace gui;
	
	private int cookTime;
    private int totalCookTime;
    private int furnaceBurnTime;
    private int currentItemBurnTime;
	
	public ContainerElectricalFurnace(InventoryPlayer inventoryPlayer, TileEntityFurnace tile) {
		this.inventoryPlayer = inventoryPlayer;
        this.tile = tile;
        this.addPlayerInventory(inventoryPlayer, 8, 84);
        
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                int index = x * 3 + y;
                int posX = 16 + 18 * x;
                int posY = 17 + 18 * y;
                this.addSlotToContainer(new Slot(tile, index, posX, posY));
            }
        }
        
        for(int x = 3; x < 4; x++){
            for(int y = 0; y < 1; y++){
                int index2 = x * 3 + y;
                int posX2 = 34 + 18 * x;
                int posY2 = 35 + 18 * y;
                this.addSlotToContainer(new SlotFurnaceFuel(tile, index2, posX2, posY2));
            }
        }
        
        for(int x = 4; x < 7; x++){
            for(int y = 0; y < 3; y++){
                int index3 = x * 3 + y;
                int posX3 = 52 + 18 * x;
                int posY3 = 17 + 18 * y;
                this.addSlotToContainer(new SlotFurnaceOutput(inventoryPlayer.player, tile, index3, posX3, posY3));
            }
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.tile.isUsableByPlayer(playerIn);
	}
	
	public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener icontainerlistener = (IContainerListener)this.listeners.get(i);

            if (this.cookTime != this.tile.getField(2))
            {
                icontainerlistener.sendProgressBarUpdate(this, 2, this.tile.getField(2));
            }

            if (this.furnaceBurnTime != this.tile.getField(0))
            {
                icontainerlistener.sendProgressBarUpdate(this, 0, this.tile.getField(0));
            }

            if (this.currentItemBurnTime != this.tile.getField(1))
            {
                icontainerlistener.sendProgressBarUpdate(this, 1, this.tile.getField(1));
            }

            if (this.totalCookTime != this.tile.getField(3))
            {
                icontainerlistener.sendProgressBarUpdate(this, 3, this.tile.getField(3));
            }
        }

        this.cookTime = this.tile.getField(2);
        this.furnaceBurnTime = this.tile.getField(0);
        this.currentItemBurnTime = this.tile.getField(1);
        this.totalCookTime = this.tile.getField(3);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.tile.setField(id, data);
    }

    /**
     * Take a stack from the specified inventory slot.
     */
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index != 1 && index != 0)
            {
                if (!FurnaceRecipes.instance().getSmeltingResult(itemstack1).isEmpty())
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 3 && index < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }

}
