package net.thegaminghuskymc.futopia.init;

import cofh.lib.util.helpers.ItemHelper;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.IntStream;

public class FutopiaOreDictionary {

    public static void init() {
        IntStream.range(0, 8).forEach(meta -> ItemHelper.registerWithHandlers("oreFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTBlocks.ores, 1, meta)));
        IntStream.range(0, 8).forEach(meta -> ItemHelper.registerWithHandlers("blockFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTBlocks.storage, 1, meta)));

        IntStream.range(0, 8).forEach(meta -> ItemHelper.registerWithHandlers("gearFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTItems.gears, 1, meta)));
        IntStream.range(0, 8).forEach(meta -> ItemHelper.registerWithHandlers("alloyFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTItems.ingots, 1, meta)));
        IntStream.range(0, 8).forEach(meta -> ItemHelper.registerWithHandlers("nuggetFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTItems.nuggets, 1, meta)));
        IntStream.range(0, 8).forEach(meta -> ItemHelper.registerWithHandlers("dustFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTItems.dusts, 1, meta)));
        IntStream.range(0, 8).forEach(meta -> ItemHelper.registerWithHandlers("shardFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTItems.shards, 1, meta)));
        IntStream.range(0, 8).forEach(meta -> ItemHelper.registerWithHandlers("plateFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTItems.plates, 1, meta)));
    }

}
