package net.thegaminghuskymc.futopia.block;

import keri.ninetaillib.block.BlockBase;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.reference.Refs;

public class BlockMachineBase<T extends TileEntity> extends BlockBase<T> {

    public BlockMachineBase(String blockName) {
        super(Refs.MODID, blockName, Material.ROCK);
        setCreativeTab(FTCreativeTabs.machines);
        setSoundType(SoundType.METAL);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public CreativeTabs getCreativeTab() {
        return FTCreativeTabs.machines;
    }

    @Override
    public IRenderingRegistry getRenderingRegistry() {
        return Futopia.proxy.getRenderingRegistry();
    }

}