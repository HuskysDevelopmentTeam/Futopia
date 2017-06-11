package net.thegaminghuskymc.futopia.block;

import static cofh.lib.util.helpers.ItemHelper.registerWithHandlers;

import java.util.List;

import javax.annotation.Nonnull;

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
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.item.block.ItemBlockBasalt;
import net.thegaminghuskymc.futopia.reference.Refs;

public class TestBlock extends BlockCore implements IInitializer, IModelRegister{
	
	public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
    /* REFERENCES */
    public static ItemStack testA;
    public static ItemStack testB;
    public static ItemStack testC;
    public static ItemStack testD;
    public static ItemStack testE;
    public static ItemStack testF;
    public static ItemStack testG;
    public static ItemStack testH;
    public static ItemStack testI;

	public TestBlock() {
		super(Material.ROCK, Refs.MODID);

		setUnlocalizedName("test_block");
		setCreativeTab(FTCreativeTabs.worldgen);

		setSoundType(SoundType.STONE);
		setDefaultState(getBlockState().getBaseState().withProperty(VARIANT, Type.A));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, VARIANT);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {
		for (int i = 0; i < Type.METADATA_LOOKUP.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	/* TYPE METHODS */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, Type.byMetadata(meta));
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
	@SideOnly(Side.CLIENT)
	public void registerModels() {
		for (int i = 0; i < Type.values().length; i++) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation(modName + ":" + name, "type=" + Type.byMetadata(i).getName()));
		}
	}
	
	@Override
	public boolean preInit() {
		this.setRegistryName("test_block");
		GameRegistry.register(this);
	
		ItemBlockBasalt itemBlock = new ItemBlockBasalt(this);
		itemBlock.setRegistryName(this.getRegistryName());
		GameRegistry.register(itemBlock);
	
		testA = new ItemStack(this, 1, Type.A.getMetadata());
		testB = new ItemStack(this, 1, Type.B.getMetadata());
		testC = new ItemStack(this, 1, Type.C.getMetadata());
		testD = new ItemStack(this, 1, Type.D.getMetadata());
		testE = new ItemStack(this, 1, Type.E.getMetadata());
		testF = new ItemStack(this, 1, Type.F.getMetadata());
		testG = new ItemStack(this, 1, Type.G.getMetadata());
		testH = new ItemStack(this, 1, Type.H.getMetadata());
		testI = new ItemStack(this, 1, Type.I.getMetadata());
	
		registerWithHandlers("blockBasalt", testA);
		registerWithHandlers("blockBasaltCobble", testB);
		registerWithHandlers("blockBasaltPaver", testC);
		registerWithHandlers("blockBasaltBrick", testD);
		registerWithHandlers("blockBasaltFancy", testE);
		registerWithHandlers("blockBasaltCrackedLava", testF);
		registerWithHandlers("blockBasaltBrickCracked", testG);
		registerWithHandlers("blockBasaltBrickSmall", testH);
		registerWithHandlers("blockBasaltTile", testI);
	
		return true;
	}
	
	@Override
	public boolean initialize() {
		return false;
	}
	
	@Override
	public boolean postInit() {
		return false;
	}
	
	public enum Type implements IStringSerializable {

        // @formatter:off
        A(0, "a"),
        B(1, "b"),
        C(2, "c"),
        D(3, "d"),
        E(4, "e"),
        F(5, "f"),
        G(6, "g"),
        H(7, "h"),
        I(8, "i");
        // @formatter: on

        private static final Type[] METADATA_LOOKUP = new Type[values().length];

        static {
            for (Type type : values()) {
                METADATA_LOOKUP[type.getMetadata()] = type;
            }
        }

        private final int metadata;
        private final String name;
        private final int light;
        private final float hardness;
        private final float resistance;

        Type(int metadata, String name, int light, float hardness, float resistance) {

            this.metadata = metadata;
            this.name = name;
            this.light = light;
            this.hardness = hardness;
            this.resistance = resistance;
        }

        Type(int metadata, String name, float hardness, float resistance) {
            this(metadata, name, 0, hardness, resistance);
        }

        Type(int metadata, String name, int light) {

            this(metadata, name, light, 5.0F, 6.0F);
        }

        Type(int metadata, String name) {

            this(metadata, name, 0, 5.0F, 6.0F);
        }

        public static Type byMetadata(int metadata) {

            if (metadata < 0 || metadata >= METADATA_LOOKUP.length) {
                metadata = 0;
            }
            return METADATA_LOOKUP[metadata];
        }

        public int getMetadata() {
            return this.metadata;
        }

        @Override
        public String getName() {

            return this.name;
        }

        public int getLight() {

            return this.light;
        }

        public float getHardness() {

            return this.hardness;
        }

        public float getResistance() {

            return this.resistance;
        }
    }

}
