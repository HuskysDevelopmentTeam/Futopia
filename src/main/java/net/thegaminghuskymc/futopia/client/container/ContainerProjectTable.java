package net.thegaminghuskymc.futopia.client.container;

import keri.ninetaillib.container.ContainerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.client.gui.slots.SlotWhitelist;
import net.thegaminghuskymc.futopia.tile.tier1.TileProjectTable;

public class ContainerProjectTable extends ContainerBase {

    private final TileProjectTable tile;

    public ContainerProjectTable(InventoryPlayer inventoryPlayer, TileProjectTable tile) {
        this.tile = tile;
        this.bindPlayerInventory(inventoryPlayer, 12, 106);
        //Lava Input
        this.addSlotToContainer(new SlotWhitelist(tile, 6, 168, 81, new ItemStack(Items.WATER_BUCKET, 1, 0)));
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

}