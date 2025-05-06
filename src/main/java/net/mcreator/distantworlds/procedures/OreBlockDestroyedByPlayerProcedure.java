package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

public class OreBlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				if (blockstate.getBlock() == DistantWorldsModBlocks.HELYST_ORE.get()) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, (x + 0.5), (y + 0.5), (z + 0.5), Mth.nextInt(RandomSource.create(), 5, 7)));
				} else if (blockstate.getBlock() == DistantWorldsModBlocks.DALITE_ORE.get()) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, (x + 0.5), (y + 0.5), (z + 0.5), Mth.nextInt(RandomSource.create(), 3, 5)));
				} else if (blockstate.getBlock() == DistantWorldsModBlocks.CURELITE_ORE.get()) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, (x + 0.5), (y + 0.5), (z + 0.5), Mth.nextInt(RandomSource.create(), 1, 3)));
				} else if (blockstate.getBlock() == DistantWorldsModBlocks.FIRON_ORE.get()) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, (x + 0.5), (y + 0.5), (z + 0.5), Mth.nextInt(RandomSource.create(), 7, 10)));
				}
			}
		}
	}
}
