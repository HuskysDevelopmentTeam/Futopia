package net.thegaminghuskymc.futopia.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.tiles.TileBase;

public class BlockContainerBase extends Block implements ITileEntityProvider {

    @SideOnly(Side.CLIENT)
    private Class<? extends TileBase> tileEntityClass;
    private boolean isRedstoneEmitter;
    private boolean isSilkyRemoving;
    private String name;

    public BlockContainerBase(Material material, Class<? extends TileBase> tileEntityClass) {
        super(material);
        isBlockContainer = true;
        setTileEntityClass(tileEntityClass);
        setCreativeTab(FTCreativeTabs.main);
    }


    public BlockContainerBase setTileEntityClass(Class<? extends TileBase> tileEntityClass) {

        this.tileEntityClass = tileEntityClass;
        return this;
    }

    public BlockContainerBase emitsRedstone() {

        setRedstoneEmitter(true);
        return this;
    }

    /**
     * Fetches the TileEntity Class that goes with the block
     *
     * @return a .class
     */
    protected Class<? extends TileEntity> getTileEntity() {

        return tileEntityClass;
    }

    protected TileBase get(IBlockAccess w, BlockPos pos) {

        TileEntity te = w.getTileEntity(pos);

        return (TileBase) te;
    }

    protected boolean canRotateVertical() {

        return true;
    }

    @Override
    public Block setUnlocalizedName(String name) {
        super.setUnlocalizedName(name);
        return this;
    }

    public boolean isRedstoneEmitter() {
        return isRedstoneEmitter;
    }

    public void setRedstoneEmitter(boolean isRedstoneEmitter) {
        this.isRedstoneEmitter = isRedstoneEmitter;
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileBase();
    }

}