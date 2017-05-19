package net.thegaminghuskymc.futopia.network;

import codechicken.lib.colour.ColourRGBA;
import keri.ninetaillib.util.IPropertyProvider;

public enum EnumXycroniumColor implements IPropertyProvider {

    BLUE("blue", 0, new ColourRGBA(0, 100, 255, 255)),
    YELLOW("yellow", 1, new ColourRGBA(237, 248, 32, 255)),
    PINK("pink", 2, new ColourRGBA(248, 32, 208, 255)),
    NEON_GREEN("neon_green", 3, new ColourRGBA(17, 217, 133, 255)),
    GREEN("green", 4, new ColourRGBA(16711935)),
    FOX("fox", 5, new ColourRGBA(255, 120, 0, 255)),
    RED("red", 6, new ColourRGBA(-16776961)),
    DARK("dark", 7, new ColourRGBA(30, 30, 30, 255)),
    LIGHT("light", 8, new ColourRGBA(-1));

    private String name;
    private int ID;
    private ColourRGBA color;

    EnumXycroniumColor(String name, int ID, ColourRGBA color) {
        this.name = name;
        this.ID = ID;
        this.color = color;
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
        return this.ID;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public ColourRGBA getColor() {
        return this.color;
    }

}
