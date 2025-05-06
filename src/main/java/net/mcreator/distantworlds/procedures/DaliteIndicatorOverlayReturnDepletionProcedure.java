package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;
import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

public class DaliteIndicatorOverlayReturnDepletionProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("gui.distant_worlds.dalite_indicator_overlay.depletion").getString() + ""
				+ ((new java.text.DecimalFormat("##.#").format((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion / 1000) + "K") + ""
						+ ("/" + (new java.text.DecimalFormat("##.#").format(((double) ConfigCommonConfiguration.MAX_GARHENNA_DEPLETION.get() >= 1200 ? (double) ConfigCommonConfiguration.MAX_GARHENNA_DEPLETION.get() : 1200) / 1000) + "K")));
	}
}
