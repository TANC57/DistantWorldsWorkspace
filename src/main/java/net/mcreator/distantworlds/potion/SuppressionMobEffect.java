
package net.mcreator.distantworlds.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class SuppressionMobEffect extends MobEffect {
	public SuppressionMobEffect() {
		super(MobEffectCategory.HARMFUL, -13130566);
	}

	@Override
	public String getDescriptionId() {
		return "effect.distant_worlds.suppression";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
