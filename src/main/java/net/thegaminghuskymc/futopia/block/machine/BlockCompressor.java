package net.thegaminghuskymc.futopia.block.machine;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.client.render.CompressorRenderer;
import net.thegaminghuskymc.futopia.compatibilities.waila.IWailaUser;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.item.block.ItemBlockCompressor;
import net.thegaminghuskymc.futopia.items.ores.ItemAlloyIngot;
import net.thegaminghuskymc.futopia.items.ores.ItemOreIngot;
import net.thegaminghuskymc.futopia.reference.Refs;
import net.thegaminghuskymc.futopia.tile.tier1.TileCompressor;

import javax.annotation.Nullable;
import java.util.List;

public class BlockCompressor extends Block implements ITileEntityProvider, IWailaUser {

    public BlockCompressor() {
        super(Material.IRON);
        setUnlocalizedName(Refs.COMPRESSOR_NAME);
        setRegistryName(Refs.COMPRESSOR_NAME);
        GameRegistry.register(this);
        setLightLevel(15.0F);
        GameRegistry.register(new ItemBlockCompressor(this), getRegistryName());
        setCreativeTab(FTCreativeTabs.machines);
    }

    private TileCompressor getTE(World world, BlockPos pos) {
        return (TileCompressor) world.getTileEntity(pos);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileCompressor te = getTE(world, pos);
            if (te.getStack() == null) {
                if (player.getHeldItem(hand) != null && player.getHeldItem(hand).getItem() instanceof ItemOreIngot || player.getHeldItem(hand).getItem() instanceof ItemAlloyIngot) {
                    ItemStack stack = player.getHeldItem(hand).copy();
                    int stackSize = stack.stackSize;

                    if (player.getHeldItem(hand).stackSize > 9) {
                        stack.stackSize = 9;
                        te.setStack(stack);

                        ItemStack returnStack = player.getHeldItem(hand).copy();
                        returnStack.stackSize -= 9;
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, returnStack);
                    } else {
                        stack.stackSize = stackSize;
                        te.setStack(stack);

                        ItemStack returnStack = player.getHeldItem(hand).copy();
                        returnStack.stackSize -= stackSize;
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, returnStack);

                    }
                    player.openContainer.detectAndSendChanges();
                }
            } else {
                ItemStack stack = te.getStack();

                te.setStack(null);
                if (!player.inventory.addItemStackToInventory(stack)) {
                    EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY() + 1, pos.getZ(), stack);
                    world.spawnEntityInWorld(entityItem);
                } else {
                    player.openContainer.detectAndSendChanges();
                }
            }
        }
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean isBlockNormalCube(IBlockState blockState) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileCompressor.class, new CompressorRenderer());
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileCompressor();
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        TileCompressor te = getTE(accessor.getWorld(), accessor.getPosition());

        if (te instanceof TileCompressor) {
            ItemStack item = te.getStack();
            if (te.getStack() != null) {
                currenttip.add("Contains: " + item.getDisplayName());
            }
        }
        return currenttip;
    }
}