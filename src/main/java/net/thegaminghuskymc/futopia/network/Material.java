package net.thegaminghuskymc.futopia.network;

import codechicken.lib.colour.ColourRGBA;
import com.google.common.collect.Lists;
import net.minecraft.util.text.translation.I18n;

public enum Material {
    IRON("iron", new ColourRGBA(171, 171, 171, 255), MaterialType.ALL),
    GOLD("gold", new ColourRGBA(226, 209, 69, 255), MaterialType.ALL),
    COPPER("copper", new ColourRGBA(255, 136, 90, 255), MaterialType.ALL),
    SILVER("silver", new ColourRGBA(209, 226, 232, 255), MaterialType.ALL),
    ELECTRUM("electrum", new ColourRGBA(171, 164, 49, 255), MaterialType.CRAFTING),
    LEAD("lead", new ColourRGBA(59, 62, 78, 255), MaterialType.ALL),
    TIN("tin", new ColourRGBA(222, 218, 205, 255), MaterialType.ALL),
    SIGNALUM("signalum", new ColourRGBA(203, 60, 24, 255), MaterialType.CRAFTING),
    BRONZE("bronze", new ColourRGBA(200, 125, 41, 255), MaterialType.CRAFTING),
    IRIDIUM("iridium", new ColourRGBA(255, 255, 255, 255), MaterialType.ALL);

    private String oreDict;
    private java.util.List<MaterialType> materialTypes;


    Material(String oreDict, ColourRGBA rgba, MaterialType... types) {
        this.oreDict = oreDict;
        this.materialTypes = Lists.newArrayList(types);
    }

    public static Material getMaterial(int i) {
        if (i >= values().length)
            i = 0;
        return values()[i];
    }

    public String getOreDict() {
        return oreDict;
    }

    public String translateServer() {
        return I18n.translateToLocal("material.futopia." + getOreDict().toLowerCase() + ".name");
    }

    public boolean canBe(MaterialType type) {
        return this.materialTypes.contains(type);
    }
}