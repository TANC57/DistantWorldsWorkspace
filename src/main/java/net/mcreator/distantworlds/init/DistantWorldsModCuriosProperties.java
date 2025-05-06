package net.mcreator.distantworlds.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.distantworlds.procedures.DaliteIndicatorPropertyValueProviderProcedure;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DistantWorldsModCuriosProperties {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(DistantWorldsModItems.DALITE_INDICATOR.get(), new ResourceLocation("distant_worlds:dalite_indicator_depletion_level"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) DaliteIndicatorPropertyValueProviderProcedure.execute(entity));
		});
	}
}
