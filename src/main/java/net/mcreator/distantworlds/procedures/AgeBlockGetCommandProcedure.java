package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.distantworlds.init.DistantWorldsModBlocks;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class AgeBlockGetCommandProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (entity.hasPermissions(2)) {
			if ((world.getBlockState(BlockPos.containing(new Object() {
				public double getX() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "block").getX();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getX(), new Object() {
				public double getY() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "block").getY();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getY(), new Object() {
				public double getZ() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "block").getZ();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getZ()))).getBlock() == DistantWorldsModBlocks.SALMORAN_EGG.get() || (world.getBlockState(BlockPos.containing(new Object() {
				public double getX() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "block").getX();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getX(), new Object() {
				public double getY() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "block").getY();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getY(), new Object() {
				public double getZ() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "block").getZ();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getZ()))).getBlock() == DistantWorldsModBlocks.CRACKED_SALMORAN_EGG.get()) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.command.age").getString() + "" + (" = " + (new java.text.DecimalFormat("##").format(new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(new Object() {
						public double getX() {
							try {
								return BlockPosArgument.getLoadedBlockPos(arguments, "block").getX();
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return 0;
							}
						}
					}.getX(), new Object() {
						public double getY() {
							try {
								return BlockPosArgument.getLoadedBlockPos(arguments, "block").getY();
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return 0;
							}
						}
					}.getY(), new Object() {
						public double getZ() {
							try {
								return BlockPosArgument.getLoadedBlockPos(arguments, "block").getZ();
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return 0;
							}
						}
					}.getZ()), "Age")) + "" + ("/" + "1600"))))), (!world.getLevelData().getGameRules().getBoolean(GameRules.RULE_COMMANDBLOCKOUTPUT)));
			} else {
				if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_COMMANDBLOCKOUTPUT)) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.command.data_issue").getString())), false);
				}
			}
		} else {
			if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_COMMANDBLOCKOUTPUT)) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.command.permission_issue").getString())), true);
			}
		}
	}
}
