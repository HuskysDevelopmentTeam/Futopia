package net.thegaminghuskymc.futopia.blocks.normal;

import me.modmuss50.jsonDestroyer.api.ITexturedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class TestBlock extends Block implements ITexturedBlock{

	public TestBlock() {
		super(Material.ROCK);
		setUnlocalizedName("test_block");
		setRegistryName("test_block");
		setCreativeTab(FTCreativeTabs.main);
	}

	@Override
	public String getTextureNameFromState(IBlockState state, EnumFacing side) {
		return "futopia:blocks/basalt_brick";
	}

	@Override
	public int amountOfStates() {
		return 1;
	}

}
