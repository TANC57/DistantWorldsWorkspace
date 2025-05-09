package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class AsmuldaBerryBushUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (!world.isClientSide()) {
			if (Math.random() < 0.1) {
				if ((blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip2 ? blockstate.getValue(_getip2) : -1) < 3) {
					{
						int _value = (int) ((blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip4 ? blockstate.getValue(_getip4) : -1) + 1);
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				}
			}
		}
	}
}
