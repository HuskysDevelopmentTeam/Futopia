package net.thegaminghuskymc.futopia.block.worldgen;

import cofh.core.block.BlockCore;
import cofh.core.render.IModelRegister;
import cofh.core.util.core.IInitializer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.item.ItemMaterial;
import net.thegaminghuskymc.futopia.item.block.ItemBlockOre;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.reference.Refs;

import javax.annotation.Nonnull;
import java.util.List;

import static cofh.lib.util.helpers.ItemHelper.addSmelting;
import static cofh.lib.util.helpers.ItemHelper.registerWithHandlers;

public class BlockOre extends BlockCore implements IInitializer, IModelRegister {

    public static final PropertyEnum<EnumMaterialType> VARIANT = PropertyEnum.create("type", EnumMaterialType.class);
    /* REFERENCES */
    public static ItemStack oreRed;
    public static ItemStack oreBlue;
    public static ItemStack orePurple;
    public static ItemStack oreGreen;
    public static ItemStack oreZinc;
    public static ItemStack oreTungsten;
    public static ItemStack oreBrass;
    public static ItemStack oreTesselite;

    public BlockOre() {

        super(Material.ROCK, Refs.MODID);

        setUnlocalizedName("ore");
        setCreativeTab(FTCreativeTabs.worldgen);

        setHardness(3.0F);
        setResistance(5.0F);
        setSoundType(SoundType.STONE);
        setDefaultState(blockState.getBaseState().withProperty(VARIANT, EnumMaterialType.RED));

        setHarvestLevel("pickaxe", 2);
    }

    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {

        for (int i = 0; i < EnumMaterialType.values().length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    /* TYPE METHODS */
    @Override
    public IBlockState getStateFromMeta(int meta) {

        return this.getDefaultState().withProperty(VARIANT, EnumMaterialType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {

        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    public int damageDropped(IBlockState state) {

        return state.getValue(VARIANT).getMetadata();
    }

    /* IModelRegister */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {

        for (int i = 0; i < EnumMaterialType.values().length; i++) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation(modName + ":" + name, "type=" + EnumMaterialType.byMetadata(i).getName()));
        }
    }

    /* IInitializer */
    @Override
    public boolean preInit() {

        this.setRegistryName("ore");
        GameRegistry.register(this);

        ItemBlockOre itemBlock = new ItemBlockOre(this);
        itemBlock.setRegistryName(this.getRegistryName());
        GameRegistry.register(itemBlock);

        oreRed = new ItemStack(this, 1, EnumMaterialType.RED.getMetadata());
        oreBlue = new ItemStack(this, 1, EnumMaterialType.BLUE.getMetadata());
        orePurple = new ItemStack(this, 1, EnumMaterialType.PURPLE.getMetadata());
        oreGreen = new ItemStack(this, 1, EnumMaterialType.GREEN.getMetadata());
        oreZinc = new ItemStack(this, 1, EnumMaterialType.ZINC.getMetadata());
        oreTungsten = new ItemStack(this, 1, EnumMaterialType.TUNGSTEN.getMetadata());
        oreBrass = new ItemStack(this, 1, EnumMaterialType.BRASS.getMetadata());
        oreTesselite = new ItemStack(this, 1, EnumMaterialType.TESSELATION.getMetadata());

        registerWithHandlers("oreRed", oreRed);
        registerWithHandlers("oreBlue", oreBlue);
        registerWithHandlers("orePurple", orePurple);
        registerWithHandlers("oreGreen", oreGreen);
        registerWithHandlers("oreZinc", oreZinc);
        registerWithHandlers("oreTungsten", oreTungsten);
        registerWithHandlers("oreBrass", oreBrass);
        registerWithHandlers("oreTesselite", oreTesselite);

        return true;
    }

    @Override
    public boolean initialize() {

        addSmelting(ItemMaterial.ingotRed, oreRed, 0.6F);
        addSmelting(ItemMaterial.ingotBlue, oreBlue, 0.7F);
        addSmelting(ItemMaterial.ingotPurple, orePurple, 0.9F);
        addSmelting(ItemMaterial.ingotGreen, oreGreen, 0.8F);
        addSmelting(ItemMaterial.ingotZinc, oreZinc, 0.6F);
        addSmelting(ItemMaterial.ingotTungsten, oreTungsten, 1.0F);
        addSmelting(ItemMaterial.ingotBrass, oreBrass, 1.0F);
        addSmelting(ItemMaterial.ingotTesselite, oreTesselite, 1.2F);

        return true;
    }

    @Override
    public boolean postInit() {
        return true;
    }

}
