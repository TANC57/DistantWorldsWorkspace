package net.mcreator.distantworlds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;

import net.mcreator.distantworlds.init.DistantWorldsModMobEffects;
import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.entity.AlphaSalmoranEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityAttackedByAlphaSalmoranProcedure {
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
		double helystArmor = 0;
		double salmoranArmor = 0;
		if (!world.isClientSide()) {
			if (sourceentity instanceof AlphaSalmoranEntity) {
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
				if (entity instanceof LivingEntity _livEnt18 && _livEnt18.isBlocking()) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHIELD) {
						{
							ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
							if (_ist.hurt(5, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 120);
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.SHIELD) {
						{
							ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
							if (_ist.hurt(5, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem(), 120);
					}
				} else {
					if (Math.random() > 0.2 * helystArmor + 0.1 * salmoranArmor) {
						if (!(entity instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(DistantWorldsModMobEffects.SUPPRESSION.get()))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(DistantWorldsModMobEffects.SUPPRESSION.get(), 200, 0));
						} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DistantWorldsModMobEffects.SUPPRESSION.get()) ? _livEnt.getEffect(DistantWorldsModMobEffects.SUPPRESSION.get()).getAmplifier() : 0) < 4) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(DistantWorldsModMobEffects.SUPPRESSION.get(), 200,
										(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DistantWorldsModMobEffects.SUPPRESSION.get()) ? _livEnt.getEffect(DistantWorldsModMobEffects.SUPPRESSION.get()).getAmplifier() : 0) + 1)));
						} else {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(DistantWorldsModMobEffects.SUPPRESSION.get(), 300, 4));
						}
					}
				}
			}
		}
	}
}
