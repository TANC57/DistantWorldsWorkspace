package net.mcreator.distantworlds.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
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
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class GarhennaTpCommandProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (!((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "target");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) == null)) {
			if (entity.hasPermissions(2)) {
				if ((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "target");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).canChangeDimensions()) {
					if (!(((new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "target");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("distant_worlds:garhenna"))))) {
						if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_COMMANDBLOCKOUTPUT)) {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.command.target_teleported").getString() + "" + Component.translatable("advancements.garhenna_explore.title").getString())),
										false);
						}
						if ((new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "target");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()) instanceof ServerPlayer _player && !_player.level().isClientSide()) {
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
						(new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "target");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).setDeltaMovement(new Vec3(0, 0, 0));
						if (world instanceof ServerLevel _origLevel) {
							LevelAccessor _worldorig = world;
							world = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("distant_worlds:garhenna")));
							if (world != null) {
								{
									Entity _ent = (new Object() {
										public Entity getEntity() {
											try {
												return EntityArgument.getEntity(arguments, "target");
											} catch (CommandSyntaxException e) {
												e.printStackTrace();
												return null;
											}
										}
									}.getEntity());
									_ent.teleportTo((new Object() {
										public double getX() {
											try {
												return BlockPosArgument.getLoadedBlockPos(arguments, "position").getX();
											} catch (CommandSyntaxException e) {
												e.printStackTrace();
												return 0;
											}
										}
									}.getX()), (new Object() {
										public double getY() {
											try {
												return BlockPosArgument.getLoadedBlockPos(arguments, "position").getY();
											} catch (CommandSyntaxException e) {
												e.printStackTrace();
												return 0;
											}
										}
									}.getY()), (new Object() {
										public double getZ() {
											try {
												return BlockPosArgument.getLoadedBlockPos(arguments, "position").getZ();
											} catch (CommandSyntaxException e) {
												e.printStackTrace();
												return 0;
											}
										}
									}.getZ()));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((new Object() {
											public double getX() {
												try {
													return BlockPosArgument.getLoadedBlockPos(arguments, "position").getX();
												} catch (CommandSyntaxException e) {
													e.printStackTrace();
													return 0;
												}
											}
										}.getX()), (new Object() {
											public double getY() {
												try {
													return BlockPosArgument.getLoadedBlockPos(arguments, "position").getY();
												} catch (CommandSyntaxException e) {
													e.printStackTrace();
													return 0;
												}
											}
										}.getY()), (new Object() {
											public double getZ() {
												try {
													return BlockPosArgument.getLoadedBlockPos(arguments, "position").getZ();
												} catch (CommandSyntaxException e) {
													e.printStackTrace();
													return 0;
												}
											}
										}.getZ()), _ent.getYRot(), _ent.getXRot());
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.FLAME, (new Object() {
										public double getX() {
											try {
												return BlockPosArgument.getLoadedBlockPos(arguments, "position").getX();
											} catch (CommandSyntaxException e) {
												e.printStackTrace();
												return 0;
											}
										}
									}.getX()), (new Object() {
										public double getY() {
											try {
												return BlockPosArgument.getLoadedBlockPos(arguments, "position").getY();
											} catch (CommandSyntaxException e) {
												e.printStackTrace();
												return 0;
											}
										}
									}.getY() + 0.5), (new Object() {
										public double getZ() {
											try {
												return BlockPosArgument.getLoadedBlockPos(arguments, "position").getZ();
											} catch (CommandSyntaxException e) {
												e.printStackTrace();
												return 0;
											}
										}
									}.getZ()), 3, 0.2, 0.5, 0.2, 0.02);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.SMALL_FLAME, (new Object() {
										public double getX() {
											try {
												return BlockPosArgument.getLoadedBlockPos(arguments, "position").getX();
											} catch (CommandSyntaxException e) {
												e.printStackTrace();
												return 0;
											}
										}
									}.getX()), (new Object() {
										public double getY() {
											try {
												return BlockPosArgument.getLoadedBlockPos(arguments, "position").getY();
											} catch (CommandSyntaxException e) {
												e.printStackTrace();
												return 0;
											}
										}
									}.getY() + 0.5), (new Object() {
										public double getZ() {
											try {
												return BlockPosArgument.getLoadedBlockPos(arguments, "position").getZ();
											} catch (CommandSyntaxException e) {
												e.printStackTrace();
												return 0;
											}
										}
									}.getZ()), 5, 0.2, 0.5, 0.2, 0.02);
							}
							world = _worldorig;
						}
					} else {
						if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_COMMANDBLOCKOUTPUT)) {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.command.in_dimension").getString())), false);
						}
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
