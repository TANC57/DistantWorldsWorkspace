package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class GarhennaLoadingTerrainDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("distant_worlds:garhenna")));
	}
}
