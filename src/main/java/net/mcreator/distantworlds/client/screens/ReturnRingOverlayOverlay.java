
package net.mcreator.distantworlds.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.distantworlds.procedures.ReturnRingOverlayReturnZProcedure;
import net.mcreator.distantworlds.procedures.ReturnRingOverlayReturnYProcedure;
import net.mcreator.distantworlds.procedures.ReturnRingOverlayReturnXProcedure;
import net.mcreator.distantworlds.procedures.ReturnRingOverlayDisplayOverlayIngameProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class ReturnRingOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = (w / 2) -71;
		int posY = (h / 2) + (h / 8);
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (ReturnRingOverlayDisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().blit(new ResourceLocation("distant_worlds:textures/screens/return_ring_overlay.png"), posX, posY, 0, 0, 142, 51, 142, 51);

			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					"X = " + ReturnRingOverlayReturnXProcedure.execute(entity), posX + 23, posY + 7, -16737997, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					"Y = " + ReturnRingOverlayReturnYProcedure.execute(entity), posX + 23, posY + 22, -16737997, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					"Z = " + ReturnRingOverlayReturnZProcedure.execute(entity), posX + 23, posY + 36, -16737997, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
