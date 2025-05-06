package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class PlantBlockOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (blockstate.getBlock() == DistantWorldsModBlocks.LIFELESS_SPROUTS.get()) {
			world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.TALL_LIFELESS_SPROUTS.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
				}
			}.with(DistantWorldsModBlocks.TALL_LIFELESS_SPROUTS.get().defaultBlockState(), "half", "upper")), 3);
		} else if (blockstate.getBlock() == DistantWorldsModBlocks.WITHERED_SPROUTS.get()) {
			world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.TALL_WITHERED_SPROUTS.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
				}
			}.with(DistantWorldsModBlocks.TALL_WITHERED_SPROUTS.get().defaultBlockState(), "half", "upper")), 3);
		} else if (blockstate.getBlock() == DistantWorldsModBlocks.STICKY_SPROUTS.get()) {
			world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.TALL_STICKY_SPROUTS.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
				}
			}.with(DistantWorldsModBlocks.TALL_STICKY_SPROUTS.get().defaultBlockState(), "half", "upper")), 3);
		} else if (blockstate.getBlock() == DistantWorldsModBlocks.MOLTEN_SPROUTS.get()) {
			world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.TALL_MOLTEN_SPROUTS.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
				}
			}.with(DistantWorldsModBlocks.TALL_MOLTEN_SPROUTS.get().defaultBlockState(), "half", "upper")), 3);
		} else if (blockstate.getBlock() == DistantWorldsModBlocks.CULAFITE_MUSHROOM.get()) {
			world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.CULAFITE_MUSHROOM_TALL.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
				}
			}.with(DistantWorldsModBlocks.CULAFITE_MUSHROOM_TALL.get().defaultBlockState(), "half", "upper")), 3);
		} else if ((new ItemStack(blockstate.getBlock())).is(ItemTags.create(new ResourceLocation("distant_worlds:orange_dye_plants")))) {
			world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.VINRETTY.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
				}
			}.with(DistantWorldsModBlocks.VINRETTY.get().defaultBlockState(), "half", "upper")), 3);
		} else if ((new ItemStack(blockstate.getBlock())).is(ItemTags.create(new ResourceLocation("distant_worlds:blue_dye_plants")))) {
			world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.OFYPLETTA.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
				}
			}.with(DistantWorldsModBlocks.OFYPLETTA.get().defaultBlockState(), "half", "upper")), 3);
		} else if ((new ItemStack(blockstate.getBlock())).is(ItemTags.create(new ResourceLocation("distant_worlds:pink_dye_plants")))) {
			world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.ANEWORT.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
				}
			}.with(DistantWorldsModBlocks.ANEWORT.get().defaultBlockState(), "half", "upper")), 3);
		} else if ((new ItemStack(blockstate.getBlock())).is(ItemTags.create(new ResourceLocation("distant_worlds:red_dye_plants")))) {
			world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.FLEMMAWIES.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
				}
			}.with(DistantWorldsModBlocks.FLEMMAWIES.get().defaultBlockState(), "half", "upper")), 3);
		} else if (blockstate.getBlock() == DistantWorldsModBlocks.FUZIANNA.get()) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == DistantWorldsModBlocks.FUZIANNA.get()) {
				PlantBlockOnBoneMealSuccessProcedure.execute(world, x, (y + 1), z, blockstate);
			} else if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && !((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == DistantWorldsModBlocks.FUZIANNA.get())) {
				world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.FUZIANNA.get().defaultBlockState(), 3);
			}
		} else if (blockstate.getBlock() == DistantWorldsModBlocks.WOKAMIRE.get()) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == DistantWorldsModBlocks.WOKAMIRE.get()) {
				PlantBlockOnBoneMealSuccessProcedure.execute(world, x, (y + 1), z, blockstate);
			} else if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && !((world.getBlockState(BlockPos.containing(x, y - 3, z))).getBlock() == DistantWorldsModBlocks.WOKAMIRE.get())) {
				world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.WOKAMIRE.get().defaultBlockState(), 3);
			}
		}
	}
}
