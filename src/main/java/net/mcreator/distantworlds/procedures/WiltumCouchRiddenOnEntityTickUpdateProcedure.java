package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class WiltumCouchRiddenOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _getbp1 && (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getbp1)
				|| !(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("distant_worlds:wiltum_couch_blocks")))) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();
		entity.clearFire();
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 0) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
