package net.mcreator.distantworlds.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.network.DistantWorldsModVariables;
import net.mcreator.distantworlds.init.DistantWorldsModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class UsingRequiredDaliteEnergyTickUpdateProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft > 0) {
			if (entity instanceof LivingEntity lv) {
				CuriosApi.getCuriosHelper().findCurios(lv, DistantWorldsModItems.DALITE_STORAGE_INITIAL.get()).forEach(item -> {
					ItemStack itemstackiterator = item.stack();
					if (itemstackiterator.getOrCreateTag()
							.getDouble("CurrentEnergy") > (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft) {
						itemstackiterator.getOrCreateTag().putDouble("CurrentEnergy", (itemstackiterator.getOrCreateTag().getDouble("CurrentEnergy")
								- (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft));
						{
							double _setval = 0;
							entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RequiredDaliteEnergyLeft = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						{
							double _setval = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft
									- itemstackiterator.getOrCreateTag().getDouble("CurrentEnergy");
							entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RequiredDaliteEnergyLeft = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						itemstackiterator.getOrCreateTag().putDouble("CurrentEnergy", 0);
					}
				});
			}
		}
		if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft > 0) {
			if (entity instanceof LivingEntity lv) {
				CuriosApi.getCuriosHelper().findCurios(lv, DistantWorldsModItems.DALITE_STORAGE_EXTENDED.get()).forEach(item -> {
					ItemStack itemstackiterator = item.stack();
					if (itemstackiterator.getOrCreateTag()
							.getDouble("CurrentEnergy") > (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft) {
						itemstackiterator.getOrCreateTag().putDouble("CurrentEnergy", (itemstackiterator.getOrCreateTag().getDouble("CurrentEnergy")
								- (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft));
						{
							double _setval = 0;
							entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RequiredDaliteEnergyLeft = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						{
							double _setval = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft
									- itemstackiterator.getOrCreateTag().getDouble("CurrentEnergy");
							entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RequiredDaliteEnergyLeft = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						itemstackiterator.getOrCreateTag().putDouble("CurrentEnergy", 0);
					}
				});
			}
		}
		if ((entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft > 0) {
			if (entity instanceof LivingEntity lv) {
				CuriosApi.getCuriosHelper().findCurios(lv, DistantWorldsModItems.DALITE_STORAGE_ADVANCED.get()).forEach(item -> {
					ItemStack itemstackiterator = item.stack();
					if (itemstackiterator.getOrCreateTag()
							.getDouble("CurrentEnergy") > (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft) {
						itemstackiterator.getOrCreateTag().putDouble("CurrentEnergy", (itemstackiterator.getOrCreateTag().getDouble("CurrentEnergy")
								- (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft));
						{
							double _setval = 0;
							entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RequiredDaliteEnergyLeft = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						{
							double _setval = (entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DistantWorldsModVariables.PlayerVariables())).RequiredDaliteEnergyLeft
									- itemstackiterator.getOrCreateTag().getDouble("CurrentEnergy");
							entity.getCapability(DistantWorldsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RequiredDaliteEnergyLeft = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						itemstackiterator.getOrCreateTag().putDouble("CurrentEnergy", 0);
					}
				});
			}
		}
	}
}
