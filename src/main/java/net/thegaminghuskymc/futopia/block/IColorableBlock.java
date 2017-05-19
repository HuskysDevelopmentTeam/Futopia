package net.thegaminghuskymc.futopia.block;

import codechicken.lib.colour.ColourRGBA;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public interface IColorableBlock {

    ColourRGBA getBlockColor(@Nonnull ItemStack stack);

    ItemStack setBlockColor(@Nonnull ItemStack stack, @Nonnull ColourRGBA color);

}