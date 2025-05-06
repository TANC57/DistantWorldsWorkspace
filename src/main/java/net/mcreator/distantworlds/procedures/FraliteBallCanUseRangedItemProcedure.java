package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class FraliteBallCanUseRangedItemProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		return !((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + entity.getBbHeight() * 0.75, entity.getZ()))).getBlock() instanceof LiquidBlock);
	}
}
