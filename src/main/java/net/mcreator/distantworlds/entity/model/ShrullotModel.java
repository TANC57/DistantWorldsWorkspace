package net.mcreator.distantworlds.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.distantworlds.entity.ShrullotEntity;

public class ShrullotModel extends GeoModel<ShrullotEntity> {
	@Override
	public ResourceLocation getAnimationResource(ShrullotEntity entity) {
		return new ResourceLocation("distant_worlds", "animations/shrullot.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShrullotEntity entity) {
		return new ResourceLocation("distant_worlds", "geo/shrullot.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShrullotEntity entity) {
		return new ResourceLocation("distant_worlds", "textures/entities/" + entity.getTexture() + ".png");
	}

}
