package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class GarsaleSaplingUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (Math.random() < 0.1) {
				if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == DistantWorldsModBlocks.GARSALE_SAPLING.get()
						&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == DistantWorldsModBlocks.GARSALE_SAPLING.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == DistantWorldsModBlocks.GARSALE_SAPLING.get()) {
					GarsaleTreeWidePlacementProcedureProcedure.execute(world, x, y, z);
				} else {
					GarsaleTreePlacementProcedureProcedure.execute(world, x, y, z);
				}
			}
		}
	}
}
