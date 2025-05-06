package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
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
import net.mcreator.distantworlds.entity.BabySalmoranEntity;

public class BabySalmoranRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		Entity GeneratedEntity = null;
		String Name = "";
		if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
			if (itemstack.getItem() == DistantWorldsModItems.WILTUM_FRUIT.get()) {
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
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 4
								? (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)
								: (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 4));
				}
			} else if (itemstack.getItem() == ItemStack.EMPTY.getItem()) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if ((entity instanceof BabySalmoranEntity _datEntI ? _datEntI.getEntityData().get(BabySalmoranEntity.DATA_Behavior) : 0) != 1) {
					if (entity instanceof BabySalmoranEntity _datEntSetI)
						_datEntSetI.getEntityData().set(BabySalmoranEntity.DATA_Behavior, 1);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + "" + Component.translatable("event.distant_worlds.behavior.wander").getString())), true);
				} else if ((entity instanceof BabySalmoranEntity _datEntI ? _datEntI.getEntityData().get(BabySalmoranEntity.DATA_Behavior) : 0) != 2) {
					if (entity instanceof BabySalmoranEntity _datEntSetI)
						_datEntSetI.getEntityData().set(BabySalmoranEntity.DATA_Behavior, 2);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + "" + Component.translatable("event.distant_worlds.behavior.stay").getString())), true);
				}
			}
		}
		if (!world.isClientSide()) {
			if (((entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) || (sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false))
					&& itemstack.getItem() == DistantWorldsModItems.WILTUM_CRATE.get()) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item_frame.add_item")), SoundSource.PLAYERS, 1, (float) (0.8 + Math.random() * 0.4));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item_frame.add_item")), SoundSource.PLAYERS, 1, (float) (0.8 + Math.random() * 0.4), false);
					}
				}
				itemstack.getOrCreateTag().putString("Contains", "salmoran");
				itemstack.getOrCreateTag().putDouble("Health", (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1));
				itemstack.getOrCreateTag().putString("Name", (entity.getDisplayName().getString()));
				itemstack.getOrCreateTag().putDouble("Behavior", (entity instanceof BabySalmoranEntity _datEntI ? _datEntI.getEntityData().get(BabySalmoranEntity.DATA_Behavior) : 0));
				itemstack.getOrCreateTag().putDouble("Age", (entity instanceof BabySalmoranEntity _datEntI ? _datEntI.getEntityData().get(BabySalmoranEntity.DATA_Age) : 0));
				if (!entity.level().isClientSide())
					entity.discard();
				if (sourceentity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 5);
			}
		}
	}
}
