package net.thegaminghuskymc.futopia.blocks.normal;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import codechicken.lib.math.MathHelper;
import codechicken.lib.raytracer.IndexedCuboid6;
import codechicken.lib.raytracer.RayTracer;
import codechicken.lib.util.CommonUtils;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Rotation;
import codechicken.lib.vec.Vector3;
import keri.ninetaillib.lib.block.BlockBase;
import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockPowerCable extends BlockBase {

    public static Cuboid6[] BLOCK_BOUNDS = new Cuboid6[]{
            new Cuboid6(5D, 5D, 0D, 11D, 11D, 16D), //bottom_west
            new Cuboid6(5D, 5D, 0D, 11D, 11D, 16D) //corner_nw
//          new Cuboid6(15.49999999254942D, 0.5000000074505806D, 5D, 15.999999985098839D, 5.500000007450581D, 5.499999992549419D) //corver_ne
//  		new Cuboid6(0D, 0D, 5D, 0.4999999925494194D, 0.4999999925494194D, 11D), //bottom_west
//          new Cuboid6(0D, 0.5000000074505806D, 5D, 0.4999999925494194D, 5.500000007450581D, 5.499999992549419D), //corner_nw
//          new Cuboid6(0, 5.499999977648258D, 5D, 0.4999999776482582D, 5.999999970197678D, 11D), //top_west
//          new Cuboid6(0D, 0.5000000074505806D, 10.50000000745058D, 0.4999999925494194D, 5.500000007450581D, 11D), //corver_sw
//          new Cuboid6(0.5000000074505806D, 5.499999977648258D, 5D, 15.50000000745058D, 5.999999970197678D, 5.499999992549419D), //long_side_top_north
//          new Cuboid6(15.49999999254942D, 5.499999977648258D, 5D, 15.999999970197678D, 5.999999970197678D, 11D), //top_east
//          new Cuboid6(0.5000000074505806D, -2.9802322387695312E-8D, 5D, 15.50000000745058D, 0.499999962747097D, 5.499999992549419D), //long_side_bottom_north
//          new Cuboid6(0.5000000074505806D, -2.9802322387695312E-8D, 10.49999999254942D, 15.50000000745058D, 0.499999962747097D, 10.999999985098839D), //long_side_bottom_south
//          new Cuboid6(0.5000000074505806D, -2.9802322387695312E-8D, 10.49999999254942D, 15.50000000745058D, 0.499999962747097D, 10.999999985098839D), //long_side_top_south
//          new Cuboid6(15.49999999254942D, -1.4901161193847656E-8D, 5D, 15.999999970197678D, 0.4999999776482582D, 11D), //bottom_east
//          new Cuboid6(15.49999999254942D, 0.5000000074505806D, 10.50000000745058D, 15.999999985098839D, 5.500000007450581D, 11D), //corner_ew
//          new Cuboid6(15.49999999254942D, 0.5000000074505806D, 5D, 15.999999985098839D, 5.500000007450581D, 5.499999992549419D) //corver_ne
    };
    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite texture;

    public BlockPowerCable() {
        super("power_cable", Material.IRON);
        setCreativeTab(FTCreativeTabs.main);
    }

    /*@Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        TilePowerCable tile = (TilePowerCable) world.getTileEntity(pos);
        int orientation = MathHelper.floor(placer.rotationYaw * 4D / 360D + 0.5D) & 3;

        if (tile != null) {
            tile.setOrientation(EnumFacing.getHorizontal(orientation));
        }
    }

    @Nullable
    @Override
    @SuppressWarnings("deprecation")
    public RayTraceResult collisionRayTrace(IBlockState state, World world, BlockPos pos, Vec3d start, Vec3d end) {
        TilePowerCable tile = (TilePowerCable) world.getTileEntity(pos);

        if (tile != null) {
            List<IndexedCuboid6> cuboids = Lists.newArrayList();
            Vector3 axis = new Vector3(0D, 1D, 0D);
            double angle = 0D;

            switch (tile.getOrientation()) {
                case NORTH:
                    angle = 0D;
                    break;
                case EAST:
                    angle = 270D;
                    break;
                case SOUTH:
                    angle = 180D;
                    break;
                case WEST:
                    angle = 90D;
                    break;
                default:
                    break;
            }

            for (int index = 0; index < BLOCK_BOUNDS.length; index++) {
                Cuboid6 cuboid = CommonUtils.devide(BLOCK_BOUNDS[index], 16D).apply(new Rotation(angle * MathHelper.torad, axis).at(Vector3.center));
                cuboids.add(new IndexedCuboid6(index, cuboid));
            }

            return RayTracer.rayTraceCuboidsClosest(start, end, cuboids, pos);
        }

        return super.collisionRayTrace(state, world, pos, start, end);
    }

    @Override
    public TilePowerCable createNewTileEntity(World world, int meta) {
        return new TilePowerCable();
    }*/

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
        return layer == BlockRenderLayer.SOLID || layer == BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registrar) {
        this.texture = registrar.registerIcon(Refs.MODID + ":blocks/black");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        return this.texture;
    }

}
