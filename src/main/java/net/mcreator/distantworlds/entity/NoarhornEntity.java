
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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
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
import net.mcreator.distantworlds.procedures.NoarhornRightClickedOnEntityProcedure;
import net.mcreator.distantworlds.procedures.NoarhornOnEntityTickUpdateProcedure;
import net.mcreator.distantworlds.procedures.NoarhornKillsAnotherEntityProcedure;
import net.mcreator.distantworlds.procedures.NoarhornNaturalEntitySpawningConditionProcedure;
import net.mcreator.distantworlds.procedures.NoarhornAttackAdditionalConditionProcedure;
import net.mcreator.distantworlds.procedures.LookAroundAdditionalConditionProcedure;
import net.mcreator.distantworlds.procedures.NoarhornEntityDiesProcedure;
import net.mcreator.distantworlds.procedures.FollowAdditionalConditionProcedure;
import net.mcreator.distantworlds.procedures.EntityIsHurtBehaviorProcedure;
import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.init.DistantWorldsModEntities;

import net.minecraft.world.item.ItemStack;
import net.mcreator.distantworlds.init.DistantWorldsModItems;

import java.util.List;

public class NoarhornEntity extends TamableAnimal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(NoarhornEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(NoarhornEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(NoarhornEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_Behavior = SynchedEntityData.defineId(NoarhornEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_InLove = SynchedEntityData.defineId(NoarhornEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_BabyAge = SynchedEntityData.defineId(NoarhornEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_BabyType = SynchedEntityData.defineId(NoarhornEntity.class, EntityDataSerializers.INT);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public NoarhornEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(DistantWorldsModEntities.NOARHORN.get(), world);
	}

	public NoarhornEntity(EntityType<NoarhornEntity> type, Level world) {
		super(type, world);
		xpReward = 3;
		setNoAi(false);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "noarhorn");
		this.entityData.define(DATA_Behavior, 0);
		this.entityData.define(DATA_InLove, 0);
		this.entityData.define(DATA_BabyAge, 0);
		this.entityData.define(DATA_BabyType, 0);
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
		double x = NoarhornEntity.this.getX();
		double y = NoarhornEntity.this.getY();
		double z = NoarhornEntity.this.getZ();
		Entity entity = NoarhornEntity.this;
		Level world = NoarhornEntity.this.level();
		super.registerGoals();
		this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1, (float) 6, (float) 12, false) {
			@Override
			public boolean canUse() {
				return super.canUse() && FollowAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && FollowAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.8) {
			@Override
			public boolean canUse() {
				return super.canUse() && WanderAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && WanderAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(3, new PanicGoal(this, 1.4) {
			@Override
			public boolean canUse() {
				return super.canUse() && WanderAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && WanderAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(11, new RandomSwimmingGoal(this, 1, 40) {
			@Override
			public boolean canUse() {
				return super.canUse() && WanderAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && WanderAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				return super.canUse() && LookAroundAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && LookAroundAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(7, new FloatGoal(this));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, LivingEntity.class, (float) 6) {
			@Override
			public boolean canUse() {
				return super.canUse() && WanderAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && WanderAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(DistantWorldsModItems.CULAFITE_MUSHROOM_ON_A_STICK.get()), false) {
			@Override
			public boolean canUse() {
				return super.canUse() && WanderAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && WanderAdditionalConditionProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, CulafiteShroomerEntity.class, false, false) {
			@Override
			public boolean canUse() {
				return super.canUse() && NoarhornAttackAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && NoarhornAttackAdditionalConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(11, new MeleeAttackGoal(this, 1, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return 10;
			}

			@Override
			public boolean canUse() {
				return super.canUse() && NoarhornAttackAdditionalConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && NoarhornAttackAdditionalConditionProcedure.execute(entity);
			}

		});

	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zoglin.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zoglin.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zoglin.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zoglin.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		EntityIsHurtBehaviorProcedure.execute(this);
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		NoarhornEntityDiesProcedure.execute(this.level(), this, source.getEntity());
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putInt("DataBehavior", this.entityData.get(DATA_Behavior));
		compound.putInt("DataInLove", this.entityData.get(DATA_InLove));
		compound.putInt("DataBabyAge", this.entityData.get(DATA_BabyAge));
		compound.putInt("DataBabyType", this.entityData.get(DATA_BabyType));
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
		if (compound.contains("DataBabyAge"))
			this.entityData.set(DATA_BabyAge, compound.getInt("DataBabyAge"));
		if (compound.contains("DataBabyType"))
			this.entityData.set(DATA_BabyType, compound.getInt("DataBabyType"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		Item item = itemstack.getItem();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();
		
		if (this.isOwnedBy(sourceentity)) {
			if (sourceentity.isShiftKeyDown()) {
				NoarhornRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity, itemstack);
				//return InteractionResult.SUCCESS;
				return InteractionResult.sidedSuccess(this.level().isClientSide);
			} else {
				sourceentity.startRiding(this);
				return InteractionResult.PASS;
			}
		} else {
			NoarhornRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity, itemstack);
			//return InteractionResult.SUCCESS;
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		}
	}

	@Override
	public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
		super.awardKillScore(entity, score, damageSource);
		NoarhornKillsAnotherEntityProcedure.execute(entity, this);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		NoarhornOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		NoarhornEntity retval = DistantWorldsModEntities.NOARHORN.get().create(serverWorld);
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
		if (this.isVehicle() && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == DistantWorldsModItems.CULAFITE_MUSHROOM_ON_A_STICK.get()) {
			this.setYRot(entity.getYRot());
			this.yRotO = this.getYRot();
			this.setXRot(entity.getXRot() * 0.5F);
			this.setRot(this.getYRot(), this.getXRot());
			this.yBodyRot = entity.getYRot();
			this.yHeadRot = entity.getYRot();
			this.setMaxUpStep(1.0F);
			if (entity instanceof LivingEntity passenger) {
				this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED) - 0.15F);
				float forward = passenger.zza;
				float strafe = 0;
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
		this.setMaxUpStep(0.5F);
		super.travel(dir);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
	}

	public static void init() {
		SpawnPlacements.register(DistantWorldsModEntities.NOARHORN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return NoarhornNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 2);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("running"));
			}
			if (this.isPassenger() || (this.getEntityData().get(NoarhornEntity.DATA_Behavior) == 2 && this.onGround() && !this.isVehicle())) {
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
			this.remove(NoarhornEntity.RemovalReason.KILLED);
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
