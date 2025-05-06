package net.mcreator.distantworlds.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityTravelsToDimensionProcedure {
	@SubscribeEvent
	public static void onEntityTravelToDimension(EntityTravelToDimensionEvent event) {
		execute(event, event.getDimension(), event.getEntity());
	}

	public static void execute(ResourceKey<Level> dimension, Entity entity) {
		execute(null, dimension, entity);
	}

	private static void execute(@Nullable Event event, ResourceKey<Level> dimension, Entity entity) {
		if (dimension == null || entity == null)
			return;
		if (entity instanceof Player && ConfigCommonConfiguration.ALLOW_PORTALS.get() == false && (entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("distant_worlds:garhenna")))
				&& !(dimension == Level.OVERWORLD)) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
		if (dimension == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("distant_worlds:garhenna")))
				&& !(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(DistantWorldsModItems.RETURN_RING.get())) : false)
				&& !(entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(DistantWorldsModItems.RETURN_RING.get(), lv).isPresent() : false ? true : false)) {
			if (!(entity instanceof ServerPlayer _plr13 && _plr13.level() instanceof ServerLevel
					&& _plr13.getAdvancements().getOrStartProgress(_plr13.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:where_is_exit"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:where_is_exit"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
	}
}
