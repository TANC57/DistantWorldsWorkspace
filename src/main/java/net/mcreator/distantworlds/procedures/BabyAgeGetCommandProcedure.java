package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.distantworlds.entity.SalmoranEntity;
import net.mcreator.distantworlds.entity.NoarhornEntity;
import net.mcreator.distantworlds.entity.ArmoredNoarhornEntity;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class BabyAgeGetCommandProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		double Age = 0;
		if (entity.hasPermissions(2)) {
			if ((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "target");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()) instanceof NoarhornEntity || (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "target");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()) instanceof ArmoredNoarhornEntity || (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "target");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()) instanceof SalmoranEntity) {
				if ((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "target");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()) instanceof NoarhornEntity) {
					Age = (new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "target");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()) instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_BabyAge) : 0;
				} else if ((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "target");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()) instanceof ArmoredNoarhornEntity) {
					Age = (new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "target");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()) instanceof ArmoredNoarhornEntity _datEntI ? _datEntI.getEntityData().get(ArmoredNoarhornEntity.DATA_BabyAge) : 0;
				} else {
					Age = (new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "target");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()) instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_BabyAge) : 0;
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.command.baby_age").getString() + "" + (" = " + (new java.text.DecimalFormat("##").format(Age) + "" + (" / " + ((new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "target");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()) instanceof SalmoranEntity ? "2200" : "3600")))))), (!world.getLevelData().getGameRules().getBoolean(GameRules.RULE_COMMANDBLOCKOUTPUT)));
			} else {
				if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_COMMANDBLOCKOUTPUT)) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.command.data_issue").getString())), false);
				}
			}
		} else {
			if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_COMMANDBLOCKOUTPUT)) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.command.permission_issue").getString())), false);
			}
		}
	}
}
