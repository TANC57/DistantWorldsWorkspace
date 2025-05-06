package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class GarhennaLoadingTerrainReturnBiomeNameProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		String biome = "";
		if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("distant_worlds:burning_plains"))) {
			biome = Component.translatable("biome.distant_worlds.burning_plains").getString();
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("distant_worlds:dead_valley"))) {
			biome = Component.translatable("gui.distant_worlds.garhenna_loading_terrain_overlay.dead_valley").getString();
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("distant_worlds:molten_hills"))) {
			biome = Component.translatable("biome.distant_worlds.molten_hills").getString();
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("distant_worlds:sticky_marshes"))) {
			biome = Component.translatable("biome.distant_worlds.sticky_marshes").getString();
		}
		return (Component.translatable("gui.distant_worlds.garhenna_loading_terrain_overlay.welcome").getString()).replace("<biome>", biome);
	}
}
