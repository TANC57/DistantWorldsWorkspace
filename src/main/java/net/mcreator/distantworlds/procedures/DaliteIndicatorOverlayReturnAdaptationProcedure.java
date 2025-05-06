package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;

public class DaliteIndicatorOverlayReturnAdaptationProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("gui.distant_worlds.dalite_indicator_overlay.adaptation").getString() + ""
				+ (new java.text.DecimalFormat("##").format((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaAdaptation) + "/5");
	}
}
