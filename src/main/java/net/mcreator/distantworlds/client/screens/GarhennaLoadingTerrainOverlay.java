
package net.mcreator.distantworlds.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.gui.screens.ReceivingLevelScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

import net.mcreator.distantworlds.procedures.GarhennaLoadingTerrainDisplayOverlayIngameProcedure;
import net.mcreator.distantworlds.procedures.GarhennaLoadingTerrainReturnBiomeNameProcedure;
import net.mcreator.distantworlds.procedures.GarhennaLoadingTerrainReturnBiomeDisplayProcedure;
import net.mcreator.distantworlds.procedures.GarhennaLoadingTerrainReturnBiomeBackgroundProcedure;

import net.minecraft.client.renderer.GameRenderer;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.resources.ResourceLocation;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class GarhennaLoadingTerrainOverlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(ScreenEvent.Render.Post event) {
		if (event.getScreen() instanceof ReceivingLevelScreen) {
			int w = event.getScreen().width;
			int h = event.getScreen().height;
			int posX = w / 2;
			int posY = h / 2 - 50;
			Level world = null;
			double x = 0;
			double y = 0;
			double z = 0;
			String biomeMessage = "";
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				world = entity.level();
				x = entity.getX();
				y = entity.getY();
				z = entity.getZ();
				biomeMessage = GarhennaLoadingTerrainReturnBiomeNameProcedure.execute(world, entity);
			}
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);
			double biomeNum = GarhennaLoadingTerrainReturnBiomeBackgroundProcedure.execute(world, entity);
			
			if (GarhennaLoadingTerrainDisplayOverlayIngameProcedure.execute(entity)) {
				if (biomeNum == 1) {
					event.getGuiGraphics().blit(new ResourceLocation("distant_worlds:textures/block/fralite.png"), 0, 0, 0, 0, w, h, 32, 32);
					event.getGuiGraphics().blit(new ResourceLocation("distant_worlds:textures/block/overgrown_fralite_top.png"), 0, 0, 0, 0, w, 32, 32, 32);
					event.getGuiGraphics().blit(new ResourceLocation("distant_worlds:textures/block/overgrown_fralite_side.png"), 0, 32, 0, 0, w, 32, 32, 32);
				} else if (biomeNum == 2) {
					event.getGuiGraphics().blit(new ResourceLocation("distant_worlds:textures/block/layered_mud.png"), 0, 0, 0, 0, w, h, 32, 32);
					event.getGuiGraphics().blit(new ResourceLocation("distant_worlds:textures/block/lifeless_grass_top.png"), 0, 0, 0, 0, w, 32, 32, 32);
					event.getGuiGraphics().blit(new ResourceLocation("distant_worlds:textures/block/lifeless_grass_side.png"), 0, 32, 0, 0, w, 32, 32, 32);
				} else if (biomeNum == 3) {
					event.getGuiGraphics().blit(new ResourceLocation("distant_worlds:textures/block/layered_mud.png"), 0, 0, 0, 0, w, h, 32, 32);
					event.getGuiGraphics().blit(new ResourceLocation("distant_worlds:textures/block/sticky_layered_mud.png"), 0, 0, 0, 0, w, 64, 32, 32);
				} else if (biomeNum == 4) {
					event.getGuiGraphics().blit(new ResourceLocation("distant_worlds:textures/block/lithum.png"), 0, 0, 0, 0, w, h, 32, 32);
					event.getGuiGraphics().blit(new ResourceLocation("distant_worlds:textures/block/withered_soil.png"), 0, 0, 0, 0, w, 64, 32, 32);
				} else {
					event.getGuiGraphics().blit(new ResourceLocation("distant_worlds:textures/block/revelite.png"), 0, 0, 0, 0, w, h, 32, 32);
				}

				event.getGuiGraphics().blit(new ResourceLocation("distant_worlds:textures/screens/loading_terrain.png"), 0, 0, 0, 0, w, h, 32, 32);
				event.getGuiGraphics().drawCenteredString(Minecraft.getInstance().font, Component.translatable("multiplayer.downloadingTerrain"), posX, posY, -1);

				if (GarhennaLoadingTerrainReturnBiomeDisplayProcedure.execute(world, entity)) {
					event.getGuiGraphics().drawCenteredString(Minecraft.getInstance().font, biomeMessage, posX, posY + 20, -1);
				}
			}
			
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
