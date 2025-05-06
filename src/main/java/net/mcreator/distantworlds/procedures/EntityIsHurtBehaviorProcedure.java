package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.entity.SalmoranEntity;
import net.mcreator.distantworlds.entity.NoarhornEntity;
import net.mcreator.distantworlds.entity.BabySalmoranEntity;
import net.mcreator.distantworlds.entity.BabyNoarhornEntity;
import net.mcreator.distantworlds.entity.ArmoredNoarhornEntity;
import net.mcreator.distantworlds.entity.AlphaSalmoranEntity;

public class EntityIsHurtBehaviorProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.isVehicle()) {
			if (entity instanceof BabySalmoranEntity) {
				if ((entity instanceof BabySalmoranEntity _datEntI ? _datEntI.getEntityData().get(BabySalmoranEntity.DATA_Behavior) : 0) == 2) {
					if (entity instanceof BabySalmoranEntity _datEntSetI)
						_datEntSetI.getEntityData().set(BabySalmoranEntity.DATA_Behavior, 1);
				}
			} else if (entity instanceof SalmoranEntity) {
				if ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_Behavior) : 0) == 2) {
					if (entity instanceof SalmoranEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SalmoranEntity.DATA_Behavior, 1);
				}
			} else if (entity instanceof AlphaSalmoranEntity) {
				if ((entity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Behavior) : 0) == 2) {
					if (entity instanceof AlphaSalmoranEntity _datEntSetI)
						_datEntSetI.getEntityData().set(AlphaSalmoranEntity.DATA_Behavior, 1);
				}
			} else if (entity instanceof BabyNoarhornEntity) {
				if ((entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_Behavior) : 0) == 2) {
					if (entity instanceof BabyNoarhornEntity _datEntSetI)
						_datEntSetI.getEntityData().set(BabyNoarhornEntity.DATA_Behavior, 1);
				}
			} else if (entity instanceof NoarhornEntity) {
				if ((entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_Behavior) : 0) == 2) {
					if (entity instanceof NoarhornEntity _datEntSetI)
						_datEntSetI.getEntityData().set(NoarhornEntity.DATA_Behavior, 1);
				}
			} else if (entity instanceof ArmoredNoarhornEntity) {
				if ((entity instanceof ArmoredNoarhornEntity _datEntI ? _datEntI.getEntityData().get(ArmoredNoarhornEntity.DATA_Behavior) : 0) == 2) {
					if (entity instanceof ArmoredNoarhornEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ArmoredNoarhornEntity.DATA_Behavior, 1);
				}
			}
		}
	}
}
