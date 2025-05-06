package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class WiltumSaplingOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == DistantWorldsModBlocks.WILTUM_SAPLING.get() && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == DistantWorldsModBlocks.WILTUM_SAPLING.get()
					&& (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == DistantWorldsModBlocks.WILTUM_SAPLING.get()) {
				WiltumTreeWidePlacementProcedure.execute(world, x, y, z);
			} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == DistantWorldsModBlocks.WILTUM_SAPLING.get()
					&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == DistantWorldsModBlocks.WILTUM_SAPLING.get()
					&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == DistantWorldsModBlocks.WILTUM_SAPLING.get()) {
				WiltumTreeWidePlacementProcedure.execute(world, (x - 1), y, z);
			} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == DistantWorldsModBlocks.WILTUM_SAPLING.get()
					&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == DistantWorldsModBlocks.WILTUM_SAPLING.get()
					&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == DistantWorldsModBlocks.WILTUM_SAPLING.get()) {
				WiltumTreeWidePlacementProcedure.execute(world, (x - 1), y, (z - 1));
			} else if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == DistantWorldsModBlocks.WILTUM_SAPLING.get()
					&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == DistantWorldsModBlocks.WILTUM_SAPLING.get()
					&& (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == DistantWorldsModBlocks.WILTUM_SAPLING.get()) {
				WiltumTreeWidePlacementProcedure.execute(world, x, y, (z - 1));
			} else {
				WiltumTreePlacementProcedureProcedure.execute(world, x, y, z);
			}
		}
	}
}
