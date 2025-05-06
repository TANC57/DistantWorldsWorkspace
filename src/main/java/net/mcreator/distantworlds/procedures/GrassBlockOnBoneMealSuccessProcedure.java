package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class GrassBlockOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double X = 0;
		double Z = 0;
		if (!world.isClientSide()) {
			if (blockstate.getBlock() == DistantWorldsModBlocks.LIFELESS_GRASS.get()) {
				if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
					if (Math.random() < 0.7) {
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.TALL_LIFELESS_SPROUTS.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y + 2, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with(DistantWorldsModBlocks.TALL_LIFELESS_SPROUTS.get().defaultBlockState(), "half", "upper")), 3);
					} else {
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.VINRETTY.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y + 2, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with(DistantWorldsModBlocks.VINRETTY.get().defaultBlockState(), "half", "upper")), 3);
					}
				}
				Z = z - 2;
				for (int index0 = 0; index0 < 5; index0++) {
					X = x - 2;
					for (int index1 = 0; index1 < 5; index1++) {
						if ((world.getBlockState(BlockPos.containing(X, y, Z))).getBlock() == blockstate.getBlock() && world.isEmptyBlock(BlockPos.containing(X, y + 1, Z))) {
							world.setBlock(BlockPos.containing(X, y + 1, Z),
									(Math.random() < 0.95
											? ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("distant_worlds:burning_plains_flowers"))).getRandomElement(RandomSource.create()).orElseGet(() -> Blocks.AIR)
													.defaultBlockState()
											: (new Object() {
												public BlockState with(BlockState _bs, String _property, int _newValue) {
													Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
													return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
												}
											}.with(DistantWorldsModBlocks.ASMULDA_BERRY_BUSH.get().defaultBlockState(), "age", 0))),
									3);
						}
						X = X + 1;
					}
					Z = Z + 1;
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.WITHERED_SOIL.get()) {
				if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
					if (Math.random() < 0.7) {
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.TALL_WITHERED_SPROUTS.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y + 2, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with(DistantWorldsModBlocks.TALL_WITHERED_SPROUTS.get().defaultBlockState(), "half", "upper")), 3);
					} else {
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.OFYPLETTA.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y + 2, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with(DistantWorldsModBlocks.OFYPLETTA.get().defaultBlockState(), "half", "upper")), 3);
					}
				}
				Z = z - 2;
				for (int index2 = 0; index2 < 5; index2++) {
					X = x - 2;
					for (int index3 = 0; index3 < 5; index3++) {
						if ((world.getBlockState(BlockPos.containing(X, y, Z))).getBlock() == blockstate.getBlock() && world.isEmptyBlock(BlockPos.containing(X, y + 1, Z))) {
							if (Math.random() < 0.95) {
								world.setBlock(BlockPos.containing(X, y + 1, Z),
										(ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("distant_worlds:dead_valley_flowers"))).getRandomElement(RandomSource.create()).orElseGet(() -> Blocks.AIR)).defaultBlockState(), 3);
							} else {
								world.setBlock(BlockPos.containing(X, y + 1, Z), (Math.random() <= 0.5 ? DistantWorldsModBlocks.WOKAMIRE.get().defaultBlockState() : DistantWorldsModBlocks.FUZIANNA.get().defaultBlockState()), 3);
							}
						}
						X = X + 1;
					}
					Z = Z + 1;
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.OVERGROWN_FRALITE.get()) {
				if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
					if (Math.random() < 0.7) {
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.TALL_MOLTEN_SPROUTS.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y + 2, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with(DistantWorldsModBlocks.TALL_MOLTEN_SPROUTS.get().defaultBlockState(), "half", "upper")), 3);
					} else {
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.FLEMMAWIES.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y + 2, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with(DistantWorldsModBlocks.FLEMMAWIES.get().defaultBlockState(), "half", "upper")), 3);
					}
				}
				Z = z - 2;
				for (int index4 = 0; index4 < 5; index4++) {
					X = x - 2;
					for (int index5 = 0; index5 < 5; index5++) {
						if ((world.getBlockState(BlockPos.containing(X, y, Z))).getBlock() == blockstate.getBlock() && world.isEmptyBlock(BlockPos.containing(X, y + 1, Z))) {
							world.setBlock(BlockPos.containing(X, y + 1, Z),
									(ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("distant_worlds:molten_hills_flowers"))).getRandomElement(RandomSource.create()).orElseGet(() -> Blocks.AIR)).defaultBlockState(), 3);
						}
						X = X + 1;
					}
					Z = Z + 1;
				}
			} else if (blockstate.getBlock() == DistantWorldsModBlocks.LAYERED_MUD.get()) {
				if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
					if (Math.random() < 0.7) {
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.TALL_STICKY_SPROUTS.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y + 2, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with(DistantWorldsModBlocks.TALL_STICKY_SPROUTS.get().defaultBlockState(), "half", "upper")), 3);
					} else {
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.ANEWORT.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y + 2, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with(DistantWorldsModBlocks.ANEWORT.get().defaultBlockState(), "half", "upper")), 3);
					}
				}
				Z = z - 2;
				for (int index6 = 0; index6 < 5; index6++) {
					X = x - 2;
					for (int index7 = 0; index7 < 5; index7++) {
						if ((world.getBlockState(BlockPos.containing(X, y, Z))).getBlock() == blockstate.getBlock() && world.isEmptyBlock(BlockPos.containing(X, y + 1, Z))) {
							world.setBlock(BlockPos.containing(X, y + 1, Z),
									(ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("distant_worlds:sticky_marshes_flowers"))).getRandomElement(RandomSource.create()).orElseGet(() -> Blocks.AIR)).defaultBlockState(), 3);
						}
						X = X + 1;
					}
					Z = Z + 1;
				}
			}
		}
	}
}
