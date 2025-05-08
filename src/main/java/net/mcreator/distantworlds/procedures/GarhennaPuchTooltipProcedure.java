package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.distantworlds.init.DistantWorldsModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class GarhennaPuchTooltipProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getEntity(), event.getItemStack(), event.getToolTip());
	}

	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		execute(null, entity, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		double additional_number = 0;
		double count_of_lines = 0;
		if (itemstack.getItem() == DistantWorldsModItems.GARHENNA_POUCH.get()) {
			if ((entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) && itemstack.getOrCreateTag().getBoolean("generatedTag")) {
				while (!(itemstack.getOrCreateTag().getString(("lootLine" + Math.round(additional_number)))).equals("")) {
					tooltip.add((int) (additional_number + 1),
							Component.literal(("\u00A77\u2014 " + Math.round(itemstack.getOrCreateTag().getDouble(("countLine" + Math.round(additional_number)))) + " "
									+ new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((itemstack.getOrCreateTag().getString(("lootLine" + Math.round(additional_number))))).toLowerCase(java.util.Locale.ENGLISH)))).getDisplayName()
											.getString())));
					additional_number = additional_number + 1;
				}
			} else {
				tooltip.add(1, Component.literal(("\u00A77\u2014 " + Component.translatable("item.distant_worlds.garhenna_pouch.description.unknown").getString())));
			}
		}
	}
}
