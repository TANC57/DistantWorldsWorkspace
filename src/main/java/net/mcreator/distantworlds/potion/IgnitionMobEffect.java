
package net.mcreator.distantworlds.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class IgnitionMobEffect extends MobEffect {
	public IgnitionMobEffect() {
		super(MobEffectCategory.HARMFUL, -2664959);
	}

	@Override
	public String getDescriptionId() {
		return "effect.distant_worlds.ignition";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
