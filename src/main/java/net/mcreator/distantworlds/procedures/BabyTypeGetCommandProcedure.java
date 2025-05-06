package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.distantworlds.entity.NoarhornEntity;
import net.mcreator.distantworlds.entity.BabyNoarhornEntity;
import net.mcreator.distantworlds.entity.ArmoredNoarhornEntity;

import java.lang.reflect.Type;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class BabyTypeGetCommandProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		double Type = 0;
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
			}.getEntity()) instanceof BabyNoarhornEntity || (new Object() {
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
			}.getEntity()) instanceof ArmoredNoarhornEntity) {
				if ((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "target");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()) instanceof BabyNoarhornEntity) {
					Type = (new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "target");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()) instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_BabyType) : 0;
				} else if ((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "target");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()) instanceof NoarhornEntity) {
					Type = (new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "target");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()) instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_BabyType) : 0;
				} else {
					Type = (new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "target");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()) instanceof ArmoredNoarhornEntity _datEntI ? _datEntI.getEntityData().get(ArmoredNoarhornEntity.DATA_BabyType) : 0;
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.command.baby_type").getString() + ""
							+ (" = " + (new java.text.DecimalFormat("##").format(Type) + ""
									+ (Type == 1 || Type == 2
											? " \u00A77(" + ((Type == 1 ? Component.translatable("entity.distant_worlds.noarhorn").getString() : Component.translatable("entity.distant_worlds.armored_noarhorn").getString()) + ")")
											: " \u00A77(?)"))))),
							(!world.getLevelData().getGameRules().getBoolean(GameRules.RULE_COMMANDBLOCKOUTPUT)));
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
