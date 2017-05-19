package net.thegaminghuskymc.futopia.network;

import keri.ninetaillib.util.IPropertyProvider;

public enum EnumColorType implements IPropertyProvider {

    BLACK("black", 0),
    RED("red", 1),
    GREEN("green", 2),
    BROWN("brown", 3),
    BLUE("blue", 4),
    PURPLE("purple", 5),
    CYAN("cyan", 6),
    LIGHT_GRAY("light_gray", 7),
    GRAY("gray", 8),
    PINK("pink", 9),
    LIME("lime", 10),
    YELLOW("yellow", 11),
    LIGHT_BLUE("light_blue", 12),
    MAGENTA("magenta", 13),
    ORANGE("orange", 14),
    WHITE("white", 15);

    private String name;
    private int ID;

    EnumColorType(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public static String[] toStringArray() {
        String[] subNames = new String[values().length];

        for (int i = 0; i < values().length; i++) {
            subNames[i] = values()[i].getName();
        }

        return subNames;
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
        return this.getName();
    }

}
