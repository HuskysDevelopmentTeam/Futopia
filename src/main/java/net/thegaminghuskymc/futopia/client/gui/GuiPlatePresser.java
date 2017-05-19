package net.thegaminghuskymc.futopia.client.gui;

import keri.ninetaillib.util.ResourceAction;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.thegaminghuskymc.futopia.client.container.ContainerPlatePresser;
import net.thegaminghuskymc.futopia.reference.Refs;
import net.thegaminghuskymc.futopia.tile.tier1.TilePlatePresser;

/**
 * Created by TheGamingHuskyMC on 01.05.2017.
 */
public class GuiPlatePresser extends GuiContainer {

    private final ResourceAction texture = new ResourceAction(Refs.RESOURSE_PREFIX, "textures/gui/monitorgui.png");
    private final ContainerPlatePresser container;
    private TilePlatePresser tile;

    public GuiPlatePresser(InventoryPlayer inventoryPlayer, TilePlatePresser tile) {
        super(new ContainerPlatePresser(inventoryPlayer, tile));
        this.tile = tile;
        this.container = (ContainerPlatePresser) this.inventorySlots;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        texture.bind(true);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    }
}
