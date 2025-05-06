package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.entity.SalmoranEntity;

public class SalmoranEntityIsHurtProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof SalmoranEntity _datEntSetI)
			_datEntSetI.getEntityData().set(SalmoranEntity.DATA_Irritated, 180);
		EntityIsHurtBehaviorProcedure.execute(entity);
	}
}
