package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.distantworlds.init.DistantWorldsModParticleTypes;

public class GlowingPollenBlockClientDisplayRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.4) {
			world.addParticle((SimpleParticleType) (DistantWorldsModParticleTypes.GLOWING_POLLEN_PARTICLE.get()), (x + Mth.nextInt(RandomSource.create(), 4, 6) * 0.1), (y + 0.2), (z + Mth.nextInt(RandomSource.create(), 4, 6) * 0.1),
					(Mth.nextInt(RandomSource.create(), -5, 5) * 0.015), (Mth.nextInt(RandomSource.create(), 5, 10) * 0.015), (Mth.nextInt(RandomSource.create(), -5, 5) * 0.015));
		}
	}
}
