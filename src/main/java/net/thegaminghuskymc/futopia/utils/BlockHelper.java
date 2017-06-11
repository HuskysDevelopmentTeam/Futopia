// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BlockHelper.java

package net.thegaminghuskymc.futopia.utils;

import java.util.*;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public final class BlockHelper
{
    public static final class RotationType
    {

        public static final int STAIRS = 1;
        public static final int SLAB = 2;
        public static final int CHEST = 3;

        private RotationType()
        {
        }
    }


    private BlockHelper()
    {
    }

    public static int getHighestY(World world, int x, int z)
    {
        return world.getChunkFromBlockCoords(new BlockPos(x, 0, z)).getTopFilledSegment() + 16;
    }

    public static int getSurfaceBlockY(World world, int x, int z)
    {
        int y = world.getChunkFromBlockCoords(new BlockPos(x, 0, z)).getTopFilledSegment() + 16;
        BlockPos pos;
        IBlockState state;
        Block block;
        do
        {
            if(--y < 0)
                break;
            pos = new BlockPos(x, y, z);
            state = world.getBlockState(pos);
            block = state.getBlock();
        } while(block.isAir(state, world, pos) || block.isReplaceable(world, pos) || block.isLeaves(state, world, pos) || block.isFoliage(world, pos) || block.canBeReplacedByLeaves(state, world, pos));
        return y;
    }

    public static int getTopBlockY(World world, int x, int z)
    {
        int y = world.getChunkFromBlockCoords(new BlockPos(x, 0, z)).getTopFilledSegment() + 16;
        BlockPos pos;
        IBlockState state;
        Block block;
        do
        {
            if(--y < 0)
                break;
            pos = new BlockPos(x, y, z);
            state = world.getBlockState(pos);
            block = state.getBlock();
        } while(block.isAir(state, world, pos));
        return y;
    }

    public static int determineXZPlaceFacing(EntityLivingBase living)
    {
        int quadrant = MathHelper.floor((double)((living.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        switch(quadrant)
        {
        case 0: // '\0'
            return 2;

        case 1: // '\001'
            return 5;

        case 2: // '\002'
            return 3;

        case 3: // '\003'
            return 4;
        }
        return 3;
    }

    public static boolean isEqual(Block blockA, Block blockB)
    {
        if(blockA == blockB)
            return true;
        if((blockA == null) | (blockB == null))
            return false;
        else
            return blockA.equals(blockB) || blockA.isAssociatedBlock(blockB);
    }

    public static IBlockState getAdjacentBlock(World world, BlockPos pos, EnumFacing dir)
    {
        pos = pos.offset(dir);
        return world != null && world.isBlockLoaded(pos) ? world.getBlockState(pos) : Blocks.AIR.getDefaultState();
    }

    public static TileEntity getAdjacentTileEntity(World world, BlockPos pos, EnumFacing dir)
    {
        pos = pos.offset(dir);
        return world != null && world.isBlockLoaded(pos) ? world.getTileEntity(pos) : null;
    }

    public static TileEntity getAdjacentTileEntity(World world, BlockPos pos, int side)
    {
        return world != null ? getAdjacentTileEntity(world, pos, EnumFacing.VALUES[side]) : null;
    }

    public static TileEntity getAdjacentTileEntity(TileEntity refTile, EnumFacing dir)
    {
        return refTile != null ? getAdjacentTileEntity(refTile.getWorld(), refTile.getPos(), dir) : null;
    }

    public static TileEntity getAdjacentTileEntity(TileEntity refTile, int side)
    {
        return refTile != null ? getAdjacentTileEntity(refTile.getWorld(), refTile.getPos(), EnumFacing.VALUES[side]) : null;
    }

    public static int determineAdjacentSide(TileEntity refTile, BlockPos pos)
    {
        return pos.getY() <= refTile.getPos().getY() ? pos.getY() >= refTile.getPos().getY() ? pos.getZ() <= refTile.getPos().getZ() ? ((int) (pos.getZ() >= refTile.getPos().getZ() ? ((int) (pos.getX() <= refTile.getPos().getX() ? 4 : 5)) : 2)) : 3 : 0 : 1;
    }

    public static int[] getAdjacentCoordinatesForSide(RayTraceResult trace)
    {
        BlockPos pos = trace.getBlockPos();
        return getAdjacentCoordinatesForSide(pos.getX(), pos.getY(), pos.getZ(), trace.sideHit.ordinal());
    }

    public static int[] getAdjacentCoordinatesForSide(int x, int y, int z, int side)
    {
        return (new int[] {
            x + SIDE_COORD_MOD[side][0], y + SIDE_COORD_MOD[side][1], z + SIDE_COORD_MOD[side][2]
        });
    }

    public static AxisAlignedBB getAdjacentAABBForSide(RayTraceResult trace)
    {
        BlockPos pos = trace.getBlockPos();
        return getAdjacentAABBForSide(pos.getX(), pos.getY(), pos.getZ(), trace.sideHit.ordinal());
    }

    public static AxisAlignedBB getAdjacentAABBForSide(BlockPos pos, EnumFacing side)
    {
        return getAdjacentAABBForSide(pos, side.ordinal());
    }

    public static AxisAlignedBB getAdjacentAABBForSide(BlockPos pos, int side)
    {
        return getAdjacentAABBForSide(pos.getX(), pos.getY(), pos.getZ(), side);
    }

    public static AxisAlignedBB getAdjacentAABBForSide(int x, int y, int z, int side)
    {
        return new AxisAlignedBB(x + SIDE_COORD_MOD[side][0], y + SIDE_COORD_MOD[side][1], z + SIDE_COORD_MOD[side][2], (float)x + SIDE_COORD_AABB[side][0], (float)y + SIDE_COORD_AABB[side][1], (float)z + SIDE_COORD_AABB[side][2]);
    }

    public static int getLeftSide(int side)
    {
        return SIDE_LEFT[side];
    }

    public static int getRightSide(int side)
    {
        return SIDE_RIGHT[side];
    }

    public static int getOppositeSide(int side)
    {
        return SIDE_OPPOSITE[side];
    }

    public static int getAboveSide(int side)
    {
        return SIDE_ABOVE[side];
    }

    public static int getBelowSide(int side)
    {
        return SIDE_BELOW[side];
    }

    public static boolean canRotate(Block block)
    {
        return Block.getIdFromBlock(block) < MAX_ID && rotateType[Block.getIdFromBlock(block)] != 0;
    }

    public static IBlockState rotateVanillaBlock(World world, IBlockState state, BlockPos pos)
    {
        int bId = Block.getIdFromBlock(state.getBlock());
        int bMeta = state.getBlock().getMetaFromState(state);
        Block block = state.getBlock();
        switch(rotateType[bId])
        {
        case 1: // '\001'
            return block.getStateFromMeta(++bMeta % 8);

        case 2: // '\002'
            return block.getStateFromMeta((bMeta + 8) % 16);

        case 3: // '\003'
            EnumFacing aenumfacing[] = EnumFacing.HORIZONTALS;
            int i = aenumfacing.length;
            for(int j = 0; j < i; j++)
            {
                EnumFacing facing = aenumfacing[j];
                BlockPos offsetPos = pos.offset(facing);
                if(isEqual(world.getBlockState(offsetPos).getBlock(), state.getBlock()))
                {
                    world.setBlockState(offsetPos, state.getBlock().getStateFromMeta(SIDE_OPPOSITE[bMeta]), 1);
                    return block.getStateFromMeta(SIDE_OPPOSITE[bMeta]);
                }
            }

            return block.getStateFromMeta(SIDE_LEFT[bMeta]);
        }
        return block.getStateFromMeta(bMeta);
    }

    public static List breakBlock(World worldObj, BlockPos pos, IBlockState state, int fortune, boolean doBreak, boolean silkTouch)
    {
        return breakBlock(worldObj, null, pos, state, fortune, doBreak, silkTouch);
    }

    public static List breakBlock(World worldObj, EntityPlayer player, BlockPos pos, IBlockState state, int fortune, boolean doBreak, boolean silkTouch)
    {
        if(state.getBlockHardness(worldObj, pos) == -1F)
            return new LinkedList();
        List stacks;
        if(silkTouch && state.getBlock().canSilkHarvest(worldObj, pos, state, player))
        {
            stacks = new LinkedList();
            stacks.add(createStackedBlock(state));
        } else
        {
            stacks = state.getBlock().getDrops(worldObj, pos, state, fortune);
        }
        if(!doBreak)
            return stacks;
        worldObj.playEvent(2001, pos, Block.getStateId(state));
        worldObj.setBlockToAir(pos);
        List result = worldObj.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(pos.getX() - 2, pos.getY() - 2, pos.getZ() - 2, pos.getX() + 3, pos.getY() + 3, pos.getZ() + 3));
        Iterator iterator = result.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            EntityItem entity = (EntityItem)iterator.next();
            if(!entity.isDead && entity.getEntityItem().getCount() > 0)
            {
                stacks.add(entity.getEntityItem());
                entity.world.removeEntity(entity);
            }
        } while(true);
        return stacks;
    }

    public static ItemStack createStackedBlock(IBlockState state)
    {
        Item item = Item.getItemFromBlock(state.getBlock());
        if(item.getHasSubtypes())
            return new ItemStack(item, 1, state.getBlock().getMetaFromState(state));
        else
            return new ItemStack(item, 1, 0);
    }

    public static int MAX_ID;
    public static byte rotateType[];
    public static final int SIDE_COORD_MOD[][] = {
        {
            0, -1, 0
        }, {
            0, 1, 0
        }, {
            0, 0, -1
        }, {
            0, 0, 1
        }, {
            -1, 0, 0
        }, {
            1, 0, 0
        }
    };
    public static float SIDE_COORD_AABB[][] = {
        {
            1.0F, -2F, 1.0F
        }, {
            1.0F, 2.0F, 1.0F
        }, {
            1.0F, 1.0F, 1.0F
        }, {
            1.0F, 1.0F, 2.0F
        }, {
            1.0F, 1.0F, 1.0F
        }, {
            2.0F, 1.0F, 1.0F
        }
    };
    public static final byte SIDE_LEFT[] = {
        4, 5, 5, 4, 2, 3
    };
    public static final byte SIDE_RIGHT[] = {
        5, 4, 4, 5, 3, 2
    };
    public static final byte SIDE_OPPOSITE[] = {
        1, 0, 3, 2, 5, 4
    };
    public static final byte SIDE_ABOVE[] = {
        3, 2, 1, 1, 1, 1
    };
    public static final byte SIDE_BELOW[] = {
        2, 3, 0, 0, 0, 0
    };
    public static final byte ROTATE_CLOCK_Y[] = {
        0, 1, 4, 5, 3, 2
    };
    public static final byte ROTATE_CLOCK_Z[] = {
        5, 4, 2, 3, 0, 1
    };
    public static final byte ROTATE_CLOCK_X[] = {
        2, 3, 1, 0, 4, 5
    };
    public static final byte ROTATE_COUNTER_Y[] = {
        0, 1, 5, 4, 2, 3
    };
    public static final byte ROTATE_COUNTER_Z[] = {
        4, 5, 2, 3, 1, 0
    };
    public static final byte ROTATE_COUNTER_X[] = {
        3, 2, 0, 1, 4, 5
    };
    public static final byte INVERT_AROUND_Y[] = {
        0, 1, 3, 2, 5, 4
    };
    public static final byte INVERT_AROUND_Z[] = {
        1, 0, 2, 3, 5, 4
    };
    public static final byte INVERT_AROUND_X[] = {
        1, 0, 3, 2, 4, 5
    };
    public static final byte ICON_ROTATION_MAP[][];

    static 
    {
        MAX_ID = 1024;
        rotateType = new byte[MAX_ID];
        ICON_ROTATION_MAP = new byte[6][];
        ICON_ROTATION_MAP[0] = (new byte[] {
            0, 1, 2, 3, 4, 5
        });
        ICON_ROTATION_MAP[1] = (new byte[] {
            1, 0, 2, 3, 4, 5
        });
        ICON_ROTATION_MAP[2] = (new byte[] {
            3, 2, 0, 1, 4, 5
        });
        ICON_ROTATION_MAP[3] = (new byte[] {
            3, 2, 1, 0, 5, 4
        });
        ICON_ROTATION_MAP[4] = (new byte[] {
            3, 2, 5, 4, 0, 1
        });
        ICON_ROTATION_MAP[5] = (new byte[] {
            3, 2, 4, 5, 1, 0
        });
        rotateType[Block.getIdFromBlock(Blocks.STONE_SLAB)] = 2;
        rotateType[Block.getIdFromBlock(Blocks.WOODEN_SLAB)] = 2;
        rotateType[Block.getIdFromBlock(Blocks.STONE_SLAB2)] = 2;
        rotateType[Block.getIdFromBlock(Blocks.PURPUR_SLAB)] = 2;
        rotateType[Block.getIdFromBlock(Blocks.TRAPPED_CHEST)] = 3;
        rotateType[Block.getIdFromBlock(Blocks.CHEST)] = 3;
        rotateType[Block.getIdFromBlock(Blocks.OAK_STAIRS)] = 1;
        rotateType[Block.getIdFromBlock(Blocks.STONE_STAIRS)] = 1;
        rotateType[Block.getIdFromBlock(Blocks.BRICK_STAIRS)] = 1;
        rotateType[Block.getIdFromBlock(Blocks.STONE_BRICK_STAIRS)] = 1;
        rotateType[Block.getIdFromBlock(Blocks.NETHER_BRICK_STAIRS)] = 1;
        rotateType[Block.getIdFromBlock(Blocks.SANDSTONE_STAIRS)] = 1;
        rotateType[Block.getIdFromBlock(Blocks.SPRUCE_STAIRS)] = 1;
        rotateType[Block.getIdFromBlock(Blocks.BIRCH_STAIRS)] = 1;
        rotateType[Block.getIdFromBlock(Blocks.JUNGLE_STAIRS)] = 1;
        rotateType[Block.getIdFromBlock(Blocks.QUARTZ_STAIRS)] = 1;
        rotateType[Block.getIdFromBlock(Blocks.RED_SANDSTONE_STAIRS)] = 1;
        rotateType[Block.getIdFromBlock(Blocks.PURPUR_STAIRS)] = 1;
    }
}
