package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.distantworlds.init.DistantWorldsModItems;

import java.util.concurrent.atomic.AtomicReference;

public class LithumAltarRecipePickerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack itemstack6 = ItemStack.EMPTY;
		ItemStack itemstack5 = ItemStack.EMPTY;
		ItemStack itemstack8 = ItemStack.EMPTY;
		ItemStack itemstack7 = ItemStack.EMPTY;
		ItemStack itemstack2 = ItemStack.EMPTY;
		ItemStack itemstack1 = ItemStack.EMPTY;
		ItemStack itemstack4 = ItemStack.EMPTY;
		ItemStack itemstack3 = ItemStack.EMPTY;
		String Result = "";
		String summ = "";
		double Loop = 0;
		double xOffset = 0;
		double EmptyItemstack = 0;
		double XPLevel = 0;
		double zOffset = 0;
		if (!world.isClientSide()) {
			if ((Result).equals("")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.lithum_multiblock.norecipe").getString())), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			} else if (Result.contains("!NoAdv")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.lithum_multiblock.noadv").getString())), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			} else if (Result.contains("!NoXp")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(((Component.translatable("event.distant_worlds.lithum_multiblock.noxp").getString()).replace("%1", new java.text.DecimalFormat("##").format(XPLevel)))), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putString("CurrentRecipe", Result);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				Loop = 0;
				if (!world.isClientSide()) {
					for (int index0 = 0; index0 < 8; index0++) {
						if (Loop == 0) {
							xOffset = -2;
							zOffset = -1;
						} else if (Loop == 1) {
							xOffset = -1;
							zOffset = -2;
						} else if (Loop == 2) {
							xOffset = 1;
							zOffset = -2;
						} else if (Loop == 3) {
							xOffset = 2;
							zOffset = -1;
						} else if (Loop == 4) {
							xOffset = 2;
							zOffset = 1;
						} else if (Loop == 5) {
							xOffset = 1;
							zOffset = 2;
						} else if (Loop == 6) {
							xOffset = -1;
							zOffset = 2;
						} else {
							xOffset = -2;
							zOffset = 1;
						}
						if ((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 1)).getItem() == DistantWorldsModItems.MODULE_CHARMED_PEDESTAL.get()) {
							if (Math.random() < 0.9) {
								{
									BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x + xOffset, y, z + zOffset));
									if (_ent != null) {
										final int _slotid = 0;
										final int _amount = 1;
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
											if (capability instanceof IItemHandlerModifiable) {
												ItemStack _stk = capability.getStackInSlot(_slotid).copy();
												_stk.shrink(_amount);
												((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
											}
										});
									}
								}
							}
						} else {
							{
								BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x + xOffset, y, z + zOffset));
								if (_ent != null) {
									final int _slotid = 0;
									final int _amount = 1;
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable) {
											ItemStack _stk = capability.getStackInSlot(_slotid).copy();
											_stk.shrink(_amount);
											((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
										}
									});
								}
							}
						}
						Loop = Loop + 1;
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.power_select")), SoundSource.BLOCKS, 1, (float) (1 + Math.random() * 0.2));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.power_select")), SoundSource.BLOCKS, 1, (float) (1 + Math.random() * 0.2), false);
					}
				}
				if (!(entity instanceof ServerPlayer _plr17 && _plr17.level() instanceof ServerLevel
						&& _plr17.getAdvancements().getOrStartProgress(_plr17.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:magic_of_stones_and_crystals"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:magic_of_stones_and_crystals"));
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
}
