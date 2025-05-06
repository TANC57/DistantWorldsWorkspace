package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class LithumTransmitterCrystalPlayReturnedAnimationProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x + 2, y - 2, z + 2))).getBlock() == DistantWorldsModBlocks.LITHUM_CORE.get() && !(new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x + 2, y - 2, z + 2), "CurrentRecipe")).equals("") || (world.getBlockState(BlockPos.containing(x - 2, y - 2, z + 2))).getBlock() == DistantWorldsModBlocks.LITHUM_CORE.get() && !(new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x - 2, y - 2, z + 2), "CurrentRecipe")).equals("") || (world.getBlockState(BlockPos.containing(x - 2, y - 2, z - 2))).getBlock() == DistantWorldsModBlocks.LITHUM_CORE.get() && !(new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x - 2, y - 2, z - 2), "CurrentRecipe")).equals("") || (world.getBlockState(BlockPos.containing(x + 2, y - 2, z - 2))).getBlock() == DistantWorldsModBlocks.LITHUM_CORE.get() && !(new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x + 2, y - 2, z - 2), "CurrentRecipe")).equals("")) {
			return true;
		}
		return false;
	}
}
