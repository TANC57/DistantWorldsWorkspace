
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.distantworlds.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber
public class DistantWorldsModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == DistantWorldsModItems.MOLTEN_FRALITE.get())
			event.setBurnTime(800);
		else if (itemstack.getItem() == DistantWorldsModItems.FRALITE_HEART.get())
			event.setBurnTime(6400);
		else if (itemstack.getItem() == DistantWorldsModItems.RAW_CURELITE.get())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == DistantWorldsModItems.CURELITE.get())
			event.setBurnTime(3200);
		else if (itemstack.getItem() == DistantWorldsModBlocks.RAW_CURELITE_BLOCK.get().asItem())
			event.setBurnTime(16000);
		else if (itemstack.getItem() == DistantWorldsModBlocks.CURELITE_BLOCK.get().asItem())
			event.setBurnTime(32000);
	}
}
