package net.mcreator.distantworlds.init;

import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;

import net.mcreator.distantworlds.client.renderer.SalmoranCrownRenderer;
import net.mcreator.distantworlds.client.renderer.GlowingPollenJarRenderer;
import net.mcreator.distantworlds.client.renderer.CulafiteShroomerCapRenderer;
import net.mcreator.distantworlds.client.model.ModelSalmoranCrown;
import net.mcreator.distantworlds.client.model.ModelGlowingPollenJar;
import net.mcreator.distantworlds.client.model.ModelCulafiteShroomerCap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DistantWorldsModCuriosRenderers {
	@SubscribeEvent
	public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions evt) {
		evt.registerLayerDefinition(DistantWorldsModLayerDefinitions.CULAFITE_SHROOMER_CAP, ModelCulafiteShroomerCap::createBodyLayer);
		evt.registerLayerDefinition(DistantWorldsModLayerDefinitions.SALMORAN_CROWN, ModelSalmoranCrown::createBodyLayer);
		evt.registerLayerDefinition(DistantWorldsModLayerDefinitions.GLOWING_POLLEN_JAR, ModelGlowingPollenJar::createBodyLayer);
	}

	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent evt) {
		CuriosRendererRegistry.register(DistantWorldsModItems.CULAFITE_SHROOMER_CAP.get(), CulafiteShroomerCapRenderer::new);
		CuriosRendererRegistry.register(DistantWorldsModItems.SALMORAN_CROWN.get(), SalmoranCrownRenderer::new);
		CuriosRendererRegistry.register(DistantWorldsModItems.GLOWING_POLLEN_JAR.get(), GlowingPollenJarRenderer::new);
	}
}
