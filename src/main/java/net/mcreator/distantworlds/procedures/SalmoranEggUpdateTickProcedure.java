package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModEntities;
import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class SalmoranEggUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (!((blockstate.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) == true
				|| world.getLevelData().getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING) == false)) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "Age") < 1600) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Age", (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "Age") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "Age") >= 700 && blockstate.getBlock() == DistantWorldsModBlocks.SALMORAN_EGG.get()) {
				world.levelEvent(2001, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), Block.getId(blockstate));
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = DistantWorldsModBlocks.CRACKED_SALMORAN_EGG.get().defaultBlockState();
					BlockEntity _be = world.getBlockEntity(_bp);
					CompoundTag _bnbt = null;
					if (_be != null) {
						_bnbt = _be.saveWithFullMetadata();
						_be.setRemoved();
					}
					world.setBlock(_bp, _bs, 3);
					if (_bnbt != null) {
						_be = world.getBlockEntity(_bp);
						if (_be != null) {
							try {
								_be.load(_bnbt);
							} catch (Exception ignored) {
							}
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.egg_hatch")), SoundSource.BLOCKS, 1, (float) (0.8 + Math.random() * 0.4));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.egg_hatch")), SoundSource.BLOCKS, 1, (float) (0.8 + Math.random() * 0.4), false);
					}
				}
			} else if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "Age") >= 1600) {
				world.levelEvent(2001, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), Block.getId(blockstate));
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.egg_hatch")), SoundSource.BLOCKS, 1, (float) (0.8 + Math.random() * 0.4));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.egg_hatch")), SoundSource.BLOCKS, 1, (float) (0.8 + Math.random() * 0.4), false);
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = DistantWorldsModEntities.BABY_SALMORAN.get().spawn(_level, BlockPos.containing(x + 0.5, y, z + 0.5), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
			}
		}
	}
}
