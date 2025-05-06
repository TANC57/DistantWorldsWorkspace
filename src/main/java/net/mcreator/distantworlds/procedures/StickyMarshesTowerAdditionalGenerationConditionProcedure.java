package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class StickyMarshesTowerAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return world.getBlockState(BlockPos.containing(x + 2, y - 1, z + 2)).canOcclude() && world.isEmptyBlock(BlockPos.containing(x + 2, y + 6, z + 2)) && world.isEmptyBlock(BlockPos.containing(x + 2, y + 12, z + 2))
				&& world.getBiome(BlockPos.containing(x + 2, y, z + 2)).is(new ResourceLocation("distant_worlds:sticky_marshes")) && y < 90;
	}
}
