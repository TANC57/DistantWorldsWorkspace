
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.distantworlds.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.distantworlds.client.particle.WiltumTwinkleParticleParticle;
import net.mcreator.distantworlds.client.particle.WiltumLeafParticleParticle;
import net.mcreator.distantworlds.client.particle.WiltumCoreParticleParticle;
import net.mcreator.distantworlds.client.particle.StickyMarshesParticleParticle;
import net.mcreator.distantworlds.client.particle.MoltenHillsParticleParticle;
import net.mcreator.distantworlds.client.particle.GlowingPollenParticleParticle;
import net.mcreator.distantworlds.client.particle.GarsaleSlimeParticleParticle;
import net.mcreator.distantworlds.client.particle.GarsaleLeafParticleParticle;
import net.mcreator.distantworlds.client.particle.FuziannaJellyParticleParticle;
import net.mcreator.distantworlds.client.particle.DeadValleyParticleParticle;
import net.mcreator.distantworlds.client.particle.DaliteSparkParticleParticle;
import net.mcreator.distantworlds.client.particle.DaliteSparkLargeParticleParticle;
import net.mcreator.distantworlds.client.particle.DaliteParticleParticle;
import net.mcreator.distantworlds.client.particle.DaliteEnergyParticleParticle;
import net.mcreator.distantworlds.client.particle.DaliteCoreParticleParticle;
import net.mcreator.distantworlds.client.particle.CureliteSparkLargeParticleParticle;
import net.mcreator.distantworlds.client.particle.CureliteParticleParticle;
import net.mcreator.distantworlds.client.particle.CureliteFlameParticleParticle;
import net.mcreator.distantworlds.client.particle.CureliteEnergyParticleParticle;
import net.mcreator.distantworlds.client.particle.CureliteCoreParticleParticle;
import net.mcreator.distantworlds.client.particle.CulafiteSporeParticleParticle;
import net.mcreator.distantworlds.client.particle.CulafiteShroomlightParticleParticle;
import net.mcreator.distantworlds.client.particle.BurningPlainsParticleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DistantWorldsModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(DistantWorldsModParticleTypes.WILTUM_CORE_PARTICLE.get(), WiltumCoreParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.DEAD_VALLEY_PARTICLE.get(), DeadValleyParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.GARSALE_SLIME_PARTICLE.get(), GarsaleSlimeParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.MOLTEN_HILLS_PARTICLE.get(), MoltenHillsParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.STICKY_MARSHES_PARTICLE.get(), StickyMarshesParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.GLOWING_POLLEN_PARTICLE.get(), GlowingPollenParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.DALITE_PARTICLE.get(), DaliteParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.CURELITE_FLAME_PARTICLE.get(), CureliteFlameParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get(), DaliteEnergyParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.DALITE_CORE_PARTICLE.get(), DaliteCoreParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.BURNING_PLAINS_PARTICLE.get(), BurningPlainsParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.CURELITE_PARTICLE.get(), CureliteParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.CURELITE_ENERGY_PARTICLE.get(), CureliteEnergyParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.CURELITE_CORE_PARTICLE.get(), CureliteCoreParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.DALITE_SPARK_PARTICLE.get(), DaliteSparkParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.FUZIANNA_JELLY_PARTICLE.get(), FuziannaJellyParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.DALITE_SPARK_LARGE_PARTICLE.get(), DaliteSparkLargeParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.GARSALE_LEAF_PARTICLE.get(), GarsaleLeafParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.WILTUM_TWINKLE_PARTICLE.get(), WiltumTwinkleParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.WILTUM_LEAF_PARTICLE.get(), WiltumLeafParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.CURELITE_SPARK_LARGE_PARTICLE.get(), CureliteSparkLargeParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.CULAFITE_SPORE_PARTICLE.get(), CulafiteSporeParticleParticle::provider);
		event.registerSpriteSet(DistantWorldsModParticleTypes.CULAFITE_SHROOMLIGHT_PARTICLE.get(), CulafiteShroomlightParticleParticle::provider);
	}
}
