
package net.mcreator.distantworlds.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.distantworlds.procedures.SupervisionOnEffectActiveTickProcedure;

public class SupervisionMobEffect extends MobEffect {
	public SupervisionMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13865833);
	}

	@Override
	public String getDescriptionId() {
		return "effect.distant_worlds.supervision";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SupervisionOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
