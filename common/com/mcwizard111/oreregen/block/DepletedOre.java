package com.mcwizard111.oreregen.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.mcwizard111.oreregen.OreRegen;
import com.mcwizard111.oreregen.lib.Reference;
import com.mcwizard111.oreregen.lib.Strings;
import com.mcwizard111.oreregen.tileentity.TileEntityDepletedOre;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DepletedOre extends BlockContainer {
	private Icon[] icons;

	public DepletedOre(int id) {
		super(id, Material.rock);
		setUnlocalizedName(Strings.DEPLETED_ORE_NAME);
		setCreativeTab(OreRegen.tabOre);
		this.setHardness(10f);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		//blockIcon = iconRegister.registerIcon("oreregen:depleted_ore");
		
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

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityDepletedOre();
	}
	
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(this, 1, 0));
		par3List.add(new ItemStack(this, 1, 1));
	}
	
	@Override
	public int idDropped(int metadata, Random par2Random, int fortune) {
		return Block.cobblestone.blockID;
	}
}
