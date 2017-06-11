package net.thegaminghuskymc.futopia.init;

import cofh.core.util.core.IInitializer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.block.TestBlock;
import net.thegaminghuskymc.futopia.block.normal.BlockClearGlass;
import net.thegaminghuskymc.futopia.block.normal.BlockCrackedGlass;
import net.thegaminghuskymc.futopia.block.normal.BlockDirtyGlass;
import net.thegaminghuskymc.futopia.block.worldgen.*;
import net.thegaminghuskymc.futopia.reference.Refs;

import java.util.ArrayList;

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
    public static TestBlock test_block;
    private static ArrayList<IInitializer> initList = new ArrayList<>();

    public static void preInit() {

        limestone = new BlockLimestone();
        basalt = new BlockBasalt();
        meteor = new BlockMeteor();
        marble = new BlockMarble();
        clearGlass = new BlockClearGlass();
        test_block = new TestBlock();
//        crackedGlass = new BlockCrackedGlass();
//        dirtyGlass = new BlockDirtyGlass();

        initList.add(limestone);
        initList.add(basalt);
        initList.add(meteor);
        initList.add(marble);
        initList.add(clearGlass);
        initList.add(test_block);
//        initList.add(crackedGlass);
//        initList.add(dirtyGlass);

        Futopia.proxy.addIModelRegister(limestone);
        Futopia.proxy.addIModelRegister(marble);
        Futopia.proxy.addIModelRegister(basalt);
        Futopia.proxy.addIModelRegister(meteor);
        Futopia.proxy.addIModelRegister(clearGlass);
        Futopia.proxy.addIModelRegister(test_block);
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
