
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.distantworlds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.entity.decoration.PaintingVariant;

import net.mcreator.distantworlds.DistantWorldsMod;

public class DistantWorldsModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, DistantWorldsMod.MODID);
	public static final RegistryObject<PaintingVariant> FIRON_SWORD_PAINTING = REGISTRY.register("firon_sword_painting", () -> new PaintingVariant(16, 16));
	public static final RegistryObject<PaintingVariant> STICKY_MARSHES_PAINTING = REGISTRY.register("sticky_marshes_painting", () -> new PaintingVariant(32, 32));
	public static final RegistryObject<PaintingVariant> BURNING_PLAINS_PAINTING = REGISTRY.register("burning_plains_painting", () -> new PaintingVariant(32, 16));
	public static final RegistryObject<PaintingVariant> MOLTEN_HILLS_PAINTING = REGISTRY.register("molten_hills_painting", () -> new PaintingVariant(32, 32));
	public static final RegistryObject<PaintingVariant> SALMORAN_PAINTING = REGISTRY.register("salmoran_painting", () -> new PaintingVariant(64, 32));
	public static final RegistryObject<PaintingVariant> NOARHORN_PAINTING = REGISTRY.register("noarhorn_painting", () -> new PaintingVariant(64, 32));
}
