package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;

public class GarhennaPouchRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double count_of_lines = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather")), SoundSource.PLAYERS, (float) 0.5, (float) (0.8 + Math.random() * 0.4));
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather")), SoundSource.PLAYERS, (float) 0.5, (float) (0.8 + Math.random() * 0.4), false);
			}
		}
		while (!(itemstack.getOrCreateTag().getString(("lootLine" + Math.round(count_of_lines)))).equals("")) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("summon minecraft:item ~ ~0.25 ~ {Item:{id:\"" + "" + itemstack.getOrCreateTag().getString(("lootLine" + Math.round(count_of_lines))) + "\",Count:"
								+ Math.round(itemstack.getOrCreateTag().getDouble(("countLine" + Math.round(count_of_lines)))) + "}}"));
			count_of_lines = count_of_lines + 1;
		}
		if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaPouchOpen == 100) {
			if (!(entity instanceof ServerPlayer _plr11 && _plr11.level() instanceof ServerLevel
					&& _plr11.getAdvancements().getOrStartProgress(_plr11.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:noarhorn_out_of_bag"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:noarhorn_out_of_bag"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		} else {
			{
				double _setval = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).GarhennaPouchOpen + 1;
				entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GarhennaPouchOpen = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			itemstack.setCount((int) (itemstack.getCount() - 1));
		} else {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 10);
		}
	}
}
