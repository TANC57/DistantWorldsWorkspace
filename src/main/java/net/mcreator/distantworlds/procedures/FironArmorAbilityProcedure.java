package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModItems;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class FironArmorAbilityProcedure {
	@SubscribeEvent
	public static void onEntityFall(LivingFallEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getDistance());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, double distance) {
		execute(null, world, entity, distance);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double distance) {
		if (entity == null)
			return;
		double Damage = 0;
		double TimeOnFire = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.FIRON_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.FIRON_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.FIRON_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.FIRON_BOOTS.get()
				&& !(entity instanceof Player _plrCldCheck8 && _plrCldCheck8.getCooldowns().isOnCooldown(DistantWorldsModItems.FIRON_HELMET.get()))
				&& !(entity instanceof Player _plrCldCheck9 && _plrCldCheck9.getCooldowns().isOnCooldown(DistantWorldsModItems.FIRON_CHESTPLATE.get()))
				&& !(entity instanceof Player _plrCldCheck10 && _plrCldCheck10.getCooldowns().isOnCooldown(DistantWorldsModItems.FIRON_LEGGINGS.get()))
				&& !(entity instanceof Player _plrCldCheck11 && _plrCldCheck11.getCooldowns().isOnCooldown(DistantWorldsModItems.FIRON_BOOTS.get())) && entity.isShiftKeyDown()) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(DistantWorldsModItems.FIRON_HELMET.get(), 600);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(DistantWorldsModItems.FIRON_CHESTPLATE.get(), 600);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(DistantWorldsModItems.FIRON_LEGGINGS.get(), 600);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(DistantWorldsModItems.FIRON_BOOTS.get(), 600);
			{
				ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY);
				if (_ist.hurt(3, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			{
				ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
				if (_ist.hurt(3, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			{
				ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY);
				if (_ist.hurt(3, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			{
				ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY);
				if (_ist.hurt(3, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			Damage = Math.round(distance) * 3;
			if (Damage > 15) {
				Damage = 15;
			} else if (Damage < 5) {
				Damage = 5;
			}
			TimeOnFire = Math.round(distance) * 2;
			if (TimeOnFire > 8) {
				TimeOnFire = 8;
			} else if (TimeOnFire < 2) {
				TimeOnFire = 2;
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity) && entityiterator instanceof LivingEntity && !entityiterator.fireImmune()
							&& !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.HOT_FLOOR), entity), (float) Damage);
						entityiterator.setSecondsOnFire((int) TimeOnFire);
						entityiterator.setDeltaMovement(new Vec3(((-0.75) * (entity.getX() - entityiterator.getX())), 0.25, ((-0.75) * (entity.getZ() - entityiterator.getZ()))));
					}
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.magma_cube.squish")), SoundSource.AMBIENT, (float) 1.5, (float) 0.8);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.magma_cube.squish")), SoundSource.AMBIENT, (float) 1.5, (float) 0.8, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.AMBIENT, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.AMBIENT, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LAVA, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 0.25, 0.1, 0.25, 1);
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
