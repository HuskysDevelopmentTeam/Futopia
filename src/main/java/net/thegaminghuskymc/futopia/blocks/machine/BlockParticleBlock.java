package net.thegaminghuskymc.futopia.blocks.machine;

import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.BlockFutopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockParticleBlock extends BlockFutopia {


    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockParticleBlock() {
        super(BlockNames.PARTICLE_BLOCKNAME, Material.IRON);
        setCreativeTab(FTCreativeTabs.main);
    }

    /*@Override
    public void addInformation(ItemStack stack, EntityPlayer player, NonNullList<String> tooltip, boolean advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add("Hold " + StringHelper.getDeactivationText("Shift") + StringHelper.getFlavorText(" for information."));
        } else {
            tooltip.add(StringHelper.getInfoText("This block is used to summon whatever particles you want"));
        }
    }*/
    
    /*@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
    		EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
    	// TODO Auto-generated method stub
    	return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
    }*/

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registrar) {
        this.texture = new TextureAtlasSprite[3];
        this.texture[0] = registrar.registerIcon(Refs.MODID + ":blocks/machines/particle_block/particle_block_bottom");
        this.texture[1] = registrar.registerIcon(Refs.MODID + ":blocks/machines/particle_block/particle_block_top");
        this.texture[2] = registrar.registerIcon(Refs.MODID + ":blocks/machines/particle_block/particle_block_side");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        switch (side) {
            case 0:
                return this.texture[0];
            case 1:
                return this.texture[1];
            case 2:
                return this.texture[2];
            case 3:
                return this.texture[2];
            case 4:
                return this.texture[2];
            case 5:
                return this.texture[2];
        }

        return null;
    }

}
