package net.thegaminghuskymc.futopia.network;

public enum EnumMaterial {
    STONE("stone"),
    COAL("coal"),
    CHARCOAL("charcoal"),
    IRON("iron"),
    GOLD("gold"),
    COPPER("copper"),
    TIN("tin"),
    BRONZE("bronze"),
    ELECTRUM("electrum"),
    INVAR("invar"),
    NICKEL("nickel"),
    ZINC("zinc"),
    BRASS("brass"),
    SILVER("silver"),
    STEEL("steel"),
    LEAD("lead"),
    PLATINUM("platinum"),
    CUPRONICKEL("cupronickel"),
    REDSTONE("redstone"),
    GLOWSTONE("glowstone"),
    ENDERPEARL("enderpearl"),
    SIGNALUM("signalum"),
    LUMIUM("lumium"),
    ENDERIUM("enderium"),
    SULFUR("sulfur"),
    NITER("niter"),
    GUNPOWDER("gunpowder"),
    OBSIDIAN("obsidian"),
    BLAZE("blaze"),
    ALUMINA("alumina"),
    ALUMINIUM("aluminium"),
    CHROMIUM("chrome"),
    BIRCH("birch"),
    OAK("oak"),
    DARKOAK("dark_oak"),
    SPRUCE("spruce"),
    ACACIA("acacia"),
    JUNGLE("jungle"),
    DIRT("dirt"),
    GRASS("grass"),
    ANDESITE("andesite"),
    GRANITE("granitie"),
    DIORITE("diorite"),
    SAND("sand"),
    CLAY("clay"),
    ENDSTONE("eEndstone"),
    WOOL("wool"),
    DIAMOND("diamond"),
    EMERALD("emerald"),
    GLASS("glass"),
    ENDER("ender"),
    GRAVITITE("gravitite");

    public final String suffix;

    public final String suffix_alias;

    EnumMaterial(String suffix) {
        this.suffix = suffix;
        this.suffix_alias = null;
    }

    EnumMaterial(String suffix, String suffix_alias) {
        this.suffix = suffix;
        this.suffix_alias = suffix_alias;
    }

}
