package com.sci.torcherino.proxy;

import com.sci.torcherino.Torcherino;
import com.sci.torcherino.block.BlockCompressedTorcherino;
import com.sci.torcherino.block.BlockDoubleCompresedTorcherino;
import com.sci.torcherino.block.BlockTorcherino;
import com.sci.torcherino.init.ModBlocks;
import com.sci.torcherino.tile.TileCompressedTorcherino;
import com.sci.torcherino.tile.TileDoubleCompressedTorcherino;
import com.sci.torcherino.tile.TileTorcherino;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

@Mod.EventBusSubscriber
public abstract class CommonProxy {
    
    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	
    	ModBlocks.torcherino = new BlockTorcherino();
    	ModBlocks.compressedTorcherino = new BlockCompressedTorcherino();
    	ModBlocks.doubleCompressedTorcherino = new BlockDoubleCompresedTorcherino();
    	
    	ModBlocks.torcherino.setRegistryName("torcherino");
    	ModBlocks.compressedTorcherino.setRegistryName("compressed_torcherino");
    	ModBlocks.doubleCompressedTorcherino.setRegistryName("double_compressed_torcherino");
    	
    	event.getRegistry().register(ModBlocks.torcherino);
    	GameRegistry.registerTileEntity(TileTorcherino.class, "torcherino_tile");

    	event.getRegistry().register(ModBlocks.compressedTorcherino);
    	GameRegistry.registerTileEntity(TileCompressedTorcherino.class, "compressed_torcherino_tile");

    	event.getRegistry().register(ModBlocks.doubleCompressedTorcherino);
    	GameRegistry.registerTileEntity(TileDoubleCompressedTorcherino.class, "double_compressed_torcherino_tile");
    }
    
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	event.getRegistry().register(new ItemBlock(ModBlocks.torcherino).setRegistryName("torcherino:torcherino"));
    	event.getRegistry().register(new ItemBlock(ModBlocks.compressedTorcherino).setRegistryName("torcherino:compressed_torcherino"));
    	event.getRegistry().register(new ItemBlock(ModBlocks.doubleCompressedTorcherino).setRegistryName("torcherino:double_compressed_torcherino"));
    }
    
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    	ModBlocks.initModels();
    }
    
    /*
    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event){
    	if(!Torcherino.compressedTorcherino){
        	ResourceLocation recipe = new ResourceLocation("torcherino:compressed_torcherino");
        	IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
        	modRegistry.remove(recipe);

    	}
    }
    */
        
}