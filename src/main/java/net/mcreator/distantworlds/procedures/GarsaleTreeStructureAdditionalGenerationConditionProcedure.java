package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GarsaleTreeStructureAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double X = 0;
		double Z = 0;
		return world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("distant_worlds:sticky_marshes")) && world.getBiome(BlockPos.containing(x + 2, y, z)).is(new ResourceLocation("distant_worlds:sticky_marshes"))
				&& world.getBiome(BlockPos.containing(x - 2, y, z)).is(new ResourceLocation("distant_worlds:sticky_marshes")) && world.getBiome(BlockPos.containing(x, y, z + 2)).is(new ResourceLocation("distant_worlds:sticky_marshes"))
				&& world.getBiome(BlockPos.containing(x, y, z - 2)).is(new ResourceLocation("distant_worlds:sticky_marshes"));
	}
}
