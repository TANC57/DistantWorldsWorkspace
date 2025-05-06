package net.mcreator.distantworlds.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.distantworlds.entity.ArmoredNoarhornEntity;

public class ArmoredNoarhornModel extends GeoModel<ArmoredNoarhornEntity> {
	@Override
	public ResourceLocation getAnimationResource(ArmoredNoarhornEntity entity) {
		return new ResourceLocation("distant_worlds", "animations/noarhorn.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ArmoredNoarhornEntity entity) {
		return new ResourceLocation("distant_worlds", "geo/noarhorn.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ArmoredNoarhornEntity entity) {
		return new ResourceLocation("distant_worlds", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(ArmoredNoarhornEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("Head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(head.getRotX() + entityData.headPitch() * ((float) Math.PI / 180F));
			head.setRotY(head.getRotY() + entityData.netHeadYaw() * ((float) Math.PI / 180F));
		}
	}
}
