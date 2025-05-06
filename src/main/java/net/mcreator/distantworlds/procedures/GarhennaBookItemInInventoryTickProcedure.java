package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.ModList;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

public class GarhennaBookItemInInventoryTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack book = ItemStack.EMPTY;
		if (ModList.get().isLoaded("patchouli")) {
			itemstack.shrink(1);
			book = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("patchouli:guide_book")));
			book.getOrCreateTag().putString("patchouli:book", "distant_worlds:garhenna_book");
			if (entity instanceof Player _player) {
				ItemStack _setstack = book;
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
