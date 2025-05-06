package net.mcreator.distantworlds.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.distantworlds.entity.BabySalmoranEntity;
import net.mcreator.distantworlds.DistantWorldsMod;

import java.util.Comparator;

public class BabySalmoranOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		DistantWorldsMod.queueServerWork(1, () -> {
			if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 3, 3, 3), e -> true).isEmpty()) {
					if (entity instanceof TamableAnimal _toTame && ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 3, 3, 3), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) instanceof Player _owner)
						_toTame.tame(_owner);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HEART, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 1, 1, 1, 0.1);
				}
			}
		});
		if (entity instanceof BabySalmoranEntity _datEntSetI)
			_datEntSetI.getEntityData().set(BabySalmoranEntity.DATA_Behavior, 1);
	}
}
