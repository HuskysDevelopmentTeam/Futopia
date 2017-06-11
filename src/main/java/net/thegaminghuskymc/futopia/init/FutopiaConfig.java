package net.thegaminghuskymc.futopia.init;

import com.google.common.collect.Lists;
import keri.ninetaillib.config.ConfigBoolean;
import keri.ninetaillib.config.ConfigInteger;
import keri.ninetaillib.config.ConfigManagerBase;
import keri.ninetaillib.config.IConfigComponent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class FutopiaConfig extends ConfigManagerBase {

    private static final String categoryIntegration = "mod_integration";
    private static final String categoryWorldgen = "worldgen_ores";
    private static final String commentCategoryIntegration = "enable/disable mod integration modules";
    private static final String commentCategoryRendering = "rendering tweaks that (may) improve performance";
    private static final String commentCategoryWorldgen = "tweak the worldgen of ores etc.";
    private static final String commentWorldgenOre = "chance, min height, max height, min veinsize, max veinsize";
    public ConfigBoolean integrationTinkers;
    public ConfigBoolean integrationThermalExpansion;
    public ConfigBoolean integrationIC2;
    public ConfigBoolean integrationEnderIO;

    public FutopiaConfig(FMLPreInitializationEvent event) {
        super(event);
    }

    @Override
    public List<Pair<String, String>> getCategories() {
        List<Pair<String, String>> list = Lists.newArrayList();
        list.add(Pair.of(this.categoryIntegration, this.commentCategoryIntegration));
        list.add(Pair.of(this.categoryWorldgen, this.commentCategoryWorldgen));
        return list;
    }

    @Override
    public void addConfigComponents(List<IConfigComponent<?>> components) {
        components.add(this.integrationTinkers = new ConfigBoolean(categoryIntegration, "integrationTinkersConstruct", true));
        components.add(this.integrationThermalExpansion = new ConfigBoolean(categoryIntegration, "integrationThermalExpansion", true));
        components.add(this.integrationIC2 = new ConfigBoolean(categoryIntegration, "integrationIC2", true));
        components.add(this.integrationEnderIO = new ConfigBoolean(categoryIntegration, "integrationEnderIO", true));
    }

}
