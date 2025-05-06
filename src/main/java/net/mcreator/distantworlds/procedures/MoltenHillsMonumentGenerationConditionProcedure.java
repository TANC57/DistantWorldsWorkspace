package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class MoltenHillsMonumentGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return world.getBlockState(BlockPos.containing(x + 8, y - 1, z + 8)).canOcclude() && world.isEmptyBlock(BlockPos.containing(x + 8, y + 7, z + 8)) && world.isEmptyBlock(BlockPos.containing(x + 8, y + 15, z + 8)) && y < 90;
	}
}
