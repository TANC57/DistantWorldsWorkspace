package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class LithumTransmitterCancelRitualProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Loop = 0;
		double xOffset = 0;
		double yOffset = 0;
		double zOffset = 0;
		for (int index0 = 0; index0 < 4; index0++) {
			if (Loop == 0) {
				xOffset = 2;
				yOffset = -2;
				zOffset = 2;
			} else if (Loop == 1) {
				xOffset = -2;
				yOffset = -2;
				zOffset = 2;
			} else if (Loop == 2) {
				xOffset = -2;
				yOffset = -2;
				zOffset = -2;
			} else {
				xOffset = 2;
				yOffset = -2;
				zOffset = -2;
			}
			if (!(new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset), "CurrentRecipe")).equals("")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x + xOffset, y + yOffset, z + zOffset);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putString("CurrentRecipe", "");
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x + xOffset, y + yOffset, z + zOffset);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Recovery", 400);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x + xOffset, y + yOffset, z + zOffset);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("MaxRecovery", 400);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound((x + xOffset), (y + yOffset), (z + zOffset), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
			Loop = Loop + 1;
		}
	}
}
