package net.mcreator.distantworlds.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class GarsaleVinesEntityCollidesInTheBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && !entity.isShiftKeyDown()) {
			Vec3 vec3 = entity.getDeltaMovement();
			entity.setDeltaMovement(vec3.x * 0.8, vec3.y < 0 ? vec3.y : vec3.y * 0.8, vec3.z * 0.8);
			//entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.8, vec3.y < 0 ? 1 : 0.75, 0.8));
			//entity.setDeltaMovement(entity.getDeltaMovement().add(0, 0, 0));
		}
	}
}
