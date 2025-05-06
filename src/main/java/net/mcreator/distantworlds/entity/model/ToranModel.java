package net.mcreator.distantworlds.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.distantworlds.entity.ToranEntity;

public class ToranModel extends GeoModel<ToranEntity> {
	@Override
	public ResourceLocation getAnimationResource(ToranEntity entity) {
		return new ResourceLocation("distant_worlds", "animations/toran.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ToranEntity entity) {
		return new ResourceLocation("distant_worlds", "geo/toran.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ToranEntity entity) {
		return new ResourceLocation("distant_worlds", "textures/entities/" + entity.getTexture() + ".png");
	}

}
