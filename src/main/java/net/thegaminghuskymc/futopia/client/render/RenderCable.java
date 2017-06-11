/*package net.thegaminghuskymc.futopia.client.render;

import codechicken.lib.colour.Colour;
import keri.ninetaillib.lib.json.model.JsonModel;
import keri.ninetaillib.lib.render.IBlockRenderingHandler;
import keri.ninetaillib.lib.render.RenderingRegistry;
import keri.ninetaillib.lib.util.BlockAccessUtils;
import keri.ninetaillib.lib.util.EnumDyeColor;
import keri.ninetaillib.lib.util.RenderUtils;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.thegaminghuskymc.futopia.proxy.ClientProxy;

import java.util.List;

*//**
 * Created by TheGamingHuskyMC on 26.05.2017.
 *//*
public class RenderCable implements IBlockRenderingHandler{

    public static EnumBlockRenderType RENDER_TYPE;
    private static JsonModel jsonModel = ClientProxy.modelLoader.getModelData("cable");

    static{
        RENDER_TYPE = RenderingRegistry.getNextAvailableType();
        RenderingRegistry.registerRenderingHandler(new RenderCable());
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
        model.recolor(color, "cuboid_5");
        model.recolor(color, "cuboid_6");
        model.recolor(color, "cuboid_7");
        model.recolor(color, "cuboid_8");
        model.recolor(color, "cuboid_9");
        model.recolor(color, "cuboid_10");
        model.recolor(color, "cuboid_11");
        model.recolor(color, "cuboid_12");
        model.recolor(color, "cuboid_13");
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
        model.recolor(color, "cuboid_5");
        model.recolor(color, "cuboid_6");
        model.recolor(color, "cuboid_7");
        model.recolor(color, "cuboid_8");
        model.recolor(color, "cuboid_9");
        model.recolor(color, "cuboid_10");
        model.recolor(color, "cuboid_11");
        model.recolor(color, "cuboid_12");
        model.recolor(color, "cuboid_13");
        RenderHelper.enableStandardItemLighting();
        model.generateModel().render(buffer, null, null);
    }

    @Override
    public EnumBlockRenderType getRenderType() {
        return RENDER_TYPE;
    }
}
*/