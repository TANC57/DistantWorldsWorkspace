
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.distantworlds.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.distantworlds.client.renderer.WiltumCouchRiddenRenderer;
import net.mcreator.distantworlds.client.renderer.ToranRenderer;
import net.mcreator.distantworlds.client.renderer.ShrullotRenderer;
import net.mcreator.distantworlds.client.renderer.SalmoranRenderer;
import net.mcreator.distantworlds.client.renderer.NoarhornRenderer;
import net.mcreator.distantworlds.client.renderer.LoteressRenderer;
import net.mcreator.distantworlds.client.renderer.LithumTransmitterCrystalRenderer;
import net.mcreator.distantworlds.client.renderer.GarsaleCouchRiddenRenderer;
import net.mcreator.distantworlds.client.renderer.GarhennaResearchesBookRenderer;
import net.mcreator.distantworlds.client.renderer.DruthRenderer;
import net.mcreator.distantworlds.client.renderer.CulafiteShroomerRenderer;
import net.mcreator.distantworlds.client.renderer.CrouthilRenderer;
import net.mcreator.distantworlds.client.renderer.BooglianRenderer;
import net.mcreator.distantworlds.client.renderer.BabySalmoranRenderer;
import net.mcreator.distantworlds.client.renderer.BabyNoarhornRenderer;
import net.mcreator.distantworlds.client.renderer.ArmoredNoarhornRenderer;
import net.mcreator.distantworlds.client.renderer.AlphaSalmoranRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DistantWorldsModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(DistantWorldsModEntities.DRUTH.get(), DruthRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.CROUTHIL.get(), CrouthilRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.SHRULLOT.get(), ShrullotRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.BOOGLIAN.get(), BooglianRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.CULAFITE_SHROOMER.get(), CulafiteShroomerRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.BABY_NOARHORN.get(), BabyNoarhornRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.NOARHORN.get(), NoarhornRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.ARMORED_NOARHORN.get(), ArmoredNoarhornRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.BABY_SALMORAN.get(), BabySalmoranRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.SALMORAN.get(), SalmoranRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.ALPHA_SALMORAN.get(), AlphaSalmoranRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.TORAN.get(), ToranRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.LOTERESS.get(), LoteressRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.GARHENNA_RESEARCHES_BOOK.get(), GarhennaResearchesBookRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.LITHUM_TRANSMITTER_CRYSTAL.get(), LithumTransmitterCrystalRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.GARSALE_COUCH_RIDDEN.get(), GarsaleCouchRiddenRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.WILTUM_COUCH_RIDDEN.get(), WiltumCouchRiddenRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.FRALITE_BALL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(DistantWorldsModEntities.SIMPLE_DALITE_MAGIC.get(), ThrownItemRenderer::new);
	}
}
