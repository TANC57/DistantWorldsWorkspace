package net.mcreator.distantworlds.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.distantworlds.entity.LithumTransmitterCrystalEntity;

public class LithumTransmitterCrystalModel extends GeoModel<LithumTransmitterCrystalEntity> {
	@Override
	public ResourceLocation getAnimationResource(LithumTransmitterCrystalEntity entity) {
		return new ResourceLocation("distant_worlds", "animations/lithum_transmitter_crystal.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LithumTransmitterCrystalEntity entity) {
		return new ResourceLocation("distant_worlds", "geo/lithum_transmitter_crystal.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LithumTransmitterCrystalEntity entity) {
		return new ResourceLocation("distant_worlds", "textures/entities/" + entity.getTexture() + ".png");
	}

}
