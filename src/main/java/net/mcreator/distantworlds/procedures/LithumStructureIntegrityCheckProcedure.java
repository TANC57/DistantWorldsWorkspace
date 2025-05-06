package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class LithumStructureIntegrityCheckProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		double xOffset = 0;
		double zOffset = 0;
		double yOffset = 0;
		BlockState LastBaseLayer = Blocks.AIR.defaultBlockState();
		BlockState LastUpperLayerFrame = Blocks.AIR.defaultBlockState();
		LastBaseLayer = Blocks.AIR.defaultBlockState();
		LastUpperLayerFrame = Blocks.AIR.defaultBlockState();
		if (!world.isClientSide()) {
			zOffset = z - 2;
			for (int index0 = 0; index0 < 5; index0++) {
				xOffset = x - 2;
				for (int index1 = 0; index1 < 5; index1++) {
					if (!((world.getBlockState(BlockPos.containing(xOffset, y - 2, zOffset))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_base_layer_blocks")))
							&& (LastBaseLayer.getBlock() == Blocks.AIR ? true : (world.getBlockState(BlockPos.containing(xOffset, y - 2, zOffset))).getBlock() == LastBaseLayer.getBlock()))) {
						return "BottomLayer";
					}
					LastBaseLayer = (world.getBlockState(BlockPos.containing(xOffset, y - 2, zOffset)));
					xOffset = xOffset + 1;
				}
				zOffset = zOffset + 1;
			}
			if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_main_blocks")))
					&& (world.getBlockState(BlockPos.containing(x + 2, y - 1, z))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_main_blocks")))
					&& (world.getBlockState(BlockPos.containing(x - 2, y - 1, z))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_main_blocks")))
					&& (world.getBlockState(BlockPos.containing(x, y - 1, z + 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_main_blocks")))
					&& (world.getBlockState(BlockPos.containing(x, y - 1, z - 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_main_blocks")))
					&& (world.getBlockState(BlockPos.containing(x - 2, y - 1, z - 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_additional_blocks")))
					&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_additional_blocks")))
					&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_additional_blocks")))
					&& (world.getBlockState(BlockPos.containing(x + 2, y - 1, z - 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_additional_blocks")))
					&& (world.getBlockState(BlockPos.containing(x + 2, y - 1, z - 1))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_additional_blocks")))
					&& (world.getBlockState(BlockPos.containing(x + 2, y - 1, z + 1))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_additional_blocks")))
					&& (world.getBlockState(BlockPos.containing(x + 2, y - 1, z + 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_additional_blocks")))
					&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_additional_blocks")))
					&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_additional_blocks")))
					&& (world.getBlockState(BlockPos.containing(x - 2, y - 1, z + 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_additional_blocks")))
					&& (world.getBlockState(BlockPos.containing(x - 2, y - 1, z + 1))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_additional_blocks")))
					&& (world.getBlockState(BlockPos.containing(x - 2, y - 1, z - 1))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_additional_blocks")))
					&& (world.getBlockState(BlockPos.containing(x + 2, y - 1, z))).getBlock() == (world.getBlockState(BlockPos.containing(x - 2, y - 1, z))).getBlock()
					&& (world.getBlockState(BlockPos.containing(x - 2, y - 1, z))).getBlock() == (world.getBlockState(BlockPos.containing(x, y - 1, z + 2))).getBlock()
					&& (world.getBlockState(BlockPos.containing(x, y - 1, z + 2))).getBlock() == (world.getBlockState(BlockPos.containing(x, y - 1, z - 2))).getBlock()
					&& (world.getBlockState(BlockPos.containing(x, y - 1, z - 2))).getBlock() == (world.getBlockState(BlockPos.containing(x + 2, y - 1, z))).getBlock())) {
				return "UpperLayer";
			}
			zOffset = -1;
			for (int index2 = 0; index2 < 3; index2++) {
				xOffset = -1;
				for (int index3 = 0; index3 < 3; index3++) {
					if (!(Math.abs(xOffset) + Math.abs(zOffset) == 0)) {
						if (!((world.getBlockState(BlockPos.containing(x + xOffset, y - 1, z + zOffset))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_altar_upper_layer_frame_blocks")))
								&& (LastUpperLayerFrame.getBlock() == Blocks.AIR ? true : (world.getBlockState(BlockPos.containing(x + xOffset, y - 1, z + zOffset))).getBlock() == LastUpperLayerFrame.getBlock()))) {
							return "GrassFrame";
						}
						LastUpperLayerFrame = (world.getBlockState(BlockPos.containing(x + xOffset, y - 1, z + zOffset)));
					}
					xOffset = xOffset + 1;
				}
				zOffset = zOffset + 1;
			}
			if (!((world.getBlockState(BlockPos.containing(x - 2, y, z - 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_furnace")))
					&& (world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_furnace")))
					&& (world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_furnace")))
					&& (world.getBlockState(BlockPos.containing(x - 2, y, z + 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_furnace"))))) {
				return "EnergyGenerator";
			}
			if (!((world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_storage")))
					&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_storage")))
					&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_storage")))
					&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 2))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_storage"))))) {
				return "EnergyStorage";
			}
			if (!((world.getBlockState(BlockPos.containing(x - 2, y + 2, z - 2))).getBlock() == DistantWorldsModBlocks.LITHUM_TRANSMITTER.get()
					&& (world.getBlockState(BlockPos.containing(x + 2, y + 2, z - 2))).getBlock() == DistantWorldsModBlocks.LITHUM_TRANSMITTER.get()
					&& (world.getBlockState(BlockPos.containing(x + 2, y + 2, z + 2))).getBlock() == DistantWorldsModBlocks.LITHUM_TRANSMITTER.get()
					&& (world.getBlockState(BlockPos.containing(x - 2, y + 2, z + 2))).getBlock() == DistantWorldsModBlocks.LITHUM_TRANSMITTER.get())) {
				return "EnergyTransmitter";
			}
			if (!((world.getBlockState(BlockPos.containing(x - 2, y, z - 1))).getBlock() == DistantWorldsModBlocks.LITHUM_PEDESTAL.get()
					&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == DistantWorldsModBlocks.LITHUM_PEDESTAL.get()
					&& (world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).getBlock() == DistantWorldsModBlocks.LITHUM_PEDESTAL.get()
					&& (world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).getBlock() == DistantWorldsModBlocks.LITHUM_PEDESTAL.get()
					&& (world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == DistantWorldsModBlocks.LITHUM_PEDESTAL.get()
					&& (world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == DistantWorldsModBlocks.LITHUM_PEDESTAL.get()
					&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 2))).getBlock() == DistantWorldsModBlocks.LITHUM_PEDESTAL.get()
					&& (world.getBlockState(BlockPos.containing(x - 2, y, z + 1))).getBlock() == DistantWorldsModBlocks.LITHUM_PEDESTAL.get())) {
				return "Pedestal";
			}
			yOffset = 0;
			for (int index4 = 0; index4 < 3; index4++) {
				zOffset = -2;
				for (int index5 = 0; index5 < 5; index5++) {
					xOffset = -2;
					for (int index6 = 0; index6 < 5; index6++) {
						if (!(Math.abs(xOffset) + Math.abs(yOffset) + Math.abs(zOffset) == 0 || xOffset * xOffset + zOffset * zOffset == 5 && yOffset == 0 || Math.abs(xOffset) == 2 && Math.abs(zOffset) == 2)
								&& !world.isEmptyBlock(BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
							if (xOffset * xOffset + zOffset * zOffset <= 2) {
								return "MiddleAir";
							} else {
								return "SideAir";
							}
						}
						xOffset = xOffset + 1;
					}
					zOffset = zOffset + 1;
				}
				yOffset = yOffset + 1;
			}
			return "Successful";
		}
		return "Client";
	}
}
