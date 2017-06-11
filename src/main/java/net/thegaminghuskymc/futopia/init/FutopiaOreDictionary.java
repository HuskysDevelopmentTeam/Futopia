package net.thegaminghuskymc.futopia.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.oredict.OreDictionary;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.utils.ItemHelper;

import org.apache.commons.lang3.StringUtils;

import keri.ninetaillib.lib.mod.ContentLoader;

import java.util.stream.IntStream;

@ContentLoader(modid = Refs.MODID)
public class FutopiaOreDictionary {

    public static void init() {
//        IntStream.range(0, 8).forEach(meta -> registerWithHandlers("oreFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTBlocks.ores, 1, meta)));
//        IntStream.range(0, 8).forEach(meta -> registerWithHandlers("blockFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTBlocks.storage, 1, meta)));

        IntStream.range(0, 8).forEach(meta -> registerWithHandlers("gearFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTItems.gears, 1, meta)));
        IntStream.range(0, 8).forEach(meta -> registerWithHandlers("alloyFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTItems.ingots, 1, meta)));
        IntStream.range(0, 8).forEach(meta -> registerWithHandlers("nuggetFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTItems.nuggets, 1, meta)));
        IntStream.range(0, 8).forEach(meta -> registerWithHandlers("dustFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTItems.dusts, 1, meta)));
        IntStream.range(0, 8).forEach(meta -> registerWithHandlers("shardFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTItems.shards, 1, meta)));
        IntStream.range(0, 8).forEach(meta -> registerWithHandlers("plateFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()), new ItemStack(FTItems.plates, 1, meta)));
    }
    
    private static void registerWithHandlers(String oreName, ItemStack stack)
    {
        OreDictionary.registerOre(oreName, stack);
        FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", stack);
    }

}
