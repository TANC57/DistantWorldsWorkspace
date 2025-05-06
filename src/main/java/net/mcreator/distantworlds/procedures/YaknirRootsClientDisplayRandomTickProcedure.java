package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.distantworlds.init.DistantWorldsModParticleTypes;

public class YaknirRootsClientDisplayRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.3) {
			world.addParticle((SimpleParticleType) (DistantWorldsModParticleTypes.CULAFITE_SHROOMLIGHT_PARTICLE.get()), (x + Mth.nextInt(RandomSource.create(), 4, 6) * 0.1), (y + 0.9), (z + Mth.nextInt(RandomSource.create(), 4, 6) * 0.1),
					(Mth.nextInt(RandomSource.create(), -5, 5) * 0.015), (Mth.nextInt(RandomSource.create(), -10, -5) * 0.015), (Mth.nextInt(RandomSource.create(), -5, 5) * 0.015));
		}
	}
}
