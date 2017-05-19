package net.thegaminghuskymc.futopia.block.machine;

import codechicken.lib.model.blockbakery.BlockBakery;
import codechicken.lib.model.blockbakery.IBakeryBlock;
import codechicken.lib.model.blockbakery.IBlockStateKeyGenerator;
import codechicken.lib.model.blockbakery.ICustomBlockBakery;
import cofh.core.block.IFogOverlay;
import cofh.lib.util.helpers.StringHelper;
import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.block.BlockMachineBase;
import net.thegaminghuskymc.futopia.reference.Refs;

import java.util.LinkedList;
import java.util.List;

public class BlockProjectTable extends BlockMachineBase implements IBakeryBlock, IBlockStateKeyGenerator, IFogOverlay {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockProjectTable() {
        super(Refs.PROJECT_TABLENAME);
    }

    @Override
    public Vec3d getFog(IBlockState state, Entity renderViewEntity, float fogColorRed, float fogColorGreen, float fogColorBlue) {
        return null;
    }

    @Override
    @SideOnly (Side.CLIENT)
    public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
        return BlockBakery.handleExtendedState((IExtendedBlockState) super.getExtendedState(state, world, pos), world.getTileEntity(pos));
    }

    @Override
    public String generateKey(IExtendedBlockState state) {
        return null;
    }

    @Override
    public ICustomBlockBakery getCustomBakery() {
        return new ICustomBlockBakery() {

            @Override
            public IExtendedBlockState handleState(IExtendedBlockState state, TileEntity tileEntity) {
                return state;
            }

            @Override
            public List<BakedQuad> bakeItemQuads(EnumFacing face, ItemStack stack) {
                List<BakedQuad> quads = new LinkedList<>();
                return quads;
            }

        };
    }

    @Override
    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add("Hold " + StringHelper.getDeactivationText("Shift") + StringHelper.getFlavorText(" for information."));
        } else {
            tooltip.add(StringHelper.getInfoText("This block is used to craft special blocks"));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegistrar registrar) {
        this.texture = new TextureAtlasSprite[4];
        this.texture[0] = registrar.registerIcon(Refs.MODID + ":blocks/machines/project_table/project_table_top");
        this.texture[1] = registrar.registerIcon(Refs.MODID + ":blocks/machines/project_table/project_table_side");
        this.texture[2] = registrar.registerIcon(Refs.MODID + ":blocks/machines/project_table/project_table_side_2");
        this.texture[3] = registrar.registerIcon(Refs.MODID + ":blocks/machines/project_table/project_table_bottom");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        switch (side) {
            case 0:
                return this.texture[3];
            case 1:
                return this.texture[0];
            case 2:
                return this.texture[1];
            case 3:
                return this.texture[1];
            case 4:
                return this.texture[2];
            case 5:
                return this.texture[2];
        }

        return null;
    }

}
