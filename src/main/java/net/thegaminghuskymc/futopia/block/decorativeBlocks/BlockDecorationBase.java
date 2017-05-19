package net.thegaminghuskymc.futopia.block.decorativeBlocks;

import keri.ninetaillib.block.BlockBase;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.reference.Refs;

public class BlockDecorationBase extends BlockBase {

    public BlockDecorationBase(String blockName) {
        super(Refs.MODID, blockName, Material.IRON);
        setCreativeTab(FTCreativeTabs.decoration);
        setSoundType(SoundType.METAL);
    }

    @Override
    public IRenderingRegistry getRenderingRegistry() {
        return Futopia.proxy.getRenderingRegistry();
    }

}