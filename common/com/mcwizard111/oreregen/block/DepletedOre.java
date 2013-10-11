package com.mcwizard111.oreregen.block;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.mcwizard111.oreregen.OreRegen;
import com.mcwizard111.oreregen.lib.Strings;
import com.mcwizard111.oreregen.tileentity.TileEntityDepletedOre;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DepletedOre extends BlockContainer {
	public DepletedOre(int id) {
		super(id, Material.rock);
		setUnlocalizedName(Strings.DEPLETED_ORE_NAME);
		setCreativeTab(OreRegen.tabOre);
		this.setHardness(10f);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("oreregen:depleted_ore");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityDepletedOre();
	}
}
