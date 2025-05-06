
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

import net.mcreator.distantworlds.procedures.DaliteIndicatorOverlayReturnPermanentImmunityProcedure;
import net.mcreator.distantworlds.procedures.DaliteIndicatorOverlayReturnDepletionProcedure;
import net.mcreator.distantworlds.procedures.DaliteIndicatorOverlayReturnAdaptationProcedure;
import net.mcreator.distantworlds.procedures.DaliteIndicatorOverlayDisplayOverlayIngameProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class DaliteIndicatorOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w / 64;
		int posY = h / 32;
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
		if (DaliteIndicatorOverlayDisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().blit(new ResourceLocation("distant_worlds:textures/screens/dalite_indicator_overlay.png"), posX, posY, 0, 0, 142, 51, 142, 51);

			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DaliteIndicatorOverlayReturnDepletionProcedure.execute(entity), posX + 22, posY + 7, -13210, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DaliteIndicatorOverlayReturnAdaptationProcedure.execute(entity), posX + 22, posY + 22, -13210, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DaliteIndicatorOverlayReturnPermanentImmunityProcedure.execute(entity), posX + 22, posY + 36, -13210, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
