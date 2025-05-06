package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.TamableAnimal;
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

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;
import net.mcreator.distantworlds.entity.WiltumCouchRiddenEntity;
import net.mcreator.distantworlds.entity.SalmoranEntity;
import net.mcreator.distantworlds.entity.AlphaSalmoranEntity;

import java.util.List;
import java.util.Comparator;

public class SalmoranOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity NearestEntity = null;
		double Height = 0;
		boolean HasPartner = false;
		Vec3 vec3 = entity.getDeltaMovement();
		if ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_Irritated) : 0) > 0) {
			if (entity instanceof SalmoranEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SalmoranEntity.DATA_Irritated, (int) ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_Irritated) : 0) - 1));
		} else if ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_Irritated) : 0) < 0) {
			if (entity instanceof SalmoranEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SalmoranEntity.DATA_Irritated, 0);
		}
		if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof ServerPlayer _plr6 && _plr6.level() instanceof ServerLevel
				&& _plr6.getAdvancements().getOrStartProgress(_plr6.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:yours_among_strangers"))).isDone())) {
			if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:yours_among_strangers"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (!world.isClientSide()) {
			if ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_Behavior) : 0) == 2 && !entity.isPassenger()) {
				if (entity.isVehicle()) {
					if (entity instanceof Mob _entity)
						_entity.getNavigation().stop();
				} else {
					NearestEntity = (Entity) world.getEntitiesOfClass(WiltumCouchRiddenEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 1.5, 1.5, 1.5), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null);
					if (!(NearestEntity == null)) {
						if (!NearestEntity.isVehicle()) {
							entity.startRiding(NearestEntity);
						}
					} else {
						NearestEntity = (Entity) world.getEntitiesOfClass(WiltumCouchRiddenEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 6, 6, 6), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null);
						if (NearestEntity == null) {
							if (entity instanceof Mob _entity)
								_entity.getNavigation().stop();
							entity.setDeltaMovement(vec3.x, 0, vec3.z);
						} else {
							if (NearestEntity.isVehicle()) {
								if (entity instanceof Mob _entity)
									_entity.getNavigation().stop();
								entity.setDeltaMovement(vec3.x, 0, vec3.z);
							} else {
								if (entity instanceof Mob _entity)
									_entity.getNavigation().moveTo((NearestEntity.getX()), (NearestEntity.getY() + NearestEntity.getBbHeight()), (NearestEntity.getZ()), 1);
							}
						}
					}
				}
			}
			if ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_InLove) : 0) > 0 && (entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_BabyAge) : 0) <= 0) {
				if (entity instanceof SalmoranEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SalmoranEntity.DATA_InLove, (int) ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_InLove) : 0) - 1));
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity) && (entityiterator instanceof SalmoranEntity && (entityiterator instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_InLove) : 0) > 0
								&& (entityiterator instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_BabyAge) : 0) <= 0
								|| entityiterator instanceof AlphaSalmoranEntity && (entityiterator instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_InLove) : 0) > 0)) {
							HasPartner = true;
							if (entity instanceof Mob _entity)
								_entity.getNavigation().stop();
							if (Math.random() < (entityiterator instanceof AlphaSalmoranEntity ? 0.0018 : 0.0006)) {
								if (entityiterator instanceof SalmoranEntity) {
									if (entityiterator instanceof SalmoranEntity _datEntSetI)
										_datEntSetI.getEntityData().set(SalmoranEntity.DATA_InLove, -7200);
								} else {
									if (entityiterator instanceof AlphaSalmoranEntity _datEntSetI)
										_datEntSetI.getEntityData().set(AlphaSalmoranEntity.DATA_InLove, -7200);
								}
								if (entity instanceof SalmoranEntity _datEntSetI)
									_datEntSetI.getEntityData().set(SalmoranEntity.DATA_BabyAge, 1);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 10, 0.5, 0.5, 0.5, 0);
								if (world instanceof ServerLevel _level)
									_level.addFreshEntity(new ExperienceOrb(_level, (entity.getX()), (entity.getY()), (entity.getZ()), Mth.nextInt(RandomSource.create(), 5, 15)));
								if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof ServerPlayer _plr60 && _plr60.level() instanceof ServerLevel
										&& _plr60.getAdvancements().getOrStartProgress(_plr60.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:husbandry/breed_an_animal"))).isDone())) {
									if (entity instanceof ServerPlayer _player) {
										Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:husbandry/breed_an_animal"));
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (!((entityiterator instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof ServerPlayer _plr63 && _plr63.level() instanceof ServerLevel
										&& _plr63.getAdvancements().getOrStartProgress(_plr63.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:husbandry/breed_an_animal"))).isDone())) {
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
				if (!HasPartner && !((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_Behavior) : 0) == 2 && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) && !entity.isVehicle()) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity) && (entityiterator instanceof SalmoranEntity && (entityiterator instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_InLove) : 0) > 0
									&& (entityiterator instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_BabyAge) : 0) <= 0
									|| entityiterator instanceof AlphaSalmoranEntity && (entityiterator instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_InLove) : 0) > 0)) {
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
			} else if ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_InLove) : 0) < 0) {
				if (entity instanceof SalmoranEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SalmoranEntity.DATA_InLove, (int) ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_InLove) : 0) + 1));
			}
			if ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_BabyAge) : 0) > 0) {
				if ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_BabyAge) : 0) < 2200) {
					if (entity instanceof SalmoranEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SalmoranEntity.DATA_BabyAge, (int) ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_BabyAge) : 0) + 1));
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z)) && world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
						world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.SALMORAN_EGG.get().defaultBlockState(), 3);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.lay_egg")), SoundSource.NEUTRAL, 1, (float) (0.8 + Math.random() * 0.4));
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.lay_egg")), SoundSource.NEUTRAL, 1, (float) (0.8 + Math.random() * 0.4), false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.addFreshEntity(new ExperienceOrb(_level, (entity.getX()), (entity.getY()), (entity.getZ()), Mth.nextInt(RandomSource.create(), 10, 25)));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 10, 1, 1, 1, 0);
						if (entity instanceof SalmoranEntity _datEntSetI)
							_datEntSetI.getEntityData().set(SalmoranEntity.DATA_BabyAge, 0);
						if (entity instanceof SalmoranEntity _datEntSetI)
							_datEntSetI.getEntityData().set(SalmoranEntity.DATA_InLove, -5000);
					} else {
						if (entity.tickCount % 60 == 0) {
							Height = 1;
							for (int index0 = 0; index0 < 8; index0++) {
								if (world.isEmptyBlock(BlockPos.containing(x, y - Height, z)) && world.getBlockState(BlockPos.containing(x, (y - Height) - 1, z)).canOcclude()) {
									if (entity instanceof Mob _entity)
										_entity.getNavigation().moveTo((entity.getX()), (y - Height), (entity.getZ()), 2);
									break;
								} else {
									Height = Height + 1;
								}
							}
						}
					}
				}
			} else if ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_BabyAge) : 0) < 0) {
				if (entity instanceof SalmoranEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SalmoranEntity.DATA_BabyAge, 0);
			}
		}
	}
}
