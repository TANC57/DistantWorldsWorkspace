
package net.mcreator.distantworlds.item.extension;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockSource;

import net.mcreator.distantworlds.procedures.AsmuldaBerriesOnDispenseAttemptWithResultProcedure;
import net.mcreator.distantworlds.procedures.AsmuldaBerriesDispenseSuccessfullyIfProcedure;
import net.mcreator.distantworlds.init.DistantWorldsModItems;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AsmuldaBerriesExtensionItemExtension {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> DispenserBlock.registerBehavior(DistantWorldsModItems.ASMULDA_BERRIES.get(), new OptionalDispenseItemBehavior() {
			public ItemStack execute(BlockSource blockSource, ItemStack stack) {
				ItemStack itemstack = stack.copy();
				Level world = blockSource.getLevel();
				Direction direction = blockSource.getBlockState().getValue(DispenserBlock.FACING);
				int x = blockSource.getPos().getX();
				int y = blockSource.getPos().getY();
				int z = blockSource.getPos().getZ();
				this.setSuccess(AsmuldaBerriesDispenseSuccessfullyIfProcedure.execute(world, x, y, z));
				boolean success = this.isSuccess();
				AsmuldaBerriesOnDispenseAttemptWithResultProcedure.execute(world, x, y, z);
				if (success)
					itemstack.shrink(1);
				return itemstack;
			}
		}));
	}
}
