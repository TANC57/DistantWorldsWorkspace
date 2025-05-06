package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;
import net.mcreator.distantworlds.init.DistantWorldsModMobEffects;
import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

public class GarhennaDepletionOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double MaxDepletion = 0;
		if (entity instanceof Player) {
			MaxDepletion = (double) ConfigCommonConfiguration.MAX_GARHENNA_DEPLETION.get() >= 1200 ? (double) ConfigCommonConfiguration.MAX_GARHENNA_DEPLETION.get() : 1200;
			if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion < MaxDepletion && (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
					}
					return false;
				}
			}.checkGamemode(entity)) && !(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(DistantWorldsModMobEffects.GARHENNA_IMMUNITY.get())) && !ConfigCommonConfiguration.DISABLE_GARHENNA_DEPLETION.get()) {
				if (Mth.nextInt(RandomSource.create(), 2, (int) (2 + (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).PermanentGarhennaImmunity)) <= 2) {
					{
						double _setval = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion + 1
								+ (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DistantWorldsModMobEffects.GARHENNA_DEPLETION.get()) ? _livEnt.getEffect(DistantWorldsModMobEffects.GARHENNA_DEPLETION.get()).getAmplifier() : 0);
						entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.GarhennaDepletion = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion > MaxDepletion) {
				{
					double _setval = MaxDepletion;
					entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.GarhennaDepletion = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
