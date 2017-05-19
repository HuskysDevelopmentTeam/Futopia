package net.thegaminghuskymc.futopia.client.gui;

import keri.ninetaillib.util.ResourceAction;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.thegaminghuskymc.futopia.client.container.ContainerPlatePresser;
import net.thegaminghuskymc.futopia.client.container.ContainerProjectTable;
import net.thegaminghuskymc.futopia.reference.Refs;
import net.thegaminghuskymc.futopia.tile.tier1.TileProjectTable;

/**
 * Created by TheGamingHuskyMC on 01.05.2017.
 */
public class GuiProjectTable extends GuiContainer {

    private final ResourceAction texture = new ResourceAction(Refs.MODID, "textures/gui/project_table.png");
    private final ContainerProjectTable container;
    private TileProjectTable tile;

    public GuiProjectTable(InventoryPlayer inventoryPlayer, TileProjectTable tile) {
        super(new ContainerProjectTable(inventoryPlayer, tile));
        this.tile = tile;
        this.container = (ContainerProjectTable) this.inventorySlots;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        texture.bind(true);
        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    }
}
