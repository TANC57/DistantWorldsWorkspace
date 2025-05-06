package net.mcreator.distantworlds.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.distantworlds.world.inventory.GarhennaResearchesTableGUIMenu;
import net.mcreator.distantworlds.procedures.OutputImageDisplayConditionProcedure;
import net.mcreator.distantworlds.procedures.Module2ImageDisplayConditionProcedure;
import net.mcreator.distantworlds.procedures.Module0ImageDisplayConditionProcedure;

import net.mcreator.distantworlds.procedures.ReturnGarhennaResearchesLevelDisplayProcedure;
import net.mcreator.distantworlds.procedures.ReturnGarhennaResearchesBookDisplayProcedure;
import net.mcreator.distantworlds.procedures.GarhennaResearchesLevelAlertProcedure;
import net.minecraft.client.Minecraft;
import java.util.List;
import com.google.common.collect.Lists;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GarhennaResearchesTableGUIScreen extends AbstractContainerScreen<GarhennaResearchesTableGUIMenu> {
	private final static HashMap<String, Object> guistate = GarhennaResearchesTableGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public GarhennaResearchesTableGUIScreen(GarhennaResearchesTableGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("distant_worlds:textures/screens/garhenna_researches_table_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (GarhennaResearchesLevelAlertProcedure.execute(world, x, y, z) && this.isHovering(53, 46, 16, 16, (double)mouseX, (double)mouseY))
			guiGraphics.renderTooltip(font, Component.translatable("gui.distant_worlds.garhenna_researches.level_alert"), mouseX, mouseY + 15);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		double GarhennaResearchesLevel = ReturnGarhennaResearchesLevelDisplayProcedure.execute(world, x, y, z);
		double GarhennaResearchesBook = ReturnGarhennaResearchesBookDisplayProcedure.execute(world, x, y, z);

		//Garhenna Researches Book Display
		guiGraphics.blit(new ResourceLocation("distant_worlds:textures/screens/garhenna_book_max.png"), this.leftPos + 90, this.topPos + 49, 0, 0, 14, 11, 14, 11);
		guiGraphics.blit(new ResourceLocation("distant_worlds:textures/screens/garhenna_book_min.png"), this.leftPos + 90, this.topPos + 49, 0, 0, 14, (int)GarhennaResearchesBook, 14, 11);

		//Garhenna Researches Level Display
		if (GarhennaResearchesLevel >= 0 && GarhennaResearchesLevel <= 4)
			guiGraphics.blit(new ResourceLocation("distant_worlds:textures/screens/garhenna_researches_levels.png"), this.leftPos + 94, this.topPos + 66, 0, 0 + (int)(GarhennaResearchesLevel * 5), 7, 5, 7, 25);



		if (Module0ImageDisplayConditionProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("distant_worlds:textures/screens/garhenna_researches_empty_slot.png"), this.leftPos + 53, this.topPos + 46, 0, 0, 16, 16, 16, 16);
		}
		if (OutputImageDisplayConditionProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("distant_worlds:textures/screens/ancient_garhenna_papers_icon.png"), this.leftPos + 71, this.topPos + 46, 0, 0, 16, 16, 16, 16);
		}
		if (Module2ImageDisplayConditionProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("distant_worlds:textures/screens/completed_garhenna_researches_icon.png"), this.leftPos + 107, this.topPos + 46, 0, 0, 16, 16, 16, 16);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		int posX = this.imageWidth / 2;
		int posY = 7;
		guiGraphics.drawCenteredString(Minecraft.getInstance().font, Component.translatable("name.distant_worlds.garhenna_researches_table"), posX, posY, -2985372);
	}



	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
	}
}
