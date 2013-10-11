package com.mcwizard111.oreregen.tileentity;

import com.mcwizard111.oreregen.block.DepletedOre;
import com.mcwizard111.oreregen.block.ModBlocks;
import com.mcwizard111.oreregen.core.util.LogHelper;
import com.mcwizard111.oreregen.lib.BlockIds;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDepletedOre extends TileEntity {
	public int x, y, z;
	private int time;

	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
	}
	
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);
	}
	
	@Override
	public void updateEntity() {
		LogHelper.info("Meta: " + blockMetadata);
		if (blockMetadata == 0) {
			time = 20*20;
		}
		
		LogHelper.info(time);
		
		if (time <= 0) {
			worldObj.setBlock(xCoord, yCoord, zCoord, BlockIds.FULL_ORE, blockMetadata, 2);
		} else {
			time--;
		}
	}
}
