
package net.mcreator.distantworlds.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.distantworlds.entity.model.CrouthilModel;
import net.mcreator.distantworlds.entity.layer.CrouthilLayer;
import net.mcreator.distantworlds.entity.CrouthilEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CrouthilRenderer extends GeoEntityRenderer<CrouthilEntity> {
	public CrouthilRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new CrouthilModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new CrouthilLayer(this));
	}

	@Override
	public RenderType getRenderType(CrouthilEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityCutout(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, CrouthilEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
