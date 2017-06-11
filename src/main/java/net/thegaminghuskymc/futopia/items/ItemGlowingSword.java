package net.thegaminghuskymc.futopia.items;

import com.teamwizardry.librarianlib.features.base.item.IGlowingItem;
import com.teamwizardry.librarianlib.features.base.item.ItemModSword;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.Refs;

public class ItemGlowingSword extends ItemModSword implements IGlowingItem{

	public ItemGlowingSword(String name, ToolMaterial material) {
		super(name, material);
		setUnlocalizedName(name);
		setRegistryName(Refs.MODID + ":" + name);
	}

	@Override
	public int packedGlowCoords(ItemStack arg0, IBakedModel arg1) {
		return 0xf000f0;
	}

	@Override
	public boolean shouldDisableLightingForGlow(ItemStack arg0, IBakedModel arg1) {
		return true;
	}

	@Override
	public IBakedModel transformToGlow(ItemStack stack, IBakedModel iBakedModel) {
		return IGlowingItem.Helper.wrapperBake(iBakedModel, false, 1);
	}

}
