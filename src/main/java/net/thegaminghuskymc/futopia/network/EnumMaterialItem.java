package net.thegaminghuskymc.futopia.network;

import com.google.common.collect.ImmutableList;

public enum EnumMaterialItem {
    INGOT("ingot_other", ImmutableList.of(
            EnumMaterial.COPPER,
            EnumMaterial.TIN,
            EnumMaterial.BRONZE,
            EnumMaterial.ELECTRUM,
            EnumMaterial.INVAR,
            EnumMaterial.NICKEL,
            EnumMaterial.ZINC,
            EnumMaterial.BRASS,
            EnumMaterial.SILVER,
            EnumMaterial.STEEL,
            EnumMaterial.LEAD,
            EnumMaterial.PLATINUM,
            EnumMaterial.CUPRONICKEL,
            EnumMaterial.SIGNALUM,
            EnumMaterial.LUMIUM,
            EnumMaterial.ENDERIUM,
            EnumMaterial.ALUMINA,
            EnumMaterial.ALUMINIUM,
            EnumMaterial.CHROMIUM,
            EnumMaterial.ENDER,
            EnumMaterial.GRAVITITE),
            //Deprecated
            ImmutableList.of(EnumMaterial.ALUMINA)),

    DUST("dust_other", ImmutableList.of(
            EnumMaterial.COAL,
            EnumMaterial.IRON,
            EnumMaterial.GOLD,
            EnumMaterial.COPPER,
            EnumMaterial.TIN,
            EnumMaterial.BRONZE,
            EnumMaterial.ELECTRUM,
            EnumMaterial.INVAR,
            EnumMaterial.NICKEL,
            EnumMaterial.ZINC,
            EnumMaterial.BRASS,
            EnumMaterial.SILVER,
            EnumMaterial.STEEL,
            EnumMaterial.LEAD,
            EnumMaterial.PLATINUM,
            EnumMaterial.CUPRONICKEL,
            EnumMaterial.ENDERPEARL,
            EnumMaterial.SIGNALUM,
            EnumMaterial.LUMIUM,
            EnumMaterial.ENDERIUM,
            EnumMaterial.CHARCOAL,
            EnumMaterial.OBSIDIAN,
            EnumMaterial.SULFUR,
            EnumMaterial.NITER,
            EnumMaterial.ALUMINA,
            EnumMaterial.ALUMINIUM,
            EnumMaterial.CHROMIUM,
            EnumMaterial.ENDER,
            EnumMaterial.GRAVITITE)),

    NUGGET("nugget_other", ImmutableList.of(
            EnumMaterial.IRON,
            EnumMaterial.COPPER,
            EnumMaterial.TIN,
            EnumMaterial.BRONZE,
            EnumMaterial.ELECTRUM,
            EnumMaterial.INVAR,
            EnumMaterial.NICKEL,
            EnumMaterial.ZINC,
            EnumMaterial.BRASS,
            EnumMaterial.SILVER,
            EnumMaterial.STEEL,
            EnumMaterial.LEAD,
            EnumMaterial.PLATINUM,
            EnumMaterial.CUPRONICKEL,
            EnumMaterial.SIGNALUM,
            EnumMaterial.LUMIUM,
            EnumMaterial.ENDERIUM,
            EnumMaterial.ALUMINA,
            EnumMaterial.ALUMINIUM,
            EnumMaterial.CHROMIUM,
            EnumMaterial.ENDER,
            EnumMaterial.GRAVITITE),
            //Deprecated
            ImmutableList.of(EnumMaterial.ALUMINA)),

    //1 gear = 4 ingots
    GEAR("gear_other", ImmutableList.of(
            EnumMaterial.STONE,
            EnumMaterial.IRON,
            EnumMaterial.GOLD,
            EnumMaterial.COPPER,
            EnumMaterial.TIN,
            EnumMaterial.BRONZE,
            EnumMaterial.ELECTRUM,
            EnumMaterial.INVAR,
            EnumMaterial.NICKEL,
            EnumMaterial.ZINC,
            EnumMaterial.BRASS,
            EnumMaterial.SILVER,
            EnumMaterial.STEEL,
            EnumMaterial.LEAD,
            EnumMaterial.PLATINUM,
            EnumMaterial.CUPRONICKEL,
            EnumMaterial.SIGNALUM,
            EnumMaterial.LUMIUM,
            EnumMaterial.ENDERIUM,
            EnumMaterial.ALUMINIUM,
            EnumMaterial.CHROMIUM,
            EnumMaterial.ENDER,
            EnumMaterial.GRAVITITE)),

