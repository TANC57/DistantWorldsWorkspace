package net.mcreator.distantworlds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.distantworlds.init.DistantWorldsModMobEffects;
import net.mcreator.distantworlds.init.DistantWorldsModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StickyShacklesOnEffectActiveTickProcedure {
	@SubscribeEvent
	public static void onEntityFall(LivingFallEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getDistance());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, double distance) {
		execute(null, world, entity, distance);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double distance) {
		if (entity == null)
			return;
		double vairisArmor = 0;
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
		if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(DistantWorldsModMobEffects.STICKY_SHACKLES.get()) && distance > 0.5) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FALL), entity),
					(float) ((1 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DistantWorldsModMobEffects.STICKY_SHACKLES.get()) ? _livEnt.getEffect(DistantWorldsModMobEffects.STICKY_SHACKLES.get()).getAmplifier() : 0))
							/ (vairisArmor == 4 ? 4 : 1)));
		}
	}
}
