package com.sci.torcherino.block;

import com.sci.torcherino.CreativeTabHandler;
import com.sci.torcherino.tile.TileDoubleCompressedTorcherino;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class BlockDoubleCompresedTorcherino extends BlockTorcherino {
    public BlockDoubleCompresedTorcherino() {
       setUnlocalizedName("torcherino.double_compressed_torcherino");
       setCreativeTab(CreativeTabHandler.tabBlocks);
       //setCreativeTab(CreativeTabs.MISC);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
    
    @Override
    public TileEntity createNewTileEntity(final World world, final int i) {
        return new TileDoubleCompressedTorcherino();
    }
}