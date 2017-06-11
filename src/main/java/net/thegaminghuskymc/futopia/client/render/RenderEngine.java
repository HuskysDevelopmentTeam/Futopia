/*package net.thegaminghuskymc.futopia.client.render;

import keri.ninetaillib.lib.json.model.JsonModel;
import keri.ninetaillib.lib.render.IBlockRenderingHandler;
import keri.ninetaillib.lib.render.RenderingRegistry;
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
public class RenderEngine implements IBlockRenderingHandler{

    public static EnumBlockRenderType RENDER_TYPE;
    private static JsonModel jsonModel = ClientProxy.modelLoader.getModelData("engine");

    static{
        RENDER_TYPE = RenderingRegistry.getNextAvailableType();
        RenderingRegistry.registerRenderingHandler(new RenderEngine());
    }

    //Renders Blocks in world
    @Override
    public boolean renderWorld(IBlockAccess world, BlockPos pos, VertexBuffer buffer, BlockRenderLayer layer) {
        JsonModel model = jsonModel.copy();
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
        RenderHelper.enableStandardItemLighting();
        model.generateModel().render(buffer, null, null);
    }

    @Override
    public EnumBlockRenderType getRenderType() {
        return RENDER_TYPE;
    }
}
*/