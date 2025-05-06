package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class WiltumTreeStructureAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double X = 0;
		double Z = 0;
		Z = z - 2;
		for (int index0 = 0; index0 < 5; index0++) {
			X = x - 2;
			for (int index1 = 0; index1 < 5; index1++) {
				if (!world.getBlockState(BlockPos.containing(X, y - 1, Z)).canOcclude()) {
					return false;
				}
				X = X + 1;
			}
			Z = Z + 1;
		}
		if (!(world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 3, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 4, z))
				&& world.isEmptyBlock(BlockPos.containing(x, y + 5, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 6, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 7, z)))) {
			return false;
		}
		if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("distant_worlds:dead_valley"))) {
			return false;
		}
		return true;
	}
}
