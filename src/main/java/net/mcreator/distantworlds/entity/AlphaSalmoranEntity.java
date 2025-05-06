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

import javax.annotation.Nullable;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.procedures.WanderAdditionalConditionProcedure;
import net.mcreator.distantworlds.procedures.SalmoranAttackAdditionalConditionProcedure;
import net.mcreator.distantworlds.procedures.NotSittingAdditionalConditionProcedure;
import net.mcreator.distantworlds.procedures.FollowAdditionalConditionProcedure;
import net.mcreator.distantworlds.procedures.LookAroundAdditionalConditionProcedure;
import net.mcreator.distantworlds.procedures.EntityIsHurtBehaviorProcedure;
import net.mcreator.distantworlds.procedures.AlphaSalmoranRightClickedOnEntityProcedure;
import net.mcreator.distantworlds.procedures.AlphaSalmoranOnEntityTickUpdateProcedure;
import net.mcreator.distantworlds.procedures.AlphaSalmoranNaturalEntitySpawningConditionProcedure;
import net.mcreator.distantworlds.procedures.AlphaSalmoranEntityDiesProcedure;
import net.mcreator.distantworlds.init.DistantWorldsModEntities;

import java.util.List;
import java.util.EnumSet;

public class AlphaSalmoranEntity extends TamableAnimal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(AlphaSalmoranEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(AlphaSalmoranEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(AlphaSalmoranEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_Behavior = SynchedEntityData.defineId(AlphaSalmoranEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_InLove = SynchedEntityData.defineId(AlphaSalmoranEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Stamina = SynchedEntityData.defineId(AlphaSalmoranEntity.class, EntityDataSerializers.INT);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public AlphaSalmoranEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(DistantWorldsModEntities.ALPHA_SALMORAN.get(), world);
	}

	public AlphaSalmoranEntity(EntityType<AlphaSalmoranEntity> type, Level world) {
		super(type, world);
		xpReward = 10;
		setNoAi(false);
		this.moveControl = new FlyingMoveControl(this, 5, true);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "alpha_salmoran");
		this.entityData.define(DATA_Behavior, 0);
		this.entityData.define(DATA_InLove, 0);
		this.entityData.define(DATA_Stamina, 0);
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
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		double x = AlphaSalmoranEntity.this.getX();
		double y = AlphaSalmoranEntity.this.getY();
		double z = AlphaSalmoranEntity.this.getZ();
		Entity entity = AlphaSalmoranEntity.this;
		Level world = AlphaSalmoranEntity.this.level();
		super.registerGoals();
		this.targetSelector.addGoal(1, new OwnerHurtTargetGoal(this) {
			@Override
			public boolean canUse() {
				return super.canUse() && FollowAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && FollowAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1, (float) 6, (float) 12, false) {
			@Override
			public boolean canUse() {
				return super.canUse() && FollowAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && FollowAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(3, new OwnerHurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				return super.canUse() && FollowAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && FollowAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				return super.canUse() && LookAroundAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && LookAroundAdditionalConditionProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, false, false) {
			@Override
			public boolean canUse() {
				return super.canUse() && SalmoranAttackAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && SalmoranAttackAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(6, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
				if (AlphaSalmoranEntity.this.getTarget() != null && !AlphaSalmoranEntity.this.getMoveControl().hasWanted()) {
					return NotSittingAdditionalConditionProcedure.execute(entity);
				} else {
					return false;
				}
			}

			@Override
			public boolean canContinueToUse() {
				return NotSittingAdditionalConditionProcedure.execute(entity) && AlphaSalmoranEntity.this.getMoveControl().hasWanted() && AlphaSalmoranEntity.this.getTarget() != null && AlphaSalmoranEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = AlphaSalmoranEntity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				AlphaSalmoranEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 0.1);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = AlphaSalmoranEntity.this.getTarget();
				if (AlphaSalmoranEntity.this.distanceToSqr(livingentity) < 6) {
					AlphaSalmoranEntity.this.doHurtTarget(livingentity);
					AlphaSalmoranEntity.this.setAnimation("attack");
				} else {
					double d0 = AlphaSalmoranEntity.this.distanceToSqr(livingentity);
					if (d0 < 64) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						AlphaSalmoranEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 0.1);
					}
				}
			}
		});
		this.targetSelector.addGoal(7, new HurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				return super.canUse() && SalmoranAttackAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && SalmoranAttackAdditionalConditionProcedure.execute(entity);
			}
		}.setAlertOthers());
		this.goalSelector.addGoal(8, new RandomStrollGoal(this, 4, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = AlphaSalmoranEntity.this.getRandom();
				double dir_x = AlphaSalmoranEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = AlphaSalmoranEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = AlphaSalmoranEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}

			@Override
			public boolean canUse() {
				return super.canUse() && WanderAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && WanderAdditionalConditionProcedure.execute(entity);
			}

		});
		this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, LivingEntity.class, (float) 4) {
			@Override
			public boolean canUse() {
				return super.canUse() && WanderAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && WanderAdditionalConditionProcedure.execute(entity);
			}
		});
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public double getPassengersRidingOffset() {
		return super.getPassengersRidingOffset() + 0.5;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.death_land"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		EntityIsHurtBehaviorProcedure.execute(this);
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		AlphaSalmoranEntityDiesProcedure.execute(this.level(), this, source.getEntity());
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putInt("DataBehavior", this.entityData.get(DATA_Behavior));
		compound.putInt("DataInLove", this.entityData.get(DATA_InLove));
		compound.putInt("DataStamina", this.entityData.get(DATA_Stamina));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("DataBehavior"))
			this.entityData.set(DATA_Behavior, compound.getInt("DataBehavior"));
		if (compound.contains("DataInLove"))
			this.entityData.set(DATA_InLove, compound.getInt("DataInLove"));
		if (compound.contains("DataStamina"))
			this.entityData.set(DATA_Stamina, compound.getInt("DataStamina"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		Item item = itemstack.getItem();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		if (this.isOwnedBy(sourceentity)) {
			if (sourceentity.isShiftKeyDown()) {
				AlphaSalmoranRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity, itemstack);
				//return InteractionResult.SUCCESS;
				return InteractionResult.sidedSuccess(this.level().isClientSide);
			} else {
				sourceentity.startRiding(this);
				return InteractionResult.PASS;
			}
		} else {
			AlphaSalmoranRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity, itemstack);
			//return InteractionResult.SUCCESS;
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		}
	}

	@Override
	public void baseTick() {
		super.baseTick();
		AlphaSalmoranOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		if (this.isVehicle()) {
			if (this.getPersistentData().getDouble("FlyBoost") > 0) {
				this.setDeltaMovement(this.getDeltaMovement().add(0, (double) (this.getPersistentData().getDouble("FlyBoost")), 0));
				this.getPersistentData().putDouble("FlyBoost", 0);
			} else {
				this.setDeltaMovement(this.getDeltaMovement().add(0, (double) (this.getPassengers().size() * -0.03F), 0));
			}
		}
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		AlphaSalmoranEntity retval = DistantWorldsModEntities.ALPHA_SALMORAN.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of().contains(stack.getItem());
	}

	@Override
	public void travel(Vec3 dir) {
		Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
		if (this.isVehicle()) {
			this.setYRot(entity.getYRot());
			this.yRotO = this.getYRot();
			this.setXRot(entity.getXRot() * 0.5F);
			this.setRot(this.getYRot(), this.getXRot());
			this.yBodyRot = entity.getYRot();
			this.yHeadRot = entity.getYRot();
			this.setMaxUpStep(1.0F);
			if (entity instanceof LivingEntity passenger) {
				this.setSpeed((float) (this.onGround() ? 0.075 : 0.5F));
				float forward = passenger.zza < 0 ? passenger.zza * 0.25F : passenger.zza;
				float strafe = passenger.xxa * 0.5F;
				super.travel(new Vec3(strafe, 0, forward));
			}
			double d1 = this.getX() - this.xo;
			double d0 = this.getZ() - this.zo;
			float f1 = (float) Math.sqrt(d1 * d1 + d0 * d0) * 4;
			if (f1 > 1.0F)
				f1 = 1.0F;
			this.walkAnimation.setSpeed(this.walkAnimation.speed() + (f1 - this.walkAnimation.speed()) * 0.4F);
			this.walkAnimation.position(this.walkAnimation.position() + this.walkAnimation.speed());
			this.calculateEntityAnimation(true);
			return;
		}
		this.setMaxUpStep(1F);
		super.travel(dir);
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
		this.setNoGravity(true);
	}

	public static void init() {
		SpawnPlacements.register(DistantWorldsModEntities.ALPHA_SALMORAN.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return AlphaSalmoranNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 45);
		builder = builder.add(Attributes.ARMOR, 6);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 7);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.5);
		builder = builder.add(Attributes.FLYING_SPEED, 2);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if (this.isPassenger()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("sitting"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
		}
		return PlayState.STOP;
	}

	private PlayState attackingPredicate(AnimationState event) {
		double d1 = this.getX() - this.xOld;
		double d0 = this.getZ() - this.zOld;
		float velocity = (float) Math.sqrt(d1 * d1 + d0 * d0);
		if (getAttackAnim(event.getPartialTick()) > 0f && !this.swinging) {
			this.swinging = true;
			this.lastSwing = level().getGameTime();
		}
		if (this.swinging && this.lastSwing + 7L <= level().getGameTime()) {
			this.swinging = false;
		}
		if (this.swinging && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
			event.getController().forceAnimationReset();
			return event.setAndContinue(RawAnimation.begin().thenPlay("attack"));
		}
		return PlayState.CONTINUE;
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
			this.remove(AlphaSalmoranEntity.RemovalReason.KILLED);
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
		data.add(new AnimationController<>(this, "attacking", 4, this::attackingPredicate));
		data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
	
	@Override
	protected boolean canAddPassenger(Entity passenger) {
		return this.getPassengers().size() <= 2;
	}
    
    //Prevents the controller from changing if other players right click while another is already riding.
    /*@Override
    public LivingEntity getControllingPassenger() {
        return (LivingEntity)this.getFirstPassenger();
    }*/

    @Nullable
   	public LivingEntity getControllingPassenger() {
      if (!this.getPassengers().isEmpty()) {
         Entity entity = this.getPassengers().get(0);
         if (entity instanceof LivingEntity) {
            return (LivingEntity)entity;
         }
      }
      return null;
   }

    @Override
    protected void positionRider(Entity passenger, Entity.MoveFunction moveFunc) {
        if (this.hasPassenger(passenger)) {
            //X is right to left
            //Y is down and up
            //Z is front to back
            //Passenger 0 offsets
            double p0offX = -0.4F;
            double p0offY = 2.2F;
            double p0offZ = 0F;
            //Passenger 1 offsets
            double p1offX = -1.1F;
            double p1offY = 1.5F;
            double p1offZ = 0F;

            //Reading passenger offsets and applying them
            Vec3 passenger0offset = (new Vec3(p0offX, p0offY, p0offZ)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
            Vec3 passenger1offset = (new Vec3(p1offX, p1offY, p1offZ)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
            int passengerNumber = this.getPassengers().indexOf(passenger);
            if (passengerNumber == 0) {
                moveFunc.accept(passenger, this.getX() + passenger0offset.x, this.getY() + passenger0offset.y, this.getZ() + passenger0offset.z);
            }
            if (passengerNumber == 1) {
                moveFunc.accept(passenger, this.getX() + passenger1offset.x, this.getY() + passenger1offset.y, this.getZ() + passenger1offset.z);
            }
        }
    }

    @Override
	public int getMaxHeadYRot() {
      return 30;
   }
}