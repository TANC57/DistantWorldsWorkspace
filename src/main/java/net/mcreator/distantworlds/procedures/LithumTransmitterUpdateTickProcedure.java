package net.mcreator.distantworlds.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModParticleTypes;
import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.init.DistantWorldsModEntities;
import net.mcreator.distantworlds.init.DistantWorldsModBlocks;
import net.mcreator.distantworlds.entity.LithumTransmitterCrystalEntity;

import java.util.concurrent.atomic.AtomicReference;

public class LithumTransmitterUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double energy = 0;
		double TransferedEnergy = 0;
		if (!(!world.getEntitiesOfClass(LithumTransmitterCrystalEntity.class, AABB.ofSize(new Vec3((x + 0.5), y, (z + 0.5)), 0.5, 0.5, 0.5), e -> true).isEmpty())) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = DistantWorldsModEntities.LITHUM_TRANSMITTER_CRYSTAL.get().spawn(_level, BlockPos.containing(x + 0.5, y, z + 0.5), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("distant_worlds:lithum_storage"))) && new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y - 1, z), "CurrentEnergy") > 0) {
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.MODULE_FLOW_FILTER.get()) {
				energy = 10;
			} else if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.MODULE_FLOW_AMPLIFICATION.get()) {
				energy = 50;
			} else {
				energy = 25;
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y - 2, z + 2))).getBlock() == DistantWorldsModBlocks.LITHUM_CORE.get()) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x + 2, y - 2, z + 2), "CurrentEnergy") < new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x + 2, y - 2, z + 2), "MaxEnergy")) {
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y - 1, z), "CurrentEnergy") >= energy) {
						TransferedEnergy = energy;
					} else {
						TransferedEnergy = new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y - 1, z), "CurrentEnergy");
					}
					if ((new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x + 2, y - 2, z + 2), "MaxEnergy")) - (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x + 2, y - 2, z + 2), "CurrentEnergy")) < TransferedEnergy) {
						TransferedEnergy = (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x + 2, y - 2, z + 2), "MaxEnergy")) - (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x + 2, y - 2, z + 2), "CurrentEnergy"));
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y - 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("CurrentEnergy", ((new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y - 1, z), "CurrentEnergy")) - TransferedEnergy));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x + 2, y - 2, z + 2);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("CurrentEnergy", (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x + 2, y - 2, z + 2), "CurrentEnergy") + TransferedEnergy));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 6) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x + 1), (y + 0.5), (z + 1), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x + 1), (y + 0.5), (z + 1), 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 9) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x + 1.25), (y + 0.25), (z + 1.25), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x + 1.25), (y + 0.25), (z + 1.25), 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 12) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x + 1.5), y, (z + 1.5), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x + 1.5), y, (z + 1.5), 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 15) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x + 1.75), (y - 0.25), (z + 1.75), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x + 1.75), (y - 0.25), (z + 1.75), 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 18) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x + 2), (y - 0.5), (z + 2), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x + 2), (y - 0.5), (z + 2), 1, 0, 0, 0, 0);
						}
					}
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") < 18) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("ParticleSpawn", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") + 1));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") >= 18) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("ParticleSpawn", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x - 2, y - 2, z + 2))).getBlock() == DistantWorldsModBlocks.LITHUM_CORE.get()) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x - 2, y - 2, z + 2), "CurrentEnergy") < new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x - 2, y - 2, z + 2), "MaxEnergy")) {
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y - 1, z), "CurrentEnergy") >= energy) {
						TransferedEnergy = energy;
					} else {
						TransferedEnergy = new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y - 1, z), "CurrentEnergy");
					}
					if ((new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x - 2, y - 2, z + 2), "MaxEnergy")) - (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x - 2, y - 2, z + 2), "CurrentEnergy")) < TransferedEnergy) {
						TransferedEnergy = (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x - 2, y - 2, z + 2), "MaxEnergy")) - (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x - 2, y - 2, z + 2), "CurrentEnergy"));
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y - 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("CurrentEnergy", ((new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y - 1, z), "CurrentEnergy")) - TransferedEnergy));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x - 2, y - 2, z + 2);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("CurrentEnergy", (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x - 2, y - 2, z + 2), "CurrentEnergy") + TransferedEnergy));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 6) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), x, (y + 0.5), (z + 1), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), x, (y + 0.5), (z + 1), 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 9) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x - 0.25), (y + 0.25), (z + 1.25), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x - 0.25), (y + 0.25), (z + 1.25), 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 12) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x - 0.5), y, (z + 1.5), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x - 0.5), y, (z + 1.5), 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 15) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x - 0.75), (y - 0.25), (z + 1.75), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x - 0.75), (y - 0.25), (z + 1.75), 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 18) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x - 1), (y - 0.5), (z + 2), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x - 1), (y - 0.5), (z + 2), 1, 0, 0, 0, 0);
						}
					}
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") < 18) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("ParticleSpawn", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") + 1));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") >= 18) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("ParticleSpawn", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x - 2, y - 2, z - 2))).getBlock() == DistantWorldsModBlocks.LITHUM_CORE.get()) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x - 2, y - 2, z - 2), "CurrentEnergy") < new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x - 2, y - 2, z - 2), "MaxEnergy")) {
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y - 1, z), "CurrentEnergy") >= energy) {
						TransferedEnergy = energy;
					} else {
						TransferedEnergy = new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y - 1, z), "CurrentEnergy");
					}
					if ((new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x - 2, y - 2, z - 2), "MaxEnergy")) - (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x - 2, y - 2, z - 2), "CurrentEnergy")) < TransferedEnergy) {
						TransferedEnergy = (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x - 2, y - 2, z - 2), "MaxEnergy")) - (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x - 2, y - 2, z - 2), "CurrentEnergy"));
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y - 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("CurrentEnergy", ((new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y - 1, z), "CurrentEnergy")) - TransferedEnergy));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x - 2, y - 2, z - 2);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("CurrentEnergy", (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x - 2, y - 2, z - 2), "CurrentEnergy") + TransferedEnergy));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 6) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), x, (y + 0.5), z, 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), x, (y + 0.5), z, 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 9) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x - 0.25), (y + 0.25), (z - 0.25), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x - 0.25), (y + 0.25), (z - 0.25), 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 12) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x - 0.5), y, (z - 0.5), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x - 0.5), y, (z - 0.5), 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 15) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x - 0.75), (y - 0.25), (z - 0.75), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x - 0.75), (y - 0.25), (z - 0.75), 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 18) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x - 1), (y - 0.5), (z - 1), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x - 1), (y - 0.5), (z - 1), 1, 0, 0, 0, 0);
						}
					}
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") < 18) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("ParticleSpawn", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") + 1));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") >= 18) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("ParticleSpawn", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x + 2, y - 2, z - 2))).getBlock() == DistantWorldsModBlocks.LITHUM_CORE.get()) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x + 2, y - 2, z - 2), "CurrentEnergy") < new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x + 2, y - 2, z - 2), "MaxEnergy")) {
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y - 1, z), "CurrentEnergy") >= energy) {
						TransferedEnergy = energy;
					} else {
						TransferedEnergy = new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y - 1, z), "CurrentEnergy");
					}
					if ((new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x + 2, y - 2, z - 2), "MaxEnergy")) - (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x + 2, y - 2, z - 2), "CurrentEnergy")) < TransferedEnergy) {
						TransferedEnergy = (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x + 2, y - 2, z - 2), "MaxEnergy")) - (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x + 2, y - 2, z - 2), "CurrentEnergy"));
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y - 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("CurrentEnergy", ((new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y - 1, z), "CurrentEnergy")) - TransferedEnergy));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x + 2, y - 2, z - 2);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("CurrentEnergy", (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x + 2, y - 2, z - 2), "CurrentEnergy") + TransferedEnergy));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 6) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x + 1), (y + 0.5), z, 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x + 1), (y + 0.5), z, 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 9) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x + 1.25), (y + 0.25), (z - 0.25), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x + 1.25), (y + 0.25), (z - 0.25), 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 12) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x + 1.5), y, (z - 0.5), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x + 1.5), y, (z - 0.5), 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 15) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x + 1.75), (y - 0.25), (z - 0.75), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x + 1.75), (y - 0.25), (z - 0.75), 1, 0, 0, 0, 0);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") == 18) {
						if (energy == 10) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get()), (x + 2), (y - 0.5), (z - 1), 1, 0, 0, 0, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (x + 2), (y - 0.5), (z - 1), 1, 0, 0, 0, 0);
						}
					}
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") < 18) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("ParticleSpawn", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") + 1));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ParticleSpawn") >= 18) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("ParticleSpawn", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("ParticleSpawn", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
	}
}
