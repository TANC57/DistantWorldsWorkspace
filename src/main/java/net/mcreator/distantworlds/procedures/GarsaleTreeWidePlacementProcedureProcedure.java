package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class GarsaleTreeWidePlacementProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double AllowedHigh = 0;
		if (!world.isClientSide()) {
			AllowedHigh = 1;
			for (int index0 = 0; index0 < 8; index0++) {
				if (world.isEmptyBlock(BlockPos.containing(x, y + AllowedHigh, z)) && world.isEmptyBlock(BlockPos.containing(x + 1, y + AllowedHigh, z)) && world.isEmptyBlock(BlockPos.containing(x, y + AllowedHigh, z + 1))
						&& world.isEmptyBlock(BlockPos.containing(x + 1, y + AllowedHigh, z + 1))) {
					AllowedHigh = AllowedHigh + 1;
				} else {
					break;
				}
			}
			if (AllowedHigh == 8) {
				if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_wide"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y, z - 2), BlockPos.containing(x - 2, y, z - 2), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_wide"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x + 3, y, z - 2), BlockPos.containing(x + 3, y, z - 2),
									new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_wide"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x + 3, y, z + 3), BlockPos.containing(x + 3, y, z + 3),
									new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_wide"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y, z + 3), BlockPos.containing(x - 2, y, z + 3),
									new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				}
				if (Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.CRACKED_GARSALE_LOG.get().defaultBlockState(), 3);
				} else if (Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.STICKY_GARSALE_LOG.get().defaultBlockState(), 3);
				}
				if (Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x + 1, y + 1, z), DistantWorldsModBlocks.CRACKED_GARSALE_LOG.get().defaultBlockState(), 3);
				} else if (Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x + 1, y + 1, z), DistantWorldsModBlocks.STICKY_GARSALE_LOG.get().defaultBlockState(), 3);
				}
				if (Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x, y + 1, z + 1), DistantWorldsModBlocks.CRACKED_GARSALE_LOG.get().defaultBlockState(), 3);
				} else if (Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x, y + 1, z + 1), DistantWorldsModBlocks.STICKY_GARSALE_LOG.get().defaultBlockState(), 3);
				}
				if (Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), DistantWorldsModBlocks.CRACKED_GARSALE_LOG.get().defaultBlockState(), 3);
				} else if (Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), DistantWorldsModBlocks.STICKY_GARSALE_LOG.get().defaultBlockState(), 3);
				}
			} else if (AllowedHigh >= 9) {
				if (Math.random() < 0.7) {
					world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.GARSALE_LOG.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 1, y, z), DistantWorldsModBlocks.GARSALE_LOG.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y, z + 1), DistantWorldsModBlocks.GARSALE_LOG.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 1, y, z + 1), DistantWorldsModBlocks.GARSALE_LOG.get().defaultBlockState(), 3);
					if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_wide"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 1, z - 2), BlockPos.containing(x - 2, y + 1, z - 2),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_wide"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 3, y + 1, z - 2), BlockPos.containing(x + 3, y + 1, z - 2),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_wide"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 3, y + 1, z + 3), BlockPos.containing(x + 3, y + 1, z + 3),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_wide"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y + 1, z + 3), BlockPos.containing(x - 2, y + 1, z + 3),
										new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
					if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.CRACKED_GARSALE_LOG.get().defaultBlockState(), 3);
					} else if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.STICKY_GARSALE_LOG.get().defaultBlockState(), 3);
					}
					if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x + 1, y + 1, z), DistantWorldsModBlocks.CRACKED_GARSALE_LOG.get().defaultBlockState(), 3);
					} else if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x + 1, y + 1, z), DistantWorldsModBlocks.STICKY_GARSALE_LOG.get().defaultBlockState(), 3);
					}
					if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x, y + 1, z + 1), DistantWorldsModBlocks.CRACKED_GARSALE_LOG.get().defaultBlockState(), 3);
					} else if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x, y + 1, z + 1), DistantWorldsModBlocks.STICKY_GARSALE_LOG.get().defaultBlockState(), 3);
					}
					if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), DistantWorldsModBlocks.CRACKED_GARSALE_LOG.get().defaultBlockState(), 3);
					} else if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), DistantWorldsModBlocks.STICKY_GARSALE_LOG.get().defaultBlockState(), 3);
					}
				} else {
					if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_wide"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y, z - 2), BlockPos.containing(x - 2, y, z - 2), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
										_serverworld.random, 3);
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_wide"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 3, y, z - 2), BlockPos.containing(x + 3, y, z - 2),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_wide"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 3, y, z + 3), BlockPos.containing(x + 3, y, z + 3),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("distant_worlds", "garsale_wide"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y, z + 3), BlockPos.containing(x - 2, y, z + 3),
										new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
					if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.CRACKED_GARSALE_LOG.get().defaultBlockState(), 3);
					} else if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x, y + 1, z), DistantWorldsModBlocks.STICKY_GARSALE_LOG.get().defaultBlockState(), 3);
					}
					if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x + 1, y + 1, z), DistantWorldsModBlocks.CRACKED_GARSALE_LOG.get().defaultBlockState(), 3);
					} else if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x + 1, y + 1, z), DistantWorldsModBlocks.STICKY_GARSALE_LOG.get().defaultBlockState(), 3);
					}
					if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x, y + 1, z + 1), DistantWorldsModBlocks.CRACKED_GARSALE_LOG.get().defaultBlockState(), 3);
					} else if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x, y + 1, z + 1), DistantWorldsModBlocks.STICKY_GARSALE_LOG.get().defaultBlockState(), 3);
					}
					if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), DistantWorldsModBlocks.CRACKED_GARSALE_LOG.get().defaultBlockState(), 3);
					} else if (Math.random() < 0.3) {
						world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), DistantWorldsModBlocks.STICKY_GARSALE_LOG.get().defaultBlockState(), 3);
					}
				}
			}
		}
	}
}
