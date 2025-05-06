package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.distantworlds.init.DistantWorldsModItems;

public class FironBootsTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Vec3 vec3 = entity.getDeltaMovement();
		if (((world.getBlockState(BlockPos.containing(x, y - 0.125, z))).getBlock() == Blocks.LAVA || (world.getBlockState(BlockPos.containing(x, y - 0.125, z))).getBlock() == Blocks.LAVA) && !entity.isShiftKeyDown() && !(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity)) && !entity.isInLava() && entity.getY() == Math.floor(entity.getY())) {
			entity.setDeltaMovement(vec3.x * 0.9, vec3.y > 0 ? vec3.y : 0, vec3.z * 0.9);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.DRIPPING_LAVA, (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0.2, 0, 0.2, 0);
			if ((Math.abs(vec3.x) > 0.05 || Math.abs(vec3.z) > 0.05) && entity.tickCount % 20 == 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.step")), SoundSource.BLOCKS, (float) 0.3, (float) (0.1 + Math.random() * 0.2));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.step")), SoundSource.BLOCKS, (float) 0.3, (float) (0.1 + Math.random() * 0.2), false);
					}
				}
			}
			if (entity.tickCount % 10 == 0 && !(entity.fireImmune() || (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == DistantWorldsModItems.FIRON_LEGGINGS.get())) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.HOT_FLOOR)), 1);
			}
		}
	}
}
