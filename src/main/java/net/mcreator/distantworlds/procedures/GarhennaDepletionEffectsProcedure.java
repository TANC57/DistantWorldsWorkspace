package net.mcreator.distantworlds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;
import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GarhennaDepletionEffectsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double MaxDepletion = 0;
		if (entity.tickCount % 5 == 0) {
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0
					&& (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion > 0) {
				MaxDepletion = (double) ConfigCommonConfiguration.MAX_GARHENNA_DEPLETION.get() >= 1200 ? (double) ConfigCommonConfiguration.MAX_GARHENNA_DEPLETION.get() : 1200;
				if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion >= MaxDepletion * 0.25) {
					if (entity.tickCount % 80 == 0) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 90, 2, true, true));
					}
				}
				if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion >= MaxDepletion * 0.5) {
					if (entity.tickCount % 80 == 0) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 90, 1, true, true));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 90, 0, true, true));
					}
				}
				if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion >= MaxDepletion * 0.75) {
					if (entity.tickCount % 80 == 0) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 90, 0, true, true));
					}
				}
				if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion >= MaxDepletion) {
					if (entity.isAlive()) {
						entity.kill();
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.death_message.lost_in_another_world").getString())), false);
					}
				}
			}
		}
	}
}
