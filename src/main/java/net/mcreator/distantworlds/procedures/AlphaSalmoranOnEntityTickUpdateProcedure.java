package net.mcreator.distantworlds.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.distantworlds.init.DistantWorldsModMobEffects;
import net.mcreator.distantworlds.entity.WiltumCouchRiddenEntity;
import net.mcreator.distantworlds.entity.SalmoranEntity;
import net.mcreator.distantworlds.entity.AlphaSalmoranEntity;

import java.util.List;
import java.util.Comparator;

public class AlphaSalmoranOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity NearestEntity = null;
		boolean HasPartner = false;
		Vec3 vec3 = entity.getDeltaMovement();
		if (entity.isVehicle()) {
			if (entity instanceof AlphaSalmoranEntity animatable)
				animatable.setTexture("alpha_salmoran_saddle");
		} else {
			if (entity instanceof AlphaSalmoranEntity animatable)
				animatable.setTexture("alpha_salmoran");
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(18 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entity instanceof TamableAnimal _tamIsTamedBy && entityiterator instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(DistantWorldsModMobEffects.SUPERVISION.get(), 60, 0, true, false));
				}
			}
		}
		if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof ServerPlayer _plr7 && _plr7.level() instanceof ServerLevel
				&& _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:yours_among_strangers"))).isDone())) {
			if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:yours_among_strangers"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof ServerPlayer _plr11 && _plr11.level() instanceof ServerLevel
				&& _plr11.getAdvancements().getOrStartProgress(_plr11.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:supervised"))).isDone())) {
			if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:supervised"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (!world.isClientSide()) {
			if ((entity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Behavior) : 0) == 2 && !entity.isPassenger()) {
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
			if (entity.isVehicle() && entity.isPassenger()) {
				entity.stopRiding();
			}
			if ((entity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_InLove) : 0) > 0) {
				if (entity instanceof AlphaSalmoranEntity _datEntSetI)
					_datEntSetI.getEntityData().set(AlphaSalmoranEntity.DATA_InLove, (int) ((entity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_InLove) : 0) - 1));
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity) && entityiterator instanceof SalmoranEntity && (entityiterator instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_InLove) : 0) > 0
								&& (entityiterator instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_BabyAge) : 0) <= 0) {
							HasPartner = true;
							if (entity instanceof Mob _entity)
								_entity.getNavigation().stop();
						}
					}
				}
				if (!HasPartner && !((entity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Behavior) : 0) == 2 && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false))
						&& !entity.isVehicle()) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity) && entityiterator instanceof SalmoranEntity && (entityiterator instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_InLove) : 0) > 0
									&& (entityiterator instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_BabyAge) : 0) <= 0) {
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
			}
		}
		if (!entity.isVehicle() && (entity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Stamina) : 0) < 150) {
			if (entity.tickCount % 10 == 0) {
				if (entity instanceof AlphaSalmoranEntity _datEntSetI)
					_datEntSetI.getEntityData().set(AlphaSalmoranEntity.DATA_Stamina, (int) ((entity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Stamina) : 0)
							+ (entity.isPassenger() && (entity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Stamina) : 0) <= 148 ? 2 : 1)));
			}
		}
		if ((entity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Stamina) : 0) > 150) {
			if (entity instanceof AlphaSalmoranEntity _datEntSetI)
				_datEntSetI.getEntityData().set(AlphaSalmoranEntity.DATA_Stamina, 150);
		} else if ((entity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Stamina) : 0) < 0) {
			if (entity instanceof AlphaSalmoranEntity _datEntSetI)
				_datEntSetI.getEntityData().set(AlphaSalmoranEntity.DATA_Stamina, 0);
		}
	}
}
