package net.mcreator.distantworlds.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModItems;

import java.util.concurrent.atomic.AtomicReference;

public class GarhennaResearchesLevelAlertProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		String result = "";
		ItemStack ResItem = ItemStack.EMPTY;
		double Level = 0;
		Level = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "ResearchesLevel");
		ResItem = (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 0));
		if (!(ResItem.getItem() == ItemStack.EMPTY.getItem())) {
			if ((ResItem.getItem() == DistantWorldsModItems.RAW_FIRON.get() || ResItem.getItem() == DistantWorldsModItems.FIRON_NUGGET.get() || ResItem.getItem() == DistantWorldsModItems.FIRON_INGOT.get()) && Level < 4) {
				return true;
			}
			if ((ResItem.getItem() == DistantWorldsModItems.MOLTEN_FRALITE.get() || ResItem.getItem() == DistantWorldsModItems.FRALITE_HEART.get()) && Level < 2) {
				return true;
			}
			if ((ResItem.getItem() == DistantWorldsModItems.RAW_CURELITE.get() || ResItem.getItem() == DistantWorldsModItems.CURELITE.get()) && Level < 1) {
				return true;
			}
			if (ResItem.getItem() == DistantWorldsModItems.NOARHORN_SPIKE.get() && Level < 2) {
				return true;
			}
			if (ResItem.getItem() == DistantWorldsModItems.UBRICITE_CRYSTAL.get() && Level < 2) {
				return true;
			}
			if ((ResItem.getItem() == DistantWorldsModItems.RAW_DALITE.get() || ResItem.getItem() == DistantWorldsModItems.DALITE_NUGGET.get() || ResItem.getItem() == DistantWorldsModItems.DALITE_CRYSTAL.get()) && Level < 2) {
				return true;
			}
			if ((ResItem.getItem() == DistantWorldsModItems.STICKY_GARSALE_BARK.get() || ResItem.getItem() == DistantWorldsModItems.GLOWING_POLLEN.get()) && Level < 2) {
				return true;
			}
			if (ResItem.getItem() == DistantWorldsModItems.GARSALE_FRUIT.get() && Level < 1) {
				return true;
			}
			if ((ResItem.getItem() == DistantWorldsModItems.RAW_VAIRIS.get() || ResItem.getItem() == DistantWorldsModItems.VAIRIS_CRYSTAL.get()) && Level < 3) {
				return true;
			}
			if ((ResItem.getItem() == DistantWorldsModItems.SALMORAN_SCALES.get() || ResItem.getItem() == DistantWorldsModItems.SALMORAN_EYE.get()) && Level < 2) {
				return true;
			}
			if (ResItem.getItem() == DistantWorldsModItems.WILTUM_FRUIT.get() && Level < 1) {
				return true;
			}
			if ((ResItem.getItem() == DistantWorldsModItems.RAW_HELYST.get() || ResItem.getItem() == DistantWorldsModItems.HELYST_NUGGET.get() || ResItem.getItem() == DistantWorldsModItems.HELYST_CRYSTAL.get()) && Level < 3) {
				return true;
			}
		}
		return false;
	}
}
