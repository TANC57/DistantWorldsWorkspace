
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.distantworlds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.distantworlds.block.entity.SalmoranEggBlockEntity;
import net.mcreator.distantworlds.block.entity.PottedFuziannaBlockEntity;
import net.mcreator.distantworlds.block.entity.LithumTransmitterBlockEntity;
import net.mcreator.distantworlds.block.entity.LithumStorageInitialBlockEntity;
import net.mcreator.distantworlds.block.entity.LithumStorageExtendedBlockEntity;
import net.mcreator.distantworlds.block.entity.LithumStorageAdvancedBlockEntity;
import net.mcreator.distantworlds.block.entity.LithumPedestalBlockEntity;
import net.mcreator.distantworlds.block.entity.LithumFurnaceBlockEntity;
import net.mcreator.distantworlds.block.entity.LithumCoreBlockEntity;
import net.mcreator.distantworlds.block.entity.LithumConverterBlockEntity;
import net.mcreator.distantworlds.block.entity.GlowingPollenBlockBlockEntity;
import net.mcreator.distantworlds.block.entity.GarhennaResearchesTableBlockEntity;
import net.mcreator.distantworlds.block.entity.CrackedSalmoranEggBlockEntity;
import net.mcreator.distantworlds.DistantWorldsMod;

public class DistantWorldsModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DistantWorldsMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> SALMORAN_EGG = register("salmoran_egg", DistantWorldsModBlocks.SALMORAN_EGG, SalmoranEggBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GARHENNA_RESEARCHES_TABLE = register("garhenna_researches_table", DistantWorldsModBlocks.GARHENNA_RESEARCHES_TABLE, GarhennaResearchesTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LITHUM_PEDESTAL = register("lithum_pedestal", DistantWorldsModBlocks.LITHUM_PEDESTAL, LithumPedestalBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LITHUM_FURNACE = register("lithum_furnace", DistantWorldsModBlocks.LITHUM_FURNACE, LithumFurnaceBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LITHUM_CONVERTER = register("lithum_converter", DistantWorldsModBlocks.LITHUM_CONVERTER, LithumConverterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LITHUM_STORAGE_INITIAL = register("lithum_storage_initial", DistantWorldsModBlocks.LITHUM_STORAGE_INITIAL, LithumStorageInitialBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LITHUM_STORAGE_EXTENDED = register("lithum_storage_extended", DistantWorldsModBlocks.LITHUM_STORAGE_EXTENDED, LithumStorageExtendedBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LITHUM_STORAGE_ADVANCED = register("lithum_storage_advanced", DistantWorldsModBlocks.LITHUM_STORAGE_ADVANCED, LithumStorageAdvancedBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LITHUM_TRANSMITTER = register("lithum_transmitter", DistantWorldsModBlocks.LITHUM_TRANSMITTER, LithumTransmitterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LITHUM_CORE = register("lithum_core", DistantWorldsModBlocks.LITHUM_CORE, LithumCoreBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> POTTED_FUZIANNA = register("potted_fuzianna", DistantWorldsModBlocks.POTTED_FUZIANNA, PottedFuziannaBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GLOWING_POLLEN_BLOCK = register("glowing_pollen_block", DistantWorldsModBlocks.GLOWING_POLLEN_BLOCK, GlowingPollenBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CRACKED_SALMORAN_EGG = register("cracked_salmoran_egg", DistantWorldsModBlocks.CRACKED_SALMORAN_EGG, CrackedSalmoranEggBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
