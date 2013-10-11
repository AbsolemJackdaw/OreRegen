package com.mcwizard111.oreregen.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabOre extends CreativeTabs {
	public CreativeTabOre(int tabID, String tabLabel) {
		super(tabID, tabLabel);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return Item.coal.itemID;
	}
}
