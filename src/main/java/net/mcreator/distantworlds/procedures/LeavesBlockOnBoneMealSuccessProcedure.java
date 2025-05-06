package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModParticleTypes;
import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class LeavesBlockOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (blockstate.getBlock() == DistantWorldsModBlocks.GARSALE_LEAVES.get()) {
			world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.FLOWERING_GARSALE_LEAVES.get().defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.GLOWING_POLLEN_PARTICLE.get()), (x + 0.5), (y + 0.5), (z + 0.5), 5, 0.5, 0.5, 0.5, 0.1);
		} else if (blockstate.getBlock() == DistantWorldsModBlocks.WILTUM_LEAVES.get()) {
			world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.FLOWERING_WILTUM_LEAVES.get().defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.WILTUM_TWINKLE_PARTICLE.get()), (x + 0.5), (y + 0.5), (z + 0.5), 5, 0.5, 0.5, 0.5, 0.1);
		} else if (blockstate.getBlock() == DistantWorldsModBlocks.GARSALE_VINES.get()) {
			world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.FLOWERING_GARSALE_VINES.get().defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.GLOWING_POLLEN_PARTICLE.get()), (x + 0.5), (y + 0.5), (z + 0.5), 5, 0.5, 0.5, 0.5, 0.1);
		} else if (blockstate.getBlock() == DistantWorldsModBlocks.WILTUM_VINES.get()) {
			world.setBlock(BlockPos.containing(x, y, z), DistantWorldsModBlocks.FLOWERING_WILTUM_VINES.get().defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.WILTUM_TWINKLE_PARTICLE.get()), (x + 0.5), (y + 0.5), (z + 0.5), 5, 0.5, 0.5, 0.5, 0.1);
		} else if (blockstate.getBlock() == DistantWorldsModBlocks.GARSALE_LANTERN.get()) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(DistantWorldsModItems.GLOWING_POLLEN.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beehive.exit")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beehive.exit")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.GLOWING_POLLEN_PARTICLE.get()), (x + 0.5), (y + 0.5), (z + 0.5), 5, 0.5, 0.5, 0.5, 0.1);
		}
	}
}
