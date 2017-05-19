package net.thegaminghuskymc.futopia.init;

import cofh.core.util.core.IInitializer;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.block.normal.BlockClearGlass;
import net.thegaminghuskymc.futopia.block.normal.BlockCrackedGlass;
import net.thegaminghuskymc.futopia.block.normal.BlockDirtyGlass;
import net.thegaminghuskymc.futopia.block.worldgen.BlockBasalt;
import net.thegaminghuskymc.futopia.block.worldgen.BlockLimestone;
import net.thegaminghuskymc.futopia.block.worldgen.BlockMarble;
import net.thegaminghuskymc.futopia.block.worldgen.BlockMeteor;
import slimeknights.tconstruct.common.TinkerOredict;

import java.util.ArrayList;

public class TFBlocks {

    public static void preInit() {

        limestone = new BlockLimestone();
        basalt = new BlockBasalt();
        meteor = new BlockMeteor();
        marble = new BlockMarble();
        clearGlass = new BlockClearGlass();
        crackedGlass = new BlockCrackedGlass();
        dirtyGlass = new BlockDirtyGlass();

        initList.add(limestone);
        initList.add(basalt);
        initList.add(meteor);
        initList.add(marble);
        initList.add(clearGlass);
        initList.add(crackedGlass);
        initList.add(dirtyGlass);

        Futopia.proxy.addIModelRegister(limestone);
        Futopia.proxy.addIModelRegister(marble);
        Futopia.proxy.addIModelRegister(basalt);
        Futopia.proxy.addIModelRegister(meteor);
        Futopia.proxy.addIModelRegister(clearGlass);
        Futopia.proxy.addIModelRegister(crackedGlass);
        Futopia.proxy.addIModelRegister(dirtyGlass);

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

    /* REFERENCES */
    public static BlockMarble marble;
    public static BlockBasalt basalt;
    public static BlockMeteor meteor;
    public static BlockLimestone limestone;
    public static BlockClearGlass clearGlass;
    public static BlockDirtyGlass dirtyGlass;
    public static BlockCrackedGlass crackedGlass;
    private static ArrayList<IInitializer> initList = new ArrayList<>();
}
