
package net.mcreator.distantworlds.world.features;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.distantworlds.world.features.configurations.StructureFeatureConfiguration;
import net.mcreator.distantworlds.procedures.HelystStalagmiteAdditionalGenerationConditionProcedure;

public class HelystStalagmiteLowFeatureFeature extends StructureFeature {
	public HelystStalagmiteLowFeatureFeature() {
		super(StructureFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!HelystStalagmiteAdditionalGenerationConditionProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}
