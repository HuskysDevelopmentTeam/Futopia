package net.thegaminghuskymc.futopia.compatibilities;

import net.minecraftforge.fml.common.Loader;
import net.thegaminghuskymc.futopia.compatibilities.waila.WailaCompatibility;

/**
 * Created by EwyBoy
 **/
public class CompatibilityHandler {
    public static void registerWaila() {
        if (Loader.isModLoaded("Waila")) WailaCompatibility.register();
    }
}
