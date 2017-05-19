package net.thegaminghuskymc.futopia.tile.tier1;

import keri.ninetaillib.tile.TileEntityBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

public class TilePowerCable extends TileEntityBase {

    private EnumFacing orientation = EnumFacing.NORTH;

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.orientation = EnumFacing.getFront(tag.getInteger("orientation"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("orientation", this.orientation.getIndex());
        return tag;
    }

    public EnumFacing getOrientation() {
        return this.orientation;
    }

    public void setOrientation(EnumFacing orientation) {
        this.orientation = orientation;
    }

}
