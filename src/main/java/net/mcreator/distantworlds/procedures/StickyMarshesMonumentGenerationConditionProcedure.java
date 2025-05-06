package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class StickyMarshesMonumentGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return world.getBlockState(BlockPos.containing(x + 5, y - 1, z + 5)).canOcclude() && world.isEmptyBlock(BlockPos.containing(x + 5, y + 8, z + 5)) && world.isEmptyBlock(BlockPos.containing(x + 5, y + 17, z + 5))
				&& world.getBiome(BlockPos.containing(x + 5, y, z + 5)).is(new ResourceLocation("distant_worlds:sticky_marshes")) && y < 90;
	}
}
