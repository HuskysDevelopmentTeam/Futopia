package net.thegaminghuskymc.futopia.init;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.block.decorativeBlocks.base.BlockFutopiaStair;
import net.thegaminghuskymc.futopia.block.idk.pipe.BlockPipeBasic;
import net.thegaminghuskymc.futopia.block.idk.pipe.BlockPipeFluid;
import net.thegaminghuskymc.futopia.block.machine.*;
import net.thegaminghuskymc.futopia.block.normal.BlockConcrete;
import net.thegaminghuskymc.futopia.block.worldgen.BlockAsphalt;
import net.thegaminghuskymc.futopia.block.worldgen.BlockBaseOre;
import net.thegaminghuskymc.futopia.block.worldgen.BlockBaseStorage;
import net.thegaminghuskymc.futopia.reference.Refs;
import net.thegaminghuskymc.futopia.tile.tier1.TileAlloyFurnace;
import net.thegaminghuskymc.futopia.tile.tier1.TileProjectTable;
import net.thegaminghuskymc.futopia.tile.tier3.TileKinectGenerator;

@GameRegistry.ObjectHolder(Refs.MODID)
public class FTBlocks {

    public static BlockAlloyFurnace alloyfurnace;

    public static BlockProjectTable projectTable;
    public static BlockElectricalFurnace electricalfurnace;

    public static BlockParticleBlock particle_block;
    public static BlockConcrete concrete;

    public static BlockAsphalt asphalt;

    public static BlockBaseOre ores;
    public static BlockBaseStorage storage;

    public static BlockPipeBasic basic;
    public static BlockPipeFluid fluid;

    public static BlockFutopiaStair subStairBlock;

    public static BlockEngine engine;


    public static void init() {
        instantiateBlocks();
        registerTE();
    }

    private static void instantiateBlocks() {

        if (Loader.isModLoaded("ninetaillib")) {

        }

        projectTable = new BlockProjectTable();
        alloyfurnace = new BlockAlloyFurnace();

        electricalfurnace = new BlockElectricalFurnace();
        particle_block = new BlockParticleBlock();
        concrete = new BlockConcrete();

        ores = new BlockBaseOre();
        storage = new BlockBaseStorage();

        asphalt = new BlockAsphalt();

        //TODO Fix these stair things
        /*subStairBlock = new BlockFutopiaStair("marble_stair", TFBlocks.marble.getDefaultState());
        subStairBlock.registerModels();*/
    }

    private static void registerTE() {
        GameRegistry.registerTileEntity(TileAlloyFurnace.class, "tile_alloy_furnace");
        GameRegistry.registerTileEntity(TileProjectTable.class, "tile_project_table");
        GameRegistry.registerTileEntity(TileKinectGenerator.class, "tile_kinetic_generator");
    }

}