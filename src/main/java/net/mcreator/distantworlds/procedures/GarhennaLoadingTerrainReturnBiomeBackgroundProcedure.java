package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GarhennaLoadingTerrainReturnBiomeBackgroundProcedure {
	public static double execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return 0;
		if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("distant_worlds:molten_hills"))) {
			return 1;
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("distant_worlds:burning_plains"))) {
			return 2;
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("distant_worlds:sticky_marshes"))) {
			return 3;
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("distant_worlds:dead_valley"))) {
			return 4;
		}
		return 0;
	}
}
