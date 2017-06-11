package net.thegaminghuskymc.futopia.blocks.normal;

import java.util.ArrayList;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import codechicken.lib.raytracer.RayTracer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.BlockCore;
import net.thegaminghuskymc.futopia.blocks.IInitializer;
import net.thegaminghuskymc.futopia.blocks.IModelRegister;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.items.itemblocks.ItemBlockClearGlass;
import net.thegaminghuskymc.futopia.network.ClearGlassType;

public class BlockClearGlass extends BlockCore implements IInitializer, IModelRegister {

    public static final PropertyEnum<ClearGlassType> VARIANT = PropertyEnum.create("type", ClearGlassType.class);
    /* REFERENCES */
    public static ItemStack clearGlassNormal;
    public static ItemStack clearGlassBlack;
    public static ItemStack clearGlassBlue;
    public static ItemStack clearGlassBrown;
    public static ItemStack clearGlassCyan;
    public static ItemStack clearGlassGray;
    public static ItemStack clearGlassGreen;
    public static ItemStack clearGlassLightBlue;
    public static ItemStack clearGlassLime;
    public static ItemStack clearGlassMagenta;
    public static ItemStack clearGlassOrange;
    public static ItemStack clearGlassPink;
    public static ItemStack clearGlassPurple;
    public static ItemStack clearGlassRed;
    public static ItemStack clearGlassSilver;
    public static ItemStack clearGlassYellow;

    public BlockClearGlass() {

        super(Material.GLASS, Refs.MODID);

        setUnlocalizedName("clear_glass");
        setCreativeTab(FTCreativeTabs.main);
        setHardness(3.0F);
        setResistance(200.0F);
        setSoundType(SoundType.GLASS);
        setDefaultState(getBlockState().getBaseState().withProperty(VARIANT, ClearGlassType.NORMAL));
    }

    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(@Nonnull Item item, CreativeTabs tab, NonNullList<ItemStack> list) {

        for (int i = 0; i < ClearGlassType.METADATA_LOOKUP.length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {

        return this.getDefaultState().withProperty(VARIANT, ClearGlassType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {

        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    public int damageDropped(IBlockState state) {

        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {

        return ClearGlassType.byMetadata(state.getBlock().getMetaFromState(state)).light;
    }

    @Override
    public int quantityDropped(Random rand) {

        return 0;
    }

    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, net.minecraft.entity.EntityLiving.SpawnPlacementType type) {

        return false;
    }

    @Override
    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {

        return true;
    }

    @Override
    public boolean canProvidePower(IBlockState state) {

        return true;
    }

    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {

        return true;
    }

    @Override
    public boolean isFullCube(IBlockState state) {

        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {

        return false;
    }

    /*@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {

        if (player.isSneaking()) {
            RayTraceResult traceResult = RayTracer.retrace(player);
            if (WrenchHelper.isHoldingUsableWrench(player, traceResult)) {
                if (ServerHelper.isServerWorld(world)) {
                    dismantleBlock(world, pos, state, player, false);
                    WrenchHelper.usedWrench(player, traceResult);
                }
                return true;
            }
        }
        return false;
    }*/

    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {

        IBlockState offset = blockAccess.getBlockState(pos.offset(side));
        return offset.getBlock() != this && super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public float[] getBeaconColorMultiplier(IBlockState state, World world, BlockPos pos, BlockPos beaconPos) {
        return ClearGlassType.byMetadata(state.getBlock().getMetaFromState(state)).beaconMult;
    }

    /* IDismantleable 
    @Override
    public ArrayList<ItemStack> dismantleBlock(World world, BlockPos pos, IBlockState state, EntityPlayer player, boolean returnDrops) {

        int metadata = getMetaFromState(world.getBlockState(pos));
        ItemStack dropBlock = new ItemStack(this, 1, damageDropped(state));
        world.setBlockToAir(pos);

        if (!returnDrops) {
            float f = 0.3F;
            double x2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            double y2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            double z2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            EntityItem dropEntity = new EntityItem(world, pos.getX() + x2, pos.getY() + y2, pos.getZ() + z2, dropBlock);
            dropEntity.setPickupDelay(10);
            world.spawnEntity(dropEntity);

            CoreUtils.dismantleLog(player.getName(), this, metadata, pos);
        }
        ArrayList<ItemStack> ret = new ArrayList<>();
        ret.add(dropBlock);
        return ret;
    }

    @Override
    public boolean canDismantle(World world, BlockPos pos, IBlockState state, EntityPlayer player) {

        return true;
    }*/

    /* IModelRegister */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {

        for (int i = 0; i < ClearGlassType.values().length; i++) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation(modName + ":" + name, "type=" + ClearGlassType.byMetadata(i).getName()));
        }
    }

    /* IInitializer */
    @Override
    public boolean preInit() {

        setRegistryName("clear_glass");
        GameRegistry.register(this);

        ItemBlockClearGlass itemBlock = new ItemBlockClearGlass(this);
        itemBlock.setRegistryName(this.getRegistryName());
        GameRegistry.register(itemBlock);

        clearGlassNormal = new ItemStack(this, 1, ClearGlassType.NORMAL.getID());
        clearGlassBlack = new ItemStack(this, 1, ClearGlassType.BLACK.getID());
        clearGlassBlue = new ItemStack(this, 1, ClearGlassType.BLUE.getID());
        clearGlassBrown = new ItemStack(this, 1, ClearGlassType.BROWN.getID());
        clearGlassCyan = new ItemStack(this, 1, ClearGlassType.CYAN.getID());
        clearGlassGray = new ItemStack(this, 1, ClearGlassType.GRAY.getID());
        clearGlassGreen = new ItemStack(this, 1, ClearGlassType.GREEN.getID());
        clearGlassLightBlue = new ItemStack(this, 1, ClearGlassType.LIGHT_BLUE.getID());
        clearGlassLime = new ItemStack(this, 1, ClearGlassType.LIME.getID());
        clearGlassMagenta = new ItemStack(this, 1, ClearGlassType.MAGENTA.getID());
        clearGlassOrange = new ItemStack(this, 1, ClearGlassType.ORANGE.getID());
        clearGlassPink = new ItemStack(this, 1, ClearGlassType.PINK.getID());
        clearGlassPurple = new ItemStack(this, 1, ClearGlassType.PURPLE.getID());
        clearGlassRed = new ItemStack(this, 1, ClearGlassType.RED.getID());
        clearGlassSilver = new ItemStack(this, 1, ClearGlassType.SILVER.getID());
        clearGlassYellow = new ItemStack(this, 1, ClearGlassType.YELLOW.getID());

        OreDictionary.registerOre("blockClearGlass", new ItemStack(this, 1, OreDictionary.WILDCARD_VALUE));

        return true;
    }

    @Override
    public boolean initialize() {

        return true;
    }

    @Override
    public boolean postInit() {

        return true;
    }

}
