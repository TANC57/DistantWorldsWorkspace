package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

import java.util.Map;

public class LayeredMudUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double X = 0;
		double Y = 0;
		double Z = 0;
		boolean isGrassNear = false;
		if (!world.isClientSide()) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("distant_worlds:burning_plains"))) {
				if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).isFaceSturdy(world, BlockPos.containing(x, y + 1, z), Direction.DOWN)) {
					isGrassNear = false;
					Y = y - 1;
					for (int index0 = 0; index0 < 3; index0++) {
						Z = z - 1;
						for (int index1 = 0; index1 < 3; index1++) {
							X = x - 1;
							for (int index2 = 0; index2 < 3; index2++) {
								if ((world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == DistantWorldsModBlocks.LIFELESS_GRASS.get()) {
									isGrassNear = true;
									break;
								}
								X = X + 1;
							}
							Z = Z + 1;
						}
						Y = Y + 1;
					}
					if (isGrassNear == true) {
						if (Math.random() < 0.5) {
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = DistantWorldsModBlocks.LIFELESS_GRASS.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
									if (_property != null && _bs.getValue(_property) != null)
										try {
											_bs = _bs.setValue(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
						}
					}
				}
			}
		}
	}
}
