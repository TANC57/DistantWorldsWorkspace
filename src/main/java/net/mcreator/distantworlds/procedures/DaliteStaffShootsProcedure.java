package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;
import net.mcreator.distantworlds.init.DistantWorldsModEntities;
import net.mcreator.distantworlds.init.DistantWorldsModEnchantments;
import net.mcreator.distantworlds.entity.SimpleDaliteMagicEntity;
import net.mcreator.distantworlds.entity.BabyNoarhornEntity;


public class DaliteStaffShootsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null) {
			return;
		}
		double 	withUsagePrice = 50,
				UsagePriceStep = 0.4,
		
				withPowerBonus = 0,
				powerBonusStep = 0.5,
				
				withDistanceBonus = 0,
				distanceBonusStep = 0.03,
				
				withDistanceBonusStep = 0,
				
				withCooldown = 10,
				CooldownStep = 0.3;

		int 	CrystalFacetingLevel = 0, 
				OversaturationLevel = 0;
		
		if (!world.isClientSide()) {
			if (!(entity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem()))) {
				
				CrystalFacetingLevel = itemstack.getEnchantmentLevel(DistantWorldsModEnchantments.CRYSTAL_FACETING.get());
				OversaturationLevel = itemstack.getEnchantmentLevel(DistantWorldsModEnchantments.OVERSATURATION.get());
			
				withUsagePrice = withUsagePrice + Math.round(withUsagePrice * (CrystalFacetingLevel * UsagePriceStep));
				
				withPowerBonus = CrystalFacetingLevel * powerBonusStep;
				withDistanceBonus = OversaturationLevel * distanceBonusStep;
				withDistanceBonusStep = withDistanceBonus;
				withCooldown = withCooldown * (1 + (OversaturationLevel * CooldownStep));
				
				if (ReturnDaliteEnergyCurioProcedure.execute(world, entity) >= withUsagePrice
						+ (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft
						|| (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), (int) withCooldown);
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing, float powerBonus, float distanceBonus, float distanceBonusStep) {
									AbstractArrow entityToSpawn = new SimpleDaliteMagicEntity(DistantWorldsModEntities.SIMPLE_DALITE_MAGIC.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setPierceLevel(piercing);

									if (entityToSpawn instanceof SimpleDaliteMagicEntity datEnt) {
										datEnt.setPowerBonus(powerBonus);
										datEnt.setDistanceBonus(distanceBonus);
										datEnt.setDistanceBonusStep(distanceBonusStep);
									}
									
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) 4, (int) 0, (byte) 2, (float) withPowerBonus, (float) withDistanceBonus, (float) withDistanceBonusStep);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, (_shootFrom.getLookAngle().y) + 0.03, _shootFrom.getLookAngle().z, (float) 1.6, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (!world.isClientSide() && !(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
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
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.fall")), SoundSource.PLAYERS, (float) 0.85, (float) (1.4 + Math.random() * 0.2));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.fall")), SoundSource.PLAYERS, (float) 0.85, (float) (1.4 + Math.random() * 0.2), false);
						}

						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("minecraft:entity.player.attack.sweep")), SoundSource.PLAYERS, (float) 0.3, (float) (1.2 + Math.random() * 0.2));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("minecraft:entity.player.attack.sweep")), SoundSource.PLAYERS, (float) 0.3, (float) (1.2 + Math.random() * 0.2), false);
						}
					}
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						{
							double _setval = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft + withUsagePrice;
							entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RequiredDaliteEnergyLeft = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
	}
}
