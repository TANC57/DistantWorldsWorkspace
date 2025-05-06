package net.mcreator.distantworlds.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.distantworlds.entity.DruthEntity;

public class DruthModel extends GeoModel<DruthEntity> {
	@Override
	public ResourceLocation getAnimationResource(DruthEntity entity) {
		return new ResourceLocation("distant_worlds", "animations/druth.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DruthEntity entity) {
		return new ResourceLocation("distant_worlds", "geo/druth.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DruthEntity entity) {
		return new ResourceLocation("distant_worlds", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(DruthEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("Head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
