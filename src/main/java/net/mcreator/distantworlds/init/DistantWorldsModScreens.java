
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.distantworlds.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.distantworlds.client.gui.LithumTransmitterGUIScreen;
import net.mcreator.distantworlds.client.gui.LithumStorageGUIScreen;
import net.mcreator.distantworlds.client.gui.LithumPedestalGUIScreen;
import net.mcreator.distantworlds.client.gui.LithumFurnaceGUIScreen;
import net.mcreator.distantworlds.client.gui.LithumCoreGUIScreen;
import net.mcreator.distantworlds.client.gui.LithumConverterGUIScreen;
import net.mcreator.distantworlds.client.gui.GarhennaResearchesTableGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DistantWorldsModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(DistantWorldsModMenus.LITHUM_PEDESTAL_GUI.get(), LithumPedestalGUIScreen::new);
			MenuScreens.register(DistantWorldsModMenus.LITHUM_FURNACE_GUI.get(), LithumFurnaceGUIScreen::new);
			MenuScreens.register(DistantWorldsModMenus.LITHUM_STORAGE_GUI.get(), LithumStorageGUIScreen::new);
			MenuScreens.register(DistantWorldsModMenus.LITHUM_TRANSMITTER_GUI.get(), LithumTransmitterGUIScreen::new);
			MenuScreens.register(DistantWorldsModMenus.LITHUM_CORE_GUI.get(), LithumCoreGUIScreen::new);
			MenuScreens.register(DistantWorldsModMenus.LITHUM_CONVERTER_GUI.get(), LithumConverterGUIScreen::new);
			MenuScreens.register(DistantWorldsModMenus.GARHENNA_RESEARCHES_TABLE_GUI.get(), GarhennaResearchesTableGUIScreen::new);
		});
	}
}
