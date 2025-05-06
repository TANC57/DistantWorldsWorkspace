package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class TreeTowerGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return world.getBlockState(BlockPos.containing(x + 3, y - 1, z + 3)).canOcclude() && world.isEmptyBlock(BlockPos.containing(x + 3, y + 8, z + 3)) && world.isEmptyBlock(BlockPos.containing(x + 3, y + 16, z + 3)) && y < 90;
	}
}
