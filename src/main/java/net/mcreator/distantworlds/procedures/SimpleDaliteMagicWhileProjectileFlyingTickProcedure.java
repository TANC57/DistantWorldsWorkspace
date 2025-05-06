package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.Entity;

public class SimpleDaliteMagicWhileProjectileFlyingTickProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.setNoGravity(true);
	}
}
