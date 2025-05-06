
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
import net.mcreator.distantworlds.procedures.SalmoranRightClickedOnEntityProcedure;
import net.mcreator.distantworlds.procedures.SalmoranOnEntityTickUpdateProcedure;
import net.mcreator.distantworlds.procedures.SalmoranNaturalEntitySpawningConditionProcedure;
import net.mcreator.distantworlds.procedures.SalmoranEntityIsHurtProcedure;
import net.mcreator.distantworlds.procedures.SalmoranEntityDiesProcedure;
import net.mcreator.distantworlds.procedures.SalmoranAttackAdditionalConditionProcedure;
import net.mcreator.distantworlds.procedures.NotSittingAdditionalConditionProcedure;
import net.mcreator.distantworlds.procedures.FollowAdditionalConditionProcedure;
import net.mcreator.distantworlds.procedures.LookAroundAdditionalConditionProcedure;
import net.mcreator.distantworlds.init.DistantWorldsModEntities;
import net.mcreator.distantworlds.init.DistantWorldsModMobEffects;

import java.util.List;
import java.util.EnumSet;

public class SalmoranEntity extends TamableAnimal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SalmoranEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SalmoranEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SalmoranEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_Irritated = SynchedEntityData.defineId(SalmoranEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Behavior = SynchedEntityData.defineId(SalmoranEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_InLove = SynchedEntityData.defineId(SalmoranEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_BabyAge = SynchedEntityData.defineId(SalmoranEntity.class, EntityDataSerializers.INT);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public SalmoranEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(DistantWorldsModEntities.SALMORAN.get(), world);
	}

	public SalmoranEntity(EntityType<SalmoranEntity> type, Level world) {
		super(type, world);
		xpReward = 7;
		setNoAi(false);
		this.moveControl = new FlyingMoveControl(this, 5, true);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "salmoran");
		this.entityData.define(DATA_Irritated, 0);
		this.entityData.define(DATA_Behavior, 0);
		this.entityData.define(DATA_InLove, 0);
		this.entityData.define(DATA_BabyAge, 0);
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
		double x = SalmoranEntity.this.getX();
		double y = SalmoranEntity.this.getY();
		double z = SalmoranEntity.this.getZ();
		Entity entity = SalmoranEntity.this;
		Level world = SalmoranEntity.this.level();
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
		this.goalSelector.addGoal(5, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
				if (SalmoranEntity.this.getTarget() != null && (!SalmoranEntity.this.getTarget().hasEffect(DistantWorldsModMobEffects.SUPERVISION.get()) || SalmoranEntity.this.getEntityData().get(SalmoranEntity.DATA_Irritated) > 0) && !SalmoranEntity.this.getMoveControl().hasWanted()) {
					return NotSittingAdditionalConditionProcedure.execute(entity);
				} else {
					return false;
				}
			}

			@Override
			public boolean canContinueToUse() {
				return NotSittingAdditionalConditionProcedure.execute(entity) && SalmoranEntity.this.getMoveControl().hasWanted() && SalmoranEntity.this.getTarget() != null && (!SalmoranEntity.this.getTarget().hasEffect(DistantWorldsModMobEffects.SUPERVISION.get()) || SalmoranEntity.this.getEntityData().get(SalmoranEntity.DATA_Irritated) > 0) && SalmoranEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = SalmoranEntity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				SalmoranEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 8);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = SalmoranEntity.this.getTarget();
				if (SalmoranEntity.this.distanceToSqr(livingentity) < 5) {
					SalmoranEntity.this.doHurtTarget(livingentity);
					SalmoranEntity.this.setAnimation("attack");
				} else {
					double d0 = SalmoranEntity.this.distanceToSqr(livingentity);
					if (d0 < 64) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						SalmoranEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 8);
					}
				}
			}
		});
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, Player.class, false, false) {
			@Override
			public boolean canUse() {
				return super.canUse() && SalmoranAttackAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && SalmoranAttackAdditionalConditionProcedure.execute(entity);
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
		this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = SalmoranEntity.this.getRandom();
				double dir_x = SalmoranEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = SalmoranEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = SalmoranEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
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
				return super.canContinueToUse() && LookAroundAdditionalConditionProcedure.execute(entity);
			}
		});
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.guardian.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.guardian.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.guardian.death"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		SalmoranEntityIsHurtProcedure.execute(this.getX(), this.getY(), this.getZ(), this);
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		SalmoranEntityDiesProcedure.execute(this.level(), this, source.getEntity());
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putInt("DataIrritated", this.entityData.get(DATA_Irritated));
		compound.putInt("DataBehavior", this.entityData.get(DATA_Behavior));
		compound.putInt("DataInLove", this.entityData.get(DATA_InLove));
		compound.putInt("DataBabyAge", this.entityData.get(DATA_BabyAge));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("DataIrritated"))
			this.entityData.set(DATA_Irritated, compound.getInt("DataIrritated"));
		if (compound.contains("DataBehavior"))
			this.entityData.set(DATA_Behavior, compound.getInt("DataBehavior"));
		if (compound.contains("DataInLove"))
			this.entityData.set(DATA_InLove, compound.getInt("DataInLove"));
		if (compound.contains("DataBabyAge"))
			this.entityData.set(DATA_BabyAge, compound.getInt("DataBabyAge"));
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

		SalmoranRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity, itemstack);
		return InteractionResult.sidedSuccess(this.level().isClientSide);
		//return InteractionResult.SUCCESS;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		SalmoranOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		SalmoranEntity retval = DistantWorldsModEntities.SALMORAN.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of().contains(stack.getItem());
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
		SpawnPlacements.register(DistantWorldsModEntities.SALMORAN.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return SalmoranNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 30);
		builder = builder.add(Attributes.ARMOR, 4);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 5);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.2);
		builder = builder.add(Attributes.FLYING_SPEED, 2.5);
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
			this.remove(SalmoranEntity.RemovalReason.KILLED);
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
	public int getMaxHeadYRot() {
      return 30;
   }
}
