package net.thegaminghuskymc.futopia.block.machine;

import cofh.lib.util.helpers.StringHelper;
import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.block.BlockFutopia;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.reference.Refs;

import java.util.List;

public class BlockParticleBlock extends BlockFutopia {


    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockParticleBlock() {
        super(Refs.PARTICLE_BLOCKNAME, Material.IRON);
        setCreativeTab(FTCreativeTabs.machines);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add("Hold " + StringHelper.getDeactivationText("Shift") + StringHelper.getFlavorText(" for information."));
        } else {
            tooltip.add(StringHelper.getInfoText("This block is used to summon whatever particles you want"));
        }
    }
    
    /*@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
    		EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
    	// TODO Auto-generated method stub
    	return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
    }*/

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegistrar registrar) {
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
