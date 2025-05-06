package net.mcreator.distantworlds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.distantworlds.init.DistantWorldsModMobEffects;
import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.entity.ToranEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityAttackedByToranProcedure {
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
		double vairisArmor = 0;
		if (!world.isClientSide()) {
			if (sourceentity instanceof ToranEntity) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.VAIRIS_HELMET.get()) {
					vairisArmor = vairisArmor + 1;
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.VAIRIS_CHESTPLATE.get()) {
					vairisArmor = vairisArmor + 1;
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.VAIRIS_LEGGINGS.get()) {
					vairisArmor = vairisArmor + 1;
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.VAIRIS_BOOTS.get()) {
					vairisArmor = vairisArmor + 1;
				}
				if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.isBlocking())) {
					if (Math.random() > 0.2 * vairisArmor) {
						if (!(entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(DistantWorldsModMobEffects.STICKY_SHACKLES.get()))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(DistantWorldsModMobEffects.STICKY_SHACKLES.get(), 100, 0));
						} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DistantWorldsModMobEffects.SUPPRESSION.get()) ? _livEnt.getEffect(DistantWorldsModMobEffects.SUPPRESSION.get()).getAmplifier() : 0) < 4) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(DistantWorldsModMobEffects.STICKY_SHACKLES.get(), 100,
										(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DistantWorldsModMobEffects.STICKY_SHACKLES.get()) ? _livEnt.getEffect(DistantWorldsModMobEffects.STICKY_SHACKLES.get()).getAmplifier() : 0)
												+ 1)));
						} else {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(DistantWorldsModMobEffects.STICKY_SHACKLES.get(), 100, 4));
						}
					}
				}
			}
		}
	}
}
