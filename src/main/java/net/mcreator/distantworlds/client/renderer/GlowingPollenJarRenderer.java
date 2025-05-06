package net.mcreator.distantworlds.client.renderer;

import top.theillusivec4.curios.api.client.ICurioRenderer;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.distantworlds.init.DistantWorldsModLayerDefinitions;
import net.mcreator.distantworlds.client.model.ModelGlowingPollenJar;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GlowingPollenJarRenderer implements ICurioRenderer {
	private static final ResourceLocation TEXTURE = new ResourceLocation("distant_worlds", "textures/entities/glowing_pollen_jar.png");
	private static final ResourceLocation GLOWING = new ResourceLocation("distant_worlds", "textures/entities/glowing_pollen_jar_glowing.png");
	private final ModelGlowingPollenJar model;

	public GlowingPollenJarRenderer() {
		this.model = new ModelGlowingPollenJar(Minecraft.getInstance().getEntityModels().bakeLayer(DistantWorldsModLayerDefinitions.GLOWING_POLLEN_JAR));
	}

	@Override
	public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing,
			float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		LivingEntity entity = slotContext.entity();
		ICurioRenderer.translateIfSneaking(matrixStack, entity);
		this.model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
		this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(renderTypeBuffer, RenderType.entityTranslucentCull(TEXTURE), false, stack.hasFoil());
		this.model.renderToBuffer(matrixStack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		VertexConsumer vertexconsumerglowing = ItemRenderer.getArmorFoilBuffer(renderTypeBuffer, RenderType.eyes(GLOWING), false, stack.hasFoil());
		this.model.renderToBuffer(matrixStack, vertexconsumerglowing, light, OverlayTexture.NO_OVERLAY, 0.5F, 0.5F, 0.5F, 0.5F);
	}
}
