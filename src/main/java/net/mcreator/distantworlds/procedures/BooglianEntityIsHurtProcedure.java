package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.entity.BooglianEntity;
import net.mcreator.distantworlds.DistantWorldsMod;

public class BooglianEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0 && !entity.isInWaterOrBubble() && sourceentity instanceof LivingEntity) {
			DistantWorldsMod.queueServerWork(10, () -> {
				if (entity instanceof BooglianEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BooglianEntity.DATA_Scared, 160);
			});
		}
	}
}
