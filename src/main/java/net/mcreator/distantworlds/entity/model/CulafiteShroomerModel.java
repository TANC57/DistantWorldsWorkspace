package net.mcreator.distantworlds.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.distantworlds.entity.CulafiteShroomerEntity;

public class CulafiteShroomerModel extends GeoModel<CulafiteShroomerEntity> {
	@Override
	public ResourceLocation getAnimationResource(CulafiteShroomerEntity entity) {
		return new ResourceLocation("distant_worlds", "animations/culafite_shroomer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CulafiteShroomerEntity entity) {
		return new ResourceLocation("distant_worlds", "geo/culafite_shroomer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CulafiteShroomerEntity entity) {
		return new ResourceLocation("distant_worlds", "textures/entities/" + entity.getTexture() + ".png");
	}

}
