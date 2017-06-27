package net.thegaminghuskymc.futopia.blocks.machine;

import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.client.gui.GuiHandler;
import net.thegaminghuskymc.futopia.tiles.TileElectricalFurnace;
import net.thegaminghuskymc.futopia.tiles.TileEntityFurnace;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockElectricalFurnace extends BlockMachineBase<TileEntityFurnace>{

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockElectricalFurnace() {
        super(BlockNames.ELECTRICALFURNACE_NAME);
    }

    @Override
    public TileEntityFurnace createNewTileEntity(World world, int meta) {
        return new TileEntityFurnace();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registrar) {
        this.texture = new TextureAtlasSprite[3];
        this.texture[0] = registrar.registerIcon(Refs.MODID + ":blocks/machines/electrical_furnace/electrical_furnace_side");
        this.texture[1] = registrar.registerIcon(Refs.MODID + ":blocks/machines/electrical_furnace/electrical_furnace_front_off");
        this.texture[2] = registrar.registerIcon(Refs.MODID + ":blocks/machines/electrical_furnace/electrical_furnace_front_on");
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
    		EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	
    	if(!playerIn.isSneaking()){
    		playerIn.openGui(Futopia.INSTANCE, GuiHandler.ELECTRICAL_FURNACE, worldIn, pos.getX(), pos.getY(), pos.getZ());
    		return true;
    	}
    	
    	return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
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