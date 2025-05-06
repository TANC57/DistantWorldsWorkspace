
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.distantworlds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.distantworlds.potion.SuppressionMobEffect;
import net.mcreator.distantworlds.potion.SupervisionMobEffect;
import net.mcreator.distantworlds.potion.StickyShacklesMobEffect;
import net.mcreator.distantworlds.potion.IgnitionMobEffect;
import net.mcreator.distantworlds.potion.GarhennaImmunityMobEffect;
import net.mcreator.distantworlds.potion.GarhennaDepletionMobEffect;
import net.mcreator.distantworlds.DistantWorldsMod;

public class DistantWorldsModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DistantWorldsMod.MODID);
	public static final RegistryObject<MobEffect> GARHENNA_DEPLETION = REGISTRY.register("garhenna_depletion", () -> new GarhennaDepletionMobEffect());
	public static final RegistryObject<MobEffect> GARHENNA_IMMUNITY = REGISTRY.register("garhenna_immunity", () -> new GarhennaImmunityMobEffect());
	public static final RegistryObject<MobEffect> SUPPRESSION = REGISTRY.register("suppression", () -> new SuppressionMobEffect());
	public static final RegistryObject<MobEffect> STICKY_SHACKLES = REGISTRY.register("sticky_shackles", () -> new StickyShacklesMobEffect());
	public static final RegistryObject<MobEffect> IGNITION = REGISTRY.register("ignition", () -> new IgnitionMobEffect());
	public static final RegistryObject<MobEffect> SUPERVISION = REGISTRY.register("supervision", () -> new SupervisionMobEffect());
}
