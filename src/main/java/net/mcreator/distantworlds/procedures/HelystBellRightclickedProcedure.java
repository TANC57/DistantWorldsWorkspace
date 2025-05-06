package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.distantworlds.entity.SalmoranEntity;
import net.mcreator.distantworlds.entity.AlphaSalmoranEntity;
import net.mcreator.distantworlds.DistantWorldsMod;

import java.util.List;
import java.util.Comparator;

public class HelystBellRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 40);
		} else {
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.OFF_HAND, true);
		}
		if (!world.isClientSide()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && (!entityiterator.isPassenger() || entity.isShiftKeyDown())
							&& (entityiterator instanceof AlphaSalmoranEntity && (entityiterator instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Behavior) : 0) != 0
									|| entityiterator instanceof SalmoranEntity && (entityiterator instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_Behavior) : 0) != 0)) {
						if (entity.isShiftKeyDown()) {
							entityiterator.stopRiding();
						}
						if (!entityiterator.isPassenger()) {
							entityiterator.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())));
						}
						if (entityiterator instanceof AlphaSalmoranEntity) {
							if (entityiterator instanceof AlphaSalmoranEntity _datEntSetI)
								_datEntSetI.getEntityData().set(AlphaSalmoranEntity.DATA_Behavior, 0);
						} else if (entityiterator instanceof SalmoranEntity) {
							if (entityiterator instanceof SalmoranEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SalmoranEntity.DATA_Behavior, 0);
						}
					}
				}
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.bell")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.bell")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		DistantWorldsMod.queueServerWork(5, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.chime")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.chime")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		});
	}
}
