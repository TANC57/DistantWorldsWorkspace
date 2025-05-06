package net.mcreator.distantworlds.procedures;

import net.minecraft.world.item.ItemStack;

public class DaliteStorageAdvancedInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("MaxEnergy") != 30000) {
			itemstack.getOrCreateTag().putDouble("MaxEnergy", 30000);
		}
	}
}
