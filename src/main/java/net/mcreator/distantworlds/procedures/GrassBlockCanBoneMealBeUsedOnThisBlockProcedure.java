package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GrassBlockCanBoneMealBeUsedOnThisBlockProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return world.isEmptyBlock(BlockPos.containing(x, y + 1, z));
	}
}
