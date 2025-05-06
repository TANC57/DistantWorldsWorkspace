package net.mcreator.distantworlds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;
import net.mcreator.distantworlds.init.DistantWorldsModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnPlayerTickUpdateProcedureProcedure {
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
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity) || new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("distant_worlds:garhenna")))
					&& !(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(DistantWorldsModMobEffects.GARHENNA_IMMUNITY.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(DistantWorldsModMobEffects.GARHENNA_DEPLETION.get(), 20, 0, false, false));
			}
		}
		if ((!(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(DistantWorldsModMobEffects.GARHENNA_DEPLETION.get())) || entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(DistantWorldsModMobEffects.GARHENNA_IMMUNITY.get()))
				&& (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion > 0) {
			{
				double _setval = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion
						- (1 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DistantWorldsModMobEffects.GARHENNA_IMMUNITY.get()) ? _livEnt.getEffect(DistantWorldsModMobEffects.GARHENNA_IMMUNITY.get()).getAmplifier() : 0));
				entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GarhennaDepletion = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion > 20000) {
			{
				double _setval = 20000;
				entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GarhennaDepletion = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion < 0) {
			{
				double _setval = 0;
				entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GarhennaDepletion = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaAdaptation >= 5
				&& (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).PermanentGarhennaImmunity < 5) {
			{
				double _setval = 0;
				entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GarhennaAdaptation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).PermanentGarhennaImmunity + 1;
				entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PermanentGarhennaImmunity = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaAdaptation < 0) {
			{
				double _setval = 0;
				entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GarhennaAdaptation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).PermanentGarhennaImmunity < 0) {
			{
				double _setval = 0;
				entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PermanentGarhennaImmunity = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
