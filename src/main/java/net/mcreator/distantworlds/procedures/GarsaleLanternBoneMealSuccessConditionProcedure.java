package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;

public class GarsaleLanternBoneMealSuccessConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if (!world.isClientSide()) {
			if (Math.random() < 0.15) {
				return true;
			}
		}
		return false;
	}
}
