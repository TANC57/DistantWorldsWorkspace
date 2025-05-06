package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class PottedPlantUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		ItemStack Flower = ItemStack.EMPTY;
		if ((blockstate.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) == true) {
			Flower = ItemStack.EMPTY;
			if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_GARSALE_SAPLING.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.GARSALE_SAPLING.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_WILTUM_SAPLING.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.WILTUM_SAPLING.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_AFOLLA.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.AFOLLA.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_WALIS.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.WALIS.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_SUWONNA.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.SUWONNA.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_APHLAVIS.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.APHLAVIS.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_CREWANOLLA.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.CREWANOLLA.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_CEBLUM.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.CEBLUM.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_RINYOT.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.RINYOT.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_CULAFITE_MUSHROOM.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.CULAFITE_MUSHROOM.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_IROTINE.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.IROTINE.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_LAFOSIA.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.LAFOSIA.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_LIORESS.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.LIORESS.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_PRIFONNA.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.PRIFONNA.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_FUZIANNA.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.FUZIANNA.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_WOKAMIRE.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.WOKAMIRE.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_ULBISEAF.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.ULBISEAF.get());
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.POTTED_OTREBORE.get()) {
				Flower = new ItemStack(DistantWorldsModBlocks.OTREBORE.get());
			}
			if (!(Flower.getItem() == ItemStack.EMPTY.getItem())) {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(Items.FLOWER_POT));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), Flower);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
