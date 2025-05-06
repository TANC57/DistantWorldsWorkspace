package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class CureliteTorchRightclickedOnBlockProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
		if (direction == null || entity == null)
			return InteractionResult.PASS;
		double xOffset = 0;
		double yOffset = 0;
		double zOffset = 0;
		boolean success = false;
		Direction finalDirection = Direction.NORTH;
		BlockState finalBlockstate = Blocks.AIR.defaultBlockState();
		if (!world.isClientSide()) {
			if (direction == Direction.NORTH) {
				zOffset = -1;
			} else if (direction == Direction.SOUTH) {
				zOffset = 1;
			} else if (direction == Direction.WEST) {
				xOffset = -1;
			} else if (direction == Direction.EAST) {
				xOffset = 1;
			} else if (direction == Direction.UP) {
				yOffset = 1;
			} else {
				yOffset = -1;
			}
			if (world.isEmptyBlock(BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
				if (direction == Direction.DOWN) {
					if (entity.getYRot() >= -135 && entity.getYRot() < -45 && (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.WEST)).canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
						finalBlockstate = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.WEST));
						success = true;
					} else if (entity.getYRot() >= -45 && entity.getYRot() < 45 && (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.NORTH)).canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
						finalBlockstate = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.NORTH));
						success = true;
					} else if (entity.getYRot() >= 45 && entity.getYRot() < 135 && (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.EAST)).canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
						finalBlockstate = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.EAST));
						success = true;
					} else if ((entity.getYRot() >= 135 || entity.getYRot() < -135) && (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.SOUTH)).canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
						finalBlockstate = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.SOUTH));
						success = true;
					} else {
						if ((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.NORTH)).canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
							finalBlockstate = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.NORTH));
							success = true;
						} else if ((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.SOUTH)).canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
							finalBlockstate = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.SOUTH));
							success = true;
						} else if ((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.WEST)).canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
							finalBlockstate = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.WEST));
							success = true;
						} else if ((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.EAST)).canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
							finalBlockstate = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.EAST));
							success = true;
						} else if (DistantWorldsModBlocks.CURELITE_TORCH_GROUND.get().defaultBlockState().canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
							finalBlockstate = DistantWorldsModBlocks.CURELITE_TORCH_GROUND.get().defaultBlockState();
							success = true;
						}
					}
				} else if (direction == Direction.UP) {
					if (DistantWorldsModBlocks.CURELITE_TORCH_GROUND.get().defaultBlockState().canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
						finalBlockstate = DistantWorldsModBlocks.CURELITE_TORCH_GROUND.get().defaultBlockState();
						success = true;
					}
				} else {
					if ((new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), direction)).canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
						finalBlockstate = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), direction));
						success = true;
					} else {
						if ((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.NORTH)).canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
							finalBlockstate = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.NORTH));
							success = true;
						} else if ((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.SOUTH)).canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
							finalBlockstate = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.SOUTH));
							success = true;
						} else if ((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.WEST)).canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
							finalBlockstate = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.WEST));
							success = true;
						} else if ((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.EAST)).canSurvive(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))) {
							finalBlockstate = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(DistantWorldsModBlocks.CURELITE_TORCH_WALL.get().defaultBlockState(), Direction.EAST));
							success = true;
						}
					}
				}
			}
			if (success) {
				world.setBlock(BlockPos.containing(x + xOffset, y + yOffset, z + zOffset), finalBlockstate, 3);
				itemstack.shrink(1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.nether_wood.place")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound((x + xOffset), (y + yOffset), (z + zOffset), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.nether_wood.place")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.FAIL;
	}
}
