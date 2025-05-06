
package net.mcreator.distantworlds.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class StickyShacklesMobEffect extends MobEffect {
	public StickyShacklesMobEffect() {
		super(MobEffectCategory.HARMFUL, -3928257);
	}

	@Override
	public String getDescriptionId() {
		return "effect.distant_worlds.sticky_shackles";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
