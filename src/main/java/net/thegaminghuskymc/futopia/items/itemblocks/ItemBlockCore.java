// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ItemBlockCore.java

package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.utils.StringHelper;

public class ItemBlockCore extends ItemBlock
{

    public ItemBlockCore(Block block)
    {
        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
        setNoRepair();
    }

    public String getItemStackDisplayName(ItemStack stack)
    {
        return StringHelper.localize(getUnlocalizedName(stack));
    }

    public int getMetadata(int i)
    {
        return i;
    }

    /*public boolean hasCustomEntity(ItemStack stack)
    {
        return SecurityHelper.isSecure(stack);
    }*/

    public boolean isItemTool(ItemStack stack)
    {
        return false;
    }

    /*public Entity createEntity(World world, Entity location, ItemStack stack)
    {
        if(SecurityHelper.isSecure(stack))
        {
            location.invulnerable = true;
            location.isImmuneToFire = true;
            ((EntityItem)location).lifespan = 0x7fffffff;
        }
        return null;
    }

    public FontRenderer getFontRenderer(ItemStack stack)
    {
        return FontRendererCore.loadFontRendererStack(stack);
    }*/
}
