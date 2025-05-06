package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class HelystStalagmiteAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return y < 60 && world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("distant_worlds:dead_valley"));
	}
}
