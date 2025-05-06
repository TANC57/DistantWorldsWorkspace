package net.mcreator.distantworlds.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.distantworlds.entity.AlphaSalmoranEntity;

public class AlphaSalmoranModel extends GeoModel<AlphaSalmoranEntity> {
	@Override
	public ResourceLocation getAnimationResource(AlphaSalmoranEntity entity) {
		return new ResourceLocation("distant_worlds", "animations/alpha_salmoran.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AlphaSalmoranEntity entity) {
		return new ResourceLocation("distant_worlds", "geo/alpha_salmoran.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AlphaSalmoranEntity entity) {
		return new ResourceLocation("distant_worlds", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(AlphaSalmoranEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("Head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(head.getRotX() + entityData.headPitch() * ((float) Math.PI / 180F));
			head.setRotY(head.getRotY() + entityData.netHeadYaw() * ((float) Math.PI / 180F));
		}
	}
}
