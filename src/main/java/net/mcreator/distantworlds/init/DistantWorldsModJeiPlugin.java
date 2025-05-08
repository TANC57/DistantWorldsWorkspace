
package net.mcreator.distantworlds.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.distantworlds.jei_recipes.LithumAltarRecipeTypeRecipeCategory;
import net.mcreator.distantworlds.jei_recipes.LithumAltarRecipeTypeRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.Objects;
import java.util.List;

@JeiPlugin
public class DistantWorldsModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<LithumAltarRecipeTypeRecipe> LithumAltarRecipeType_Type = new mezz.jei.api.recipe.RecipeType<>(LithumAltarRecipeTypeRecipeCategory.UID, LithumAltarRecipeTypeRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("distant_worlds:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new LithumAltarRecipeTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<LithumAltarRecipeTypeRecipe> LithumAltarRecipeTypeRecipes = recipeManager.getAllRecipesFor(LithumAltarRecipeTypeRecipe.Type.INSTANCE);
		registration.addRecipes(LithumAltarRecipeType_Type, LithumAltarRecipeTypeRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(DistantWorldsModBlocks.LITHUM_CORE.get().asItem()), LithumAltarRecipeType_Type);
	}
}
