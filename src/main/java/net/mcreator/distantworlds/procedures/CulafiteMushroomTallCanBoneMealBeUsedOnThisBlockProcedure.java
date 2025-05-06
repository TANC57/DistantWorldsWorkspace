package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;

public class CulafiteMushroomTallCanBoneMealBeUsedOnThisBlockProcedure {
	public static boolean execute(BlockState blockstate) {
		return !((blockstate.getBlock().getStateDefinition().getProperty("half") instanceof EnumProperty _getep1 ? blockstate.getValue(_getep1).toString() : "").equals("upper"));
	}
}
