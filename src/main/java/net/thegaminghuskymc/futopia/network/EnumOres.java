package net.thegaminghuskymc.futopia.network;

import net.minecraft.util.IStringSerializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum EnumOres implements IStringSerializable {
    // Vanilla Ores
    IRON("iron", 0, EnumOreType.DUST, EnumOreType.VANILLA, EnumOreType.FLUID),
    GOLD("gold", 1, EnumOreType.DUST, EnumOreType.VANILLA, EnumOreType.FLUID),
    DIAMOND("diamond", 2, EnumOreType.VANILLA),

    // Base Ores
    COPPER("copper", 3, EnumOreType.BLOCK, EnumOreType.NUGGET, EnumOreType.INGOT, EnumOreType.DUST, EnumOreType.PLATE, EnumOreType.ORE, EnumOreType.FLUID),
    TIN("tin", 4, EnumOreType.BLOCK, EnumOreType.NUGGET, EnumOreType.INGOT, EnumOreType.DUST, EnumOreType.PLATE, EnumOreType.ORE, EnumOreType.FLUID),
    SILVER("silver", 5, EnumOreType.BLOCK, EnumOreType.NUGGET, EnumOreType.INGOT, EnumOreType.DUST, EnumOreType.PLATE, EnumOreType.ORE, EnumOreType.FLUID),
    LEAD("lead", 6, EnumOreType.BLOCK, EnumOreType.NUGGET, EnumOreType.INGOT, EnumOreType.DUST, EnumOreType.PLATE, EnumOreType.ORE, EnumOreType.FLUID),
    GRAPHITE("graphite", 7, EnumOreType.BLOCK, EnumOreType.NUGGET, EnumOreType.INGOT, EnumOreType.DUST, EnumOreType.PLATE, EnumOreType.ORE, EnumOreType.FLUID),
    MAGNESIUM("magnesium", 8, EnumOreType.BLOCK, EnumOreType.NUGGET, EnumOreType.INGOT, EnumOreType.DUST, EnumOreType.PLATE, EnumOreType.ORE, EnumOreType.FLUID),
    ALUMINUM("aluminum", 9, EnumOreType.BLOCK, EnumOreType.NUGGET, EnumOreType.INGOT, EnumOreType.DUST, EnumOreType.PLATE, EnumOreType.ORE, EnumOreType.FLUID),;

    private static final EnumOres[] META_LOOKUP = new EnumOres[values().length];

    static {
        for (EnumOres ore : values()) {
            META_LOOKUP[ore.getMeta()] = ore;
        }
    }

    private final String name;
    private final int meta;
    private final EnumOreType[] enumOresTypeList;

    EnumOres(String name, int meta, EnumOreType... oreTypes) {
        this.name = name;
        this.meta = meta;
        this.enumOresTypeList = oreTypes;
    }

    public static EnumOres byMeta(int meta) {
        if (meta < 0 || meta >= META_LOOKUP.length) {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public static List<EnumOres> byType(EnumOreType type) {
        List<EnumOres> result = new ArrayList<>();

        for (EnumOres ore : values()) {
            if (ore.isTypeSet(type)) {
                result.add(ore);
            }
        }

        return result;
    }

    public int getMeta() {
        return this.meta;
    }

    public String getUnlocalizedName() {
        return this.name.toLowerCase();
    }

    public String getName() {
        return this.name.toLowerCase();
    }

    public String getOreName() {
        return this.name;
    }

    public String toString() {
        return getName();
    }

    public boolean isTypeSet(EnumOreType enumOreType) {
        return Arrays.asList(enumOresTypeList).contains(enumOreType);
    }
}