package net.mcreator.distantworlds.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.Difficulty;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;
import net.mcreator.distantworlds.entity.CrouthilEntity;

public class CrouthilNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return !(world.getDifficulty() == Difficulty.PEACEFUL)
				&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("distant_worlds:fralite_golems_spawnable_on"))) && y < 90
						|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == DistantWorldsModBlocks.GARSALE_PLANKS.get())
				&& !(!world.getEntitiesOfClass(CrouthilEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty());
	}
}
