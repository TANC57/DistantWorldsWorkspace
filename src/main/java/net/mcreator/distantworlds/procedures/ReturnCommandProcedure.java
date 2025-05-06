package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;

import java.util.List;
import java.util.Comparator;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class ReturnCommandProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		Entity TargetEntity = null;
		boolean TamedEntities = false;
		double yTarget = 0;
		double zTarget = 0;
		double xTarget = 0;
		TargetEntity = new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "target");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity();
		TamedEntities = BoolArgumentType.getBool(arguments, "tamed_entities");
		if (!(TargetEntity == null)) {
			if (entity.hasPermissions(2)) {
				if (TargetEntity.canChangeDimensions()) {
					if (world instanceof ServerLevel _origLevel) {
						LevelAccessor _worldorig = world;
						world = _origLevel.getServer().getLevel(Level.OVERWORLD);
						if (world != null) {
							xTarget = (TargetEntity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingY <= -64
									&& (TargetEntity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingX == 0
											? (TargetEntity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingX + -4
													+ Mth.nextInt(RandomSource.create(), 0, 8)
											: (TargetEntity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingX;
							zTarget = (TargetEntity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingY <= -64
									&& (TargetEntity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingZ == 0
											? (TargetEntity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingZ + -4
													+ Mth.nextInt(RandomSource.create(), 0, 8)
											: (TargetEntity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingZ;
							yTarget = (TargetEntity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingY <= -64
									|| world.getBlockState(
											BlockPos.containing(xTarget, (TargetEntity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingY, zTarget))
											.canOcclude()
									|| world.getBlockState(
											BlockPos.containing(xTarget, (TargetEntity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingY + 1, zTarget))
											.canOcclude()
													? world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xTarget, (int) zTarget)
													: (TargetEntity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingY;
						}
						world = _worldorig;
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(TargetEntity.getX(), TargetEntity.getY(), TargetEntity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1,
									1);
						} else {
							_level.playLocalSound((TargetEntity.getX()), (TargetEntity.getY()), (TargetEntity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.PORTAL, (TargetEntity.getX()), (TargetEntity.getY() + 1), (TargetEntity.getZ()), 25, 0.5, 1, 0.5, 1);
					if (TamedEntities) {
						{
							final Vec3 _center = new Vec3((TargetEntity.getX()), (TargetEntity.getY()), (TargetEntity.getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof TamableAnimal _tamIsTamedBy && TargetEntity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
									if ((entityiterator.level().dimension()) == Level.OVERWORLD) {
										if (world instanceof ServerLevel _origLevel) {
											LevelAccessor _worldorig = world;
											world = _origLevel.getServer().getLevel(Level.OVERWORLD);
											if (world != null) {
												entityiterator.fallDistance = 0;
												{
													Entity _ent = entityiterator;
													_ent.teleportTo((xTarget + 0.5), yTarget, (zTarget + 0.5));
													if (_ent instanceof ServerPlayer _serverPlayer)
														_serverPlayer.connection.teleport((xTarget + 0.5), yTarget, (zTarget + 0.5), _ent.getYRot(), _ent.getXRot());
												}
												entityiterator.setDeltaMovement(new Vec3(0, 0, 0));
											}
											world = _worldorig;
										}
									}
								}
							}
						}
					}
					if (!((TargetEntity.level().dimension()) == Level.OVERWORLD)) {
						if (TargetEntity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
							ResourceKey<Level> destinationType = Level.OVERWORLD;
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
					}
					if (world instanceof ServerLevel _origLevel) {
						LevelAccessor _worldorig = world;
						world = _origLevel.getServer().getLevel(Level.OVERWORLD);
						if (world != null) {
							TargetEntity.fallDistance = 0;
							{
								Entity _ent = TargetEntity;
								_ent.teleportTo((xTarget + 0.5), yTarget, (zTarget + 0.5));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((xTarget + 0.5), yTarget, (zTarget + 0.5), _ent.getYRot(), _ent.getXRot());
							}
							TargetEntity.setDeltaMovement(new Vec3(0, 0, 0));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.PORTAL, (TargetEntity.getX()), (TargetEntity.getY() + 1), (TargetEntity.getZ()), 25, 0.5, 1, 0.5, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(TargetEntity.getX(), TargetEntity.getY() + 1, TargetEntity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")),
											SoundSource.PLAYERS, 1, 1);
								} else {
									_level.playLocalSound((TargetEntity.getX()), (TargetEntity.getY() + 1), (TargetEntity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1,
											false);
								}
							}
						}
						world = _worldorig;
					}
					if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_COMMANDBLOCKOUTPUT)) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.command.target_returned").getString())), false);
					}
				} else {
					if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_COMMANDBLOCKOUTPUT)) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.command.tp_issue").getString())), false);
					}
				}
			} else {
				if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_COMMANDBLOCKOUTPUT)) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.command.permission_issue").getString())), false);
				}
			}
		}
	}
}
