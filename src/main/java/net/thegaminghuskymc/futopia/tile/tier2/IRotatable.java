package net.thegaminghuskymc.futopia.tile.tier2;

import net.minecraft.util.EnumFacing;

public interface IRotatable {
    EnumFacing getFacing();

    void setFacing(EnumFacing facing);

    boolean canRotateVertically();
}
