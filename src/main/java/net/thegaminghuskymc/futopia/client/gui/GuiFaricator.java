package net.thegaminghuskymc.futopia.client.gui;

import java.io.IOException;

import codechicken.lib.colour.ColourRGBA;
import codechicken.lib.texture.TextureUtils;
import keri.ninetaillib.lib.math.Point2i;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.client.IconHandler;
import net.thegaminghuskymc.futopia.client.container.ContainerFabricator;
import net.thegaminghuskymc.futopia.tiles.TileEntityFabricator;
import net.thegaminghuskymc.futopia.utils.EnumXycroniumColor;

@SideOnly(Side.CLIENT)
public class GuiFaricator extends GuiContainer {

    private final ResourceLocation texture = new ResourceLocation(Refs.MODID, "textures/gui/fabricator.png");
    private InventoryPlayer inventoryPlayer;
    private TileEntityFabricator tile;
    private ContainerFabricator container;
    private GuiTab tabInfo = new GuiTab();

    public GuiFaricator(InventoryPlayer inventoryPlayer, TileEntityFabricator tile) {
        super(new ContainerFabricator(inventoryPlayer, tile));
        this.inventoryPlayer = inventoryPlayer;
        this.tile = tile;
        this.container = (ContainerFabricator)this.inventorySlots;
        this.xSize = 192;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        TextureUtils.bindBlockTexture();
        TextureAtlasSprite animationTexture = Futopia.PROXY.getAnimatedTexture();
        EnumXycroniumColor.BLUE.getColor().glColour();
        this.drawTexturedModalRect(this.guiLeft + 13, this.guiTop + 14, animationTexture, 58, 58);
        EnumXycroniumColor.GREEN.getColor().glColour();
        this.drawTexturedModalRect(this.guiLeft + 81, this.guiTop + 28, animationTexture, 30, 30);
        EnumXycroniumColor.RED.getColor().glColour();
        this.drawTexturedModalRect(this.guiLeft + 121, this.guiTop + 14, animationTexture, 58, 58);
        GlStateManager.color(1F, 1F, 1F, 1F);
        this.mc.getTextureManager().bindTexture(this.texture);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        this.tabInfo.setPosition(new Point2i(this.guiLeft - 22, this.guiTop + 10));
        this.tabInfo.setSizeExpanded(new Point2i(102, 50));
        this.tabInfo.setColorUnselected(new ColourRGBA(80, 80, 80, 255));
        this.tabInfo.setColorSelected(new ColourRGBA(220, 220, 80, 255));
        this.tabInfo.setIcon(IconHandler.INSTANCE.getIcon("gui_icon_info"));
        this.tabInfo.setTooltip("Information");
        this.tabInfo.renderBackground(this, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        this.tabInfo.renderForeground(this, mouseX, mouseY);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        this.tabInfo.onMouseClicked(mouseX, mouseY);
    }

}
