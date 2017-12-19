package com.sci.torcherino.init;

import java.util.HashMap;
import java.util.Map;

import com.sci.torcherino.block.BlockCompressedTorcherino;
import com.sci.torcherino.block.BlockDoubleCompresedTorcherino;
import com.sci.torcherino.block.BlockTorcherino;
import com.sci.torcherino.tile.TileCompressedTorcherino;
import com.sci.torcherino.tile.TileTorcherino;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder("Torcherino")
public final class ModBlocks {
	
	@GameRegistry.ObjectHolder("torcherino:torcherino")
    public static BlockTorcherino torcherino;
	
	@GameRegistry.ObjectHolder("torcherino:compressed_torcherino")
	public static BlockCompressedTorcherino compressedTorcherino;
	
	@GameRegistry.ObjectHolder("torcherino:dCompressed_torcherino")
    public static BlockDoubleCompresedTorcherino doubleCompressedTorcherino;

    private static Map<String, ItemBlock> remap = new HashMap<String, ItemBlock>();

    public static void init() {
       //ModBlocks.remap.put("torcherino:tile.torcherino", (ItemBlock) Item.getItemFromBlock(ModBlocks.torcherino));
       //ModBlocks.remap.put("torcherino:tile.compressed_torcherino", (ItemBlock) Item.getItemFromBlock(ModBlocks.compressedTorcherino));
       //ModBlocks.remap.put("torcherino:tile.double_compressed_torcherino", (ItemBlock) Item.getItemFromBlock(ModBlocks.doubleCompressedTorcherino));
    }
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	torcherino.initModel();
    	compressedTorcherino.initModel();
    	doubleCompressedTorcherino.initModel();
    }
    
    /*
    public static void handleMissingMappings(RegistryEvent.MissingMappings<Item> event) {
        for (RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getMappings()) {
            if (ModBlocks.remap.containsKey(mapping.id)) {
            	mapping.remap(ModBlocks.remap.get(mapping.id));
            }
        }
    }
	*/


    private ModBlocks() {
    }
}