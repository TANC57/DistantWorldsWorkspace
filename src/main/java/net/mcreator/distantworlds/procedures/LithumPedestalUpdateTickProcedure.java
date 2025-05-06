package net.mcreator.distantworlds.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModParticleTypes;
import net.mcreator.distantworlds.init.DistantWorldsModItems;

import java.util.concurrent.atomic.AtomicReference;

public class LithumPedestalUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == ItemStack.EMPTY.getItem())) {
			if (Math.random() < 0.1) {
				if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 1)).getItem() == DistantWorldsModItems.MODULE_CHARMED_PEDESTAL.get()) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x + 0.5), (y + 1.2), (z + 0.5), 1, 0.05, 0.05, 0.05, 0);
				} else {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x + 0.5), (y + 1.2), (z + 0.5), 1, 0.05, 0.05, 0.05, 0);
				}
			}
		}
	}
}
