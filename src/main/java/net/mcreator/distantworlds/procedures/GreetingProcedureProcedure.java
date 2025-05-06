package net.mcreator.distantworlds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.util.Calendar;

@Mod.EventBusSubscriber
public class GreetingProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 14 && Calendar.getInstance().get(Calendar.MONTH) == 5 && Calendar.getInstance().get(Calendar.YEAR) > 2022) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(((Component.translatable("event.distant_worlds.greeting_message").getString()).replace("*", new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.YEAR) - 2022)))),
						false);
		}
	}
}
