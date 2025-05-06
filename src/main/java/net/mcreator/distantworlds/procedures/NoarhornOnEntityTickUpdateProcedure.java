package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.distantworlds.init.DistantWorldsModEntities;
import net.mcreator.distantworlds.entity.NoarhornEntity;
import net.mcreator.distantworlds.entity.GarsaleCouchRiddenEntity;
import net.mcreator.distantworlds.entity.BabyNoarhornEntity;
import net.mcreator.distantworlds.entity.ArmoredNoarhornEntity;

import java.util.List;
import java.util.Comparator;

public class NoarhornOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity NearestEntity = null;
		String Name = "";
		boolean HasPartner = false;
		if (entity.isVehicle()) {
			if (entity instanceof NoarhornEntity animatable)
				animatable.setTexture("noarhorn_saddle");
		} else {
			if (entity instanceof NoarhornEntity animatable)
				animatable.setTexture("noarhorn");
		}
		if ((entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_Behavior) : 0) == 2 && !entity.isPassenger()) {
			if (entity.isVehicle()) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().stop();
			} else {
				NearestEntity = (Entity) world.getEntitiesOfClass(GarsaleCouchRiddenEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 0.75, 0.75, 0.75), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null);
				if (!(NearestEntity == null)) {
					if (!NearestEntity.isVehicle()) {
						entity.startRiding(NearestEntity);
					}
				} else {
					NearestEntity = (Entity) world.getEntitiesOfClass(GarsaleCouchRiddenEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 4, 4, 4), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null);
					if (NearestEntity == null) {
						if (entity instanceof Mob _entity)
							_entity.getNavigation().stop();
					} else {
						if (NearestEntity.isVehicle()) {
							if (entity instanceof Mob _entity)
								_entity.getNavigation().stop();
						} else {
							if (entity instanceof Mob _entity)
								_entity.getNavigation().moveTo((NearestEntity.getX()), (NearestEntity.getY() + NearestEntity.getBbHeight()), (NearestEntity.getZ()), 1);
						}
					}
				}
			}
		}
		if (entity.isVehicle() && entity.isPassenger()) {
			entity.stopRiding();
		}
		if ((entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_InLove) : 0) > 0 && (entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_BabyAge) : 0) <= 0) {
			if (entity instanceof NoarhornEntity _datEntSetI)
				_datEntSetI.getEntityData().set(NoarhornEntity.DATA_InLove, (int) ((entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_InLove) : 0) - 1));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity) && (entityiterator instanceof NoarhornEntity && (entityiterator instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_InLove) : 0) > 0
							&& (entityiterator instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_BabyAge) : 0) <= 0
							|| entityiterator instanceof ArmoredNoarhornEntity && (entityiterator instanceof ArmoredNoarhornEntity _datEntI ? _datEntI.getEntityData().get(ArmoredNoarhornEntity.DATA_InLove) : 0) > 0
									&& (entityiterator instanceof ArmoredNoarhornEntity _datEntI ? _datEntI.getEntityData().get(ArmoredNoarhornEntity.DATA_BabyAge) : 0) <= 0)) {
						HasPartner = true;
						if (entity instanceof Mob _entity)
							_entity.getNavigation().stop();
						if (!world.isClientSide()) {
							if (Math.random() < 0.0006) {
								if (entityiterator instanceof NoarhornEntity) {
									if (entityiterator instanceof NoarhornEntity _datEntSetI)
										_datEntSetI.getEntityData().set(NoarhornEntity.DATA_InLove, -7200);
								} else {
									if (entityiterator instanceof ArmoredNoarhornEntity _datEntSetI)
										_datEntSetI.getEntityData().set(ArmoredNoarhornEntity.DATA_InLove, -7200);
								}
								if (entity instanceof NoarhornEntity _datEntSetI)
									_datEntSetI.getEntityData().set(NoarhornEntity.DATA_BabyAge, 1);
								if (entity instanceof NoarhornEntity _datEntSetI)
									_datEntSetI.getEntityData().set(NoarhornEntity.DATA_BabyType, (int) (entityiterator instanceof ArmoredNoarhornEntity && Math.random() < 0.3 ? 2 : 1));
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 0.5, 0.5, 0.5, 0);
								if (world instanceof ServerLevel _level)
									_level.addFreshEntity(new ExperienceOrb(_level, (entity.getX()), (entity.getY()), (entity.getZ()), Mth.nextInt(RandomSource.create(), 5, 15)));
								if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof ServerPlayer _plr59 && _plr59.level() instanceof ServerLevel
										&& _plr59.getAdvancements().getOrStartProgress(_plr59.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:husbandry/breed_an_animal"))).isDone())) {
									if (entity instanceof ServerPlayer _player) {
										Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:husbandry/breed_an_animal"));
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (!((entityiterator instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof ServerPlayer _plr62 && _plr62.level() instanceof ServerLevel
										&& _plr62.getAdvancements().getOrStartProgress(_plr62.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:husbandry/breed_an_animal"))).isDone())) {
									if (entity instanceof ServerPlayer _player) {
										Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:husbandry/breed_an_animal"));
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								break;
							}
						}
					}
				}
			}
			if (!HasPartner && !((entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_Behavior) : 0) == 2 && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) && !entity.isVehicle()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity) && (entityiterator instanceof NoarhornEntity && (entityiterator instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_InLove) : 0) > 0
								&& (entityiterator instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_BabyAge) : 0) <= 0
								|| entityiterator instanceof ArmoredNoarhornEntity && (entityiterator instanceof ArmoredNoarhornEntity _datEntI ? _datEntI.getEntityData().get(ArmoredNoarhornEntity.DATA_InLove) : 0) > 0
										&& (entityiterator instanceof ArmoredNoarhornEntity _datEntI ? _datEntI.getEntityData().get(ArmoredNoarhornEntity.DATA_BabyAge) : 0) <= 0)) {
							if (entity instanceof Mob _entity)
								_entity.getNavigation().moveTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1);
						}
					}
				}
			}
			if (entity.tickCount % 20 == 0) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HEART, x, (y + 0.5), z, 5, 0.5, 0.5, 0.5, 0);
				if (!HasPartner) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, (y + 0.5), z, 3, 0.3, 0.3, 0.3, 0);
				}
			}
		} else if ((entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_InLove) : 0) < 0) {
			if (entity instanceof NoarhornEntity _datEntSetI)
				_datEntSetI.getEntityData().set(NoarhornEntity.DATA_InLove, (int) ((entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_InLove) : 0) + 1));
		}
		if ((entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_BabyAge) : 0) > 0) {
			if ((entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_BabyAge) : 0) < 3600) {
				if (entity instanceof NoarhornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(NoarhornEntity.DATA_BabyAge, (int) ((entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_BabyAge) : 0) + 1));
			} else {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = DistantWorldsModEntities.BABY_NOARHORN.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						if (entityToSpawn instanceof TamableAnimal _toTame && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof Player _owner)
							_toTame.tame(_owner);
						if (entityToSpawn instanceof BabyNoarhornEntity _datEntSetI)
							_datEntSetI.getEntityData().set(BabyNoarhornEntity.DATA_BabyType, (int) (entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_BabyType) : 0));
						if ((entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_Behavior) : 0) == 2) {
							if (entityToSpawn instanceof BabyNoarhornEntity _datEntSetI)
								_datEntSetI.getEntityData().set(BabyNoarhornEntity.DATA_Behavior, 2);
						} else {
							if (entityToSpawn instanceof BabyNoarhornEntity _datEntSetI)
								_datEntSetI.getEntityData().set(BabyNoarhornEntity.DATA_Behavior, 1);
						}
					}
				}
				if (!world.isClientSide()) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, (entity.getX()), (entity.getY()), (entity.getZ()), Mth.nextInt(RandomSource.create(), 10, 25)));
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 1, 1, 1, 0);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.egg")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.egg")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof NoarhornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(NoarhornEntity.DATA_BabyAge, 0);
				if (entity instanceof NoarhornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(NoarhornEntity.DATA_BabyType, 0);
				if (entity instanceof NoarhornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(NoarhornEntity.DATA_InLove, -3600);
			}
		} else if ((entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_BabyAge) : 0) < 0) {
			if (entity instanceof NoarhornEntity _datEntSetI)
				_datEntSetI.getEntityData().set(NoarhornEntity.DATA_BabyAge, 0);
		}
	}
}
