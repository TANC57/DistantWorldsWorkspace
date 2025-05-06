package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;

public class TreeSaplingBoneMealSuccessConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if (!world.isClientSide()) {
			if (Math.random() < 0.2) {
				return true;
			}
		}
		return false;
	}
}
