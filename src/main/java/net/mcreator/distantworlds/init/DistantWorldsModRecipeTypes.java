package net.mcreator.distantworlds.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;

import net.mcreator.distantworlds.jei_recipes.LithumAltarRecipeTypeRecipe;
import net.mcreator.distantworlds.DistantWorldsMod;

@Mod.EventBusSubscriber(modid = DistantWorldsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DistantWorldsModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "distant_worlds");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("lithum_altar_recipe_type", () -> LithumAltarRecipeTypeRecipe.Serializer.INSTANCE);
		});
	}
}
