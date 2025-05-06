package net.mcreator.distantworlds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;
import net.mcreator.distantworlds.init.DistantWorldsModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DaliteEnergyMendingTickUpdateProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double RequiredDaliteEnergyLeft = 0;
		double MendingPrice = 0;
		if (!world.isClientSide()) {
			RequiredDaliteEnergyLeft = 0;
			MendingPrice = 10;
			if (entity.tickCount % 20 == 0) {
				if (Math.random() < 0.5) {
					if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())
							&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).isDamaged()) {
						if (ReturnDaliteEnergyCurioProcedure.execute(world,
								entity) >= (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft + RequiredDaliteEnergyLeft
										+ Math.ceil(MendingPrice / (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.DALITE_ENERGY_MENDING.get()))) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setDamageValue((int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() - 1));
							RequiredDaliteEnergyLeft = RequiredDaliteEnergyLeft
									+ Math.ceil(MendingPrice / (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.DALITE_ENERGY_MENDING.get()));
						}
					}
				}
				if (Math.random() < 0.5) {
					if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())
							&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).isDamaged()) {
						if (ReturnDaliteEnergyCurioProcedure.execute(world,
								entity) >= (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft + RequiredDaliteEnergyLeft
										+ Math.ceil(MendingPrice / (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.DALITE_ENERGY_MENDING.get()))) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).setDamageValue((int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getDamageValue() - 1));
							RequiredDaliteEnergyLeft = RequiredDaliteEnergyLeft
									+ Math.ceil(MendingPrice / (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.DALITE_ENERGY_MENDING.get()));
						}
					}
				}
				if (Math.random() < 0.5) {
					if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())
							&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).isDamaged()) {
						if (ReturnDaliteEnergyCurioProcedure.execute(world,
								entity) >= (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft + RequiredDaliteEnergyLeft + Math.ceil(
										MendingPrice / (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.DALITE_ENERGY_MENDING.get()))) {
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
									.setDamageValue((int) ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getDamageValue() - 1));
							RequiredDaliteEnergyLeft = RequiredDaliteEnergyLeft + Math
									.ceil(MendingPrice / (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.DALITE_ENERGY_MENDING.get()));
						}
					}
				}
				if (Math.random() < 0.5) {
					if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())
							&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).isDamaged()) {
						if (ReturnDaliteEnergyCurioProcedure.execute(world,
								entity) >= (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft + RequiredDaliteEnergyLeft + Math.ceil(
										MendingPrice / (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.DALITE_ENERGY_MENDING.get()))) {
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
									.setDamageValue((int) ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getDamageValue() - 1));
							RequiredDaliteEnergyLeft = RequiredDaliteEnergyLeft + Math
									.ceil(MendingPrice / (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.DALITE_ENERGY_MENDING.get()));
						}
					}
				}
				if (Math.random() < 0.5) {
					if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())
							&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).isDamaged()) {
						if (ReturnDaliteEnergyCurioProcedure.execute(world,
								entity) >= (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft + RequiredDaliteEnergyLeft + Math.ceil(
										MendingPrice / (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.DALITE_ENERGY_MENDING.get()))) {
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
									.setDamageValue((int) ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getDamageValue() - 1));
							RequiredDaliteEnergyLeft = RequiredDaliteEnergyLeft + Math
									.ceil(MendingPrice / (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.DALITE_ENERGY_MENDING.get()));
						}
					}
				}
				if (Math.random() < 0.5) {
					if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())
							&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).isDamaged()) {
						if (ReturnDaliteEnergyCurioProcedure.execute(world,
								entity) >= (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft + RequiredDaliteEnergyLeft + Math.ceil(
										MendingPrice / (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.DALITE_ENERGY_MENDING.get()))) {
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
									.setDamageValue((int) ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getDamageValue() - 1));
							RequiredDaliteEnergyLeft = RequiredDaliteEnergyLeft + Math
									.ceil(MendingPrice / (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getEnchantmentLevel(DistantWorldsModEnchantments.DALITE_ENERGY_MENDING.get()));
						}
					}
				}
				{
					double _setval = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft + RequiredDaliteEnergyLeft;
					entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.RequiredDaliteEnergyLeft = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
