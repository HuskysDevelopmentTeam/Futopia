package net.thegaminghuskymc.futopia.network;

import codechicken.lib.colour.ColourRGBA;
import keri.ninetaillib.util.IPropertyProvider;

public enum EnumConcreteColoredType implements IPropertyProvider {
    WHITE("white", 0, new ColourRGBA(206, 212, 213, 255)),
    BLACK("black", 1, new ColourRGBA(7, 9, 14, 255)),
    GREEN("green", 2, new ColourRGBA(74, 92, 38, 255)),
    PINK("pink", 3, new ColourRGBA(214, 101, 143, 255)),
    BLUE("blue", 4, new ColourRGBA(44, 46, 143, 255)),
    BROWN("brown", 5, new ColourRGBA(97, 60, 32, 255)),
    CYAN("cyan", 6, new ColourRGBA(21, 118, 135, 255)),
    LIGHT_BLUE("light_blue", 7, new ColourRGBA(36, 138, 200, 255)),
    LIME("lime", 8, new ColourRGBA(96, 170, 26, 255)),
    MAGENTA("magenta", 9, new ColourRGBA(169, 48, 159, 255)),
    ORANGE("orange", 10, new ColourRGBA(223, 96, 0, 255)),
    PURPLE("purple", 11, new ColourRGBA(100, 31, 156, 255)),
    RED("red", 12, new ColourRGBA(142, 32, 32, 255)),
    SILVER("silver", 13, new ColourRGBA(125, 125, 115, 255)),
    YELLOW("yellow", 14, new ColourRGBA(239, 174, 21, 255));

    private String name;
    private int ID;

    EnumConcreteColoredType(String name, int ID, ColourRGBA rgba) {
        this.name = name;
        this.ID = ID;
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

}
