package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;
import net.mcreator.distantworlds.init.DistantWorldsModItems;

public class WitherTotemRightclickedProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double yTarget = 0;
		if (!(entity instanceof Player _plrCldCheck0 && _plrCldCheck0.getCooldowns().isOnCooldown(DistantWorldsModItems.WITHER_TOTEM.get()))
				&& !(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get()))) {
			if (entity.isShiftKeyDown()) {
				if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("distant_worlds:garhenna")))) {
					if (y > -64 && y <= 256 && false && false) {
						{
							double _setval = Math.floor(x);
							entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WitherTotemX = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = y;
							entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WitherTotemY = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = Math.floor(z);
							entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WitherTotemZ = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("\u00A76" + Component.translatable("event.distant_worlds.target_point_new").getString())), true);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof Player _player)
								_player.getCooldowns().addCooldown(DistantWorldsModItems.WITHER_TOTEM.get(), 200);
							if (entity instanceof Player _player)
								_player.getCooldowns().addCooldown(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get(), 200);
						} else {
							if (entity instanceof Player _player)
								_player.getCooldowns().addCooldown(DistantWorldsModItems.WITHER_TOTEM.get(), 40);
							if (entity instanceof Player _player)
								_player.getCooldowns().addCooldown(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get(), 40);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("\u00A76" + Component.translatable("event.distant_worlds.target_point_failure").getString())), true);
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A76" + Component.translatable("event.distant_worlds.target_point_failure").getString())), true);
				}
			}
		}
	}
}
