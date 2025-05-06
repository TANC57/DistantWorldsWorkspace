
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.distantworlds.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DistantWorldsModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

				new ItemStack(DistantWorldsModItems.GARHENNA_POUCH.get()), 5, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(Items.REDSTONE, 3), new ItemStack(DistantWorldsModItems.RAW_DALITE.get(), 3), 15, 8, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 48), new ItemStack(Items.ENDER_PEARL), new ItemStack(DistantWorldsModItems.GARHENNA_EYE.get()), 2, 15, 0.1f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(Items.COAL), new ItemStack(DistantWorldsModItems.RAW_CURELITE.get()), 10, 3, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.ENDER_EYE), new ItemStack(DistantWorldsModItems.RETURN_RING.get()), 1, 25, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 64), new ItemStack(Blocks.TURTLE_EGG), new ItemStack(DistantWorldsModBlocks.SALMORAN_EGG.get()), 1, 25, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 4), new ItemStack(Items.SWEET_BERRIES), new ItemStack(DistantWorldsModItems.ASMULDA_BERRIES.get()), 10, 5, 0.05f));
	}

	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.LIBRARIAN) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 4), new ItemStack(Items.PAPER), new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get()), 16, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.BOOK), new ItemStack(Items.EMERALD, 16), new ItemStack(DistantWorldsModItems.DISTANT_WORLDS_BOOK.get()), 1, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.BOOK), new ItemStack(Items.EMERALD, 32), new ItemStack(DistantWorldsModItems.GARHENNA_BOOK.get()), 1, 15, 0.05f));
		}
	}
}
