package net.mcreator.distantworlds.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;
import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

public class UseWitherTotemOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double yTarget = 0;
		double zTarget = 0;
		double xTarget = 0;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get(), lv).isPresent() : false) {
			if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(DistantWorldsModItems.WITHER_TOTEM.get()))
					&& !(entity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get()))) {
				if (entity.isShiftKeyDown()) {
					if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("distant_worlds:garhenna")))) {
						if (y > -64 && y <= 256 && !world.getBlockState(BlockPos.containing(x, y, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
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
							if (entity instanceof LivingEntity lv) {
								CuriosApi.getCuriosHelper().findCurios(lv, DistantWorldsModItems.CHARGED_WITHER_TOTEM.get()).forEach(item -> {
									ItemStack itemstackiterator = item.stack();
									if (!(entity instanceof Player _plrCldCheck11 && _plrCldCheck11.getCooldowns().isOnCooldown(DistantWorldsModItems.WITHER_TOTEM.get()))
											&& !(entity instanceof Player _plrCldCheck12 && _plrCldCheck12.getCooldowns().isOnCooldown(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get()))) {
										if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
											if (entity instanceof Player _player)
												_player.getCooldowns().addCooldown(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get(), 200);
											if (entity instanceof Player _player)
												_player.getCooldowns().addCooldown(DistantWorldsModItems.WITHER_TOTEM.get(), 200);
										} else {
											if (entity instanceof Player _player)
												_player.getCooldowns().addCooldown(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get(), 40);
											if (entity instanceof Player _player)
												_player.getCooldowns().addCooldown(DistantWorldsModItems.WITHER_TOTEM.get(), 40);
										}
									}
								});
							}
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("\u00A76" + Component.translatable("event.distant_worlds.target_point_failure").getString())), true);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("\u00A76" + Component.translatable("event.distant_worlds.target_point_failure").getString())), true);
					}
				} else {
					if ((entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) && !((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("distant_worlds:garhenna"))))
							|| ((entity.level().dimension()) == Level.NETHER || ConfigCommonConfiguration.REQUIRE_DIMENSION.get() == false)
									&& (entity.getY() <= Math.abs((double) ConfigCommonConfiguration.GARHENNA_TELEPORTATION_HEIGHT.get()) || (double) ConfigCommonConfiguration.GARHENNA_TELEPORTATION_HEIGHT.get() == 0)) {
						if (entity instanceof LivingEntity lv) {
							CuriosApi.getCuriosHelper().findCurios(lv, DistantWorldsModItems.CHARGED_WITHER_TOTEM.get()).forEach(item -> {
								ItemStack itemstackiterator = item.stack();
								if (!(entity instanceof Player _plrCldCheck34 && _plrCldCheck34.getCooldowns().isOnCooldown(DistantWorldsModItems.WITHER_TOTEM.get()))
										&& !(entity instanceof Player _plrCldCheck35 && _plrCldCheck35.getCooldowns().isOnCooldown(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get()))) {
									if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
										if (entity instanceof Player _player)
											_player.getCooldowns().addCooldown(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get(), 100);
										if (entity instanceof Player _player)
											_player.getCooldowns().addCooldown(DistantWorldsModItems.WITHER_TOTEM.get(), 100);
									} else {
										if (entity instanceof Player _player)
											_player.getCooldowns().addCooldown(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get(), 40);
										if (entity instanceof Player _player)
											_player.getCooldowns().addCooldown(DistantWorldsModItems.WITHER_TOTEM.get(), 40);
									}
									if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
										itemstackiterator.shrink(1);
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(DistantWorldsModItems.WITHER_TOTEM.get());
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
								}
							});
						}
						if (!(entity instanceof Player _plrCldCheck46 && _plrCldCheck46.getCooldowns().isOnCooldown(DistantWorldsModItems.RETURN_RING.get()))) {
							if (entity instanceof Player _player)
								_player.getCooldowns().addCooldown(DistantWorldsModItems.RETURN_RING.get(), 40);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.FLAME, (entity.getX()), (entity.getY() + 0.5), (entity.getZ()), 3, 0.2, 0.5, 0.2, 0.02);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMALL_FLAME, (entity.getX()), (entity.getY() + 0.5), (entity.getZ()), 5, 0.2, 0.5, 0.2, 0.02);
						entity.fallDistance = 0;
						if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("distant_worlds:garhenna"));
							if (_player.level().dimension() == destinationType)
								return;
							ServerLevel nextLevel = _player.server.getLevel(destinationType);
							if (nextLevel != null) {
								_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
								_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
								for (MobEffectInstance _effectinstance : _player.getActiveEffects())
									_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
								_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
						if (world instanceof ServerLevel _origLevel) {
							LevelAccessor _worldorig = world;
							world = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("distant_worlds:garhenna")));
							if (world != null) {
								xTarget = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).WitherTotemY <= -64
										&& (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).WitherTotemX == 0
												? (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).WitherTotemX + -8
														+ Mth.nextInt(RandomSource.create(), 0, 16)
												: (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).WitherTotemX;
								zTarget = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).WitherTotemY <= -64
										&& (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).WitherTotemZ == 0
												? (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).WitherTotemZ + -8
														+ Mth.nextInt(RandomSource.create(), 0, 16)
												: (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).WitherTotemZ;
								yTarget = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).WitherTotemY <= -64
										|| world.getBlockState(
												BlockPos.containing(xTarget, (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).WitherTotemY, zTarget))
												.canOcclude()
										|| world.getBlockState(
												BlockPos.containing(xTarget, (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).WitherTotemY + 1, zTarget))
												.canOcclude()
														? world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xTarget, (int) zTarget)
														: (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).WitherTotemY;
								{
									Entity _ent = entity;
									_ent.teleportTo((xTarget + 0.5), yTarget, (zTarget + 0.5));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((xTarget + 0.5), yTarget, (zTarget + 0.5), _ent.getYRot(), _ent.getXRot());
								}
								entity.setDeltaMovement(new Vec3(0, 0, 0));
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.FLAME, (entity.getX()), (entity.getY() + 0.5), (entity.getZ()), 3, 0.2, 0.5, 0.2, 0.02);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.SMALL_FLAME, (entity.getX()), (entity.getY() + 0.5), (entity.getZ()), 5, 0.2, 0.5, 0.2, 0.02);
							}
							world = _worldorig;
						}
					} else {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, (entity.getX()), (entity.getY() + 0.5), (entity.getZ()), 3, 0.2, 0.5, 0.2, 0.02);
					}
				}
			}
		}
	}
}
