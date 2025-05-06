package net.mcreator.distantworlds.procedures;

import net.minecraft.world.item.ItemStack;

public class DaliteStorageExtendedInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("MaxEnergy") != 15000) {
			itemstack.getOrCreateTag().putDouble("MaxEnergy", 15000);
		}
	}
}
