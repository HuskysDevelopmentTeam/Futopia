package net.thegaminghuskymc.futopia.block.computer;

import keri.ninetaillib.block.BlockBase;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.reference.Refs;

public class ServerRack extends BlockBase {

    public ServerRack() {
        super(Refs.MODID, "server_rack", Material.IRON);
        this.setCreativeTab(FTCreativeTabs.blocks);
    }

    @Override
    public IRenderingRegistry getRenderingRegistry() {
        return Futopia.proxy.getRenderingRegistry();
    }

}