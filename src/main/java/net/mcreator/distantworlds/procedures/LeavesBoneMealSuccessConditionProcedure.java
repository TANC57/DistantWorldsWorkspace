package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;

public class LeavesBoneMealSuccessConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if (!world.isClientSide()) {
			if (Math.random() < 0.7) {
				return true;
			}
		}
		return false;
	}
}
