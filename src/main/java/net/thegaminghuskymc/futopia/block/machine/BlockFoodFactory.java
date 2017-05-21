package net.thegaminghuskymc.futopia.block.machine;

import cofh.lib.util.helpers.StringHelper;
import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.block.BlockMachineBase;
import net.thegaminghuskymc.futopia.reference.Refs;

import java.util.List;

public class BlockFoodFactory extends BlockMachineBase {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockFoodFactory() {
        super(Refs.FOOD_FACTORY);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add("Hold" + StringHelper.getDeactivationText(" Shift ") + StringHelper.getFlavorText("for information."));
        } else {
            tooltip.add("This block is used to make food");
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegistrar registrar) {
        this.texture = new TextureAtlasSprite[3];
        this.texture[0] = registrar.registerIcon(Refs.MODID + ":blocks/particle_block_bottom");
        this.texture[1] = registrar.registerIcon(Refs.MODID + ":blocks/particle_block_top");
        this.texture[2] = registrar.registerIcon(Refs.MODID + ":blocks/particle_block_side");
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
