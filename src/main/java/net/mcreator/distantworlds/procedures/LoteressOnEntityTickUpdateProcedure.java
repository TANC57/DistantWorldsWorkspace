package net.mcreator.distantworlds.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.Difficulty;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.distantworlds.init.DistantWorldsModParticleTypes;
import net.mcreator.distantworlds.entity.ToranEntity;
import net.mcreator.distantworlds.entity.LoteressEntity;

import java.util.List;
import java.util.Comparator;

public class LoteressOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double EffectLvl = 0;
		if (entity.getPersistentData().getDouble("Recovery") > 1) {
			entity.getPersistentData().putDouble("Recovery", (entity.getPersistentData().getDouble("Recovery") - 1));
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
				if (Math.random() < 0.2) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.GLOWING_POLLEN_PARTICLE.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 5, 0.2, 0.2, 0.2, 0);
				}
			}
		} else if (entity.getPersistentData().getDouble("Recovery") == 1) {
			entity.getPersistentData().putDouble("Recovery", (-400));
		} else if (entity.getPersistentData().getDouble("Recovery") < 0) {
			entity.getPersistentData().putDouble("Recovery", (entity.getPersistentData().getDouble("Recovery") + 1));
		}
		if (entity.getPersistentData().getDouble("Recovery") == 0) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof ToranEntity && (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.75) {
						entity.getPersistentData().putDouble("Recovery", 80);
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("Recovery") >= 20) {
			if (entity.getPersistentData().getDouble("Recovery") == 80) {
				EffectLvl = 0;
			} else if (entity.getPersistentData().getDouble("Recovery") == 60) {
				EffectLvl = 1;
			} else if (entity.getPersistentData().getDouble("Recovery") == 40) {
				EffectLvl = 2;
			} else if (entity.getPersistentData().getDouble("Recovery") == 20) {
				EffectLvl = 3;
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof ToranEntity) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, (int) EffectLvl, true, true));
					} else if (entityiterator instanceof LivingEntity && !(entityiterator instanceof LoteressEntity) && !(world.getDifficulty() == Difficulty.PEACEFUL)) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, (int) EffectLvl, true, true));
					}
				}
			}
		}
	}
}
