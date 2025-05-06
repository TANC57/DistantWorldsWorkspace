package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

public class ChargedWitherTotemMakeItemGlowProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		double ModX = 0;
		double TeleportatiopnAccuracy = 0;
		double ModZ = 0;
		return (entity.level().dimension()) == Level.NETHER && (entity.getY() <= Math.abs((double) ConfigCommonConfiguration.GARHENNA_TELEPORTATION_HEIGHT.get()) || (double) ConfigCommonConfiguration.GARHENNA_TELEPORTATION_HEIGHT.get() == 0);
	}
}
