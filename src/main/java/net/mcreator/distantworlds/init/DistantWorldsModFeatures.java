
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.distantworlds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.distantworlds.world.features.WiltumWideStructureFeatureFeature;
import net.mcreator.distantworlds.world.features.WiltumTreeFeatureFeature;
import net.mcreator.distantworlds.world.features.HelystStalagmiteTallFeatureFeature;
import net.mcreator.distantworlds.world.features.HelystStalagmiteLowFeatureFeature;
import net.mcreator.distantworlds.world.features.HelystStalagmiteFeatureFeature;
import net.mcreator.distantworlds.DistantWorldsMod;

@Mod.EventBusSubscriber
public class DistantWorldsModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, DistantWorldsMod.MODID);
	public static final RegistryObject<Feature<?>> WILTUM_WIDE_STRUCTURE_FEATURE = REGISTRY.register("wiltum_wide_structure_feature", WiltumWideStructureFeatureFeature::new);
	public static final RegistryObject<Feature<?>> HELYST_STALAGMITE_LOW_FEATURE = REGISTRY.register("helyst_stalagmite_low_feature", HelystStalagmiteLowFeatureFeature::new);
	public static final RegistryObject<Feature<?>> HELYST_STALAGMITE_FEATURE = REGISTRY.register("helyst_stalagmite_feature", HelystStalagmiteFeatureFeature::new);
	public static final RegistryObject<Feature<?>> HELYST_STALAGMITE_TALL_FEATURE = REGISTRY.register("helyst_stalagmite_tall_feature", HelystStalagmiteTallFeatureFeature::new);
	public static final RegistryObject<Feature<?>> WILTUM_TREE_FEATURE = REGISTRY.register("wiltum_tree_feature", WiltumTreeFeatureFeature::new);
}
