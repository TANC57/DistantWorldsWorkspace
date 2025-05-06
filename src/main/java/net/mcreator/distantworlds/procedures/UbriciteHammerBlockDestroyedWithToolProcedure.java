package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantments;

public class UbriciteHammerBlockDestroyedWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		Direction blockFace = Direction.NORTH;
		BlockState currentBlock = Blocks.AIR.defaultBlockState();
		double xOffset = 0;
		double yOffset = 0;
		double zOffsey = 0;
		double miningRange = 0;
		if (itemstack.getItem().isCorrectToolForDrops(blockstate)) {
			if (!entity.isShiftKeyDown()) {
				miningRange = 3;
				blockFace = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection();
				xOffset = blockFace == Direction.UP || blockFace == Direction.DOWN || blockFace == Direction.NORTH || blockFace == Direction.SOUTH ? Math.floor(miningRange / 2) : 0;
				for (int index0 = 0; index0 < (int) (blockFace == Direction.UP || blockFace == Direction.DOWN || blockFace == Direction.NORTH || blockFace == Direction.SOUTH ? miningRange : 1); index0++) {
					yOffset = blockFace == Direction.NORTH || blockFace == Direction.SOUTH || blockFace == Direction.WEST || blockFace == Direction.EAST ? Math.floor(miningRange / 2) : 0;
					for (int index1 = 0; index1 < (int) (blockFace == Direction.NORTH || blockFace == Direction.SOUTH || blockFace == Direction.WEST || blockFace == Direction.EAST ? miningRange : 1); index1++) {
						zOffsey = blockFace == Direction.UP || blockFace == Direction.DOWN || blockFace == Direction.WEST || blockFace == Direction.EAST ? Math.floor(miningRange / 2) : 0;
						for (int index2 = 0; index2 < (int) (blockFace == Direction.UP || blockFace == Direction.DOWN || blockFace == Direction.WEST || blockFace == Direction.EAST ? miningRange : 1); index2++) {
							if (itemstack.getDamageValue() < itemstack.getMaxDamage()) {
								currentBlock = (world.getBlockState(BlockPos.containing(x + xOffset, y + yOffset, z + zOffsey)));
								if (currentBlock.getBlock() == blockstate.getBlock() && itemstack.getItem().isCorrectToolForDrops(currentBlock)) {
									{
										BlockPos _pos = BlockPos.containing(x + xOffset, y + yOffset, z + zOffsey);
										Block.dropResources(world.getBlockState(_pos), entity.level(), BlockPos.containing(x + xOffset + 0.5, y + yOffset + 0.5, z + zOffsey + 0.5), null, entity, itemstack);
										world.destroyBlock(_pos, false);
										if (entity instanceof Player _player)
											_player.causeFoodExhaustion((float) 0.005);
									}
									if (!(Math.abs(xOffset) + Math.abs(yOffset) + Math.abs(zOffsey) == 0)) {
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
							if (blockFace == Direction.UP || blockFace == Direction.DOWN || blockFace == Direction.WEST || blockFace == Direction.EAST) {
								zOffsey = zOffsey - 1;
							}
						}
						if (blockFace == Direction.NORTH || blockFace == Direction.SOUTH || blockFace == Direction.WEST || blockFace == Direction.EAST) {
							yOffset = yOffset - 1;
						}
					}
					if (blockFace == Direction.UP || blockFace == Direction.DOWN || blockFace == Direction.NORTH || blockFace == Direction.SOUTH) {
						xOffset = xOffset - 1;
					}
				}
			} else {
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					Block.dropResources(world.getBlockState(_pos), entity.level(), BlockPos.containing(x + xOffset + 0.5, y + yOffset + 0.5, z + zOffsey + 0.5), null, entity, itemstack);
					world.destroyBlock(_pos, false);
					if (entity instanceof Player _player)
						_player.causeFoodExhaustion((float) 0.005);
				}
			}
		}
	}
}
