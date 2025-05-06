
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.distantworlds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.distantworlds.enchantment.SalmoranStingEnchantment;
import net.mcreator.distantworlds.enchantment.OversaturationEnchantment;
import net.mcreator.distantworlds.enchantment.DaliteEnergyMendingEnchantment;
import net.mcreator.distantworlds.enchantment.CrystalFacetingEnchantment;
import net.mcreator.distantworlds.DistantWorldsMod;

public class DistantWorldsModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DistantWorldsMod.MODID);
	public static final RegistryObject<Enchantment> SALMORAN_STING = REGISTRY.register("salmoran_sting", () -> new SalmoranStingEnchantment());
	public static final RegistryObject<Enchantment> DALITE_ENERGY_MENDING = REGISTRY.register("dalite_energy_mending", () -> new DaliteEnergyMendingEnchantment());
	public static final RegistryObject<Enchantment> OVERSATURATION = REGISTRY.register("oversaturation", () -> new OversaturationEnchantment());
	public static final RegistryObject<Enchantment> CRYSTAL_FACETING = REGISTRY.register("crystal_faceting", () -> new CrystalFacetingEnchantment());
}
