package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.enchantment.Enchantments;

import net.mcreator.distantworlds.init.DistantWorldsModEntities;
import net.mcreator.distantworlds.entity.BabySalmoranEntity;

public class WiltumCrateRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((itemstack.getOrCreateTag().getString("Contains")).equals("salmoran")) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = DistantWorldsModEntities.BABY_SALMORAN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.TRIGGERED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					if (entityToSpawn instanceof LivingEntity _entity)
						_entity.setHealth((float) itemstack.getOrCreateTag().getDouble("Health"));
					if (entityToSpawn instanceof TamableAnimal _toTame && entity instanceof Player _owner)
						_toTame.tame(_owner);
					if (!(itemstack.getOrCreateTag().getString("Name")).equals(Component.translatable("entity.distant_worlds.baby_salmoran").getString())) {
						entityToSpawn.setCustomName(Component.literal((itemstack.getOrCreateTag().getString("Name"))));
					}
					if (entityToSpawn instanceof BabySalmoranEntity _datEntSetI)
						_datEntSetI.getEntityData().set(BabySalmoranEntity.DATA_Behavior, (int) itemstack.getOrCreateTag().getDouble("Behavior"));
					if (entityToSpawn instanceof BabySalmoranEntity _datEntSetI)
						_datEntSetI.getEntityData().set(BabySalmoranEntity.DATA_Age, (int) itemstack.getOrCreateTag().getDouble("Age"));
					itemstack.removeTagKey("Contains");
					itemstack.removeTagKey("Health");
					itemstack.removeTagKey("Name");
					itemstack.removeTagKey("Behavior");
					itemstack.removeTagKey("Age");
				}	
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item_frame.remove_item")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item_frame.remove_item")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				if (!world.isClientSide()) {
					if (Math.random() < 1 / (itemstack.getEnchantmentLevel(Enchantments.UNBREAKING) + 1)) {
						{
							ItemStack _ist = itemstack;
							if (_ist.hurt(1, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
				}
			}
		}
	}
}
