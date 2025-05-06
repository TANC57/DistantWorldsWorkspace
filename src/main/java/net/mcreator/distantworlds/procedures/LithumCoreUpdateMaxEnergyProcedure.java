package net.mcreator.distantworlds.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

import java.util.concurrent.atomic.AtomicReference;

public class LithumCoreUpdateMaxEnergyProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double EnergyModifier = 0;
		double MaxEnergy = 0;
		String CurrentRecipe = "";
		if (!world.isClientSide()) {
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 1)).getItem() == DistantWorldsModItems.MODULE_CORE_STABILIZATION.get()) {
				EnergyModifier = 1.25;
			} else if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 1)).getItem() == DistantWorldsModItems.MODULE_CORE_DESTABILIZATION.get()) {
				EnergyModifier = 0.75;
			} else {
				EnergyModifier = 1;
			}
			CurrentRecipe = new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "CurrentRecipe");
			if (CurrentRecipe.contains("firon")) {
				MaxEnergy = 200000;
			}
			if (CurrentRecipe.contains("helyst")) {
				MaxEnergy = 120000;
			}
			if (CurrentRecipe.contains("vairis")) {
				MaxEnergy = 80000;
			}
			if (CurrentRecipe.contains("ubricite")) {
				MaxEnergy = 40000;
			}
			if (CurrentRecipe.contains("module")) {
				MaxEnergy = 10000;
			}
			if (CurrentRecipe.contains("enchantment")) {
				MaxEnergy = 10000;
			}
			return Math.round(MaxEnergy * EnergyModifier * Math.abs((double) ConfigCommonConfiguration.REQUIRED_ENERGY_MODIFIER.get()));
		}
		return 0;
	}
}
