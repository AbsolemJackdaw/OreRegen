package com.mcwizard111.oreregen.tileentity;

import com.mcwizard111.oreregen.block.DepletedOre;
import com.mcwizard111.oreregen.block.ModBlocks;
import com.mcwizard111.oreregen.core.util.LogHelper;
import com.mcwizard111.oreregen.lib.BlockIds;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDepletedOre extends TileEntity {
	public int x, y, z;
	private final int time;
	
	public TileEntityDepletedOre(int meta){
		
		switch(meta){
			
			case 0 : 
				time = (1*20)*60; // 1 minute
				break;
				default:
				time = (20*20)*60; // default 20 minutes. 
				
		}
	}

	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		
		nbtTagCompound.setInteger("regenCountDown", time)
	}
	
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);
	}
	
	@Override
	public void updateEntity() {
		LogHelper.info("Meta: " + blockMetadata);
		
		LogHelper.info(time);
		
		if (time <= 0) {
			worldObj.setBlock(xCoord, yCoord, zCoord, BlockIds.FULL_ORE, blockMetadata, 2);
			// remove this tile entity too ! 
		} else {
			time--;
		}
	}
}
