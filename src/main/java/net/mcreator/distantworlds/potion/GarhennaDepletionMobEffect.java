
package net.mcreator.distantworlds.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.distantworlds.procedures.GarhennaDepletionOnEffectActiveTickProcedure;

public class GarhennaDepletionMobEffect extends MobEffect {
	public GarhennaDepletionMobEffect() {
		super(MobEffectCategory.HARMFUL, -3310539);
	}

	@Override
	public String getDescriptionId() {
		return "effect.distant_worlds.garhenna_depletion";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		GarhennaDepletionOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
