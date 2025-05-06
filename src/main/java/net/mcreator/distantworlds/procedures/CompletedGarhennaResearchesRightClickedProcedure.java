package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

public class CompletedGarhennaResearchesRightClickedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String CurrentResearch = "";
		double Experience = 0;
		if (!world.isClientSide()) {
			CurrentResearch = itemstack.getOrCreateTag().getString("CompletedResearch");
			if ((CurrentResearch).equals("incandescent_forever")) {
				if (!(entity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel
						&& _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:incandescent_forever"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:incandescent_forever"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					Experience = 25;
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.setCount(0);
					}
				}
			}
			if ((CurrentResearch).equals("bright_clusters")) {
				if (!(entity instanceof ServerPlayer _plr8 && _plr8.level() instanceof ServerLevel
						&& _plr8.getAdvancements().getOrStartProgress(_plr8.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:bright_clusters"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:bright_clusters"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					Experience = 5;
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.setCount(0);
					}
				}
			}
			if ((CurrentResearch).equals("awakened_stones")) {
				if (!(entity instanceof ServerPlayer _plr13 && _plr13.level() instanceof ServerLevel
						&& _plr13.getAdvancements().getOrStartProgress(_plr13.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:awakened_stones"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:awakened_stones"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					Experience = 15;
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.setCount(0);
					}
				}
			}
			if ((CurrentResearch).equals("new_energy")) {
				if (!(entity instanceof ServerPlayer _plr18 && _plr18.level() instanceof ServerLevel
						&& _plr18.getAdvancements().getOrStartProgress(_plr18.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:new_energy"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:new_energy"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					Experience = 10;
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.setCount(0);
					}
				}
			}
			if ((CurrentResearch).equals("better_without_hugs")) {
				if (!(entity instanceof ServerPlayer _plr23 && _plr23.level() instanceof ServerLevel
						&& _plr23.getAdvancements().getOrStartProgress(_plr23.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:better_without_hugs"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:better_without_hugs"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					Experience = 15;
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.setCount(0);
					}
				}
			}
			if ((CurrentResearch).equals("strong_shell")) {
				if (!(entity instanceof ServerPlayer _plr28 && _plr28.level() instanceof ServerLevel
						&& _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:strong_shell"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:strong_shell"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					Experience = 15;
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.setCount(0);
					}
				}
			}
			if ((CurrentResearch).equals("experienced_mushroom_picker")) {
				if (!(entity instanceof ServerPlayer _plr33 && _plr33.level() instanceof ServerLevel
						&& _plr33.getAdvancements().getOrStartProgress(_plr33.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:experienced_mushroom_picker"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:experienced_mushroom_picker"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					Experience = 5;
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.setCount(0);
					}
				}
			}
			if ((CurrentResearch).equals("inner_spark")) {
				if (!(entity instanceof ServerPlayer _plr38 && _plr38.level() instanceof ServerLevel
						&& _plr38.getAdvancements().getOrStartProgress(_plr38.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:inner_spark"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:inner_spark"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					Experience = 15;
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.setCount(0);
					}
				}
			}
			if ((CurrentResearch).equals("trees_are_watching")) {
				if (!(entity instanceof ServerPlayer _plr43 && _plr43.level() instanceof ServerLevel
						&& _plr43.getAdvancements().getOrStartProgress(_plr43.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:trees_are_watching"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:trees_are_watching"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					Experience = 15;
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.setCount(0);
					}
				}
			}
			if ((CurrentResearch).equals("does_it_smile")) {
				if (!(entity instanceof ServerPlayer _plr48 && _plr48.level() instanceof ServerLevel
						&& _plr48.getAdvancements().getOrStartProgress(_plr48.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:does_it_smile"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:does_it_smile"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					Experience = 10;
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.setCount(0);
					}
				}
			}
			if ((CurrentResearch).equals("living_metal")) {
				if (!(entity instanceof ServerPlayer _plr53 && _plr53.level() instanceof ServerLevel
						&& _plr53.getAdvancements().getOrStartProgress(_plr53.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:living_metal"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:living_metal"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					Experience = 20;
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.setCount(0);
					}
				}
			}
			if ((CurrentResearch).equals("born_to_crawl")) {
				if (!(entity instanceof ServerPlayer _plr58 && _plr58.level() instanceof ServerLevel
						&& _plr58.getAdvancements().getOrStartProgress(_plr58.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:born_to_crawl"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:born_to_crawl"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					Experience = 15;
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.setCount(0);
					}
				}
			}
			if ((CurrentResearch).equals("at_the_very_top")) {
				if (!(entity instanceof ServerPlayer _plr63 && _plr63.level() instanceof ServerLevel
						&& _plr63.getAdvancements().getOrStartProgress(_plr63.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:at_the_very_top"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:at_the_very_top"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					Experience = 10;
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.setCount(0);
					}
				}
			}
			if ((CurrentResearch).equals("encased_soul")) {
				if (!(entity instanceof ServerPlayer _plr68 && _plr68.level() instanceof ServerLevel
						&& _plr68.getAdvancements().getOrStartProgress(_plr68.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:encased_soul"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:encased_soul"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					Experience = 20;
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.setCount(0);
					}
				}
			}
			if (entity instanceof Player _player)
				_player.giveExperienceLevels((int) (Experience * Math.abs((double) ConfigCommonConfiguration.RESEARCH_EXPERIENCE_REWARD_MODIFIER.get())));
		}
	}
}
