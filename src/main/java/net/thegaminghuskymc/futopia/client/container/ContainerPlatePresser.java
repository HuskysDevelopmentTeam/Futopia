package net.thegaminghuskymc.futopia.client.container;

import keri.ninetaillib.container.ContainerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.client.gui.slots.SlotWhitelist;
import net.thegaminghuskymc.futopia.init.FTItems;
import net.thegaminghuskymc.futopia.tile.tier1.TilePlatePresser;

public class ContainerPlatePresser extends ContainerBase {

    private TilePlatePresser tile;
    private int smeltingProgress = 0;
    private int progress = 0;
    private EntityPlayer player;

    public ContainerPlatePresser(InventoryPlayer inventoryPlayer, TilePlatePresser tile) {
        this.tile = tile;
        this.bindPlayerInventory(inventoryPlayer, 0, 88);
        //Battery
        this.addSlotToContainer(new SlotWhitelist(tile, 1, 120, 27, new ItemStack(FTItems.ingots)));
        //Armor
        /*this.addSlotToContainer(new SlotArmor(player, 4, 130, 50));
        this.addSlotToContainer(new SlotArmor(player, 3, 130, 40));
        this.addSlotToContainer(new SlotArmor(player, 4, 130, 30));
        this.addSlotToContainer(new SlotArmor(player, 1, 130, 20));*/
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.tile.isUseableByPlayer(player);
    }

    @Override
    public void updateProgressBar(int id, int data) {
        super.updateProgressBar(id, data);

        switch (id) {
            case 0:
                this.smeltingProgress = data;
                break;
            case 1:
                this.progress = data;
                break;
        }
    }

    public int getSmeltingProgress() {
        return this.smeltingProgress;
    }

    public int getProgress() {
        return this.progress;
    }
}
