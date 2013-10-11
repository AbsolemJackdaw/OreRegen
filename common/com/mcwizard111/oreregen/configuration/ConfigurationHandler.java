package com.mcwizard111.oreregen.configuration;

import java.io.File;
import java.util.logging.Level;

import com.mcwizard111.oreregen.lib.BlockIds;
import com.mcwizard111.oreregen.lib.Reference;
import com.mcwizard111.oreregen.lib.Strings;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.Configuration;

public class ConfigurationHandler {
	public static Configuration config;
	
	public static void init(File configFile) {
		config = new Configuration(configFile);
		
		try {
			config.load();
			
			BlockIds.FULL_ORE = config.getBlock(Strings.FULL_ORE_NAME, BlockIds.FULL_ORE_DEFAULT).getInt(BlockIds.FULL_ORE_DEFAULT);
			BlockIds.DEPLETE_ORE = config.getBlock(Strings.DEPLETED_ORE_NAME, BlockIds.DEPLETE_ORE).getInt(BlockIds.DELPLETE_ORE_DEFAULT);
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its configuration");
		} finally {
			config.save();
		}
	}
	
	public static void set(String categoryName, String propertyName, String newValue) {
		config.load();
		
		if (config.getCategoryNames().contains(categoryName)) {
			if (config.getCategory(categoryName).containsKey(propertyName)) {
				config.getCategory(categoryName).get(propertyName).set(newValue);
			}
		}
		
		config.save();
	}
}
