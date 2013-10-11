package com.mcwizard111.oreregen;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;

import com.mcwizard111.oreregen.block.ModBlocks;
import com.mcwizard111.oreregen.configuration.ConfigurationHandler;
import com.mcwizard111.oreregen.core.proxy.CommonProxy;
import com.mcwizard111.oreregen.core.util.LogHelper;
import com.mcwizard111.oreregen.creativetab.CreativeTabOre;
import com.mcwizard111.oreregen.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME)
public class OreRegen {
	@Instance(Reference.MOD_ID)
	public static OreRegen instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static CreativeTabs tabOre = new CreativeTabOre(CreativeTabs.getNextID(), Reference.MOD_ID);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LogHelper.init();
		ConfigurationHandler.init(new File(event.getModConfigurationDirectory() + File.separator + Reference.MOD_ID + File.separator + Reference.MOD_ID + ".cfg"));
		
		proxy.registerTileEntities();
		
		ModBlocks.init();
	}
}
