package net.thegaminghuskymc.futopia.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.reference.Refs;

/**
 * Created by TheGamingHuskyMC on 30.05.2017.
 */
public class ItemBase extends Item{

    public ItemBase(String unlocolizedName, CreativeTabs creativeTab){
        super();
        setUnlocalizedName(unlocolizedName);
        setRegistryName(unlocolizedName);
        setCreativeTab(creativeTab);
        registerRender(this);
        GameRegistry.register(this);
    }

    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Refs.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
    }

}
