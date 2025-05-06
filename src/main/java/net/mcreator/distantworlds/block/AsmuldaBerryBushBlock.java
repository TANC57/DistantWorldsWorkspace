
package net.mcreator.distantworlds.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.distantworlds.procedures.AsmuldaBerryBushPlantRightClickedProcedure;
import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

import java.util.List;
import java.util.Collections;

public class AsmuldaBerryBushBlock extends FlowerBlock implements BonemealableBlock {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	public AsmuldaBerryBushBlock() {
		super(() -> MobEffects.MOVEMENT_SPEED, 100,
				BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).randomTicks().sound(SoundType.SWEET_BERRY_BUSH).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.NONE).pushReaction(PushReaction.DESTROY).lightLevel((state) -> state.getValue(AGE) == 3 ? 8 : (state.getValue(AGE) == 2 ? 5 : 0)));
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(3)));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		if (state.getValue(AGE) == 0) {
			return box(3, 0, 3, 13, 11, 13).move(offset.x, offset.y, offset.z);
		} else if (state.getValue(AGE) == 3) {
			return box(0, 0, 0, 16, 16, 16).move(offset.x, offset.y, offset.z);
		} else {
			return box(1, 0, 1, 15, 16, 15).move(offset.x, offset.y, offset.z);
		}
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return state.getValue(AGE) < 3;
	}

	@Override
	public int getEffectDuration() {
		return 100;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(DistantWorldsModItems.ASMULDA_BERRIES.get()));
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(DistantWorldsModBlocks.LAYERED_MUD.get()) || groundState.is(DistantWorldsModBlocks.LIFELESS_GRASS.get());
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}

	@Override
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
		int i = state.getValue(AGE);
		if (i < 3 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, random.nextInt(5) == 0)) {
		world.setBlock(pos, state.setValue(AGE, Integer.valueOf(i + 1)), 2);
		net.minecraftforge.common.ForgeHooks.onCropsGrowPost(world, pos, state);
		}
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		if (blockstate.getValue(AGE) == 3) {
			super.use(blockstate, world, pos, entity, hand, hit);
			AsmuldaBerryBushPlantRightClickedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.PASS;
		}
	}

	public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate, boolean clientSide) {
      return blockstate.getValue(AGE) < 3;
   }

	@Override
	public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
      int i = Math.min(3, blockstate.getValue(AGE) + 1);
      world.setBlock(pos, blockstate.setValue(AGE, Integer.valueOf(i)), 2);
   }

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return new ItemStack(DistantWorldsModItems.ASMULDA_BERRIES.get());
	}

	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
      if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
         entity.makeStuckInBlock(blockstate, new Vec3((double)0.8F, 0.75D, (double)0.8F));
         if (!world.isClientSide && blockstate.getValue(AGE) > 0 && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
            double d0 = Math.abs(entity.getX() - entity.xOld);
            double d1 = Math.abs(entity.getZ() - entity.zOld);
            if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
               entity.hurt(world.damageSources().sweetBerryBush(), 1.0F);
            }
         }
      }
   }

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
       builder.add(AGE);
   }
}
