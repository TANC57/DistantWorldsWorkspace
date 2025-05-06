package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GarhennaLoadingTerrainReturnBiomeDisplayProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		String biome = "";
		return world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("distant_worlds:burning_plains"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("distant_worlds:dead_valley"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("distant_worlds:molten_hills"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("distant_worlds:sticky_marshes"));
	}
}
