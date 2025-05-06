package net.mcreator.distantworlds.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.Difficulty;

import net.mcreator.distantworlds.entity.LoteressEntity;

public class LoteressNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return !(world.getDifficulty() == Difficulty.PEACEFUL) && !(!world.getEntitiesOfClass(LoteressEntity.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).isEmpty()) && y < 90;
	}
}
