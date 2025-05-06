
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.distantworlds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.distantworlds.world.inventory.LithumTransmitterGUIMenu;
import net.mcreator.distantworlds.world.inventory.LithumStorageGUIMenu;
import net.mcreator.distantworlds.world.inventory.LithumPedestalGUIMenu;
import net.mcreator.distantworlds.world.inventory.LithumFurnaceGUIMenu;
import net.mcreator.distantworlds.world.inventory.LithumCoreGUIMenu;
import net.mcreator.distantworlds.world.inventory.LithumConverterGUIMenu;
import net.mcreator.distantworlds.world.inventory.GarhennaResearchesTableGUIMenu;
import net.mcreator.distantworlds.DistantWorldsMod;

public class DistantWorldsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DistantWorldsMod.MODID);
	public static final RegistryObject<MenuType<LithumPedestalGUIMenu>> LITHUM_PEDESTAL_GUI = REGISTRY.register("lithum_pedestal_gui", () -> IForgeMenuType.create(LithumPedestalGUIMenu::new));
	public static final RegistryObject<MenuType<LithumFurnaceGUIMenu>> LITHUM_FURNACE_GUI = REGISTRY.register("lithum_furnace_gui", () -> IForgeMenuType.create(LithumFurnaceGUIMenu::new));
	public static final RegistryObject<MenuType<LithumStorageGUIMenu>> LITHUM_STORAGE_GUI = REGISTRY.register("lithum_storage_gui", () -> IForgeMenuType.create(LithumStorageGUIMenu::new));
	public static final RegistryObject<MenuType<LithumTransmitterGUIMenu>> LITHUM_TRANSMITTER_GUI = REGISTRY.register("lithum_transmitter_gui", () -> IForgeMenuType.create(LithumTransmitterGUIMenu::new));
	public static final RegistryObject<MenuType<LithumCoreGUIMenu>> LITHUM_CORE_GUI = REGISTRY.register("lithum_core_gui", () -> IForgeMenuType.create(LithumCoreGUIMenu::new));
	public static final RegistryObject<MenuType<LithumConverterGUIMenu>> LITHUM_CONVERTER_GUI = REGISTRY.register("lithum_converter_gui", () -> IForgeMenuType.create(LithumConverterGUIMenu::new));
	public static final RegistryObject<MenuType<GarhennaResearchesTableGUIMenu>> GARHENNA_RESEARCHES_TABLE_GUI = REGISTRY.register("garhenna_researches_table_gui", () -> IForgeMenuType.create(GarhennaResearchesTableGUIMenu::new));
}
