package net.thegaminghuskymc.futopia.loaders;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.block.machine.BlockCompressor;
import net.thegaminghuskymc.futopia.block.machine.BlockEngine;
import net.thegaminghuskymc.futopia.block.machine.BlockPlatingPress;
import net.thegaminghuskymc.futopia.block.machine.BlockRefinery;
import net.thegaminghuskymc.futopia.reference.Refs;

@GameRegistry.ObjectHolder(Refs.MODID)
public class BlockLoader {

    public static BlockEngine engine;
    public static BlockRefinery refinery;
    public static BlockPlatingPress platingPress;
    public static BlockCompressor compressor;

    public static void loadBlocks() {
        engine = new BlockEngine();
        refinery = new BlockRefinery();
        platingPress = new BlockPlatingPress();
        compressor = new BlockCompressor();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        engine.initModel();
        refinery.initModel();
        platingPress.initModel();
        compressor.initModel();
    }
}
