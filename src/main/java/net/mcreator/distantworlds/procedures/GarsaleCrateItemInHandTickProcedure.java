package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class GarsaleCrateItemInHandTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if ((itemstack.getOrCreateTag().getString("Contains")).equals("noarhorn")) {
			itemstack.setHoverName(Component.literal(("\u00A7f" + Component.translatable("item.distant_worlds.garsale_crate_noarhorn").getString())));
			if (!world.isClientSide()) {
				if (Math.random() < 0.005) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zoglin.ambient")), SoundSource.PLAYERS, (float) 0.75, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zoglin.ambient")), SoundSource.PLAYERS, (float) 0.75, 1, false);
						}
					}
				}
			}
		} else {
			itemstack.setHoverName(Component.literal(("\u00A7f" + Component.translatable("item.distant_worlds.garsale_crate").getString())));
		}
	}
}
