package net.mcreator.distantworlds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.init.DistantWorldsModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityAttackedProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof LivingEntity && !(entity == sourceentity)) {
			if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(DistantWorldsModMobEffects.IGNITION.get()) && !entity.fireImmune()) {
				entity.setSecondsOnFire((int) (1 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DistantWorldsModMobEffects.IGNITION.get()) ? _livEnt.getEffect(DistantWorldsModMobEffects.IGNITION.get()).getAmplifier() : 0)));
			}
		}
	}
}
