
package net.mcreator.distantworlds.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.distantworlds.init.DistantWorldsModJeiPlugin;
import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class LithumAltarRecipeTypeRecipeCategory implements IRecipeCategory<LithumAltarRecipeTypeRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("distant_worlds", "lithum_altar_recipe_type");
	public final static ResourceLocation TEXTURE = new ResourceLocation("distant_worlds", "textures/screens/lithum_altar_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public LithumAltarRecipeTypeRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 112);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(DistantWorldsModBlocks.LITHUM_CORE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<LithumAltarRecipeTypeRecipe> getRecipeType() {
		return DistantWorldsModJeiPlugin.LithumAltarRecipeType_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Lithum Altar");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, LithumAltarRecipeTypeRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 36, 14).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 18, 32).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 18, 64).addIngredients(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 36, 82).addIngredients(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.INPUT, 68, 82).addIngredients(recipe.getIngredients().get(5));
		builder.addSlot(RecipeIngredientRole.INPUT, 86, 64).addIngredients(recipe.getIngredients().get(6));
		builder.addSlot(RecipeIngredientRole.INPUT, 86, 32).addIngredients(recipe.getIngredients().get(7));
		builder.addSlot(RecipeIngredientRole.INPUT, 68, 14).addIngredients(recipe.getIngredients().get(8));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 140, 49).addItemStack(recipe.getResultItem(null));
		builder.addSlot(RecipeIngredientRole.INPUT, 52, 48).addIngredients(recipe.getIngredients().get(0));
	}
}
