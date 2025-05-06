package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModParticleTypes;

public class PottedFuziannaClientDisplayRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "Fertilized") > 0) {
			if (Math.random() < 0.3) {
				world.addParticle((SimpleParticleType) (DistantWorldsModParticleTypes.FUZIANNA_JELLY_PARTICLE.get()), (x + Mth.nextInt(RandomSource.create(), 4, 6) * 0.1), (y + 0.85), (z + Mth.nextInt(RandomSource.create(), 4, 6) * 0.1),
						(Mth.nextInt(RandomSource.create(), -5, 5) * 0.01), (Mth.nextInt(RandomSource.create(), 5, 10) * 0.015), (Mth.nextInt(RandomSource.create(), -5, 5) * 0.01));
			}
		}
	}
}
