package net.mcreator.distantworlds.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.distantworlds.world.inventory.LithumFurnaceGUIMenu;
import net.mcreator.distantworlds.procedures.ModuleImageDisplayConditionProcedure;
import net.mcreator.distantworlds.procedures.Module0ImageDisplayConditionProcedure;

import net.mcreator.distantworlds.procedures.ReturnDaliteEnergyLevelDisplayProcedure;
import net.mcreator.distantworlds.procedures.ReturnCureliteFuelLevelDisplayProcedure;
import net.mcreator.distantworlds.procedures.ReturnDaliteEnergyTooltipDisplayProcedure;
import net.minecraft.client.Minecraft;
import java.util.List;
import com.google.common.collect.Lists;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class LithumFurnaceGUIScreen extends AbstractContainerScreen<LithumFurnaceGUIMenu> {
	private final static HashMap<String, Object> guistate = LithumFurnaceGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public LithumFurnaceGUIScreen(LithumFurnaceGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("distant_worlds:textures/screens/lithum_furnace_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (this.isHovering(78, 27, 16, 32, (double)mouseX, (double)mouseY))
			guiGraphics.renderTooltip(font, Component.literal(ReturnDaliteEnergyTooltipDisplayProcedure.execute(world, x, y, z)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		double DaliteEnergyLevel = ReturnDaliteEnergyLevelDisplayProcedure.execute(world, x, y, z);
		double CureliteFuelLevel = ReturnCureliteFuelLevelDisplayProcedure.execute(world, x, y, z);

		//Dalite Energy Display
		guiGraphics.blit(new ResourceLocation("distant_worlds:textures/screens/dalite_energy_max.png"), this.leftPos + 78, this.topPos + 27, 0, 0, 16, 32, 16, 32);
		guiGraphics.blit(new ResourceLocation("distant_worlds:textures/screens/dalite_energy_min.png"), this.leftPos + 78, this.topPos + 27, 0, 0, 16, (int)DaliteEnergyLevel, 16, 32);


		//Curelite Fuel Display
		guiGraphics.blit(new ResourceLocation("distant_worlds:textures/screens/curelite_fuel_min.png"), this.leftPos + 62, this.topPos + 36, 0, 0, 14, (int)CureliteFuelLevel, 14, 14);

		if (ModuleImageDisplayConditionProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("distant_worlds:textures/screens/slot_empty_module.png"), this.leftPos + 115, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (Module0ImageDisplayConditionProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("distant_worlds:textures/screens/slot_empty_item.png"), this.leftPos + 43, this.topPos + 35, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.drawCenteredString(Minecraft.getInstance().font, Component.translatable("name.distant_worlds.lithum_furnace"), posX, posY, -8756653);
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
