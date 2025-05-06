
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.distantworlds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.distantworlds.DistantWorldsMod;

public class DistantWorldsModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, DistantWorldsMod.MODID);
	public static final RegistryObject<Potion> SUPPRESSION_POTION = REGISTRY.register("suppression_potion", () -> new Potion(new MobEffectInstance(DistantWorldsModMobEffects.SUPPRESSION.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> STICKY_SHACKLES_POTION = REGISTRY.register("sticky_shackles_potion", () -> new Potion(new MobEffectInstance(DistantWorldsModMobEffects.STICKY_SHACKLES.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> GARHENNA_DEPLETION_POTION = REGISTRY.register("garhenna_depletion_potion", () -> new Potion(new MobEffectInstance(DistantWorldsModMobEffects.GARHENNA_DEPLETION.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> GARHENNA_IMMUNITY_POTION = REGISTRY.register("garhenna_immunity_potion", () -> new Potion(new MobEffectInstance(DistantWorldsModMobEffects.GARHENNA_IMMUNITY.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> IGNITION_POTION = REGISTRY.register("ignition_potion", () -> new Potion(new MobEffectInstance(DistantWorldsModMobEffects.IGNITION.get(), 3600, 0, false, true)));
}
