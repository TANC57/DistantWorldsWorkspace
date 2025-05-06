package net.mcreator.distantworlds.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModEntities;
import net.mcreator.distantworlds.entity.WiltumCouchRiddenEntity;

public class WiltumCouchUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (!(!world.getEntitiesOfClass(WiltumCouchRiddenEntity.class, AABB.ofSize(new Vec3((x + 0.5), y, (z + 0.5)), 0.5, 0.5, 0.5), e -> true).isEmpty())
				&& !(blockstate.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _getbp2 && blockstate.getValue(_getbp2))) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = DistantWorldsModEntities.WILTUM_COUCH_RIDDEN.get().spawn(_level, BlockPos.containing(x + 0.5, y, z + 0.5), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}
