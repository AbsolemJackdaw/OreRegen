package com.mcwizard111.oreregen.core.proxy;

import com.mcwizard111.oreregen.lib.Strings;
import com.mcwizard111.oreregen.tileentity.TileEntityDepletedOre;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityDepletedOre.class, Strings.DEPLETED_ORE_NAME);
	}
}
