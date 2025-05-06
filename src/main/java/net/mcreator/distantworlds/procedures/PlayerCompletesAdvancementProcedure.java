package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.AdvancementEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerCompletesAdvancementProcedure {
	@SubscribeEvent
	public static void onAdvancement(AdvancementEvent event) {
		execute(event, event.getEntity().level(), event.getAdvancement(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Advancement advancement, Entity entity) {
		execute(null, world, advancement, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Advancement advancement, Entity entity) {
		if (advancement == null || entity == null)
			return;
		ItemStack book = ItemStack.EMPTY;
		if (world instanceof Level _lvl0 && _lvl0.getServer() != null && _lvl0.getServer().getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:burning_world")).equals(advancement)) {
			if (!(entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
					&& _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:garhenna_explore"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:garhenna_explore"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (entity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel && _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:garhenna_explore"))).isDone()
				&& entity instanceof ServerPlayer _plr4 && _plr4.level() instanceof ServerLevel
				&& _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:burning_plains_explore"))).isDone() && entity instanceof ServerPlayer _plr5
				&& _plr5.level() instanceof ServerLevel && _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:molten_hills_explore"))).isDone()
				&& entity instanceof ServerPlayer _plr6 && _plr6.level() instanceof ServerLevel
				&& _plr6.getAdvancements().getOrStartProgress(_plr6.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:sticky_marshes_explore"))).isDone() && entity instanceof ServerPlayer _plr7
				&& _plr7.level() instanceof ServerLevel && _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:dead_valley_explore"))).isDone()) {
			if (!(entity instanceof ServerPlayer _plr8 && _plr8.level() instanceof ServerLevel
					&& _plr8.getAdvancements().getOrStartProgress(_plr8.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:traveled_all_over"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:traveled_all_over"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (ConfigCommonConfiguration.GRANT_GUIDE_BOOKS.get() == true) {
			if (!(entity instanceof ServerPlayer _plr11 && _plr11.level() instanceof ServerLevel
					&& _plr11.getAdvancements().getOrStartProgress(_plr11.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:distant_worlds_explore"))).isDone())) {
				if (world instanceof Level _lvl12 && _lvl12.getServer() != null && _lvl12.getServer().getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:distant_worlds_explore")).equals(advancement)) {
					if (ModList.get().isLoaded("patchouli")) {
						book = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("patchouli:guide_book")));
						book.getOrCreateTag().putString("patchouli:book", "distant_worlds:distant_worlds_book");
						if (entity instanceof Player _player) {
							ItemStack _setstack = book;
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.DISTANT_WORLDS_BOOK.get());
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Message"), false);
					}
				}
			}
			if (!(entity instanceof ServerPlayer _plr19 && _plr19.level() instanceof ServerLevel
					&& _plr19.getAdvancements().getOrStartProgress(_plr19.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:garhenna_explore"))).isDone())) {
				if (world instanceof Level _lvl20 && _lvl20.getServer() != null && _lvl20.getServer().getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:garhenna_explore")).equals(advancement)) {
					if (ModList.get().isLoaded("patchouli")) {
						book = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("patchouli:guide_book")));
						book.getOrCreateTag().putString("patchouli:book", "distant_worlds:garhenna_book");
						if (entity instanceof Player _player) {
							ItemStack _setstack = book;
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.GARHENNA_BOOK.get());
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Message"), false);
					}
				}
			}
		}
	}
}
