package net.thegaminghuskymc.futopia.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.client.container.ContainerPlatePresser;
import net.thegaminghuskymc.futopia.client.container.ContainerProjectTable;
import net.thegaminghuskymc.futopia.tile.tier1.TilePlatePresser;
import net.thegaminghuskymc.futopia.tile.tier1.TileProjectTable;

public class GUIHandler implements IGuiHandler {

    public static final int PLATE_PRESSER = 0;
    public static final int PROJECT_TABLE = 1;
    public static final int GUIID_ENGINEERING_TABLE = 2;
    public static final int GUIID_TANK = 3;

    @Override
    @SideOnly(Side.CLIENT)
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == PLATE_PRESSER) {
            TilePlatePresser tile = (TilePlatePresser) world.getTileEntity(new BlockPos(x, y, z));
            return new GuiPlatePresser(player.inventory, tile);
        }
        if (ID == PROJECT_TABLE) {
            TileProjectTable tile = (TileProjectTable) world.getTileEntity(new BlockPos(x, y, z));
            return new GuiProjectTable(player.inventory, tile);
        }

        return null;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == PLATE_PRESSER) {
            TilePlatePresser tile = (TilePlatePresser) world.getTileEntity(new BlockPos(x, y, z));
            return new ContainerPlatePresser(player.inventory, tile);
        }
        if (ID == PROJECT_TABLE) {
            TileProjectTable tile = (TileProjectTable) world.getTileEntity(new BlockPos(x, y, z));
            return new ContainerProjectTable(player.inventory, tile);
        }

        return null;
    }
}
