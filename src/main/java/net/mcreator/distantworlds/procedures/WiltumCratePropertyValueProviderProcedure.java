package net.mcreator.distantworlds.procedures;

import net.minecraft.world.item.ItemStack;

public class WiltumCratePropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		if ((itemstack.getOrCreateTag().getString("Contains")).equals("baby_salmoran")) {
			return 1;
		}
		return 0;
	}
}
