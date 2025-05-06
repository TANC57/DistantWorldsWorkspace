package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.entity.BooglianEntity;

public class BooglianOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof BooglianEntity _datEntI ? _datEntI.getEntityData().get(BooglianEntity.DATA_Scared) : 0) > 0) {
			if (entity.isInWaterOrBubble()) {
				if (entity instanceof BooglianEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BooglianEntity.DATA_Scared, 0);
			} else {
				if (entity instanceof BooglianEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BooglianEntity.DATA_Scared, (int) ((entity instanceof BooglianEntity _datEntI ? _datEntI.getEntityData().get(BooglianEntity.DATA_Scared) : 0) - 1));
			}
		} else if ((entity instanceof BooglianEntity _datEntI ? _datEntI.getEntityData().get(BooglianEntity.DATA_Scared) : 0) < 0) {
			entity.getPersistentData().putDouble("Scared", 0);
		}
	}
}
