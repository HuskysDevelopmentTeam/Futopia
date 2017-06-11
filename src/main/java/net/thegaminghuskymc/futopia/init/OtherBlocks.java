package net.thegaminghuskymc.futopia.init;

import java.util.ArrayList;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.IInitializer;
import net.thegaminghuskymc.futopia.blocks.normal.BlockClearGlass;
import net.thegaminghuskymc.futopia.blocks.normal.BlockCrackedGlass;
import net.thegaminghuskymc.futopia.blocks.normal.BlockDirtyGlass;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBasalt;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockLimestone;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockMarble;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockMeteor;

@GameRegistry.ObjectHolder(Refs.MODID)
public class OtherBlocks {

    /* REFERENCES */
    public static BlockMarble marble;
    public static BlockBasalt basalt;
    public static BlockMeteor meteor;
    public static BlockLimestone limestone;
    public static BlockClearGlass clearGlass;
    public static BlockDirtyGlass dirtyGlass;
    public static BlockCrackedGlass crackedGlass;
    private static ArrayList<IInitializer> initList = new ArrayList<>();

    public static void preInit() {

        limestone = new BlockLimestone();
        basalt = new BlockBasalt();
        meteor = new BlockMeteor();
        marble = new BlockMarble();
        clearGlass = new BlockClearGlass();
//        crackedGlass = new BlockCrackedGlass();
//        dirtyGlass = new BlockDirtyGlass();

        initList.add(limestone);
        initList.add(basalt);
        initList.add(meteor);
        initList.add(marble);
        initList.add(clearGlass);
//        initList.add(crackedGlass);
//        initList.add(dirtyGlass);

        Futopia.PROXY.addIModelRegister(limestone);
        Futopia.PROXY.addIModelRegister(marble);
        Futopia.PROXY.addIModelRegister(basalt);
        Futopia.PROXY.addIModelRegister(meteor);
        Futopia.PROXY.addIModelRegister(clearGlass);
//        Futopia.proxy.addIModelRegister(crackedGlass);
//        Futopia.proxy.addIModelRegister(dirtyGlass);

        for (IInitializer init : initList) {
            init.preInit();
        }
    }

    public static void initialize() {

        for (IInitializer init : initList) {
            init.initialize();
        }
    }

    public static void postInit() {

        for (IInitializer init : initList) {
            init.postInit();
        }
        initList.clear();
    }
}
