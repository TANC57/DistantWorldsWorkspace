package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;
import net.mcreator.distantworlds.init.DistantWorldsModMobEffects;

public class WiltumCocktailPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion > 0) {
			{
				double _setval = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion > 1000
						? (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion - 1000
						: 0;
				entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GarhennaDepletion = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(DistantWorldsModMobEffects.SUPPRESSION.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(DistantWorldsModMobEffects.SUPPRESSION.get());
			if (!(entity instanceof ServerPlayer _plr2 && _plr2.level() instanceof ServerLevel && _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:antidote"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:antidote"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.POISON)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.POISON);
		}
	}
}
