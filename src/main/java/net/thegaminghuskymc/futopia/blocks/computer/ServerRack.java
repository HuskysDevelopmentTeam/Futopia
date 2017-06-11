package net.thegaminghuskymc.futopia.blocks.computer;

import keri.ninetaillib.lib.block.BlockBase;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class ServerRack extends BlockBase {

    public ServerRack() {
        super("server_rack", Material.IRON);
        this.setCreativeTab(FTCreativeTabs.main);
    }

}