package net.mcreator.distantworlds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.distantworlds.init.DistantWorldsModMobEffects;
import net.mcreator.distantworlds.entity.DruthEntity;
import net.mcreator.distantworlds.DistantWorldsMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityAttackedByDruthProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (sourceentity instanceof DruthEntity) {
				if (!entity.fireImmune() && !(entity instanceof LivingEntity _livEnt3 && _livEnt3.isBlocking())) {
					if (Math.random() < 0.7) {
						if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(DistantWorldsModMobEffects.IGNITION.get()))) {
							DistantWorldsMod.queueServerWork(5, () -> {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(DistantWorldsModMobEffects.IGNITION.get(), 30, 0));
							});
						} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DistantWorldsModMobEffects.IGNITION.get()) ? _livEnt.getEffect(DistantWorldsModMobEffects.IGNITION.get()).getAmplifier() : 0) < 4) {
							DistantWorldsMod.queueServerWork(5, () -> {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(DistantWorldsModMobEffects.IGNITION.get(), 30,
											(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DistantWorldsModMobEffects.IGNITION.get()) ? _livEnt.getEffect(DistantWorldsModMobEffects.IGNITION.get()).getAmplifier() : 0) + 1)));
							});
						} else {
							DistantWorldsMod.queueServerWork(5, () -> {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(DistantWorldsModMobEffects.IGNITION.get(), 30, 4));
							});
						}
					}
				}
			}
		}
	}
}
