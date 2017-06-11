package net.thegaminghuskymc.futopia.blocks.computer;

import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.machine.BlockMachineBase;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockMonitor extends BlockMachineBase {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockMonitor() {
        super(BlockNames.BLOCKMONITOR_NAME);
        setLightLevel(100F);
    }

    @Override
    public int tickRate(World world) {

        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registrar) {
        this.texture = new TextureAtlasSprite[5];
        this.texture[0] = registrar.registerIcon(Refs.MODID + ":blocks/machines/monitor/monitor_front2");
        this.texture[1] = registrar.registerIcon(Refs.MODID + ":blocks/machines/monitor/monitor_side");
        this.texture[2] = registrar.registerIcon(Refs.MODID + ":blocks/machines/monitor/monitor_top");
        this.texture[3] = registrar.registerIcon(Refs.MODID + ":blocks/machines/monitor/monitor_back");
        this.texture[4] = registrar.registerIcon(Refs.MODID + ":blocks/machines/monitor/monitor_bottom");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        switch (side) {
            case 0:
                return this.texture[4];
            case 1:
                return this.texture[2];
            case 2:
                return this.texture[0];
            case 3:
                return this.texture[3];
            case 4:
                return this.texture[1];
            case 5:
                return this.texture[1];
        }

        return null;
    }

}
