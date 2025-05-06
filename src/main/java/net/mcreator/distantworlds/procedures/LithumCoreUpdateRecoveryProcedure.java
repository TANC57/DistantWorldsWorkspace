package net.mcreator.distantworlds.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

import java.util.concurrent.atomic.AtomicReference;

public class LithumCoreUpdateRecoveryProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		String CurrentRecipe = "";
		double Recovery = 0;
		if (!world.isClientSide()) {
			CurrentRecipe = new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "CurrentRecipe");
			if (CurrentRecipe.contains("firon")) {
				Recovery = 2000;
			}
			if (CurrentRecipe.contains("helyst")) {
				Recovery = 1200;
			}
			if (CurrentRecipe.contains("vairis")) {
				Recovery = 1000;
			}
			if (CurrentRecipe.contains("ubricite")) {
				Recovery = 800;
			}
			if (CurrentRecipe.contains("module")) {
				Recovery = 500;
			}
			if (CurrentRecipe.contains("enchantment")) {
				Recovery = 500;
			}
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x + 2, y + 2, z + 2), 0)).getItem() == DistantWorldsModItems.MODULE_FLOW_FILTER.get()) {
				Recovery = Recovery / 1.2;
			} else if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x + 2, y + 2, z + 2), 0)).getItem() == DistantWorldsModItems.MODULE_FLOW_AMPLIFICATION.get()) {
				Recovery = Recovery * 1.2;
			}
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x - 2, y + 2, z + 2), 0)).getItem() == DistantWorldsModItems.MODULE_FLOW_FILTER.get()) {
				Recovery = Recovery / 1.2;
			} else if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x - 2, y + 2, z + 2), 0)).getItem() == DistantWorldsModItems.MODULE_FLOW_AMPLIFICATION.get()) {
				Recovery = Recovery * 1.2;
			}
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x + 2, y + 2, z - 2), 0)).getItem() == DistantWorldsModItems.MODULE_FLOW_FILTER.get()) {
				Recovery = Recovery / 1.2;
			} else if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x + 2, y + 2, z - 2), 0)).getItem() == DistantWorldsModItems.MODULE_FLOW_AMPLIFICATION.get()) {
				Recovery = Recovery * 1.2;
			}
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x - 2, y + 2, z - 2), 0)).getItem() == DistantWorldsModItems.MODULE_FLOW_FILTER.get()) {
				Recovery = Recovery / 1.2;
			} else if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x - 2, y + 2, z - 2), 0)).getItem() == DistantWorldsModItems.MODULE_FLOW_AMPLIFICATION.get()) {
				Recovery = Recovery * 1.2;
			}
			return Math.round(Recovery) * Math.abs((double) ConfigCommonConfiguration.RECOVERY_MODIFIER.get());
		}
		return 0;
	}
}
