package net.mcreator.distantworlds.procedures;

import net.minecraft.world.item.ItemStack;

public class GarsaleCratePropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		if ((itemstack.getOrCreateTag().getString("Contains")).equals("baby_noarhorn")) {
			return 1;
		}
		return 0;
	}
}
