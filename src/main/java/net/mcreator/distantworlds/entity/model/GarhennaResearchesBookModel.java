package net.mcreator.distantworlds.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.distantworlds.entity.GarhennaResearchesBookEntity;

public class GarhennaResearchesBookModel extends GeoModel<GarhennaResearchesBookEntity> {
	@Override
	public ResourceLocation getAnimationResource(GarhennaResearchesBookEntity entity) {
		return new ResourceLocation("distant_worlds", "animations/garhenna_researches_book.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GarhennaResearchesBookEntity entity) {
		return new ResourceLocation("distant_worlds", "geo/garhenna_researches_book.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GarhennaResearchesBookEntity entity) {
		return new ResourceLocation("distant_worlds", "textures/entities/" + entity.getTexture() + ".png");
	}

}
