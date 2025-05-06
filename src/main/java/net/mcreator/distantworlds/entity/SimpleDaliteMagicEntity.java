
package net.mcreator.distantworlds.entity;

import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.particles.SimpleParticleType;
import net.mcreator.distantworlds.init.DistantWorldsModParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;

import net.mcreator.distantworlds.init.DistantWorldsModParticleTypes;
import net.mcreator.distantworlds.entity.SimpleDaliteMagicEntity;


import net.mcreator.distantworlds.procedures.SimpleDaliteMagicWhileProjectileFlyingTickProcedure;
import net.mcreator.distantworlds.procedures.SimpleDaliteMagicProjectileHitsLivingEntityProcedure;
import net.mcreator.distantworlds.init.DistantWorldsModEntities;
import net.minecraft.world.item.enchantment.ThornsEnchantment;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class SimpleDaliteMagicEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = ItemStack.EMPTY;
	public static final EntityDataAccessor<Float> DATA_PowerBonus = SynchedEntityData.defineId(SimpleDaliteMagicEntity.class, EntityDataSerializers.FLOAT);
	public static final EntityDataAccessor<Float> DATA_DistanceBonus = SynchedEntityData.defineId(SimpleDaliteMagicEntity.class, EntityDataSerializers.FLOAT);
	public static final EntityDataAccessor<Float> DATA_DistanceBonusStep = SynchedEntityData.defineId(SimpleDaliteMagicEntity.class, EntityDataSerializers.FLOAT);

	//-----------------------------------------------------------------
	// Synched Data
   @Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_PowerBonus, 0f);
		this.entityData.define(DATA_DistanceBonus, 0f);
		this.entityData.define(DATA_DistanceBonusStep, 0.01f);
	}

	// Set Additional Data
	public void setPowerBonus(float powerBonus) {
		this.getEntityData().set(this.DATA_PowerBonus, powerBonus);
	}
	public void setDistanceBonus(float distanceBonus) {
		this.getEntityData().set(this.DATA_DistanceBonus, distanceBonus);
	}
	public void setDistanceBonusStep(float distanceBonusStep) {
		this.getEntityData().set(this.DATA_DistanceBonusStep, distanceBonusStep);
	}

	// Get Additional Data
	public float getPowerBonus() {
		return this.getEntityData().get(this.DATA_PowerBonus);
	}
	public float getDistanceBonus() {
		return this.getEntityData().get(this.DATA_DistanceBonus);
	}
	public float getDistanceBonusStep() {
		return this.getEntityData().get(this.DATA_DistanceBonusStep);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putFloat("DataPowerBonus", this.entityData.get(DATA_PowerBonus));
		compound.putFloat("DataDistanceBonus", this.entityData.get(DATA_DistanceBonus));
		compound.putFloat("DataDistanceBonusStep", this.entityData.get(DATA_DistanceBonusStep));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("DataPowerBonus"))
			this.entityData.set(DATA_PowerBonus, compound.getFloat("DataPowerBonus"));
		if (compound.contains("DataDistanceBonus"))
			this.entityData.set(DATA_DistanceBonus, compound.getFloat("DataDistanceBonus"));
		if (compound.contains("DataDistanceBonusStep"))
			this.entityData.set(DATA_DistanceBonus, compound.getFloat("DataDistanceBonusStep"));
	}
	//-----------------------------------------------------------------
	
	protected float getWaterInertia() {
      return 1.0F;
   }

   protected float getAirInertia() {
      return 0.95F;
   }

   protected boolean tryPickup(Player player) {
      return false;
   }
   
	public SimpleDaliteMagicEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(DistantWorldsModEntities.SIMPLE_DALITE_MAGIC.get(), world);
	}

	public SimpleDaliteMagicEntity(EntityType<? extends SimpleDaliteMagicEntity> type, Level world) {
		super(type, world);
	}

	public SimpleDaliteMagicEntity(EntityType<? extends SimpleDaliteMagicEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public SimpleDaliteMagicEntity(EntityType<? extends SimpleDaliteMagicEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		//entity.setArrowCount(entity.getArrowCount() - 1);
	}

	// When hitting entity
	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		SimpleDaliteMagicProjectileHitsLivingEntityProcedure.execute(this.level(), entityHitResult.getEntity(), this, this.getOwner());
	}
	
	@Override
	public void tick() {
		Level world = this.level();
		super.tick();
		++this.tickCount;
		Vec3 vec3 = this.getDeltaMovement();
		if (this.tickCount >= 40 || this.inGround || (Math.abs(vec3.x) + Math.abs(vec3.y) + Math.abs(vec3.z)) < 0.25) {
			if (world instanceof ServerLevel _level) {
        		_level.sendParticles(DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get(), this.getX(), this.getY(), this.getZ(), Mth.nextInt(RandomSource.create(), 3, 5), 0.2, 0.2, 0.2, 0.05);
        		_level.sendParticles(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), Mth.nextInt(RandomSource.create(), 3, 5), 0.2, 0.2, 0.2, 0.05);
			}
			this.discard();
      	}

      	if (this.getDistanceBonus() > 0) {
      		this.setDistanceBonus(this.getDistanceBonus() + this.getDistanceBonusStep());
      	}

      	this.setNoGravity(true);
		this.setDeltaMovement(vec3.x * getAirInertia(), vec3.y * getAirInertia(), vec3.z * getAirInertia());

		world.addParticle((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_SPARK_PARTICLE.get()), (this.getX()), (this.getY()), (this.getZ()), (vec3.x * 0.95F) / 23, (vec3.y * 0.95F) / 23, (vec3.z * 0.95F) / 23);
		world.addParticle((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_SPARK_LARGE_PARTICLE.get()), (this.getX()), (this.getY()), (this.getZ()), vec3.x * 0.95F, vec3.y * 0.95F, vec3.z * 0.95F);
	}

	public static SimpleDaliteMagicEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 1f, 5, 5);
	}

	public static SimpleDaliteMagicEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		SimpleDaliteMagicEntity entityarrow = new SimpleDaliteMagicEntity(DistantWorldsModEntities.SIMPLE_DALITE_MAGIC.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		return entityarrow;
	}

	public static SimpleDaliteMagicEntity shoot(LivingEntity entity, LivingEntity target) {
		SimpleDaliteMagicEntity entityarrow = new SimpleDaliteMagicEntity(DistantWorldsModEntities.SIMPLE_DALITE_MAGIC.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(5);
		entityarrow.setKnockback(5);
		entityarrow.setCritArrow(false);
		entity.level().addFreshEntity(entityarrow);
		return entityarrow;
	}
}