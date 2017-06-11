package net.thegaminghuskymc.futopia.tiles;

import keri.ninetaillib.lib.tile.TileEntityInventoryBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

public class TileProjectTable extends TileEntityInventoryBase implements IFluidHandler, ITickable {

    private EnumFacing orientation = EnumFacing.NORTH;
    private FluidTank tankRedstone = new FluidTank(16000);

    public TileProjectTable() {
        super(1);
    }

    @Override
    public void update() {

    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.tankRedstone.readFromNBT(tag.getCompoundTag("tank_redstone"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setTag("tank_redstone", this.tankRedstone.writeToNBT(new NBTTagCompound()));
        return tag;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return true;
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return true;
    }

    public FluidTank getTankRedstone() {
        return this.tankRedstone;
    }

    public EnumFacing getOrientation() {
        return this.orientation;
    }

    public void setOrientation(EnumFacing orientation) {
        this.orientation = orientation;
    }

	@Override
	public IFluidTankProperties[] getTankProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int fill(FluidStack resource, boolean doFill) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FluidStack drain(FluidStack resource, boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FluidStack drain(int maxDrain, boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}

}