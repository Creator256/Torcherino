package com.sci.torcherino;

import com.sci.torcherino.init.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabHandler {

	public static CreativeTabs tabBlocks = new CreativeTabs("torcherino"){
		public ItemStack getTabIconItem(){
			return new ItemStack(Item.getItemFromBlock(ModBlocks.torcherino));
		}
	};
	
}
