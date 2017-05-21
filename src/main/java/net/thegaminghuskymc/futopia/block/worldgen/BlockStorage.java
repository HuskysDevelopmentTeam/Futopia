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
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.item.block.ItemBlockStorage;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.reference.Refs;

import javax.annotation.Nonnull;
import java.util.List;

import static cofh.lib.util.helpers.ItemHelper.addStorageRecipe;
import static cofh.lib.util.helpers.ItemHelper.registerWithHandlers;

public class BlockStorage extends BlockCore implements IInitializer, IModelRegister {

    public static final PropertyEnum<EnumMaterialType> VARIANT = PropertyEnum.create("type", EnumMaterialType.class);
    /* REFERENCES */
    public static ItemStack blockRed;
    public static ItemStack blockBlue;
    public static ItemStack blockPurple;
    public static ItemStack blockGreen;
    public static ItemStack blockZinc;
    public static ItemStack blockTungsten;
    public static ItemStack blockBrass;
    public static ItemStack blockTesselite;

    public BlockStorage() {

        super(Material.IRON, Refs.MODID);

        setUnlocalizedName("storage");
        setCreativeTab(FTCreativeTabs.blocks);

        setHardness(5.0F);
        setResistance(10.0F);
        setSoundType(SoundType.METAL);
        setDefaultState(getBlockState().getBaseState().withProperty(VARIANT, EnumMaterialType.RED));

        setHarvestLevel("pickaxe", 2);
    }

    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {

        for (int i = 0; i < EnumMaterialType.METADATA_LOOKUP.length; i++) {
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

    /* BLOCK METHODS */
    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, net.minecraft.entity.EntityLiving.SpawnPlacementType type) {

        return false;
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {

        return true;
    }

    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {

        return true;
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {

        return EnumMaterialType.byMetadata(state.getBlock().getMetaFromState(state)).light;
    }

    @Override
    public float getBlockHardness(IBlockState state, World world, BlockPos pos) {

        return EnumMaterialType.byMetadata(state.getBlock().getMetaFromState(state)).hardness;
    }

    @Override
    public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
        IBlockState state = world.getBlockState(pos);
        return EnumMaterialType.byMetadata(state.getBlock().getMetaFromState(state)).resistance;
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

        setRegistryName("storage");
        GameRegistry.register(this);

        ItemBlockStorage itemBlock = new ItemBlockStorage(this);
        itemBlock.setRegistryName(getRegistryName());
        GameRegistry.register(itemBlock);

        blockRed = new ItemStack(this, 1, EnumMaterialType.RED.getMetadata());
        blockBlue = new ItemStack(this, 1, EnumMaterialType.BLUE.getMetadata());
        blockPurple = new ItemStack(this, 1, EnumMaterialType.PURPLE.getMetadata());
        blockGreen = new ItemStack(this, 1, EnumMaterialType.GREEN.getMetadata());
        blockZinc = new ItemStack(this, 1, EnumMaterialType.ZINC.getMetadata());
        blockTungsten = new ItemStack(this, 1, EnumMaterialType.TUNGSTEN.getMetadata());
        blockBrass = new ItemStack(this, 1, EnumMaterialType.BRASS.getMetadata());
        blockTesselite = new ItemStack(this, 1, EnumMaterialType.TESSELATION.getMetadata());

        registerWithHandlers("blockRed", blockRed);
        registerWithHandlers("blockBlue", blockBlue);
        registerWithHandlers("blockPurple", blockPurple);
        registerWithHandlers("blockGreen", blockGreen);
        registerWithHandlers("blockZinc", blockZinc);
        registerWithHandlers("blockTungsten", blockTungsten);
        registerWithHandlers("blockBrass", blockBrass);
        registerWithHandlers("blockTesselite", blockTesselite);

        return true;
    }

    @Override
    public boolean initialize() {

        addStorageRecipe(blockRed, "ingotRed");
        addStorageRecipe(blockBlue, "ingotBlue");
        addStorageRecipe(blockPurple, "ingotPurple");
        addStorageRecipe(blockGreen, "ingotGreen");
        addStorageRecipe(blockZinc, "ingotZinc");
        addStorageRecipe(blockTungsten, "ingotTungsten");
        addStorageRecipe(blockBrass, "ingotBrass");
        addStorageRecipe(blockTesselite, "ingotTesselite");

        return true;
    }

    @Override
    public boolean postInit() {

        return true;
    }

}
