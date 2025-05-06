package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.entity.BooglianEntity;

public class BooglianWanderAdditionalConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof BooglianEntity) {
			if ((entity instanceof BooglianEntity _datEntI ? _datEntI.getEntityData().get(BooglianEntity.DATA_Scared) : 0) == 0) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
