package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.entity.AlphaSalmoranEntity;

public class ReturnStaminaLevelDisplayProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return ((entity.getVehicle()) instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Stamina) : 0) == 150
				? 3
				: Math.ceil(124 - (((entity.getVehicle()) instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Stamina) : 0) * 120) / 150);
	}
}
