package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.init.DistantWorldsModBlocks;
import net.mcreator.distantworlds.entity.ArmoredNoarhornEntity;

public class ArmoredNoarhornRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
			if (itemstack.getItem() == DistantWorldsModBlocks.CULAFITE_MUSHROOM.get().asItem()) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						itemstack.shrink(1);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.NEUTRAL, 1, (float) (0.8 + Math.random() * 0.4));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.NEUTRAL, 1, (float) (0.8 + Math.random() * 0.4), false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HEART, x, y, z, 5, 1, 1, 1, 0);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 3
								? (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)
								: (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 3));
				}
			} else if (itemstack.getItem() == DistantWorldsModItems.CULAFITE_MUSHROOM_STEW.get() && (entity instanceof ArmoredNoarhornEntity _datEntI ? _datEntI.getEntityData().get(ArmoredNoarhornEntity.DATA_InLove) : 0) == 0
					&& (entity instanceof ArmoredNoarhornEntity _datEntI ? _datEntI.getEntityData().get(ArmoredNoarhornEntity.DATA_BabyAge) : 0) <= 0) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					itemstack.shrink(1);
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.BOWL);
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.NEUTRAL, 1, (float) (0.8 + Math.random() * 0.4));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.NEUTRAL, 1, (float) (0.8 + Math.random() * 0.4), false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HEART, x, y, z, 5, 1, 1, 1, 0);
				if (entity instanceof ArmoredNoarhornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ArmoredNoarhornEntity.DATA_InLove, 1200);
			} else if (itemstack.getItem() == ItemStack.EMPTY.getItem()) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (entity.isPassenger()) {
					entity.stopRiding();
					if (entity instanceof ArmoredNoarhornEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ArmoredNoarhornEntity.DATA_Behavior, 0);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + "" + Component.translatable("event.distant_worlds.behavior.follow").getString())), true);
				} else {
					if ((entity instanceof ArmoredNoarhornEntity _datEntI ? _datEntI.getEntityData().get(ArmoredNoarhornEntity.DATA_Behavior) : 0) == 0) {
						if (entity instanceof ArmoredNoarhornEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArmoredNoarhornEntity.DATA_Behavior, 1);
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + "" + Component.translatable("event.distant_worlds.behavior.wander").getString())), true);
					} else if ((entity instanceof ArmoredNoarhornEntity _datEntI ? _datEntI.getEntityData().get(ArmoredNoarhornEntity.DATA_Behavior) : 0) == 1) {
						if (entity instanceof ArmoredNoarhornEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArmoredNoarhornEntity.DATA_Behavior, 2);
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + "" + Component.translatable("event.distant_worlds.behavior.stay").getString())), true);
					} else {
						if (entity instanceof ArmoredNoarhornEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArmoredNoarhornEntity.DATA_Behavior, 0);
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + "" + Component.translatable("event.distant_worlds.behavior.follow").getString())), true);
					}
				}
			}
		}
	}
}
