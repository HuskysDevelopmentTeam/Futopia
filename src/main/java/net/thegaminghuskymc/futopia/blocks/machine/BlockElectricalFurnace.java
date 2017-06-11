package net.thegaminghuskymc.futopia.blocks.machine;

import codechicken.lib.model.bakery.ModelBakery;
import codechicken.lib.model.bakery.key.IBlockStateKeyGenerator;
import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTBlocks;
import net.thegaminghuskymc.futopia.tiles.TileElectricalFurnace;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockElectricalFurnace extends BlockMachineBase<TileElectricalFurnace>{

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockElectricalFurnace() {
        super(BlockNames.ELECTRICALFURNACE_NAME);
    }

    @Override
    public TileElectricalFurnace createNewTileEntity(World world, int meta) {
        return new TileElectricalFurnace();
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

	/*@Override
	public String generateKey(IExtendedBlockState state) {
		ModelBakery.registerBlockKeyGenerator(FTBlocks.electricalfurnace, state -> {

		    StringBuilder builder = new StringBuilder(ModelBakery.defaultBlockKeyGenerator.generateKey(state));
		    builder.append(",facing=").append(state.getValue(BlockProperties.FACING));
		    builder.append(",active=").append(state.getValue(BlockProperties.ACTIVE));
		    return builder.toString();
		});
		
		return state.toString();
	}*/

}