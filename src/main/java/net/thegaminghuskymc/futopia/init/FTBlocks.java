package net.thegaminghuskymc.futopia.init;

import keri.ninetaillib.lib.mod.ContentLoader;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.BlockBaseOre;
import net.thegaminghuskymc.futopia.blocks.BlockBaseStorage;
import net.thegaminghuskymc.futopia.blocks.computer.BlockCPU;
import net.thegaminghuskymc.futopia.blocks.computer.BlockDiskDrive;
import net.thegaminghuskymc.futopia.blocks.computer.BlockIOExpander;
import net.thegaminghuskymc.futopia.blocks.computer.BlockMonitor;
import net.thegaminghuskymc.futopia.blocks.machine.BlockAlloyFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockElectricalFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockParticleBlock;
import net.thegaminghuskymc.futopia.blocks.machine.BlockProjectTable;
import net.thegaminghuskymc.futopia.blocks.normal.BlockConcrete;
import net.thegaminghuskymc.futopia.blocks.normal.BlockSlabBase;
import net.thegaminghuskymc.futopia.blocks.normal.BlockStairsBase;
import net.thegaminghuskymc.futopia.blocks.normal.BlockWallBase;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockAsphalt;
import net.thegaminghuskymc.futopia.tiles.TileAlloyFurnace;
import net.thegaminghuskymc.futopia.tiles.TileElectricalFurnace;
import net.thegaminghuskymc.futopia.tiles.TileProjectTable;

@ContentLoader(modid = Refs.MODID)
public class FTBlocks {

//    public static Block table = new BlockTable();
//    public static Block engine = new BlockEngine();
//    public static Block cable = new BlockCable();
    public static Block ores = new BlockBaseOre();
    public static Block storage = new BlockBaseStorage();
    
    public static BlockAlloyFurnace alloyfurnace = new BlockAlloyFurnace();

    public static BlockProjectTable projectTable = new BlockProjectTable();
    public static BlockElectricalFurnace electricalfurnace = new BlockElectricalFurnace();

    public static BlockParticleBlock particle_block = new BlockParticleBlock();
    public static BlockConcrete concrete = new BlockConcrete();

    public static BlockAsphalt asphalt = new BlockAsphalt();

    public static Block testStair = new BlockStairsBase(asphalt.getDefaultState(), "test_stair", true);
    public static Block testSlabHalf = new BlockSlabBase(asphalt, "test_stair", true);
    public static Block testWall = new BlockWallBase(asphalt, "test_stair", true);
    
    public static BlockCPU cpu = new BlockCPU();

    public static BlockDiskDrive disk_drive = new BlockDiskDrive();
    public static BlockIOExpander io_expander = new BlockIOExpander();

    public static BlockMonitor monitor = new BlockMonitor();
    
    static{
    	GameRegistry.registerTileEntity(TileAlloyFurnace.class, "tile_alloy_furnace");
        GameRegistry.registerTileEntity(TileProjectTable.class, "tile_project_table");
        GameRegistry.registerTileEntity(TileProjectTable.class, "tile_project_table");
        GameRegistry.registerTileEntity(TileElectricalFurnace.class, "tile_electrical_furnace");
//        GameRegistry.registerTileEntity(TileKinectGenerator.class, "tile_kinetic_generator");
    }

}
