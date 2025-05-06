package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class GarsaleVinesUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x + 0.5, y + 1, z + 0.5))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
				|| world.getBlockState(BlockPos.containing(x + 0.5, y + 1, z + 0.5)).isFaceSturdy(world, BlockPos.containing(x + 0.5, y + 1, z + 0.5), Direction.DOWN))) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
