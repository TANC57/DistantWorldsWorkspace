package net.mcreator.distantworlds.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.init.DistantWorldsModEntities;
import net.mcreator.distantworlds.entity.SalmoranEntity;
import net.mcreator.distantworlds.entity.BabySalmoranEntity;

import java.util.Comparator;

public class BabySalmoranOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		String Name = "";
		if (!world.isClientSide()) {
			if ((entity instanceof BabySalmoranEntity _datEntI ? _datEntI.getEntityData().get(BabySalmoranEntity.DATA_Age) : 0) < 7200) {
				if (entity instanceof BabySalmoranEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BabySalmoranEntity.DATA_Age, (int) ((entity instanceof BabySalmoranEntity _datEntI ? _datEntI.getEntityData().get(BabySalmoranEntity.DATA_Age) : 0) + 1));
			} else {
				if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT) == true) {
					for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), 1, 6); index0++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(DistantWorldsModItems.SALMORAN_SCALES.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = DistantWorldsModEntities.SALMORAN.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(entity.getYRot());
						entityToSpawn.setYBodyRot(entity.getYRot());
						entityToSpawn.setYHeadRot(entity.getYRot());
						entityToSpawn.setXRot(entity.getXRot());
						entityToSpawn.setDeltaMovement(0, 0, 0);

						if (entity.isOnFire()) {
							entityToSpawn.setSecondsOnFire(entity.getRemainingFireTicks());
						}
						if (entityToSpawn instanceof TamableAnimal _toTame && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof Player _owner)
							_toTame.tame(_owner);
						Name = entity.getDisplayName().getString();
						if (!(Name).equals(Component.translatable("entity.distant_worlds.baby_salmoran").getString())) {
							entityToSpawn.setCustomName(Component.literal(Name));
						}
						if (entityToSpawn instanceof SalmoranEntity _datEntSetI)
							_datEntSetI.getEntityData().set(SalmoranEntity.DATA_Behavior, (int) (entity instanceof BabySalmoranEntity _datEntI ? _datEntI.getEntityData().get(BabySalmoranEntity.DATA_Behavior) : 0));
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}
