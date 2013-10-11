package com.mcwizard111.oreregen.tileentity;

import com.mcwizard111.oreregen.block.DepletedOre;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDepletedOre extends TileEntity {
	public int x, y, z;

	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
	}
	
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		
	}
	
	@Override
	public void updateEntity() {
		
	}
}
