package net.thegaminghuskymc.futopia.network;

import codechicken.lib.colour.ColourRGBA;
import keri.ninetaillib.util.IPropertyProvider;

public enum EnumDyeColor implements IPropertyProvider {

    BLACK("black", 0, new ColourRGBA(16, 16, 16, 255)),
    RED("red", 1, new ColourRGBA(214, 0, 1, 220)),
    GREEN("green", 2, new ColourRGBA(0, 166, 0, 220)),
    BROWN("brown", 3, new ColourRGBA(140, 58, 0, 220)),
    BLUE("blue", 4, new ColourRGBA(4, 0, 255, 220)),
    PURPLE("purple", 5, new ColourRGBA(84, 35, 153, 220)),
    CYAN("cyan", 6, new ColourRGBA(0, 206, 199, 220)),
    LIGHT_GRAY("light_gray", 7, new ColourRGBA(161, 161, 161, 220)),
    GRAY("gray", 8, new ColourRGBA(73, 73, 73, 220)),
    PINK("pink", 9, new ColourRGBA(255, 164, 193, 220)),
    LIME("lime", 10, new ColourRGBA(110, 255, 0, 220)),
    YELLOW("yellow", 11, new ColourRGBA(255, 220, 0, 220)),
    LIGHT_BLUE("light_blue", 12, new ColourRGBA(0, 180, 255, 220)),
    MAGENTA("magenta", 13, new ColourRGBA(246, 0, 255, 220)),
    ORANGE("orange", 14, new ColourRGBA(255, 77, 0, 220)),
    WHITE("white", 15, new ColourRGBA(255, 255, 255, 220));

    private String name;
    private int ID;
    private ColourRGBA color;

    EnumDyeColor(String name, int ID, ColourRGBA color) {
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