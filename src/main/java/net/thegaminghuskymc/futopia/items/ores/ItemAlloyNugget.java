package net.thegaminghuskymc.futopia.items.ores;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.items.ItemBase;
import net.thegaminghuskymc.futopia.items.Items;
import net.thegaminghuskymc.futopia.network.EnumAlloys;
import net.thegaminghuskymc.futopia.network.EnumOreType;
import net.thegaminghuskymc.futopia.reference.Refs;
import net.thegaminghuskymc.futopia.util.interfaces.IProvideRecipe;

import java.util.List;

public class ItemAlloyNugget extends ItemBase implements IProvideRecipe {

    public ItemAlloyNugget() {
        super("ores/nugget");
        this.setHasSubtypes(true);
        this.setCreativeTab(FTCreativeTabs.materials);
        this.setInternalName("alloy_nugget");
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for (int i = 0; i < EnumAlloys.values().length; i++) {
            if (EnumAlloys.byMeta(i).isTypeSet(EnumOreType.NUGGET)) {
                subItems.add(new ItemStack(this, 1, i));
            }
        }
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        String name = super.getUnlocalizedName();
        String oreName = EnumAlloys.byMeta(stack.getItemDamage()).getUnlocalizedName();
        return name + "." + oreName;
    }

    @Override
    public void registerItemRenderer() {
        for (int i = 0; i < EnumAlloys.values().length; i++) {
            if (EnumAlloys.byMeta(i).isTypeSet(EnumOreType.NUGGET)) {
                ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(Refs.MODID + ":ores/nugget-" + EnumAlloys.byMeta(i).getUnlocalizedName(), "inventory"));
            }
        }
    }

    @Override
    public void RegisterRecipes() {
        for (EnumAlloys ore : EnumAlloys.values()) {
            // Ingot -> 9x Nugget
            if (ore.isTypeSet(EnumOreType.INGOT) && ore.isTypeSet(EnumOreType.NUGGET)) {
                GameRegistry.addRecipe(new ShapelessOreRecipe(Items.ITEM_ALLOY_NUGGET.getStack(9, ore.getMeta()), "ingot" + ore.getAlloyName()));
            }
        }
    }
}