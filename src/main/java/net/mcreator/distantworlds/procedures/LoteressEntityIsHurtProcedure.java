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
import net.mcreator.distantworlds.DistantWorldsMod;

import java.util.List;
import java.util.Comparator;

public class LoteressEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (!(world.getDifficulty() == Difficulty.PEACEFUL) && entity.getPersistentData().getDouble("Recovery") == 0 && sourceentity instanceof LivingEntity) {
				if (Math.random() < 0.5) {
					DistantWorldsMod.queueServerWork(10, () -> {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof LivingEntity && !(entityiterator instanceof ToranEntity) && !(entityiterator instanceof LoteressEntity) && !(entityiterator instanceof LivingEntity _livEnt7 && _livEnt7.isBlocking())) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0, true, true));
								}
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.GLOWING_POLLEN_PARTICLE.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 5, 0.2, 0.2, 0.2, 0);
					});
				}
			}
		}
	}
}
