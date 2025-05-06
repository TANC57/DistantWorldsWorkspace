package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class GarhennaResearchesTableUpdateLevelProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double xOffset = 0;
		double yOffset = 0;
		double zOffset = 0;
		double BookshelfBlocks = 0;
		double Result = 0;
		yOffset = y;
		for (int index0 = 0; index0 < 2; index0++) {
			zOffset = -2;
			for (int index1 = 0; index1 < 5; index1++) {
				xOffset = -2;
				for (int index2 = 0; index2 < 5; index2++) {
					if (xOffset * xOffset + zOffset * zOffset == 4 || xOffset * xOffset + zOffset * zOffset == 5) {
						if ((world.getBlockState(BlockPos.containing(x + xOffset, yOffset, z + zOffset))).getBlock() == DistantWorldsModBlocks.GARSALE_BOOKSHELF.get()) {
							if (Math.abs(xOffset) > Math.abs(zOffset)
									? !world.getBlockState(BlockPos.containing(x + xOffset / 2, yOffset, z + zOffset)).canOcclude()
									: !world.getBlockState(BlockPos.containing(x + xOffset, yOffset, z + zOffset / 2)).canOcclude()) {
								BookshelfBlocks = BookshelfBlocks + 1;
							}
						}
					}
					xOffset = xOffset + 1;
				}
				zOffset = zOffset + 1;
			}
			yOffset = yOffset + 1;
		}
		if (BookshelfBlocks >= 3) {
			Result = 1;
		}
		if (BookshelfBlocks >= 6) {
			Result = 2;
		}
		if (BookshelfBlocks >= 12) {
			Result = 3;
		}
		if (BookshelfBlocks >= 18) {
			Result = 4;
		}
		return Result;
	}
}
