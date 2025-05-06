package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

public class GarhennaResearchesTableUpdateMaxProgressProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		String CurrentResearch = "";
		double Result = 0;
		CurrentResearch = new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "CurrentResearch");
		if ((CurrentResearch).equals("incandescent_forever")) {
			Result = 20;
		}
		if ((CurrentResearch).equals("bright_clusters")) {
			Result = 5;
		}
		if ((CurrentResearch).equals("awakened_stones")) {
			Result = 10;
		}
		if ((CurrentResearch).equals("new_energy")) {
			Result = 10;
		}
		if ((CurrentResearch).equals("better_without_hugs")) {
			Result = 10;
		}
		if ((CurrentResearch).equals("strong_shell")) {
			Result = 10;
		}
		if ((CurrentResearch).equals("experienced_mushroom_picker")) {
			Result = 7;
		}
		if ((CurrentResearch).equals("inner_spark")) {
			Result = 12;
		}
		if ((CurrentResearch).equals("trees_are_watching")) {
			Result = 10;
		}
		if ((CurrentResearch).equals("does_it_smile")) {
			Result = 8;
		}
		if ((CurrentResearch).equals("living_metal")) {
			Result = 15;
		}
		if ((CurrentResearch).equals("born_to_crawl")) {
			Result = 10;
		}
		if ((CurrentResearch).equals("at_the_very_top")) {
			Result = 9;
		}
		if ((CurrentResearch).equals("encased_soul")) {
			Result = 17;
		}
		return Result * 20 * Math.abs((double) ConfigCommonConfiguration.RESEARCH_TIME_MODIFIER.get());
	}
}
