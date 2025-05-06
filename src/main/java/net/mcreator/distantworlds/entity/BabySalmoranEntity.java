
package net.mcreator.distantworlds.entity;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.distantworlds.procedures.WanderAdditionalConditionProcedure;
import net.mcreator.distantworlds.procedures.LookAroundAdditionalConditionProcedure;
import net.mcreator.distantworlds.procedures.EntityIsHurtBehaviorProcedure;
import net.mcreator.distantworlds.procedures.BabySalmoranRightClickedOnEntityProcedure;
import net.mcreator.distantworlds.procedures.BabySalmoranOnInitialEntitySpawnProcedure;
import net.mcreator.distantworlds.procedures.BabySalmoranOnEntityTickUpdateProcedure;
import net.mcreator.distantworlds.procedures.BabySalmoranNaturalEntitySpawningConditionProcedure;
import net.mcreator.distantworlds.procedures.BabySalmoranEntityDiesProcedure;
import net.mcreator.distantworlds.procedures.AttackAdditionalConditionProcedure;
import net.mcreator.distantworlds.init.DistantWorldsModEntities;

import javax.annotation.Nullable;

import java.util.List;

public class BabySalmoranEntity extends TamableAnimal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(BabySalmoranEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(BabySalmoranEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(BabySalmoranEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_Behavior = SynchedEntityData.defineId(BabySalmoranEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Age = SynchedEntityData.defineId(BabySalmoranEntity.class, EntityDataSerializers.INT);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public BabySalmoranEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(DistantWorldsModEntities.BABY_SALMORAN.get(), world);
	}

	public BabySalmoranEntity(EntityType<BabySalmoranEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "baby_salmoran");
		this.entityData.define(DATA_Behavior, 0);
		this.entityData.define(DATA_Age, 0);
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new LeapAtTargetGoal(this, (float) 0.5) {
			@Override
			public boolean canUse() {
				double x = BabySalmoranEntity.this.getX();
				double y = BabySalmoranEntity.this.getY();
				double z = BabySalmoranEntity.this.getZ();
				Entity entity = BabySalmoranEntity.this;
				Level world = BabySalmoranEntity.this.level();
				return super.canUse() && AttackAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = BabySalmoranEntity.this.getX();
				double y = BabySalmoranEntity.this.getY();
				double z = BabySalmoranEntity.this.getZ();
				Entity entity = BabySalmoranEntity.this;
				Level world = BabySalmoranEntity.this.level();
				return super.canContinueToUse() && AttackAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = BabySalmoranEntity.this.getX();
				double y = BabySalmoranEntity.this.getY();
				double z = BabySalmoranEntity.this.getZ();
				Entity entity = BabySalmoranEntity.this;
				Level world = BabySalmoranEntity.this.level();
				return super.canUse() && LookAroundAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = BabySalmoranEntity.this.getX();
				double y = BabySalmoranEntity.this.getY();
				double z = BabySalmoranEntity.this.getZ();
				Entity entity = BabySalmoranEntity.this;
				Level world = BabySalmoranEntity.this.level();
				return super.canContinueToUse() && LookAroundAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(3, new FloatGoal(this));
		this.targetSelector.addGoal(4, new HurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = BabySalmoranEntity.this.getX();
				double y = BabySalmoranEntity.this.getY();
				double z = BabySalmoranEntity.this.getZ();
				Entity entity = BabySalmoranEntity.this;
				Level world = BabySalmoranEntity.this.level();
				return super.canUse() && AttackAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = BabySalmoranEntity.this.getX();
				double y = BabySalmoranEntity.this.getY();
				double z = BabySalmoranEntity.this.getZ();
				Entity entity = BabySalmoranEntity.this;
				Level world = BabySalmoranEntity.this.level();
				return super.canContinueToUse() && AttackAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}

			@Override
			public boolean canUse() {
				double x = BabySalmoranEntity.this.getX();
				double y = BabySalmoranEntity.this.getY();
				double z = BabySalmoranEntity.this.getZ();
				Entity entity = BabySalmoranEntity.this;
				Level world = BabySalmoranEntity.this.level();
				return super.canUse() && AttackAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = BabySalmoranEntity.this.getX();
				double y = BabySalmoranEntity.this.getY();
				double z = BabySalmoranEntity.this.getZ();
				Entity entity = BabySalmoranEntity.this;
				Level world = BabySalmoranEntity.this.level();
				return super.canContinueToUse() && AttackAdditionalConditionProcedure.execute(entity);
			}

		});
		this.goalSelector.addGoal(6, new RandomSwimmingGoal(this, 1, 40) {
			@Override
			public boolean canUse() {
				double x = BabySalmoranEntity.this.getX();
				double y = BabySalmoranEntity.this.getY();
				double z = BabySalmoranEntity.this.getZ();
				Entity entity = BabySalmoranEntity.this;
				Level world = BabySalmoranEntity.this.level();
				return super.canUse() && WanderAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = BabySalmoranEntity.this.getX();
				double y = BabySalmoranEntity.this.getY();
				double z = BabySalmoranEntity.this.getZ();
				Entity entity = BabySalmoranEntity.this;
				Level world = BabySalmoranEntity.this.level();
				return super.canContinueToUse() && WanderAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 0.8) {
			@Override
			public boolean canUse() {
				double x = BabySalmoranEntity.this.getX();
				double y = BabySalmoranEntity.this.getY();
				double z = BabySalmoranEntity.this.getZ();
				Entity entity = BabySalmoranEntity.this;
				Level world = BabySalmoranEntity.this.level();
				return super.canUse() && WanderAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = BabySalmoranEntity.this.getX();
				double y = BabySalmoranEntity.this.getY();
				double z = BabySalmoranEntity.this.getZ();
				Entity entity = BabySalmoranEntity.this;
				Level world = BabySalmoranEntity.this.level();
				return super.canContinueToUse() && WanderAdditionalConditionProcedure.execute(entity);
			}
		});
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.glow_squid.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.glow_squid.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.glow_squid.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		EntityIsHurtBehaviorProcedure.execute(this);
		if (source.is(DamageTypes.FALL))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		BabySalmoranEntityDiesProcedure.execute(this.level(), this, source.getEntity());
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		BabySalmoranOnInitialEntitySpawnProcedure.execute(world, this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putInt("DataBehavior", this.entityData.get(DATA_Behavior));
		compound.putInt("DataAge", this.entityData.get(DATA_Age));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("DataBehavior"))
			this.entityData.set(DATA_Behavior, compound.getInt("DataBehavior"));
		if (compound.contains("DataAge"))
			this.entityData.set(DATA_Age, compound.getInt("DataAge"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			retval = super.mobInteract(sourceentity, hand);
		} else if (this.level().isClientSide()) {
			retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack)) ? InteractionResult.sidedSuccess(this.level().isClientSide()) : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isOwnedBy(sourceentity)) {
					if (item.isEdible() && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal((float) item.getFoodProperties().getNutrition());
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal(4);
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else {
						retval = super.mobInteract(sourceentity, hand);
					}
				}
			} else if (this.isFood(itemstack)) {
				this.usePlayerItem(sourceentity, hand, itemstack);
				if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
					this.tame(sourceentity);
					this.level().broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level().broadcastEntityEvent(this, (byte) 6);
				}
				this.setPersistenceRequired();
				retval = InteractionResult.sidedSuccess(this.level().isClientSide());
			} else {
				retval = super.mobInteract(sourceentity, hand);
				if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
					this.setPersistenceRequired();
			}
		}
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		BabySalmoranRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity, itemstack);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		BabySalmoranOnEntityTickUpdateProcedure.execute(this.level(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		BabySalmoranEntity retval = DistantWorldsModEntities.BABY_SALMORAN.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of().contains(stack.getItem());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
	}

	public static void init() {
		SpawnPlacements.register(DistantWorldsModEntities.BABY_SALMORAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return BabySalmoranNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 1);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 2);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) && this.onGround()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("running"));
			}
			if (!this.onGround()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("flying"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
		}
		return PlayState.STOP;
	}

	private PlayState procedurePredicate(AnimationState event) {
		if (!animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				this.animationprocedure = "empty";
				event.getController().forceAnimationReset();
			}
		} else if (animationprocedure.equals("empty")) {
			return PlayState.STOP;
		}
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(BabySalmoranEntity.RemovalReason.KILLED);
			this.dropExperience();
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
