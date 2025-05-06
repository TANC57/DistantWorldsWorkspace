package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.distantworlds.init.DistantWorldsModParticleTypes;

public class StickyGarsaleLogUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.3) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.GARSALE_SLIME_PARTICLE.get()), (x + 0.5), (y + 0.5), (z - 0.1), 1, 0.25, 0.2, 0, 0);
		}
		if (Math.random() < 0.3) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.GARSALE_SLIME_PARTICLE.get()), (x + 1.1), (y + 0.5), (z + 0.5), 1, 0, 0.2, 0.25, 0);
		}
		if (Math.random() < 0.3) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.GARSALE_SLIME_PARTICLE.get()), (x + 0.5), (y + 0.5), (z + 1.1), 1, 0.25, 0.2, 0, 0);
		}
		if (Math.random() < 0.3) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.GARSALE_SLIME_PARTICLE.get()), (x - 0.1), (y + 0.5), (z + 0.5), 1, 0, 0.2, 0.25, 0);
		}
	}
}
