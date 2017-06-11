package net.thegaminghuskymc.futopia.init;

import keri.ninetaillib.lib.mod.ContentLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.machine.BlockCompressor;
import net.thegaminghuskymc.futopia.blocks.machine.BlockEngine;
import net.thegaminghuskymc.futopia.blocks.machine.BlockPlatingPress;
import net.thegaminghuskymc.futopia.blocks.machine.BlockRefinery;

@ContentLoader(modid = Refs.MODID)
public class BlockLoader {

    public static BlockEngine engine = new BlockEngine();
    public static BlockRefinery refinery = new BlockRefinery();
    public static BlockPlatingPress platingPress = new BlockPlatingPress();
    public static BlockCompressor compressor = new BlockCompressor();

    static {
        engine.initModel();
        refinery.initModel();
        platingPress.initModel();
        compressor.initModel();
    }
    
}
