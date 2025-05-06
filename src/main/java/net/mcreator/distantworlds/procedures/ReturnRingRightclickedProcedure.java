package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
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
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;
import net.mcreator.distantworlds.init.DistantWorldsModItems;

import java.util.List;
import java.util.Comparator;

public class ReturnRingRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double yTarget = 0;
		double zTarget = 0;
		double xTarget = 0;
		if (!(entity instanceof Player _plrCldCheck0 && _plrCldCheck0.getCooldowns().isOnCooldown(DistantWorldsModItems.RETURN_RING.get())) && itemstack.getDamageValue() < itemstack.getMaxDamage()) {
			if (entity.isShiftKeyDown()) {
				if ((entity.level().dimension()) == Level.OVERWORLD && y > -64 && y <= 320 && !world.getBlockState(BlockPos.containing(x, y, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
					{
						double _setval = Math.floor(x);
						entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ReturnRingX = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = y;
						entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ReturnRingY = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = Math.floor(z);
						entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ReturnRingZ = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7a" + Component.translatable("event.distant_worlds.target_point_new").getString())), true);
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(DistantWorldsModItems.RETURN_RING.get(), 600);
					} else {
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(DistantWorldsModItems.RETURN_RING.get(), 40);
					}
					if (!(entity instanceof ServerPlayer _plr16 && _plr16.level() instanceof ServerLevel
							&& _plr16.getAdvancements().getOrStartProgress(_plr16.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:return_point"))).isDone())) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:return_point"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7a" + Component.translatable("event.distant_worlds.target_point_failure").getString())), true);
				}
			} else {
				if (world instanceof ServerLevel _origLevel) {
					LevelAccessor _worldorig = world;
					world = _origLevel.getServer().getLevel(Level.OVERWORLD);
					if (world != null) {
						xTarget = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingY <= -64
								&& (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingX == 0
										? (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingX + -4 + Mth.nextInt(RandomSource.create(), 0, 8)
										: (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingX;
						zTarget = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingY <= -64
								&& (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingZ == 0
										? (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingZ + -4 + Mth.nextInt(RandomSource.create(), 0, 8)
										: (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingZ;
						yTarget = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingY <= -64
								|| world.getBlockState(BlockPos.containing(xTarget, (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingY, zTarget))
										.canOcclude()
								|| world.getBlockState(BlockPos.containing(xTarget, (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingY + 1, zTarget))
										.canOcclude()
												? world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xTarget, (int) zTarget)
												: (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingY;
					}
					world = _worldorig;
				}
				if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(DistantWorldsModItems.RETURN_RING.get(), 1200);
				} else {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(DistantWorldsModItems.RETURN_RING.get(), 40);
				}
				if (!(entity instanceof Player _plrCldCheck31 && _plrCldCheck31.getCooldowns().isOnCooldown(DistantWorldsModItems.WITHER_TOTEM.get()))
						&& !(entity instanceof Player _plrCldCheck32 && _plrCldCheck32.getCooldowns().isOnCooldown(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get()))) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(DistantWorldsModItems.WITHER_TOTEM.get(), 40);
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get(), 40);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.PORTAL, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 25, 0.5, 1, 0.5, 1);
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
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
				if (!((entity.level().dimension()) == Level.OVERWORLD)) {
					if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
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
						entity.fallDistance = 0;
						{
							Entity _ent = entity;
							_ent.teleportTo((xTarget + 0.5), yTarget, (zTarget + 0.5));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((xTarget + 0.5), yTarget, (zTarget + 0.5), _ent.getYRot(), _ent.getXRot());
						}
						entity.setDeltaMovement(new Vec3(0, 0, 0));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.PORTAL, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 25, 0.5, 1, 0.5, 1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY() + 1), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
					}
					world = _worldorig;
				}
			}
		}
	}
}
