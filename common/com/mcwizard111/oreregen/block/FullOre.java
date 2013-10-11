package com.mcwizard111.oreregen.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.mcwizard111.oreregen.OreRegen;
import com.mcwizard111.oreregen.core.util.LogHelper;
import com.mcwizard111.oreregen.lib.BlockIds;
import com.mcwizard111.oreregen.lib.Reference;
import com.mcwizard111.oreregen.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FullOre extends Block {
	private Icon[] icons;

	public FullOre(int id) {
		super(id, Material.rock);
		setUnlocalizedName(Strings.FULL_ORE_NAME);
		setCreativeTab(OreRegen.tabOre);
		this.setHardness(3f);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		//blockIcon = iconRegister.registerIcon("minecraft:coal_ore");
		
		icons = new Icon[2];
		
		for (int i = 0; i < icons.length; i++) {
			icons[i] = iconRegister.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return icons[par2];
	}
	
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata) {
		int type = world.getBlockMetadata(x, y, z);
		world.setBlock(x, y, z, BlockIds.DEPLETE_ORE, type, 2);
	}
	
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(this, 1, 0));
		par3List.add(new ItemStack(this, 1, 1));
	}
	
	@Override
	public int idDropped(int metadata, Random par2Random, int fortune) {
		LogHelper.info("metadata: " + metadata);
		if (metadata == 0) {
			return Item.coal.itemID;
		} else if (metadata == 1) {
			return Block.oreIron.blockID;
		} else {
			return 0;
		}
	}
}
