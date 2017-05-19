package net.thegaminghuskymc.futopia.network;

import keri.ninetaillib.util.IPropertyProvider;

public enum EnumMaterialTypeMore implements IPropertyProvider {

    RED("red", 0),
    BLUE("blue", 1),
    PURPLE("purple", 2),
    GREEN("green", 3),
    ZINC("zinc", 4),
    TUNGSTEN("tungsten", 5),
    BRASS("brass", 6),
    TESSELATION("tesselite", 7);

    private String name;
    private int ID;

    EnumMaterialTypeMore(String name, int ID) {
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
