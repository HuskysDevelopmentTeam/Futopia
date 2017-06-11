package net.thegaminghuskymc.futopia.blocks.machine;

import keri.ninetaillib.lib.block.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockMachineBase<T extends TileEntity> extends BlockBase<T> {

    public BlockMachineBase(String blockName) {
        super(blockName, Material.IRON);
        setCreativeTab(FTCreativeTabs.main);
        setSoundType(SoundType.METAL);
    }

}