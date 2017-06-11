package net.thegaminghuskymc.futopia.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCore extends Block
{

    public BlockCore(Material material)
    {
        this(material, "futopia");
    }

    public BlockCore(Material material, String modName)
    {
        super(material);
        this.modName = modName;
    }

    public Block setUnlocalizedName(String name)
    {
        this.name = name;
        name = (new StringBuilder()).append(modName).append(".").append(name).toString();
        return super.setUnlocalizedName(name);
    }

    protected String modName;
    protected String name;
}
