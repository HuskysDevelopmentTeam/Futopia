package net.thegaminghuskymc.futopia.network;

import keri.ninetaillib.util.IPropertyProvider;
import net.minecraft.item.EnumRarity;

public enum EnumMaterialType implements IPropertyProvider {

    RED("red", 0),
    BLUE("blue", 1),
    PURPLE("purple", 2),
    GREEN("green", 3),
    ZINC("zinc", 4),
    TUNGSTEN("tungsten", 5),
    BRASS("brass", 6),
    TESSELATION("tesselite", 7);

    public static final EnumMaterialType[] METADATA_LOOKUP = new EnumMaterialType[values().length];

    static {
        for (EnumMaterialType type : values()) {
            METADATA_LOOKUP[type.getMetadata()] = type;
        }
    }

    public final int metadata;
    public final String name;
    public final int light;
    public final float hardness;
    public final float resistance;
    public final EnumRarity rarity;

    EnumMaterialType(String name, int metadata, int light, float hardness, float resistance, EnumRarity rarity) {

        this.metadata = metadata;
        this.name = name;
        this.light = light;
        this.rarity = rarity;
        this.hardness = hardness;
        this.resistance = resistance;
    }

    EnumMaterialType(String name, int metadata) {

        this(name, metadata, 0, 5.0F, 6.0F, EnumRarity.COMMON);
    }

    public static String[] toStringArray() {
        String[] names = new String[values().length];

        for (int i = 0; i < values().length; i++) {
            names[i] = values()[i].getName();
        }

        return names;
    }

    @Override
    public int getID() {
        return this.metadata;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static EnumMaterialType byMetadata(int metadata) {

        if (metadata < 0 || metadata >= METADATA_LOOKUP.length) {
            metadata = 0;
        }
        return METADATA_LOOKUP[metadata];
    }

    public int getMetadata() {

        return this.metadata;
    }

    @Override
    public String getName() {

        return this.name;
    }

    public int getLight() {

        return this.light;
    }

}
