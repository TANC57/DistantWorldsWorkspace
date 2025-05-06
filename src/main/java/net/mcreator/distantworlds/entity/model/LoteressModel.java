package net.mcreator.distantworlds.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.distantworlds.entity.LoteressEntity;

public class LoteressModel extends GeoModel<LoteressEntity> {
	@Override
	public ResourceLocation getAnimationResource(LoteressEntity entity) {
		return new ResourceLocation("distant_worlds", "animations/loteress.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LoteressEntity entity) {
		return new ResourceLocation("distant_worlds", "geo/loteress.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LoteressEntity entity) {
		return new ResourceLocation("distant_worlds", "textures/entities/" + entity.getTexture() + ".png");
	}

}
