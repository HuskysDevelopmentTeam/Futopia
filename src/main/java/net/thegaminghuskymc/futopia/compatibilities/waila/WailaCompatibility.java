package net.thegaminghuskymc.futopia.compatibilities.waila;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.thegaminghuskymc.futopia.block.machine.BlockCompressor;
import net.thegaminghuskymc.futopia.block.machine.BlockPlatingPress;
import net.thegaminghuskymc.futopia.reference.Refs;

import java.util.List;

/**
 * Created by EwyBoy
 **/
public class WailaCompatibility implements IWailaDataProvider {

    public static final WailaCompatibility INSTANCE = new WailaCompatibility();
    private static boolean registered;
    private static boolean loaded;
    private WailaCompatibility() {
    }

    public static void load(IWailaRegistrar registrar) {
        System.out.println("WailaCompatibility.load");
        if (!registered) {
            throw new RuntimeException("Please register this handler using the provided method.");
        }
        if (!loaded) {

            registrar.registerHeadProvider(INSTANCE, BlockCompressor.class);
            registrar.registerBodyProvider(INSTANCE, BlockCompressor.class);
            registrar.registerTailProvider(INSTANCE, BlockCompressor.class);

            registrar.registerHeadProvider(INSTANCE, BlockPlatingPress.class);
            registrar.registerBodyProvider(INSTANCE, BlockPlatingPress.class);
            registrar.registerTailProvider(INSTANCE, BlockPlatingPress.class);
            loaded = true;
        }
    }

    public static void register() {
        if (registered) return;
        registered = true;
        FMLInterModComms.sendMessage("Waila", "register", Refs.WAILA);
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> list, IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler) {
        return list;
    }

    @Override
    public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, BlockPos pos) {
        return tag;
    }

    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return null;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        Block block = accessor.getBlock();
        if (block instanceof IWailaUser) {
            return ((IWailaUser) block).getWailaBody(itemStack, currenttip, accessor, config);
        }
        return currenttip;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }
}