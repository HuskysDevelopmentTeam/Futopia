package net.thegaminghuskymc.futopia.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.thegaminghuskymc.futopia.client.container.ContainerElectricalFurnace;
import net.thegaminghuskymc.futopia.client.container.ContainerFabricator;
import net.thegaminghuskymc.futopia.tiles.TileEntityFabricator;
import net.thegaminghuskymc.futopia.tiles.TileEntityFurnace;

public class GuiHandler implements IGuiHandler {
	
	public static final int ELECTRICAL_FURNACE = 0;
	public static final int GUIID_BASE = 1;
    public static final int GUIID_FABRICATOR = GUIID_BASE + 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if(ID == ELECTRICAL_FURNACE){
			TileEntityFurnace tile = (TileEntityFurnace)world.getTileEntity(new BlockPos(x, y, z));
            return new ContainerElectricalFurnace(player.inventory, tile);
        }
		if(ID == GUIID_FABRICATOR){
            TileEntityFabricator tile = (TileEntityFabricator)world.getTileEntity(new BlockPos(x, y, z));
            return new ContainerFabricator(player.inventory, tile);
        }
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == ELECTRICAL_FURNACE){
			TileEntityFurnace tile = (TileEntityFurnace)world.getTileEntity(new BlockPos(x, y, z));
            return new GuiElectricalFurnace(player.inventory, tile);
        }
		if(ID == GUIID_FABRICATOR){
            TileEntityFabricator tile = (TileEntityFabricator)world.getTileEntity(new BlockPos(x, y, z));
            return new GuiFaricator(player.inventory, tile);
        }
		
		return null;
	}
	
	

}
