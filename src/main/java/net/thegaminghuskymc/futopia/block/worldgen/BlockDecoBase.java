package net.thegaminghuskymc.futopia.block.worldgen;

import keri.ninetaillib.block.BlockBase;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.reference.Refs;

public class BlockDecoBase extends BlockBase {

    public BlockDecoBase(String modid, String blockName, Material material) {
        super(Refs.MODID, blockName, Material.ROCK);
    }

    @Override
    public IRenderingRegistry getRenderingRegistry() {
        return Futopia.proxy.getRenderingRegistry();
    }

}
