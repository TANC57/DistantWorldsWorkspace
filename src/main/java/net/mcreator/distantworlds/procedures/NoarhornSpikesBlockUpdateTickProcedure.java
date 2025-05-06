package net.mcreator.distantworlds.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class NoarhornSpikesBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3((x + 0.5), (y + 0.5), (z + 0.5));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity) {
					if (entityiterator.tickCount % 20 == 0) {
						if ((world.getFluidState(BlockPos.containing(x + 1, y, z)).createLegacyBlock()) == Blocks.LAVA.defaultBlockState()
								|| (world.getFluidState(BlockPos.containing(x - 1, y, z)).createLegacyBlock()) == Blocks.LAVA.defaultBlockState()
								|| (world.getFluidState(BlockPos.containing(x, y + 1, z)).createLegacyBlock()) == Blocks.LAVA.defaultBlockState()
								|| (world.getFluidState(BlockPos.containing(x, y - 1, z)).createLegacyBlock()) == Blocks.LAVA.defaultBlockState()
								|| (world.getFluidState(BlockPos.containing(x, y, z + 1)).createLegacyBlock()) == Blocks.LAVA.defaultBlockState()
								|| (world.getFluidState(BlockPos.containing(x, y, z - 1)).createLegacyBlock()) == Blocks.LAVA.defaultBlockState()) {
							if (!entityiterator.fireImmune()) {
								entityiterator.setSecondsOnFire(5);
							}
						}
						if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 2) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.THORNS)), 2);
						}
					}
				}
			}
		}
	}
}
