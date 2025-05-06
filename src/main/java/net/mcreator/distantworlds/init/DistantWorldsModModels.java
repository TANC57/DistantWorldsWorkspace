
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.distantworlds.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.distantworlds.client.model.ModelSalmoranCrown;
import net.mcreator.distantworlds.client.model.ModelGlowingPollenJar;
import net.mcreator.distantworlds.client.model.ModelCulafiteShroomerCap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DistantWorldsModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelCulafiteShroomerCap.LAYER_LOCATION, ModelCulafiteShroomerCap::createBodyLayer);
		event.registerLayerDefinition(ModelSalmoranCrown.LAYER_LOCATION, ModelSalmoranCrown::createBodyLayer);
		event.registerLayerDefinition(ModelGlowingPollenJar.LAYER_LOCATION, ModelGlowingPollenJar::createBodyLayer);
	}
}
