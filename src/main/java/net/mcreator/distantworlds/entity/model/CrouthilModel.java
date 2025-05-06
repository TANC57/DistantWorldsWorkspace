package net.mcreator.distantworlds.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.distantworlds.entity.CrouthilEntity;

public class CrouthilModel extends GeoModel<CrouthilEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrouthilEntity entity) {
		return new ResourceLocation("distant_worlds", "animations/crouthil.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrouthilEntity entity) {
		return new ResourceLocation("distant_worlds", "geo/crouthil.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrouthilEntity entity) {
		return new ResourceLocation("distant_worlds", "textures/entities/" + entity.getTexture() + ".png");
	}

}
