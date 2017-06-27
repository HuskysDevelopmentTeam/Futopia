package net.thegaminghuskymc.futopia.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.client.container.ContainerElectricalFurnace;
import net.thegaminghuskymc.futopia.tiles.TileElectricalFurnace;
import net.thegaminghuskymc.futopia.tiles.TileEntityFurnace;

@SideOnly(Side.CLIENT)
public class GuiElectricalFurnace extends GuiContainer{
	
	private final ResourceLocation texture = new ResourceLocation(Refs.MODID, "textures/gui/electrical_furnace.png");
    private InventoryPlayer inventoryPlayer;
    private TileEntityFurnace tile;
    private ContainerElectricalFurnace container;

	public GuiElectricalFurnace(InventoryPlayer inventoryPlayer, TileEntityFurnace tile) {
		super(new ContainerElectricalFurnace(inventoryPlayer, tile));
        this.inventoryPlayer = inventoryPlayer;
        this.tile = tile;
        this.container = (ContainerElectricalFurnace)this.inventorySlots;
        this.xSize = 192;
        this.ySize = 166;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        /*this.mc.getTextureManager().bindTexture(this.texture);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);*/
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

        if (TileEntityFurnace.isBurning(this.tile))
        {
            int k = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.getCookProgressScaled(24);
        this.drawTexturedModalRect(i + 79, j + 34, 176, 14, l + 1, 16);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		/*String name = "Electrical Furnace";
        int posX = (this.xSize / 2) - (this.fontRendererObj.getStringWidth(name) / 2);
        int posY = 5;
        Colour textColor = new ColourRGBA(40, 40, 40, 255);
        this.fontRendererObj.drawString(name, posX, posY, textColor.argb());
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 18, this.ySize - 93, textColor.argb());*/
		String s = this.tile.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(this.inventoryPlayer.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
	}
	
	private int getCookProgressScaled(int pixels)
    {
        int i = this.tile.getField(2);
        int j = this.tile.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }

    private int getBurnLeftScaled(int pixels)
    {
        int i = this.tile.getField(1);

        if (i == 0)
        {
            i = 200;
        }

        return this.tile.getField(0) * pixels / i;
    }

}
