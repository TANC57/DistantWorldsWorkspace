package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.init.DistantWorldsModEntities;
import net.mcreator.distantworlds.entity.SalmoranEntity;
import net.mcreator.distantworlds.entity.AlphaSalmoranEntity;

import java.util.Comparator;

public class SalmoranRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		String Name = "";
		if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
			if (itemstack.getItem() == DistantWorldsModItems.SALMORAN_EYE.get()) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					itemstack.shrink(1);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.HOSTILE, 1, (float) (0.8 + Math.random() * 0.4));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.HOSTILE, 1, (float) (0.8 + Math.random() * 0.4), false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 15, 0.5, 0.5, 0.5, 0);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = DistantWorldsModEntities.ALPHA_SALMORAN.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(entity.getYRot());
						entityToSpawn.setYBodyRot(entity.getYRot());
						entityToSpawn.setYHeadRot(entity.getYRot());
						entityToSpawn.setXRot(entity.getXRot());
						entityToSpawn.setDeltaMovement(0, 0, 0);
						if (entityToSpawn instanceof LivingEntity _entity)
							_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
						if (entity.isOnFire()) {
							entityToSpawn.setSecondsOnFire(entity.getRemainingFireTicks());
						}
						if (entityToSpawn instanceof TamableAnimal _toTame && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof Player _owner)
							_toTame.tame(_owner);
						Name = entity.getDisplayName().getString();
						if (!(Name).equals(Component.translatable("entity.distant_worlds.salmoran").getString())) {
							entityToSpawn.setCustomName(Component.literal(Name));
						}
						if (entityToSpawn instanceof AlphaSalmoranEntity _datEntSetI)
							_datEntSetI.getEntityData().set(AlphaSalmoranEntity.DATA_Behavior, (int) (entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_Behavior) : 0));
						if (entityToSpawn instanceof AlphaSalmoranEntity _datEntSetI)
							_datEntSetI.getEntityData().set(AlphaSalmoranEntity.DATA_InLove, (int) (entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_InLove) : 0));
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if (itemstack.getItem() == DistantWorldsModItems.WILTUM_FRUIT.get()) {
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
			} else if (itemstack.getItem() == DistantWorldsModItems.SALMORAN_TREAT.get() && (entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_InLove) : 0) == 0
					&& (entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_BabyAge) : 0) <= 0) {
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
				if (entity instanceof SalmoranEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SalmoranEntity.DATA_InLove, 1200);
			} else if (itemstack.getItem() == ItemStack.EMPTY.getItem()) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (entity.isPassenger()) {
					entity.stopRiding();
					if (entity instanceof SalmoranEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SalmoranEntity.DATA_Behavior, 0);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + "" + Component.translatable("event.distant_worlds.behavior.follow").getString())), true);
				} else {
					if ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_Behavior) : 0) == 0) {
						if (entity instanceof SalmoranEntity _datEntSetI)
							_datEntSetI.getEntityData().set(SalmoranEntity.DATA_Behavior, 1);
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + "" + Component.translatable("event.distant_worlds.behavior.wander").getString())), true);
					} else if ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_Behavior) : 0) == 1) {
						if (entity instanceof SalmoranEntity _datEntSetI)
							_datEntSetI.getEntityData().set(SalmoranEntity.DATA_Behavior, 2);
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + "" + Component.translatable("event.distant_worlds.behavior.stay").getString())), true);
					} else {
						if (entity instanceof SalmoranEntity _datEntSetI)
							_datEntSetI.getEntityData().set(SalmoranEntity.DATA_Behavior, 0);
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + "" + Component.translatable("event.distant_worlds.behavior.follow").getString())), true);
					}
				}
			}
		} else {
			if (itemstack.getItem() == DistantWorldsModItems.SALMORAN_TREAT.get()) {
				if ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_Irritated) : 0) == 0 || (sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (!(sourceentity instanceof ServerPlayer _plr90 && _plr90.level() instanceof ServerLevel
							&& _plr90.getAdvancements().getOrStartProgress(_plr90.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:treats_for_new_friends"))).isDone())) {
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:treats_for_new_friends"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
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
					if (!world.isClientSide()) {
						if (Math.random() < 0.25) {
							if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
								_toTame.tame(_owner);
							if (entity instanceof SalmoranEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SalmoranEntity.DATA_InLove, -200);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.HEART, x, y, z, 5, 1, 1, 1, 0);
						} else {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 5, 1, 1, 1, 0);
							if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof SalmoranEntity _datEntSetI)
									_datEntSetI.getEntityData().set(SalmoranEntity.DATA_Irritated, (int) ((entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_Irritated) : 0) + 180));
							}
						}
					}
				} else {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 5, 0.5, 0.5, 0.5, 0);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.HOSTILE, 1, (float) (0.8 + Math.random() * 0.4));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.HOSTILE, 1, (float) (0.8 + Math.random() * 0.4), false);
						}
					}
				}
			}
		}
	}
}
