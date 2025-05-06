
package net.mcreator.distantworlds.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;

import net.mcreator.distantworlds.procedures.AsmuldaBerryBushPlantRightClickedProcedure;
import net.mcreator.distantworlds.procedures.PottedPlantOnBlockRightClickedProcedure;
import net.mcreator.distantworlds.init.DistantWorldsModItems;

import java.util.List;
import java.util.Collections;

public class PottedAsmuldaBerryBushBlock extends Block implements BonemealableBlock {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	public PottedAsmuldaBerryBushBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.STONE).instabreak().lightLevel(s -> 1).noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY).lightLevel((state) -> state.getValue(AGE) == 3 ? 8 : (state.getValue(AGE) == 2 ? 5 : 0))
				.isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return state.getValue(AGE) < 3;
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
		if (blockstate.getValue(AGE) == 3 && !entity.isShiftKeyDown()) {
			super.use(blockstate, world, pos, entity, hand, hit);
			AsmuldaBerryBushPlantRightClickedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
			return InteractionResult.SUCCESS;
		} else if (entity.isShiftKeyDown()){
			super.use(blockstate, world, pos, entity, hand, hit);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			double hitX = hit.getLocation().x;
			double hitY = hit.getLocation().y;
			double hitZ = hit.getLocation().z;
			Direction direction = hit.getDirection();
			PottedPlantOnBlockRightClickedProcedure.execute(world, x, y, z, blockstate, entity);
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
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return box(5, 0, 5, 11, 6, 11);
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return new ItemStack(DistantWorldsModItems.ASMULDA_BERRIES.get());
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(Blocks.AIR));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
       builder.add(AGE);
   }
}
