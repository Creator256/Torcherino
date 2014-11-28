package com.sci.torcherino.tile;

import com.sci.torcherino.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

/**
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileTorcherino extends TileEntity
{
    private static final String[] MODES = new String[]{"Stopped", "Radius: +1, Area: 3x3x3", "Radius: +2, Area: 5x3x5", "Radius: +3, Area: 7x3x7", "Radius: +4, Area: 9x3x9"};
    private static final String[] SPEEDS = new String[]{"Stopped", "100% increase", "200% increase", "300% increase", "400% increase"};

    private boolean isActive;
    private byte speed;
    private byte mode;
    private byte cachedMode;
    private Box box;
    private Random rand;

    public TileTorcherino()
    {
        this.isActive = true;
        this.cachedMode = -1;
        this.rand = new Random();
    }

    @Override
    public void updateEntity()
    {
        if (this.worldObj.isRemote)
            return;

        if (this.cachedMode != this.mode)
        {
            this.box = new Box(this.xCoord - this.mode, this.yCoord - 1, this.zCoord - mode, this.xCoord + mode, this.yCoord + 1, this.zCoord + mode);
            this.cachedMode = this.mode;
        }

        if (!this.isActive || this.mode == 0 || this.speed == 0)
            return;

        for (int x = this.box.xMin; x <= this.box.xMax; x++)
        {
            for (int y = this.box.yMin; y <= this.box.yMax; y++)
            {
                for (int z = this.box.zMin; z <= this.box.zMax; x++)
                {
                    final Block block = this.worldObj.getBlock(x, y, z);

                    if (block == Blocks.air || block == ModBlocks.torcherino)
                        continue;

                    if (block.getTickRandomly())
                    {
                        for (int i = 0; i < this.speed; i++)
                            block.updateTick(this.worldObj, x, y, z, this.rand);
                    }

                    final TileEntity tile = this.worldObj.getTileEntity(x, y, z);

                    if (tile != null && !(tile instanceof TileTorcherino) && !tile.isInvalid())
                    {
                        for (int i = 0; i < this.speed; i++)
                            tile.updateEntity();
                    }
                }
            }
        }
    }

    public void setActive(boolean active)
    {
        this.isActive = active;
    }

    public void changeMode(boolean sneaking)
    {
        if (sneaking)
        {
            if (this.speed < SPEEDS.length - 1)
                this.speed++;
            else
                this.speed = 0;
        }
        else
        {
            if (this.mode < MODES.length - 1)
                this.mode++;
            else
                this.mode = 0;
        }
    }

    public String getSpeedDescription()
    {
        return SPEEDS[this.speed];
    }

    public String getModeDescription()
    {
        return MODES[this.mode];
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setByte("Speed", speed);
        nbt.setByte("Mode", mode);
        nbt.setBoolean("IsActive", isActive);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.speed = nbt.getByte("Speed");
        this.mode = nbt.getByte("Mode");
        this.isActive = nbt.getBoolean("IsActive");
    }

    public class Box
    {
        public int xMin;
        public int yMin;
        public int zMin;
        public int xMax;
        public int yMax;
        public int zMax;

        public Box(int xMin, int yMin, int zMin, int xMax, int yMax, int zMax)
        {
            this.xMin = xMin;
            this.yMin = yMin;
            this.zMin = zMin;
            this.xMax = xMax;
            this.yMax = yMax;
            this.zMax = zMax;
        }
    }
}