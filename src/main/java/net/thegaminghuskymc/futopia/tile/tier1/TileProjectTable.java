/*
 * This file is part of Blue Power. Blue Power is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. Blue Power is
 * distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along
 * with Blue Power. If not, see <http://www.gnu.org/licenses/>
 */
package net.thegaminghuskymc.futopia.tile.tier1;

import keri.ninetaillib.inventory.InternalInventory;
import keri.ninetaillib.network.INetworkTile;
import keri.ninetaillib.tile.TileEntityInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fml.relauncher.Side;

public class TileProjectTable extends TileEntityInventory implements IFluidHandler, ITickable, INetworkTile {

    private EnumFacing orientation = EnumFacing.NORTH;
    private InternalInventory internalInventory = new InternalInventory(this, 7);
    private FluidTank tankRedstone = new FluidTank(16000);

    public TileProjectTable() {
        this.tankRedstone.setCanDrain(false);
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
    public void onUpdatePacket(Side side, Object value, int valueId) {
        if (side == Side.CLIENT) {
            switch (valueId) {
                case 0:
                    this.tankRedstone.setFluid((FluidStack) value);
                    break;
            }
        }
    }

    @Override
    public InternalInventory getInternalInventory() {
        return this.internalInventory;
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

    @Override
    public FluidTankInfo[] getTankInfo(EnumFacing from) {
        return null;
        //return this.tankRedstone.getCapacity();
    }

    @Override
    public FluidStack drain(EnumFacing from, FluidStack resource, boolean doDrain) {
        return this.tankRedstone.drain(resource, doDrain);
    }

    @Override
    public FluidStack drain(EnumFacing from, int maxDrain, boolean doDrain) {
        return this.tankRedstone.drain(maxDrain, doDrain);
    }

    @Override
    public int fill(EnumFacing from, FluidStack resource, boolean doFill) {
        return this.tankRedstone.fill(resource, doFill);
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
    public boolean canFill(EnumFacing from, Fluid fluid) {
        return this.tankRedstone.canFill();
    }

    @Override
    public boolean canDrain(EnumFacing from, Fluid fluid) {
        return this.tankRedstone.canDrain();
    }

}