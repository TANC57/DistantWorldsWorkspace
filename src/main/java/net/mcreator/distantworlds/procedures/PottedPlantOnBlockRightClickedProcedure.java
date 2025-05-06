package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

import java.util.Map;

public class PottedPlantOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = Blocks.FLOWER_POT.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_GARSALE_SAPLING.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.GARSALE_SAPLING.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_WILTUM_SAPLING.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.WILTUM_SAPLING.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_ASMULDA_BERRY_BUSH.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModItems.ASMULDA_BERRIES.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_AFOLLA.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.AFOLLA.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_WALIS.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.WALIS.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_SUWONNA.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.SUWONNA.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_APHLAVIS.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.SUWONNA.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_CREWANOLLA.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.CREWANOLLA.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_CEBLUM.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.CEBLUM.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_RINYOT.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.RINYOT.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_IROTINE.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.IROTINE.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_LAFOSIA.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.LAFOSIA.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_CULAFITE_MUSHROOM.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.CULAFITE_MUSHROOM.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_LIORESS.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.LIORESS.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_PRIFONNA.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.PRIFONNA.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_FUZIANNA.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.FUZIANNA.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_WOKAMIRE.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.WOKAMIRE.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_ULBISEAF.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.ULBISEAF.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_OTREBORE.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DistantWorldsModBlocks.OTREBORE.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_FUZIANNA.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.POISONOUS_POTATO && new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "Fertilized") > 0) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Fertilized", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.POISONOUS_POTATO);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.honeycomb.wax_on")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.honeycomb.wax_on")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SNEEZE, (x + 0.5), (y + 0.5), (z + 0.5), 5, 0.5, 0.5, 0.5, 0);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BONE_MEAL && new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "Fertilized") <= 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Fertilized", (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "Fertilized") + 5));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.BONE_MEAL);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + 0.5), (y + 0.5), (z + 0.5), 5, 0.5, 0.5, 0.5, 1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.honeycomb.wax_on")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.honeycomb.wax_on")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
		}
	}
}
