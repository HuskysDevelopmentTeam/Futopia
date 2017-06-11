package net.thegaminghuskymc.futopia.blocks.machine;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.blocks.EnumPlacementType;
import net.thegaminghuskymc.futopia.client.render.PlatingPressRenderer;
import net.thegaminghuskymc.futopia.client.render.PropertyObject;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.items.itemblocks.ItemBlockPlatingPresser;
import net.thegaminghuskymc.futopia.tiles.TilePlatingPress;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockPlatingPress extends Block {

    public static final PropertyObject<Integer[]> DISK_STATE = new PropertyObject<>("disk_state", Integer[].class);

    public BlockPlatingPress() {
        super(Material.IRON);
        setUnlocalizedName(BlockNames.PLATING_PRESS_NAME);
        setRegistryName(BlockNames.PLATING_PRESS_NAME);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlockPlatingPresser(this), getRegistryName());
        setCreativeTab(FTCreativeTabs.main);
    }

    private TilePlatingPress getTE(World world, BlockPos pos) {
        return (TilePlatingPress) world.getTileEntity(pos);
    }

    /*@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TilePlatingPress te = getTE(world, pos);
            if (te.getStack() == null) {
                //if (player.getHeldItem(hand) != null && player.getHeldItem(hand).getItem() instanceof ItemOreBlock || player.getHeldItem(hand).getItem() instanceof ItemAlloyBlock) {
                if (player.getHeldItem(hand) != null) {
                    // If block is empty and the player is holding an ingot. We move that item into the

                    //Inn
                    ItemStack stack = player.getHeldItem(hand).copy();
                    stack.getCount();
                    te.setStack(stack);

                    ItemStack returnStack = player.getHeldItem(hand).copy();
                    returnStack.shrink(1);;
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, returnStack);

                    // Make sure the client knows about the changes in the player inventory
                    player.openContainer.detectAndSendChanges();
                }
            } else if (!player.isSneaking()) {
                // There is a stack in the pedestal. In this case we remove it and try to put it in the
                // players inventory if there is room
                ItemStack stack = te.getStack();
                te.setStack(null);
                if (!player.inventory.addItemStackToInventory(stack)) {
                    // Not possible. Throw item in the world
                    EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY() + 1, pos.getZ(), stack);
                    world.spawnEntityInWorld(entityItem);
                } else {
                    player.openContainer.detectAndSendChanges();
                }
            }
        }
        // Return true also on the client to make sure that MC knows we handled this and will not try to place
        // a block on the client
        return true;
    }*/


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
        ClientRegistry.bindTileEntitySpecialRenderer(TilePlatingPress.class, new PlatingPressRenderer());
    }


    @Nullable
    public EnumPlacementType getDirection() {
        return EnumPlacementType.HORIZONTAL;
    }
}