package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class CulafiteMushroomPlacementProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double AllowedHigh = 0;
		if (!world.isClientSide()) {
			if ((blockstate.getBlock().getStateDefinition().getProperty("half") instanceof EnumProperty _getep2 ? blockstate.getValue(_getep2).toString() : "").equals("lower")) {
				AllowedHigh = 1;
				for (int index0 = 0; index0 < 10; index0++) {
					if (world.isEmptyBlock(BlockPos.containing(x, y + AllowedHigh, z)) || (world.getBlockState(BlockPos.containing(x, y + AllowedHigh, z))).getBlock() == (new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(DistantWorldsModBlocks.CULAFITE_MUSHROOM_TALL.get().defaultBlockState(), "half", "upper")).getBlock()) {
						AllowedHigh = AllowedHigh + 1;
					} else {
						break;
					}
				}
				if (AllowedHigh == 6) {
					if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y, z - 2), BlockPos.containing(x - 2, y, z - 2), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
										_serverworld.random, 3);
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y, z - 2), BlockPos.containing(x + 2, y, z - 2),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y, z + 2), BlockPos.containing(x + 2, y, z + 2),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y, z + 2), BlockPos.containing(x - 2, y, z + 2),
										new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
				} else if (AllowedHigh == 7) {
					world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.CULAFITE_MUSHROOM_STEM.get().defaultBlockState(), 3);
					if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 1, z - 2), BlockPos.containing(x - 2, y + 1, z - 2),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 1, z - 2), BlockPos.containing(x + 2, y + 1, z - 2),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 1, z + 2), BlockPos.containing(x + 2, y + 1, z + 2),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 1, z + 2), BlockPos.containing(x - 2, y + 1, z + 2),
										new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
				} else if (AllowedHigh == 8) {
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.CULAFITE_MUSHROOM_STEM.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.CULAFITE_MUSHROOM_STEM.get().defaultBlockState(), 3);
						if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
							if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z - 2), BlockPos.containing(x - 2, y + 2, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z - 2), BlockPos.containing(x + 2, y + 2, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z + 2), BlockPos.containing(x + 2, y + 2, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z + 2), BlockPos.containing(x - 2, y + 2, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							}
						} else {
							if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z - 2), BlockPos.containing(x - 2, y + 2, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z - 2), BlockPos.containing(x + 2, y + 2, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z + 2), BlockPos.containing(x + 2, y + 2, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z + 2), BlockPos.containing(x - 2, y + 2, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							}
						}
					} else {
						world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.CULAFITE_MUSHROOM_STEM.get().defaultBlockState(), 3);
						if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_type2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 1, z - 2), BlockPos.containing(x - 2, y + 1, z - 2),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_type2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 1, z - 2), BlockPos.containing(x + 2, y + 1, z - 2),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_type2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 1, z + 2), BlockPos.containing(x + 2, y + 1, z + 2),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_type2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 1, z + 2), BlockPos.containing(x - 2, y + 1, z + 2),
											new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
					}
				} else if (AllowedHigh >= 9 && AllowedHigh < 11) {
					world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.CULAFITE_MUSHROOM_STEM.get().defaultBlockState(), 3);
					if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
						if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type3"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z - 2), BlockPos.containing(x - 2, y + 2, z - 2),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type3"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z - 2), BlockPos.containing(x + 2, y + 2, z - 2),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type3"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z + 2), BlockPos.containing(x + 2, y + 2, z + 2),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type3"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z + 2), BlockPos.containing(x - 2, y + 2, z + 2),
											new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
						if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z - 2), BlockPos.containing(x - 2, y + 2, z - 2),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z - 2), BlockPos.containing(x + 2, y + 2, z - 2),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z + 2), BlockPos.containing(x + 2, y + 2, z + 2),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z + 2), BlockPos.containing(x - 2, y + 2, z + 2),
											new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
					} else {
						if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z - 2), BlockPos.containing(x - 2, y + 2, z - 2),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z - 2), BlockPos.containing(x + 2, y + 2, z - 2),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z + 2), BlockPos.containing(x + 2, y + 2, z + 2),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z + 2), BlockPos.containing(x - 2, y + 2, z + 2),
											new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
					}
				} else if (AllowedHigh >= 11) {
					if (Mth.nextInt(RandomSource.create(), 1, 3) <= 1) {
						world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.CULAFITE_MUSHROOM_STEM.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.CULAFITE_MUSHROOM_STEM.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y + 2, z), DistantWorldsModBlocks.CULAFITE_MUSHROOM_STEM.get().defaultBlockState(), 3);
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 3, z - 2), BlockPos.containing(x - 2, y + 3, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 3, z - 2), BlockPos.containing(x + 2, y + 3, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 3, z + 2), BlockPos.containing(x + 2, y + 3, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 3, z + 2), BlockPos.containing(x - 2, y + 3, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 3, z - 2), BlockPos.containing(x - 2, y + 3, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 3, z - 2), BlockPos.containing(x + 2, y + 3, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 3, z + 2), BlockPos.containing(x + 2, y + 3, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 3, z + 2), BlockPos.containing(x - 2, y + 3, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							}
						} else {
							if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type3"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 3, z - 2), BlockPos.containing(x - 2, y + 3, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type3"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 3, z - 2), BlockPos.containing(x + 2, y + 3, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type3"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 3, z + 2), BlockPos.containing(x + 2, y + 3, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type3"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 3, z + 2), BlockPos.containing(x - 2, y + 3, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 2) <= 1) {
						world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.CULAFITE_MUSHROOM_STEM.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.CULAFITE_MUSHROOM_STEM.get().defaultBlockState(), 3);
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z - 2), BlockPos.containing(x - 2, y + 2, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z - 2), BlockPos.containing(x + 2, y + 2, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z + 2), BlockPos.containing(x + 2, y + 2, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type1"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z + 2), BlockPos.containing(x - 2, y + 2, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z - 2), BlockPos.containing(x - 2, y + 2, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z - 2), BlockPos.containing(x + 2, y + 2, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z + 2), BlockPos.containing(x + 2, y + 2, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z + 2), BlockPos.containing(x - 2, y + 2, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							}
						} else {
							if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type3"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z - 2), BlockPos.containing(x - 2, y + 2, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type3"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z - 2), BlockPos.containing(x + 2, y + 2, z - 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type3"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 2, z + 2), BlockPos.containing(x + 2, y + 2, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type3"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 2, z + 2), BlockPos.containing(x - 2, y + 2, z + 2),
												new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							}
						}
					} else {
						world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.CULAFITE_MUSHROOM_STEM.get().defaultBlockState(), 3);
						if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 1, z - 2), BlockPos.containing(x - 2, y + 1, z - 2),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 1, z - 2), BlockPos.containing(x + 2, y + 1, z - 2),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y + 1, z + 2), BlockPos.containing(x + 2, y + 1, z + 2),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "culafite_type2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 1, z + 2), BlockPos.containing(x - 2, y + 1, z + 2),
											new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
					}
				}
			}
		}
	}
}
