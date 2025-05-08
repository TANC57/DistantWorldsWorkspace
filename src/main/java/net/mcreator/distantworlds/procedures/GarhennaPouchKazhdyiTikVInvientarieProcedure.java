package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class GarhennaPouchKazhdyiTikVInvientarieProcedure {
	public static void execute(ItemStack itemstack) {
		double line_number = 0;
		if (!itemstack.getOrCreateTag().getBoolean("generatedTag")) {
			for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), 1, 4); index0++) {
				itemstack.getOrCreateTag().putString(("lootLine" + Math.round(line_number)),
						(ForgeRegistries.ITEMS.getKey((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("distant_worlds:garhenna_pouch_loot"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).toString()));
				itemstack.getOrCreateTag().putDouble(("countLine" + Math.round(line_number)), (Mth.nextDouble(RandomSource.create(), 1, 3)));
				line_number = line_number + 1;
			}
			itemstack.getOrCreateTag().putBoolean("generatedTag", true);
		}
	}
}
