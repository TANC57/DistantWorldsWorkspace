package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class DeadValleyMonumentGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return world.getBlockState(BlockPos.containing(x + 6, y - 1, z + 6)).canOcclude() && world.isEmptyBlock(BlockPos.containing(x + 6, y + 6, z + 6)) && world.isEmptyBlock(BlockPos.containing(x + 6, y + 13, z + 6)) && y < 90;
	}
}
