package net.mcreator.distantworlds.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;
import net.mcreator.distantworlds.DistantWorldsMod;

@Mod.EventBusSubscriber(modid = DistantWorldsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DistantWorldsModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigCommonConfiguration.SPEC, "distantworlds-common.toml");
		});
	}
}
