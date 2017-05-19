/*
 * This file is part of Blue Power.
 *
 *     Blue Power is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Blue Power is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Blue Power.  If not, see <http://www.gnu.org/licenses/>
 */

package net.thegaminghuskymc.futopia.tile.tier2;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.thegaminghuskymc.futopia.Futopia;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TheGamingHuskyMC
 */
public class TileBase extends TileEntity implements IRotatable {

    private boolean isRedstonePowered;
    private int outputtingRedstone;
    private int ticker = 0;
    private EnumFacing rotation = EnumFacing.UP;

    /*************** BASIC TE FUNCTIONS **************/

	/*@Override
    public void readFromNBT(NBTTagCompound tCompound) {

		super.readFromNBT(tCompound);
		isRedstonePowered = tCompound.getBoolean("isRedstonePowered");
		readFromPacketNBT(tCompound);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tCompound) {

		super.writeToNBT(tCompound);
		tCompound.setBoolean("isRedstonePowered", isRedstonePowered);

		writeToPacketNBT(tCompound);
		return tCompound;
	}*/

    /**
     * Tags written in here are synced upon markBlockForUpdate.
     *
     * @param tCompound
     */
    protected void writeToPacketNBT(NBTTagCompound tCompound) {

        tCompound.setByte("rotation", (byte) rotation.ordinal());
        tCompound.setByte("outputtingRedstone", (byte) outputtingRedstone);
    }

    protected void readFromPacketNBT(NBTTagCompound tCompound) {

        rotation = EnumFacing.fromAngle(tCompound.getByte("rotation"));
        if (rotation.ordinal() > 5) {
            Futopia.log.warn("invalid rotation!");
            rotation = EnumFacing.UP;
        }
        outputtingRedstone = tCompound.getByte("outputtingRedstone");
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {

        readFromPacketNBT(pkt.getNbtCompound());
    }

    /**
     * ************** ADDED FUNCTIONS ****************
     */

    public void onBlockNeighbourChanged() {
        checkRedstonePower();
    }

    /**
     * Checks if redstone has changed.
     */
    public void checkRedstonePower() {
        boolean isIndirectlyPowered = getWorld().isBlockPowered(pos);
        if (isIndirectlyPowered && !getIsRedstonePowered()) {
            redstoneChanged(true);
        } else if (getIsRedstonePowered() && !isIndirectlyPowered) {
            redstoneChanged(false);
        }
    }

    /**
     * Before being able to use this, remember to mark the block as redstone
     * emitter by calling BlockContainerBase#emitsRedstone()
     *
     * @param newValue
     */
    public void setOutputtingRedstone(boolean newValue) {
        setOutputtingRedstone(newValue ? 15 : 0);
    }

    public int getOutputtingRedstone() {
        return outputtingRedstone;
    }

    /**
     * Before being able to use this, remember to mark the block as redstone
     * emitter by calling BlockContainerBase#emitsRedstone()
     *
     * @param value
     */
    public void setOutputtingRedstone(int value) {
        value = Math.max(0, value);
        value = Math.min(15, value);
        if (outputtingRedstone != value) {
            outputtingRedstone = value;
        }
    }

    /**
     * This method can be overwritten to get alerted when the redstone level has
     * changed.
     *
     * @param newValue The redstone level it is at now
     */
    protected void redstoneChanged(boolean newValue) {
        isRedstonePowered = newValue;
    }

    /**
     * Check whether or not redstone level is high
     */
    public boolean getIsRedstonePowered() {
        return isRedstonePowered;
    }

    /**
     * Returns the ticker of the Tile, this number wll increase every tick
     *
     * @return the ticker
     */
    public int getTicker() {
        return ticker;
    }

    /**
     * Gets called when the TileEntity ticks for the first time, the world is
     * accessible and updateEntity() has not been ran yet
     */
    protected void onTileLoaded() {
        if (!worldObj.isRemote)
            onBlockNeighbourChanged();
    }

    public List<ItemStack> getDrops() {
        return new ArrayList<ItemStack>();
    }

    public boolean canConnectRedstone() {
        return false;
    }

    @Override
    public EnumFacing getFacing() {
        return EnumFacing.NORTH;
    }

    @Override
    public void setFacing(EnumFacing facing) {
        facing.getAxis();
        facing.rotateAround(EnumFacing.Axis.X);
        return;
    }

    @Override
    public boolean canRotateVertically() {
        return false;
    }
}
