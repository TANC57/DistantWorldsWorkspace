package net.mcreator.distantworlds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.distantworlds.init.DistantWorldsModMobEffects;
import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.init.DistantWorldsModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WhenHitWithSalmoranStingProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, world, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		double helystArmor = 0;
		double salmoranArmor = 0;
		if (!world.isClientSide()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(DistantWorldsModEnchantments.SALMORAN_STING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0 && entity instanceof LivingEntity
					&& immediatesourceentity == sourceentity) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.HELYST_HELMET.get()) {
					helystArmor = helystArmor + 1;
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.HELYST_CHESTPLATE.get()) {
					helystArmor = helystArmor + 1;
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.HELYST_LEGGINGS.get()) {
					helystArmor = helystArmor + 1;
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.HELYST_BOOTS.get()) {
					helystArmor = helystArmor + 1;
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.SALMORAN_ARMOR_HELMET.get()) {
					salmoranArmor = salmoranArmor + 1;
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.SALMORAN_ARMOR_CHESTPLATE.get()) {
					salmoranArmor = salmoranArmor + 1;
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.SALMORAN_ARMOR_LEGGINGS.get()) {
					salmoranArmor = salmoranArmor + 1;
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.SALMORAN_ARMOR_BOOTS.get()) {
					salmoranArmor = salmoranArmor + 1;
				}
				if (Math.random() > (0.2 * helystArmor + 0.1 * salmoranArmor)
						- 0.1 * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.SALMORAN_STING.get())) {
					if (!(entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(DistantWorldsModMobEffects.SUPPRESSION.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(DistantWorldsModMobEffects.SUPPRESSION.get(),
									(int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.SALMORAN_STING.get()) * 20), 0));
					} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DistantWorldsModMobEffects.SUPPRESSION.get())
							? _livEnt.getEffect(DistantWorldsModMobEffects.SUPPRESSION.get()).getAmplifier()
							: 0) < (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.SALMORAN_STING.get()) - 1) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(DistantWorldsModMobEffects.SUPPRESSION.get(),
									(int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.SALMORAN_STING.get()) * 20),
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DistantWorldsModMobEffects.SUPPRESSION.get()) ? _livEnt.getEffect(DistantWorldsModMobEffects.SUPPRESSION.get()).getAmplifier() : 0) + 1)));
					} else {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(DistantWorldsModMobEffects.SUPPRESSION.get(),
									(int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.SALMORAN_STING.get()) * 20),
									(int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.SALMORAN_STING.get()) - 1)));
					}
				}
			}
		}
	}
}
