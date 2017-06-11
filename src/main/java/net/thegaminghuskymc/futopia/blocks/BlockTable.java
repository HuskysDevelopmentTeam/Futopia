package net.thegaminghuskymc.futopia.blocks;

import codechicken.lib.util.ItemUtils;
import keri.ninetaillib.lib.util.EnumDyeColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.tiles.TileEngine;
import net.thegaminghuskymc.futopia.tiles.TileTable;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockTable extends BlockFutopia<TileTable> {

    public BlockTable() {
        super("table", Material.ROCK, EnumDyeColor.toStringArray());
        setCreativeTab(FTCreativeTabs.main);
        setHardness(1.0F);
        GameRegistry.registerTileEntity(TileTable.class, "tile_table");
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Nullable
    @Override
    public TileTable createNewTileEntity(World world, int meta) {
        return new TileTable();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileTable tile = (TileTable)world.getTileEntity(pos);

        if(tile != null){
            if(!world.isRemote){
                ItemStack heldItem = player.getHeldItemMainhand();

                if(!heldItem.isEmpty() && tile.getStackInSlot(0).isEmpty()){
                    tile.setInventorySlotContents(0, heldItem.copy());
                    heldItem.setCount(0);
                    heldItem.hasEffect();
                }
                else if(!tile.getStackInSlot(0).isEmpty()){
                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                    entity.setEntityItemStack(tile.getStackInSlot(0));
                    world.spawnEntity(entity);
                    tile.setInventorySlotContents(0, ItemStack.EMPTY);
                }
            }

            return true;
        }

        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    /*@Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return RenderTable.RENDER_TYPE;
    }*/

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileTable tile = (TileTable)world.getTileEntity(pos);

        if(tile != null && !world.isRemote){
            ItemUtils.dropInventory(world, pos, tile);
        }

        super.breakBlock(world, pos, state);
    }

}
