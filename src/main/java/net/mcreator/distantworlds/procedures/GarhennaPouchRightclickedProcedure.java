package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class GarhennaPouchRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				itemstack.setCount((int) (itemstack.getCount() - 1));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.PLAYERS, (float) 0.5, (float) (0.8 + Math.random() * 0.4));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.PLAYERS, (float) 0.5, (float) (0.8 + Math.random() * 0.4), false);
				}
			}
			if (Math.random() < 0.5) {
				if (Math.random() < 0.05) {
					if (entity instanceof ServerPlayer _plr7 && _plr7.level() instanceof ServerLevel
							&& _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:at_the_very_top"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.WILTUM_FRUIT.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				} else if (Math.random() < 0.05) {
					if (entity instanceof ServerPlayer _plr12 && _plr12.level() instanceof ServerLevel
							&& _plr12.getAdvancements().getOrStartProgress(_plr12.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:does_it_smile"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.GARSALE_FRUIT.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				} else if (Math.random() < 0.075) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.WOKAMIRE.get());
						_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 3));
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else if (Math.random() < 0.075) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.FUZIANNA.get());
						_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 3));
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else if (Math.random() < 0.1) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.WILTUM_SAPLING.get());
						_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 3));
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else if (Math.random() < 0.1) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.GARSALE_SAPLING.get());
						_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 3));
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else if (Math.random() < 0.15) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(DistantWorldsModItems.RAW_WOKAMIRE.get());
						_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 3));
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else if (Math.random() < 0.15) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.CULAFITE_MUSHROOM.get());
						_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 6));
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(DistantWorldsModItems.ASMULDA_BERRIES.get());
						_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 8));
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			} else if (Math.random() < 0.35) {
				if (Math.random() < 0.08) {
					if (entity instanceof ServerPlayer _plr31 && _plr31.level() instanceof ServerLevel
							&& _plr31.getAdvancements().getOrStartProgress(_plr31.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:better_without_hugs"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.NOARHORN_SPIKE.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				} else if (Math.random() < 0.1) {
					if (entity instanceof ServerPlayer _plr36 && _plr36.level() instanceof ServerLevel
							&& _plr36.getAdvancements().getOrStartProgress(_plr36.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:strong_shell"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.UBRICITE_CRYSTAL.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				} else if (Math.random() < 0.12) {
					if (entity instanceof ServerPlayer _plr41 && _plr41.level() instanceof ServerLevel
							&& _plr41.getAdvancements().getOrStartProgress(_plr41.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:trees_are_watching"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.GLOWING_POLLEN.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				} else if (Math.random() < 0.15) {
					if (entity instanceof ServerPlayer _plr46 && _plr46.level() instanceof ServerLevel
							&& _plr46.getAdvancements().getOrStartProgress(_plr46.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:trees_are_watching"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.STICKY_GARSALE_BARK.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 3));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				} else if (Math.random() < 0.2) {
					if (entity instanceof ServerPlayer _plr51 && _plr51.level() instanceof ServerLevel
							&& _plr51.getAdvancements().getOrStartProgress(_plr51.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:born_to_crawl"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.SALMORAN_SCALES.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 3));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				} else if (Math.random() < 0.2) {
					if (entity instanceof ServerPlayer _plr56 && _plr56.level() instanceof ServerLevel
							&& _plr56.getAdvancements().getOrStartProgress(_plr56.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:awakened_stones"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.FRALITE_HEART.get());
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 6));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				} else {
					if (entity instanceof ServerPlayer _plr60 && _plr60.level() instanceof ServerLevel
							&& _plr60.getAdvancements().getOrStartProgress(_plr60.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:awakened_stones"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.MOLTEN_FRALITE.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 6));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 6));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				}
			} else {
				if (Math.random() < 0.1) {
					if (entity instanceof ServerPlayer _plr65 && _plr65.level() instanceof ServerLevel
							&& _plr65.getAdvancements().getOrStartProgress(_plr65.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:incandescent_forever"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.RAW_FIRON.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				} else if (Math.random() < 0.15) {
					if (entity instanceof ServerPlayer _plr70 && _plr70.level() instanceof ServerLevel
							&& _plr70.getAdvancements().getOrStartProgress(_plr70.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:encased_soul"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.RAW_HELYST.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				} else if (Math.random() < 0.15) {
					if (entity instanceof ServerPlayer _plr75 && _plr75.level() instanceof ServerLevel
							&& _plr75.getAdvancements().getOrStartProgress(_plr75.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:living_metal"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.RAW_VAIRIS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 3));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				} else if (Math.random() < 0.2) {
					if (entity instanceof ServerPlayer _plr80 && _plr80.level() instanceof ServerLevel
							&& _plr80.getAdvancements().getOrStartProgress(_plr80.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:inner_spark"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.RAW_DALITE.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 3));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				} else if (Math.random() < 0.2) {
					if (entity instanceof ServerPlayer _plr85 && _plr85.level() instanceof ServerLevel
							&& _plr85.getAdvancements().getOrStartProgress(_plr85.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:new_energy"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.CURELITE.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 4));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				} else {
					if (entity instanceof ServerPlayer _plr90 && _plr90.level() instanceof ServerLevel
							&& _plr90.getAdvancements().getOrStartProgress(_plr90.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:new_energy"))).isDone()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.RAW_CURELITE.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 6));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(DistantWorldsModItems.ANCIENT_GARHENNA_PAPERS.get());
							_setstack.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				}
			}
		}
	}
}
