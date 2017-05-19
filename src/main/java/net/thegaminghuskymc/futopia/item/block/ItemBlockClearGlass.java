package net.thegaminghuskymc.futopia.item.block;

import cofh.core.block.ItemBlockCore;
import cofh.lib.util.helpers.ItemHelper;
import cofh.thermalfoundation.block.BlockGlass;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.network.ClearGlassType;

public class ItemBlockClearGlass extends ItemBlockCore {

	public ItemBlockClearGlass(Block block) {

		super(block);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {

		return "tile.clear_glass." + ClearGlassType.byMetadata(ItemHelper.getItemDamage(stack)).getName() + ".name";
	}

}
