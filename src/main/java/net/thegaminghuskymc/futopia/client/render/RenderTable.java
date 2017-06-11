/*package net.thegaminghuskymc.futopia.client.render;

import codechicken.lib.colour.Colour;
import codechicken.lib.math.MathHelper;
import codechicken.lib.util.ClientUtils;
import keri.ninetaillib.lib.json.model.JsonModel;
import keri.ninetaillib.lib.render.IBlockRenderingHandler;
import keri.ninetaillib.lib.render.RenderingRegistry;
import keri.ninetaillib.lib.util.BlockAccessUtils;
import keri.ninetaillib.lib.util.EnumDyeColor;
import keri.ninetaillib.lib.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.thegaminghuskymc.futopia.proxy.ClientProxy;
import net.thegaminghuskymc.futopia.tiles.TileTable;

import java.util.List;

public class RenderTable extends TileEntitySpecialRenderer<TileTable> implements IBlockRenderingHandler{

    public static EnumBlockRenderType RENDER_TYPE;
    private static JsonModel jsonModel = ClientProxy.modelLoader.getModelData("table");

    static{
        RENDER_TYPE = RenderingRegistry.getNextAvailableType();
        RenderingRegistry.registerRenderingHandler(new RenderTable());
    }

    //Renders Blocks in world
    @Override
    public boolean renderWorld(IBlockAccess world, BlockPos pos, VertexBuffer buffer, BlockRenderLayer layer) {
        JsonModel model = jsonModel.copy();
        Colour color = EnumDyeColor.VALUES[BlockAccessUtils.getBlockMetadata(world, pos)].getColor();
        model.recolor(color, "cuboid_1");
        model.recolor(color, "cuboid_2");
        model.recolor(color, "cuboid_3");
        model.recolor(color, "cuboid_4");
        return RenderUtils.renderQuads(buffer, world, pos, model.generateModel().bake());
    }

    //render the damage
    @Override
    public void renderDamage(IBlockAccess world, BlockPos pos, VertexBuffer buffer, TextureAtlasSprite texture) {
        JsonModel model = jsonModel.copy();
        model.generateModel().renderDamage(buffer, world, pos, texture);
    }

    //renders blocks in the inventory
    @Override
    public void renderInventory(ItemStack stack, VertexBuffer buffer) {
        JsonModel model = jsonModel.copy();
        Colour color = EnumDyeColor.VALUES[stack.getMetadata()].getColor();
        model.recolor(color, "cuboid_1");
        model.recolor(color, "cuboid_2");
        model.recolor(color, "cuboid_3");
        model.recolor(color, "cuboid_4");
        RenderHelper.enableStandardItemLighting();
        model.generateModel().render(buffer, null, null);
    }

    @Override
    public void renderTileEntityAt(TileTable tile, double x, double y, double z, float partialTicks, int destroyStage) {
        if(!tile.getStackInSlot(0).isEmpty()){
            double sin = MathHelper.sin(Minecraft.getMinecraft().player.ticksExisted / MathHelper.todeg * 4D) / 12D;
            double floating = MathHelper.interpolate(sin, sin, partialTicks);
            GlStateManager.pushMatrix();
            GlStateManager.pushAttrib();
            GlStateManager.translate(x + 0.5D, y + 0.9D + floating, z + 0.5D);
            GlStateManager.rotate((float) ClientUtils.getRenderTime(), 0F, 1F, 0F);
            Render<EntityItem> renderer = Minecraft.getMinecraft().getRenderManager().getEntityClassRenderObject(EntityItem.class);
            EntityItem entity = new EntityItem(tile.getWorld(), 0D, 0D, 0D);
            ItemStack stack = tile.getStackInSlot(0).copy();
            stack.setCount(1);
            entity.setEntityItemStack(stack);
            entity.setNoDespawn();
            entity.hoverStart = 0F;
            renderer.doRender(entity, 0D, 0D, 0D, 0F, 0F);
            GlStateManager.popAttrib();
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.pushAttrib();
            GlStateManager.translate(x + 0.5D, y + 1.85D, z + 0.5D);
            GlStateManager.scale(0.625D, 0.625D, 0.625D);
            FontRenderer fontRenderer = Minecraft.getMinecraft().fontRendererObj;
            EntityPlayer player = Minecraft.getMinecraft().player;
            float rotationYaw = player.rotationYaw;
            float rotationPitch = player.rotationPitch;
            boolean isSneaking = player.isSneaking();
            EntityRenderer.drawNameplate(fontRenderer, stack.getDisplayName(), 0F, 0F, 0F, 0, rotationYaw, rotationPitch, false, isSneaking);
            GlStateManager.popAttrib();
            GlStateManager.popMatrix();
        }
    }

    @Override
    public EnumBlockRenderType getRenderType() {
        return RENDER_TYPE;
    }
}
*/