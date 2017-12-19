package com.sci.torcherino.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;
import com.sci.torcherino.Torcherino;

import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class DoubleCondition implements IConditionFactory {
	
	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json)
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);

		return() -> Torcherino.doubleCompressedTorcherino == value;


	}
}
