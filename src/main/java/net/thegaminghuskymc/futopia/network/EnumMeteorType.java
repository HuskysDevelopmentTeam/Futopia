package net.thegaminghuskymc.futopia.network;

import keri.ninetaillib.util.IPropertyProvider;

public enum EnumMeteorType implements IPropertyProvider {

    NORMAL("normal", 0),
    BRICK("brick", 1),
    PILLAR("pillar", 2);

    private String name;
    private int ID;

    EnumMeteorType(String name, int ID) {
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
