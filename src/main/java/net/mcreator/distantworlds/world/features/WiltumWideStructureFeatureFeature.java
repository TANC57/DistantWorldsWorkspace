
package net.mcreator.distantworlds.world.features;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.distantworlds.world.features.configurations.StructureFeatureConfiguration;
import net.mcreator.distantworlds.procedures.WiltumTreeStructureAdditionalGenerationConditionProcedure;

public class WiltumWideStructureFeatureFeature extends StructureFeature {
	public WiltumWideStructureFeatureFeature() {
		super(StructureFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!WiltumTreeStructureAdditionalGenerationConditionProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}
