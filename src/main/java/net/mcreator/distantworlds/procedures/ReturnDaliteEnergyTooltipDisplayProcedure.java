package net.mcreator.distantworlds.procedures;

import software.bernie.geckolib.core.object.Color;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class ReturnDaliteEnergyTooltipDisplayProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String Color = "";
		double MaxEnergy = 0;
		double CurrentEnergy = 0;
		double CurrentDuration = 0;
		return "\u00A76" + (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "MaxEnergy") == 0 ? "0" : new java.text.DecimalFormat("##").format(new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "CurrentEnergy")) + "" + (" / " + new java.text.DecimalFormat("##").format(new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "MaxEnergy"))));
	}
}
