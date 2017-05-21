package net.thegaminghuskymc.futopia.init;

import cofh.core.util.core.IInitializer;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.item.ItemMaterial;

import java.util.ArrayList;

public class OtherItems {

    /* REFERENCES */
    public static ItemMaterial itemMaterial;
    private static ArrayList<IInitializer> initList = new ArrayList<>();

    private OtherItems() {

    }

    public static void preInit() {

        itemMaterial = new ItemMaterial();

        initList.add(itemMaterial);

        Futopia.proxy.addIModelRegister(itemMaterial);

        for (IInitializer init : initList) {
            init.preInit();
        }
    }

    public static void initialize() {

        for (IInitializer init : initList) {
            init.initialize();
        }
    }

    public static void postInit() {

        for (IInitializer init : initList) {
            init.postInit();
        }
        initList.clear();
    }

}
