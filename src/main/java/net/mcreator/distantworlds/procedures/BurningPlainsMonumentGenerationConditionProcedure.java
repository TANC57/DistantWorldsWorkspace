package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BurningPlainsMonumentGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return world.getBlockState(BlockPos.containing(x + 7, y - 1, z + 7)).canOcclude() && world.isEmptyBlock(BlockPos.containing(x + 7, y + 7, z + 7)) && world.isEmptyBlock(BlockPos.containing(x + 7, y + 14, z + 7)) && y < 90;
	}
}