    //1 plate = 1 ingot
    PLATE("plate_other", ImmutableList.of(
            EnumMaterial.IRON,
            EnumMaterial.GOLD,
            EnumMaterial.COPPER,
            EnumMaterial.TIN,
            EnumMaterial.BRONZE,
            EnumMaterial.ELECTRUM,
            EnumMaterial.INVAR,
            EnumMaterial.NICKEL,
            EnumMaterial.ZINC,
            EnumMaterial.BRASS,
            EnumMaterial.SILVER,
            EnumMaterial.STEEL,
            EnumMaterial.LEAD,
            EnumMaterial.PLATINUM,
            EnumMaterial.CUPRONICKEL,
            EnumMaterial.SIGNALUM,
            EnumMaterial.LUMIUM,
            EnumMaterial.ENDERIUM,
            EnumMaterial.ALUMINIUM,
            EnumMaterial.CHROMIUM,
            EnumMaterial.ENDER,
            EnumMaterial.GRAVITITE)),

    BOTTLE_DUST("bottleDust", ImmutableList.of(
            EnumMaterial.REDSTONE,
            EnumMaterial.GLOWSTONE,
            EnumMaterial.ENDERPEARL)),

    BUCKET_LIQUID("bucketLiquid", ImmutableList.of(
            EnumMaterial.REDSTONE,
            EnumMaterial.GLOWSTONE,
            EnumMaterial.ENDERPEARL)),

    //4 bottles = 1 bucket
    BOTTLE_LIQUID("bottleLiquid", ImmutableList.of(
            EnumMaterial.REDSTONE,
            EnumMaterial.GLOWSTONE,
            EnumMaterial.ENDERPEARL)),

    //2 rods = 1 ingot
    ROD("rod", ImmutableList.of(
            EnumMaterial.IRON,
            EnumMaterial.GOLD,
            EnumMaterial.COPPER,
            EnumMaterial.TIN,
            EnumMaterial.BRONZE,
            EnumMaterial.ELECTRUM,
            EnumMaterial.INVAR,
            EnumMaterial.NICKEL,
            EnumMaterial.ZINC,
            EnumMaterial.BRASS,
            EnumMaterial.SILVER,
            EnumMaterial.STEEL,
            EnumMaterial.LEAD,
            EnumMaterial.PLATINUM,
            EnumMaterial.CUPRONICKEL,
            EnumMaterial.SIGNALUM,
            EnumMaterial.LUMIUM,
            EnumMaterial.ENDERIUM,
            EnumMaterial.ALUMINIUM,
            EnumMaterial.CHROMIUM,
            EnumMaterial.ENDER,
            EnumMaterial.GRAVITITE)),

    //4 small dust = 1 dust
    DUST_SMALL("dust_small", ImmutableList.of(
            EnumMaterial.COAL,
            EnumMaterial.IRON,
            EnumMaterial.GOLD,
            EnumMaterial.COPPER,
            EnumMaterial.TIN,
            EnumMaterial.BRONZE,
            EnumMaterial.ELECTRUM,
            EnumMaterial.INVAR,
            EnumMaterial.NICKEL,
            EnumMaterial.ZINC,
            EnumMaterial.BRASS,
            EnumMaterial.SILVER,
            EnumMaterial.STEEL,
            EnumMaterial.LEAD,
            EnumMaterial.PLATINUM,
            EnumMaterial.CUPRONICKEL,
            EnumMaterial.ENDERPEARL,
            EnumMaterial.SIGNALUM,
            EnumMaterial.LUMIUM,
            EnumMaterial.ENDERIUM,
            EnumMaterial.CHARCOAL,
            EnumMaterial.OBSIDIAN,
            EnumMaterial.SULFUR,
            EnumMaterial.NITER,
            EnumMaterial.GUNPOWDER,
            EnumMaterial.BLAZE,
            EnumMaterial.REDSTONE,
            EnumMaterial.GLOWSTONE,
            EnumMaterial.ALUMINA,
            EnumMaterial.ALUMINIUM,
            EnumMaterial.CHROMIUM,
            EnumMaterial.ENDER,
            EnumMaterial.GRAVITITE));

    public final ImmutableList<EnumMaterial> materials;
    public final String prefix;
    public final ImmutableList<EnumMaterial> deprecated;

    EnumMaterialItem(String prefix, ImmutableList<EnumMaterial> materials, ImmutableList<EnumMaterial> deprecated) {
        this.materials = materials;
        this.prefix = prefix;
        this.deprecated = deprecated;

    }

    EnumMaterialItem(String prefix, ImmutableList<EnumMaterial> materials) {
        this.materials = materials;
        this.prefix = prefix;
        this.deprecated = ImmutableList.of();
    }
}
