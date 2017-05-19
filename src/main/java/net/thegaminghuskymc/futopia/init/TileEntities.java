/*
 * This file is part of Blue Power.
 *
 *     Blue Power is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Blue Power is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Blue Power.  If not, see <http://www.gnu.org/licenses/>
 */

package net.thegaminghuskymc.futopia.init;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.tile.tier1.ModTileEntity;
import net.thegaminghuskymc.futopia.tile.tier1.TileAlloyFurnace;

public class TileEntities {

    /**
     * Method to register the TE's to the game. If a TE is not registered, it
     * _will_ cause issues!
     */
    public static void init() {

        GameRegistry.registerTileEntity(TileAlloyFurnace.class, "alloyFurnace");
        GameRegistry.registerTileEntity(ModTileEntity.class, "tutorial_tile_entity");
    }
}
