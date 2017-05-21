package net.thegaminghuskymc.futopia.block.machine;

import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.block.BlockMachineBase;
import net.thegaminghuskymc.futopia.reference.Refs;

public class BlockKineticGenerator extends BlockMachineBase {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockKineticGenerator() {
        super(Refs.KINETICGENERATOR_NAME);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegistrar registrar) {
        this.texture = new TextureAtlasSprite[6];
        this.texture[0] = registrar.registerIcon(Refs.MODID + ":blocks/machines/kinetic_generator/kinetic_generator_front");
        this.texture[1] = registrar.registerIcon(Refs.MODID + ":blocks/machines/kinetic_generator/kinetic_generator_vent_1");
        this.texture[2] = registrar.registerIcon(Refs.MODID + ":blocks/machines/kinetic_generator/cpu_top");
        this.texture[3] = registrar.registerIcon(Refs.MODID + ":blocks/machines/kinetic_generator/kinetic_generator_back");
        this.texture[4] = registrar.registerIcon(Refs.MODID + ":blocks/machines/kinetic_generator/cpu_bottom");
        this.texture[5] = registrar.registerIcon(Refs.MODID + ":blocks/machines/kinetic_generator/kinetic_generator_vent");
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
