
package net.mcreator.distantworlds.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.distantworlds.entity.model.SalmoranModel;
import net.mcreator.distantworlds.entity.layer.SalmoranLayer;
import net.mcreator.distantworlds.entity.SalmoranEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SalmoranRenderer extends GeoEntityRenderer<SalmoranEntity> {
	public SalmoranRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SalmoranModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new SalmoranLayer(this));
	}

	@Override
	public RenderType getRenderType(SalmoranEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityCutout(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, SalmoranEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
