package net.thegaminghuskymc.futopia.block.decorativeBlocks.base;

import net.minecraft.block.state.IBlockState;

/**
 * Created by TheGamingHuskyMC on 18.05.2017.
 */
public class BlockSubStairBlock extends BlockFutopiaStair {

    public BlockSubStairBlock(IBlockState state) {
        super("marble_stair", state);
        useNeighborBrightness = true;
    }

    @Override
    public void registerModels() {
        super.registerModels();
    }
}
