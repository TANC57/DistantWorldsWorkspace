package net.mcreator.distantworlds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHealEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;
import net.mcreator.distantworlds.init.DistantWorldsModMobEffects;
import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityHealedProcedureProcedure {
	@SubscribeEvent
	public static void onEntityHealed(LivingHealEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double helystArmor = 0;
		double salmoranArmor = 0;
		double MaxDepletion = 0;
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
		if (!world.isClientSide()) {
			if (entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(DistantWorldsModMobEffects.SUPPRESSION.get())) {
				if ((Mth.nextInt(RandomSource.create(), 1, 5)
						+ (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DistantWorldsModMobEffects.SUPPRESSION.get()) ? _livEnt.getEffect(DistantWorldsModMobEffects.SUPPRESSION.get()).getAmplifier() : 0))
						- (helystArmor + Math.floor(salmoranArmor * 0.5)) >= 5) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
				}
			}
		}
		MaxDepletion = (double) ConfigCommonConfiguration.MAX_GARHENNA_DEPLETION.get() >= 1200 ? (double) ConfigCommonConfiguration.MAX_GARHENNA_DEPLETION.get() : 1200;
		if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaDepletion >= MaxDepletion) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
