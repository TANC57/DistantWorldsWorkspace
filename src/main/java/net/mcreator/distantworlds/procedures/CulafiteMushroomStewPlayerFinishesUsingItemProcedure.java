package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;
import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

public class CulafiteMushroomStewPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion < (double) ConfigCommonConfiguration.MAX_GARHENNA_DEPLETION.get()) {
				{
					double _setval = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion < (double) ConfigCommonConfiguration.MAX_GARHENNA_DEPLETION.get() - 500
									? (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion + 500
									: 20000;
					entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.GarhennaDepletion = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
