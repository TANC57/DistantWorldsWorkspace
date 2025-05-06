package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.DistantWorldsMod;

public class FironMultitoolRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown() && !(entity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem()))
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (itemstack.getMaxDamage() - itemstack.getDamageValue() >= 5) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					for (int index0 = 0; index0 < 5; index0++) {
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
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 250);
				} else {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 15);
				}
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getFireball(Level level, Entity shooter, double ax, double ay, double az) {
								AbstractHurtingProjectile entityToSpawn = new SmallFireball(EntityType.SMALL_FIREBALL, level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.xPower = ax;
								entityToSpawn.yPower = ay;
								entityToSpawn.zPower = az;
								return entityToSpawn;
							}
						}.getFireball(projectileLevel, entity, (entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z));
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 3);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.PLAYERS, 1,
								(float) (0.8 + Math.random() * 0.4));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.PLAYERS, 1, (float) (0.8 + Math.random() * 0.4), false);
					}
				}
				for (int index1 = 0; index1 < 4; index1++) {
					world.addParticle(ParticleTypes.FLAME, (entity.getX()), (entity.getY() + entity.getEyeHeight()), (entity.getZ()), (entity.getLookAngle().x + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01),
							(entity.getLookAngle().y + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01), (entity.getLookAngle().z + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01));
				}
				for (int index2 = 0; index2 < 2; index2++) {
					world.addParticle(ParticleTypes.SMALL_FLAME, (entity.getX()), (entity.getY() + entity.getEyeHeight()), (entity.getZ()), (entity.getLookAngle().x + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01),
							(entity.getLookAngle().y + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01), (entity.getLookAngle().z + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01));
				}
				DistantWorldsMod.queueServerWork(5, () -> {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level();
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getFireball(Level level, Entity shooter, double ax, double ay, double az) {
										AbstractHurtingProjectile entityToSpawn = new SmallFireball(EntityType.SMALL_FIREBALL, level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.xPower = ax;
										entityToSpawn.yPower = ay;
										entityToSpawn.zPower = az;
										return entityToSpawn;
									}
								}.getFireball(projectileLevel, entity, (entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z));
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 3);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.PLAYERS, 1,
										(float) (0.8 + Math.random() * 0.4));
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.PLAYERS, 1, (float) (0.8 + Math.random() * 0.4),
										false);
							}
						}
						for (int index3 = 0; index3 < 6; index3++) {
							world.addParticle(ParticleTypes.FLAME, (entity.getX()), (entity.getY() + entity.getEyeHeight()), (entity.getZ()), (entity.getLookAngle().x + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01),
									(entity.getLookAngle().y + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01), (entity.getLookAngle().z + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01));
						}
						for (int index4 = 0; index4 < 4; index4++) {
							world.addParticle(ParticleTypes.SMALL_FLAME, (entity.getX()), (entity.getY() + entity.getEyeHeight()), (entity.getZ()), (entity.getLookAngle().x + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01),
									(entity.getLookAngle().y + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01), (entity.getLookAngle().z + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01));
						}
						DistantWorldsMod.queueServerWork(5, () -> {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								{
									Entity _shootFrom = entity;
									Level projectileLevel = _shootFrom.level();
									if (!projectileLevel.isClientSide()) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getFireball(Level level, Entity shooter, double ax, double ay, double az) {
												AbstractHurtingProjectile entityToSpawn = new SmallFireball(EntityType.SMALL_FIREBALL, level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.xPower = ax;
												entityToSpawn.yPower = ay;
												entityToSpawn.zPower = az;
												return entityToSpawn;
											}
										}.getFireball(projectileLevel, entity, (entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z));
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 3);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.PLAYERS, 1,
												(float) (0.8 + Math.random() * 0.4));
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.PLAYERS, 1,
												(float) (0.8 + Math.random() * 0.4), false);
									}
								}
								for (int index5 = 0; index5 < 8; index5++) {
									world.addParticle(ParticleTypes.FLAME, (entity.getX()), (entity.getY() + entity.getEyeHeight()), (entity.getZ()), (entity.getLookAngle().x + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01),
											(entity.getLookAngle().y + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01), (entity.getLookAngle().z + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01));
								}
								for (int index6 = 0; index6 < 6; index6++) {
									world.addParticle(ParticleTypes.SMALL_FLAME, (entity.getX()), (entity.getY() + entity.getEyeHeight()), (entity.getZ()), (entity.getLookAngle().x + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01),
											(entity.getLookAngle().y + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01), (entity.getLookAngle().z + (-10 + Mth.nextInt(RandomSource.create(), 0, 20)) * 0.01));
								}
							} else {
								return;
							}
						});
					} else {
						return;
					}
				});
			}
		}
	}
}
