package com.mcwizard111.oreregen.block;

import com.mcwizard111.oreregen.lib.BlockIds;
import com.mcwizard111.oreregen.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {
	public static Block fullOre;
	public static Block depletedOre;
	
	public static void init() {
		fullOre = new FullOre(BlockIds.FULL_ORE);
		depletedOre = new DepletedOre(BlockIds.DEPLETE_ORE);
		
		GameRegistry.registerBlock(fullOre, Strings.FULL_ORE_NAME);
		GameRegistry.registerBlock(depletedOre, Strings.DEPLETED_ORE_NAME);
		
		initBlockRecipes();
	}
	
	private static void initBlockRecipes() {
		
	}
}
