
package net.mcreator.distantworlds.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class GarhennaImmunityMobEffect extends MobEffect {
	public GarhennaImmunityMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3310539);
	}

	@Override
	public String getDescriptionId() {
		return "effect.distant_worlds.garhenna_immunity";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
