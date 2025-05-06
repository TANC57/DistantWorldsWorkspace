package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.entity.AlphaSalmoranEntity;

public class StaminaOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.isPassenger() && entity.getVehicle().getFirstPassenger() == entity && (entity.getVehicle()) instanceof AlphaSalmoranEntity;
	}
}
