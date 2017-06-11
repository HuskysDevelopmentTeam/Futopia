package net.thegaminghuskymc.futopia.blocks.machine;

import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.tiles.TilePlatePresser;

/**
 * Created by TheGamingHuskyMC on 01.05.2017.
 */
public class BlockPlatePresser extends BlockMachineBase<TilePlatePresser> {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockPlatePresser() {
        super("plate_presser");
    }

    /*@Override
    public TilePlatePresser createNewTileEntity(World world, int meta) {
        return new TilePlatePresser();
    }*/

    /*@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!player.isSneaking()) {
            player.openGui(Futopia.instance, GUIHandler.PLATE_PRESSER, world, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }

        return false;
    }*/

    @Override
    public void registerIcons(IIconRegister registrar) {
        this.texture = new TextureAtlasSprite[3];
        this.texture[0] = registrar.registerIcon(Refs.MODID + ":blocks/machines/electrical_furnace/electrical_furnace_side");
        this.texture[1] = registrar.registerIcon(Refs.MODID + ":blocks/machines/electrical_furnace/electrical_furnace_off");
        this.texture[2] = registrar.registerIcon(Refs.MODID + ":blocks/machines/electrical_furnace/electrical_furnace_on");
    }

    @Override
    public TextureAtlasSprite getIcon(int meta, int side) {
        switch (side) {
            case 0:
                return this.texture[0];
            case 1:
                return this.texture[0];
            case 2:
                return this.texture[1];
            case 3:
                return this.texture[0];
            case 4:
                return this.texture[0];
            case 5:
                return this.texture[0];
        }

        return null;
    }
}
