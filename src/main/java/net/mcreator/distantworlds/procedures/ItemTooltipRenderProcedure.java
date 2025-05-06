package net.mcreator.distantworlds.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import software.bernie.geckolib.core.object.Color;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;
import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class ItemTooltipRenderProcedure {
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
		String CurrentResearch = "";
		String duration = "";
		String Color = "";
		double Experience = 0;
		double CurrentDuration = 0;
		double MaxEnergy = 0;
		if (itemstack.getItem() == DistantWorldsModItems.RETURN_RING.get() && ((entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(DistantWorldsModItems.RETURN_RING.get(), lv).isPresent() : false ? true : false)
				|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(DistantWorldsModItems.RETURN_RING.get())) : false))) {
			tooltip.add(Component.literal(("\u00A77X = " + ("\u00A72" + ReturnRingOverlayReturnXProcedure.execute(entity)))));
			tooltip.add(Component.literal(("\u00A77Y = " + ("\u00A72" + ReturnRingOverlayReturnYProcedure.execute(entity)))));
			tooltip.add(Component.literal(("\u00A77Z = " + ("\u00A72" + ReturnRingOverlayReturnZProcedure.execute(entity)))));
		} else if (itemstack.getItem() == DistantWorldsModItems.CHARGED_WITHER_TOTEM.get()
				&& ((entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get(), lv).isPresent() : false ? true : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(DistantWorldsModItems.CHARGED_WITHER_TOTEM.get())) : false))
				|| itemstack.getItem() == DistantWorldsModItems.WITHER_TOTEM.get() && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(DistantWorldsModItems.WITHER_TOTEM.get())) : false)) {
			tooltip.add(Component.literal(("\u00A77X = " + ("\u00A76" + WitherTotemOverlayReturnXProcedure.execute(entity)))));
			tooltip.add(Component.literal(("\u00A77Y = " + ("\u00A76" + WitherTotemOverlayReturnYProcedure.execute(entity)))));
			tooltip.add(Component.literal(("\u00A77Z = " + ("\u00A76" + WitherTotemOverlayReturnZProcedure.execute(entity)))));
		} else if (itemstack.getItem() == DistantWorldsModItems.DALITE_INDICATOR.get()
				&& ((entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(DistantWorldsModItems.DALITE_INDICATOR.get(), lv).isPresent() : false ? true : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(DistantWorldsModItems.DALITE_INDICATOR.get())) : false))) {
			tooltip.add(Component.literal(("\u00A77" + (Component.translatable("gui.distant_worlds.dalite_indicator_overlay.depletion").getString() + ""
					+ ("\u00A76" + (new java.text.DecimalFormat("##").format((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion) + ""
							+ ("/" + new java.text.DecimalFormat("##").format((double) ConfigCommonConfiguration.MAX_GARHENNA_DEPLETION.get()))))))));
			tooltip.add(Component.literal(("\u00A77" + (Component.translatable("gui.distant_worlds.dalite_indicator_overlay.adaptation").getString() + ""
					+ ("\u00A76" + (new java.text.DecimalFormat("##").format((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaAdaptation) + "/5"))))));
			tooltip.add(Component.literal(("\u00A77" + (Component.translatable("gui.distant_worlds.dalite_indicator_overlay.permanent_immunity").getString() + "" + ("\u00A76"
					+ (new java.text.DecimalFormat("##").format((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).PermanentGarhennaImmunity) + "/5"))))));
		} else if (itemstack.getItem() == DistantWorldsModItems.COMPLETED_GARHENNA_RESEARCHES.get()) {
			CurrentResearch = itemstack.getOrCreateTag().getString("CompletedResearch");
			if ((CurrentResearch).equals("incandescent_forever")) {
				Experience = 25;
			} else if ((CurrentResearch).equals("bright_clusters")) {
				Experience = 5;
			} else if ((CurrentResearch).equals("awakened_stones")) {
				Experience = 15;
			} else if ((CurrentResearch).equals("new_energy")) {
				Experience = 10;
			} else if ((CurrentResearch).equals("better_without_hugs")) {
				Experience = 15;
			} else if ((CurrentResearch).equals("strong_shell")) {
				Experience = 15;
			} else if ((CurrentResearch).equals("experienced_mushroom_picker")) {
				Experience = 5;
			} else if ((CurrentResearch).equals("inner_spark")) {
				Experience = 15;
			} else if ((CurrentResearch).equals("trees_are_watching")) {
				Experience = 15;
			} else if ((CurrentResearch).equals("does_it_smile")) {
				Experience = 10;
			} else if ((CurrentResearch).equals("living_metal")) {
				Experience = 20;
			} else if ((CurrentResearch).equals("born_to_crawl")) {
				Experience = 15;
			} else if ((CurrentResearch).equals("at_the_very_top")) {
				Experience = 10;
			} else if ((CurrentResearch).equals("encased_soul")) {
				Experience = 20;
			}
			Experience = Experience * Math.abs((double) ConfigCommonConfiguration.RESEARCH_EXPERIENCE_REWARD_MODIFIER.get());
			tooltip.add(Component
					.literal((((Component.translatable("item.tooltip.title").getString() + "\u00A76\u00AB") + "" + Component.translatable(("advancements." + (itemstack.getOrCreateTag().getString("CompletedResearch") + ".title"))).getString())
							+ "\u00BB\u00A7r")));
			tooltip.add(Component.literal((("\u00A77" + (Component.translatable("item.tooltip.contains").getString() + ": \u00A72")) + ""
					+ (new java.text.DecimalFormat("##").format(Experience) + "" + (Component.translatable("item.tooltip.xplvl").getString() + "\u00A7r")))));
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("distant_worlds:dalite_storage")))) {
			if (itemstack.getItem() == DistantWorldsModItems.DALITE_STORAGE_INITIAL.get()) {
				MaxEnergy = 7500;
			} else if (itemstack.getItem() == DistantWorldsModItems.DALITE_STORAGE_EXTENDED.get()) {
				MaxEnergy = 15000;
			} else {
				MaxEnergy = 30000;
			}
			CurrentDuration = Math.floor((itemstack.getOrCreateTag().getDouble("CurrentEnergy") * 20) / MaxEnergy);
			if (itemstack.getOrCreateTag().getDouble("CurrentEnergy") <= 0) {
				Color = "\u00A77";
			} else if (CurrentDuration >= 15) {
				Color = "\u00A7e";
			} else if (CurrentDuration >= 5) {
				Color = "\u00A76";
			} else {
				Color = "\u00A7c";
			}
			duration = Component.translatable("item.tooltip.energy").getString() + "" + ("\u00A7l" + Color);
			for (int index0 = 0; index0 < (int) CurrentDuration; index0++) {
				duration = duration + "|";
			}
			duration = duration + "\u00A78";
			for (int index1 = 0; index1 < (int) (20 - CurrentDuration); index1++) {
				duration = duration + "|";
			}
			duration = duration + "\u00A7r";
			tooltip.add(Component.literal(duration));
			tooltip.add(Component.literal((Color + "" + (new java.text.DecimalFormat("##").format(itemstack.getOrCreateTag().getDouble("CurrentEnergy")) + "" + (" / " + new java.text.DecimalFormat("##").format(MaxEnergy))))));
		} else if (itemstack.getItem() == DistantWorldsModItems.GARSALE_CRATE.get()) {
			if ((itemstack.getOrCreateTag().getString("Contains")).equals("noarhorn")) {
				tooltip.add(Component.literal(("\u00A77" + (Component.translatable("item.tooltip.contains").getString() + "" + (": \u00A78" + Component.translatable("entity.distant_worlds.baby_noarhorn").getString())))));
			} else {
				tooltip.add(Component.literal(("\u00A77" + (Component.translatable("item.tooltip.contains").getString() + "" + (": \u00A78" + Component.translatable("item.tooltip.empty").getString())))));
			}
		} else if (itemstack.getItem() == DistantWorldsModItems.WILTUM_CRATE.get()) {
			if ((itemstack.getOrCreateTag().getString("Contains")).equals("salmoran")) {
				tooltip.add(Component.literal(("\u00A77" + (Component.translatable("item.tooltip.contains").getString() + "" + (": \u00A78" + Component.translatable("entity.distant_worlds.baby_salmoran").getString())))));
			} else {
				tooltip.add(Component.literal(("\u00A77" + (Component.translatable("item.tooltip.contains").getString() + "" + (": \u00A78" + Component.translatable("item.tooltip.empty").getString())))));
			}
		}
	}
}
