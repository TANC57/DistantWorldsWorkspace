package net.mcreator.distantworlds.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.Difficulty;

import net.mcreator.distantworlds.entity.SalmoranEntity;

public class SalmoranNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return !(world.getDifficulty() == Difficulty.PEACEFUL) && !(!world.getEntitiesOfClass(SalmoranEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) && y < 90;
	}
}
