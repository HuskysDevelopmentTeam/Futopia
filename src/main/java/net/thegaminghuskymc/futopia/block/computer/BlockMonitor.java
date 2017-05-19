package net.thegaminghuskymc.futopia.block.computer;

import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.block.BlockMachineBase;
import net.thegaminghuskymc.futopia.reference.Refs;

public class BlockMonitor extends BlockMachineBase {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

//	@Override
//	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
//
//		TileEntity tileEntity = worldIn.getTileEntity(pos);
//		if (tileEntity instanceof TileMonitor) {
//			Futopia.log.info("[FutopiaControl] CPU TE ticked");
//		}
//	}

//    @Override
//    public TileMonitor createNewTileEntity(World world, int meta) {
//        return new TileMonitor();
//    }

    public BlockMonitor() {
        super(Refs.BLOCKMONITOR_NAME);
        setLightLevel(100F);
    }

//    @Override
//    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
//        if (!worldIn.isRemote)
//        {
//            TileEntity tileentity = worldIn.getTileEntity(pos);
//
//            if (tileentity instanceof TileEntity)
//            {
//                playerIn.openGui(Futopia.instance, GuiHandler.MONITOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
//            }
//        }
//
//        return true;
//    }

    @Override
    public int tickRate(World world) {

        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegistrar registrar) {
        this.texture = new TextureAtlasSprite[5];
        this.texture[0] = registrar.registerIcon(Refs.MODID + ":blocks/machines/monitor/monitor_front2");
        this.texture[1] = registrar.registerIcon(Refs.MODID + ":blocks/machines/monitor/monitor_side");
        this.texture[2] = registrar.registerIcon(Refs.MODID + ":blocks/machines/monitor/monitor_top");
        this.texture[3] = registrar.registerIcon(Refs.MODID + ":blocks/machines/monitor/monitor_back");
        this.texture[4] = registrar.registerIcon(Refs.MODID + ":blocks/machines/monitor/monitor_bottom");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        switch (side) {
            case 0:
                return this.texture[4];
            case 1:
                return this.texture[2];
            case 2:
                return this.texture[0];
            case 3:
                return this.texture[3];
            case 4:
                return this.texture[1];
            case 5:
                return this.texture[1];
        }

        return null;
    }

}
