package net.thegaminghuskymc.futopia.blocks.machine;

import keri.ninetaillib.lib.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.tiles.TileAlloyFurnace;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockAlloyFurnace extends BlockMachineBase {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockAlloyFurnace() {
        super(BlockNames.ALLOYFURNACE_NAME);
        setCreativeTab(FTCreativeTabs.main);
    }

    @Override
    public TileAlloyFurnace createNewTileEntity(World world, int meta) {
        return new TileAlloyFurnace();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registrar) {
        this.texture = new TextureAtlasSprite[5];
        this.texture[0] = registrar.registerIcon(Refs.MODID + ":blocks/machines/alloy_furnace/alloy_furnace_side_alt");
        this.texture[1] = registrar.registerIcon(Refs.MODID + ":blocks/machines/alloy_furnace/alloy_furnace_back_alt");
        this.texture[2] = registrar.registerIcon(Refs.MODID + ":blocks/machines/alloy_furnace/alloy_furnace_top_alt");
        this.texture[3] = registrar.registerIcon(Refs.MODID + ":blocks/machines/alloy_furnace/alloy_furnace_top_alt");
        this.texture[4] = registrar.registerIcon(Refs.MODID + ":blocks/machines/alloy_furnace/alloy_furnace_front_on_alt");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta, int side) {
        switch (side) {
            case 0:
                return this.texture[3];
            case 1:
                return this.texture[2];
            case 2:
                return this.texture[4];
            case 3:
                return this.texture[1];
            case 4:
                return this.texture[0];
            case 5:
                return this.texture[0];
        }

        return null;
    }

}