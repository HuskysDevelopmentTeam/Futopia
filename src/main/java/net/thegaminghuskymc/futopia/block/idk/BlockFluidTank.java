package net.thegaminghuskymc.futopia.block.idk;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidTankProperties;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.block.BlockFutopia;
import net.thegaminghuskymc.futopia.tile.tier1.TileEntityFluidTank;

import java.util.ArrayList;
import java.util.List;

public class BlockFluidTank extends BlockFutopia<TileEntityFluidTank> {
    public BlockFluidTank() {
        super("fluid_tank", Material.GLASS);
        setSoundType(SoundType.GLASS);
    }

    public static List<ITextComponent> getFluidDataForDisplay(IFluidTankProperties[] fluidTankProperties) {
        final List<ITextComponent> data = new ArrayList<>();

        boolean hasFluid = false;

        for (final IFluidTankProperties properties : fluidTankProperties) {
            final FluidStack fluidStack = properties.getContents();

            if (fluidStack != null && fluidStack.amount > 0) {
                hasFluid = true;
                data.add(new TextComponentTranslation("tile.futopia:fluid_tank.fluid.desc", fluidStack.getLocalizedName(), fluidStack.amount, properties.getCapacity()));
            }
        }

        if (!hasFluid) {
            data.add(new TextComponentTranslation("tile.futopia:fluid_tank.empty.desc"));
        }

        return data;
    }

    @Override
    public TileEntityFluidTank createNewTileEntity(World world, int meta) {
        return new TileEntityFluidTank();
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isFullyOpaque(IBlockState state) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
}
