package net.thegaminghuskymc.futopia.util.interfaces;

import net.minecraft.util.EnumFacing;

public interface IOrientable {
    boolean canBeRotated();

    EnumFacing getForward();

    void setOrientation(EnumFacing forward);
}
