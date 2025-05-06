package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;

public class ReturnRingOverlayReturnXProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingY <= -64
				&& (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingX == 0
						? "---"
						: new java.text.DecimalFormat("##").format((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).ReturnRingX);
	}
}
