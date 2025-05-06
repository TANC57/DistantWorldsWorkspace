package net.mcreator.distantworlds.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.entity.GarsaleCouchRiddenEntity;

import java.util.Comparator;

public class GarsaleCouchOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity NearestEntity = null;
		if (!world.getEntitiesOfClass(GarsaleCouchRiddenEntity.class, AABB.ofSize(new Vec3((x + 0.5), y, (z + 0.5)), 0.5, 0.5, 0.5), e -> true).isEmpty()) {
			NearestEntity = (Entity) world.getEntitiesOfClass(GarsaleCouchRiddenEntity.class, AABB.ofSize(new Vec3((x + 0.5), y, (z + 0.5)), 0.5, 0.5, 0.5), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((x + 0.5), y, (z + 0.5))).findFirst().orElse(null);
			if (!NearestEntity.isVehicle()) {
				entity.startRiding(NearestEntity);
			}
		}
	}
}
