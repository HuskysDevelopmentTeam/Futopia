package net.thegaminghuskymc.futopia.blocks.computer;

import java.util.Random;

import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.BlockContainerBase;
import net.thegaminghuskymc.futopia.tiles.TileCPU;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockCPU extends BlockContainerBase {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockCPU() {
        super(Material.IRON, TileCPU.class);
        setUnlocalizedName(BlockNames.BLOCKCPU_NAME);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if (tileEntity instanceof TileCPU) {

        }
    }

    @Override
    public int tickRate(World world) {
        return 1;
    }

    @Override
    public TileCPU createNewTileEntity(World world, int meta) {
        return new TileCPU();
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registrar) {
        this.texture = new TextureAtlasSprite[5];
        this.texture[0] = registrar.registerIcon(Refs.MODID + ":blocks/machines/cpu_front");
        this.texture[1] = registrar.registerIcon(Refs.MODID + ":blocks/machines/cpu_side");
        this.texture[2] = registrar.registerIcon(Refs.MODID + ":blocks/machines/cpu_top");
        this.texture[3] = registrar.registerIcon(Refs.MODID + ":blocks/machines/cpu_back");
        this.texture[4] = registrar.registerIcon(Refs.MODID + ":blocks/machines/cpu_bottom");
    }

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
