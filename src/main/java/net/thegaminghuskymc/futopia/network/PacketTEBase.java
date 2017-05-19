package net.thegaminghuskymc.futopia.network;

import cofh.api.core.ISecurable;
import cofh.api.core.ISecurable.AccessMode;
import cofh.core.network.PacketCoFHBase;
import cofh.core.network.PacketHandler;
import cofh.core.util.tileentity.IRedstoneControl;
import cofh.core.util.tileentity.IRedstoneControl.ControlMode;
import cofh.core.util.tileentity.ITransferControl;
import cofh.lib.gui.container.IAugmentableContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Futopia;

public class PacketTEBase extends PacketCoFHBase {

    public static void initialize() {

        PacketHandler.instance.registerPacket(PacketTEBase.class);
    }

    /* RS POWER */
    public static void sendRSPowerUpdatePacketToClients(IRedstoneControl rs, World world, BlockPos pos) {

        sendRSPowerUpdatePacketToClients(rs, world, pos.getX(), pos.getY(), pos.getZ());
    }

    private static void sendRSPowerUpdatePacketToClients(IRedstoneControl rs, World world, int x, int y, int z) {

        PacketHandler.sendToAllAround(getPacket(PacketTypes.RS_POWER_UPDATE).addCoords(x, y, z).addBool(rs.isPowered()), world, x, y, z);
    }

    /* RS CONFIG */
    public static void sendRSConfigUpdatePacketToServer(IRedstoneControl rs, BlockPos pos) {

        sendRSConfigUpdatePacketToServer(rs, pos.getX(), pos.getY(), pos.getZ());
    }

    private static void sendRSConfigUpdatePacketToServer(IRedstoneControl rs, int x, int y, int z) {

        PacketHandler.sendToServer(getPacket(PacketTypes.RS_CONFIG_UPDATE).addCoords(x, y, z).addByte(rs.getControl().ordinal()));
    }

    /* TRANSFER CONFIG */
    public static void sendTransferUpdatePacketToServer(ITransferControl transfer, BlockPos pos) {

        sendTransferUpdatePacketToServer(transfer, pos.getX(), pos.getY(), pos.getZ());
    }

    private static void sendTransferUpdatePacketToServer(ITransferControl transfer, int x, int y, int z) {

        PacketHandler.sendToServer(getPacket(PacketTypes.TRANSFER_UPDATE).addCoords(x, y, z).addBool(transfer.getTransferIn()).addBool(transfer.getTransferOut()));
    }

    /* SECURITY */
    public static void sendSecurityPacketToServer(ISecurable securable) {

        PacketHandler.sendToServer(getPacket(PacketTypes.SECURITY_UPDATE).addByte(securable.getAccess().ordinal()));
    }

    public static void sendTabAugmentPacketToServer(boolean lock) {

        PacketHandler.sendToServer(getPacket(PacketTypes.TAB_AUGMENT).addBool(lock));
    }

    public static void sendTabSchematicPacketToServer() {

        PacketHandler.sendToServer(getPacket(PacketTypes.TAB_SCHEMATIC));
    }

    public static PacketCoFHBase getPacket(PacketTypes theType) {

        return new PacketTEBase().addByte(theType.ordinal());
    }

    @Override
    public void handlePacket(EntityPlayer player, boolean isServer) {

        try {
            int type = getByte();

            switch (PacketTypes.values()[type]) {
                case RS_POWER_UPDATE:
                    BlockPos pos = getCoords();
                    IRedstoneControl rs = (IRedstoneControl) player.worldObj.getTileEntity(pos);
                    rs.setPowered(getBool());
                    return;
                case RS_CONFIG_UPDATE:
                    pos = getCoords();
                    rs = (IRedstoneControl) player.worldObj.getTileEntity(pos);
                    rs.setControl(ControlMode.values()[getByte()]);
                    return;
                case TRANSFER_UPDATE:
                    pos = getCoords();
                    ITransferControl transfer = (ITransferControl) player.worldObj.getTileEntity(pos);
                    transfer.setTransferIn(getBool());
                    transfer.setTransferOut(getBool());
                case SECURITY_UPDATE:
                    if (player.openContainer instanceof ISecurable) {
                        ((ISecurable) player.openContainer).setAccess(AccessMode.values()[getByte()]);
                    }
                    return;
                case TAB_AUGMENT:
                    if (player.openContainer instanceof IAugmentableContainer) {
                        ((IAugmentableContainer) player.openContainer).setAugmentLock(getBool());
                    }
                    return;
                //				case CONFIG_SYNC:
                //					ThermalExpansion.instance.handleConfigSync(this);
                //					return;
                default:
                    Futopia.log.error("Unknown Packet! Internal: TEPH, ID: " + type);
            }
        } catch (Exception e) {
            Futopia.log.error("Packet payload failure! Please check your config files!");
            e.printStackTrace();
        }
    }

    //	public static void sendConfigSyncPacketToClient(EntityPlayer player) {
    //
    //		PacketHandler.sendTo(ThermalExpansion.instance.getConfigSync(), player);
    //	}

    public enum PacketTypes {
        RS_POWER_UPDATE, RS_CONFIG_UPDATE, TRANSFER_UPDATE, SECURITY_UPDATE, TAB_AUGMENT, TAB_SCHEMATIC, CONFIG_SYNC
    }

}
