package net.mcreator.distantworlds.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModEntities;
import net.mcreator.distantworlds.entity.NoarhornEntity;
import net.mcreator.distantworlds.entity.GarsaleCouchRiddenEntity;
import net.mcreator.distantworlds.entity.BabyNoarhornEntity;
import net.mcreator.distantworlds.entity.ArmoredNoarhornEntity;

import java.util.Comparator;

public class BabyNoarhornOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		String Name = "";
		Entity NearestEntity = null;
		if ((entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_Behavior) : 0) == 0) {
			if (entity instanceof BabyNoarhornEntity _datEntSetI)
				_datEntSetI.getEntityData().set(BabyNoarhornEntity.DATA_Behavior, 1);
		}
		if ((entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_Age) : 0) < 7200) {
			if (entity instanceof BabyNoarhornEntity _datEntSetI)
				_datEntSetI.getEntityData().set(BabyNoarhornEntity.DATA_Age, (int) ((entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_Age) : 0) + 1));
		} else {
			if ((entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_BabyType) : 0) == 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = DistantWorldsModEntities.NOARHORN.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(entity.getYRot());
						entityToSpawn.setYBodyRot(entity.getYRot());
						entityToSpawn.setYHeadRot(entity.getYRot());
						entityToSpawn.setXRot(entity.getXRot());
						entityToSpawn.setDeltaMovement(0, 0, 0);

						if (entity.isOnFire()) {
							entityToSpawn.setSecondsOnFire(entity.getRemainingFireTicks());
						}
						if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
							if (entityToSpawn instanceof TamableAnimal _toTame && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof Player _owner)
								_toTame.tame(_owner);
						}
						Name = entity.getDisplayName().getString();
						if (!(Name).equals(Component.translatable("entity.distant_worlds.baby_noarhorn").getString())) {
							entityToSpawn.setCustomName(Component.literal(Name));
						}
						if (entityToSpawn instanceof NoarhornEntity) {
							if (entityToSpawn instanceof NoarhornEntity _datEntSetI)
								_datEntSetI.getEntityData().set(NoarhornEntity.DATA_Behavior, (int) (entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_Behavior) : 0));
						} else {
							if (entityToSpawn instanceof ArmoredNoarhornEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ArmoredNoarhornEntity.DATA_Behavior, (int) (entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_Behavior) : 0));
						}
					}
				}
			} else if ((entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_BabyType) : 0) == 2) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = DistantWorldsModEntities.ARMORED_NOARHORN.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(entity.getYRot());
						entityToSpawn.setYBodyRot(entity.getYRot());
						entityToSpawn.setYHeadRot(entity.getYRot());
						entityToSpawn.setXRot(entity.getXRot());
						entityToSpawn.setDeltaMovement(0, 0, 0);

						if (entity.isOnFire()) {
							entityToSpawn.setSecondsOnFire(entity.getRemainingFireTicks());
						}
						if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
							if (entityToSpawn instanceof TamableAnimal _toTame && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof Player _owner)
								_toTame.tame(_owner);
						}
						Name = entity.getDisplayName().getString();
						if (!(Name).equals(Component.translatable("entity.distant_worlds.baby_noarhorn").getString())) {
							entityToSpawn.setCustomName(Component.literal(Name));
						}
						if (entityToSpawn instanceof NoarhornEntity) {
							if (entityToSpawn instanceof NoarhornEntity _datEntSetI)
								_datEntSetI.getEntityData().set(NoarhornEntity.DATA_Behavior, (int) (entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_Behavior) : 0));
						} else {
							if (entityToSpawn instanceof ArmoredNoarhornEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ArmoredNoarhornEntity.DATA_Behavior, (int) (entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_Behavior) : 0));
						}
					}
				}
			} else {
				if (!world.isClientSide()) {
					if (Math.random() < 0.3) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = DistantWorldsModEntities.ARMORED_NOARHORN.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(entity.getYRot());
								entityToSpawn.setYBodyRot(entity.getYRot());
								entityToSpawn.setYHeadRot(entity.getYRot());
								entityToSpawn.setXRot(entity.getXRot());
								entityToSpawn.setDeltaMovement(0, 0, 0);

								if (entity.isOnFire()) {
									entityToSpawn.setSecondsOnFire(entity.getRemainingFireTicks());
								}
								if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
									if (entityToSpawn instanceof TamableAnimal _toTame && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof Player _owner)
										_toTame.tame(_owner);
								}
								Name = entity.getDisplayName().getString();
								if (!(Name).equals(Component.translatable("entity.distant_worlds.baby_noarhorn").getString())) {
									entityToSpawn.setCustomName(Component.literal(Name));
								}
								if (entityToSpawn instanceof NoarhornEntity) {
									if (entityToSpawn instanceof NoarhornEntity _datEntSetI)
										_datEntSetI.getEntityData().set(NoarhornEntity.DATA_Behavior, (int) (entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_Behavior) : 0));
								} else {
									if (entityToSpawn instanceof ArmoredNoarhornEntity _datEntSetI)
										_datEntSetI.getEntityData().set(ArmoredNoarhornEntity.DATA_Behavior, (int) (entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_Behavior) : 0));
								}
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = DistantWorldsModEntities.NOARHORN.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(entity.getYRot());
								entityToSpawn.setYBodyRot(entity.getYRot());
								entityToSpawn.setYHeadRot(entity.getYRot());
								entityToSpawn.setXRot(entity.getXRot());
								entityToSpawn.setDeltaMovement(0, 0, 0);

								if (entity.isOnFire()) {
									entityToSpawn.setSecondsOnFire(entity.getRemainingFireTicks());
								}
								if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
									if (entityToSpawn instanceof TamableAnimal _toTame && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof Player _owner)
										_toTame.tame(_owner);
								}
								Name = entity.getDisplayName().getString();
								if (!(Name).equals(Component.translatable("entity.distant_worlds.baby_noarhorn").getString())) {
									entityToSpawn.setCustomName(Component.literal(Name));
								}
								if (entityToSpawn instanceof NoarhornEntity) {
									if (entityToSpawn instanceof NoarhornEntity _datEntSetI)
										_datEntSetI.getEntityData().set(NoarhornEntity.DATA_Behavior, (int) (entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_Behavior) : 0));
								} else {
									if (entityToSpawn instanceof ArmoredNoarhornEntity _datEntSetI)
										_datEntSetI.getEntityData().set(ArmoredNoarhornEntity.DATA_Behavior, (int) (entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_Behavior) : 0));
								}
							}
						}
					}
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if ((entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_Behavior) : 0) == 2 && !entity.isPassenger()) {
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
	}
}
