package net.mcreator.distantworlds.procedures;

import net.minecraft.world.item.ItemStack;

public class DaliteStorageInitialItemInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("MaxEnergy") != 7500) {
			itemstack.getOrCreateTag().putDouble("MaxEnergy", 7500);
		}
	}
}
