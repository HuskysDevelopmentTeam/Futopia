package net.thegaminghuskymc.futopia.blocks.machine;

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
import net.thegaminghuskymc.futopia.client.render.CompressorRenderer;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.items.itemblocks.ItemBlockCompressor;
import net.thegaminghuskymc.futopia.tiles.TileCompressor;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockCompressor extends Block {

    public BlockCompressor() {
        super(Material.IRON);
        setUnlocalizedName(BlockNames.COMPRESSOR_NAME);
        setRegistryName(BlockNames.COMPRESSOR_NAME);
        setLightLevel(15.0F);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlockCompressor(this), getRegistryName());
        setCreativeTab(FTCreativeTabs.main);
    }

    private TileCompressor getTE(World world, BlockPos pos) {
        return (TileCompressor) world.getTileEntity(pos);
    }

    /*@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileCompressor te = getTE(world, pos);
            if (te.getStack() == null) {

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
        ClientRegistry.bindTileEntitySpecialRenderer(TileCompressor.class, new CompressorRenderer());
    }

}