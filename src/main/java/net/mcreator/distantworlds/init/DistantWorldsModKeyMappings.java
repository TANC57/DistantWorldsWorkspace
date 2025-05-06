
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.distantworlds.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.distantworlds.network.UseWitherTotemMessage;
import net.mcreator.distantworlds.network.UseReturnRingMessage;
import net.mcreator.distantworlds.network.FlyUpMessage;
import net.mcreator.distantworlds.DistantWorldsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DistantWorldsModKeyMappings {
	public static final KeyMapping USE_RETURN_RING = new KeyMapping("key.distant_worlds.use_return_ring", GLFW.GLFW_KEY_R, "key.categories.distant_worlds") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DistantWorldsMod.PACKET_HANDLER.sendToServer(new UseReturnRingMessage(0, 0));
				UseReturnRingMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_WITHER_TOTEM = new KeyMapping("key.distant_worlds.use_wither_totem", GLFW.GLFW_KEY_U, "key.categories.distant_worlds") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DistantWorldsMod.PACKET_HANDLER.sendToServer(new UseWitherTotemMessage(0, 0));
				UseWitherTotemMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FLY_UP = new KeyMapping("key.distant_worlds.fly_up", GLFW.GLFW_KEY_SPACE, "key.categories.distant_worlds") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				FLY_UP_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - FLY_UP_LASTPRESS);
				DistantWorldsMod.PACKET_HANDLER.sendToServer(new FlyUpMessage(1, dt));
				FlyUpMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long FLY_UP_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(USE_RETURN_RING);
		event.register(USE_WITHER_TOTEM);
		event.register(FLY_UP);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				USE_RETURN_RING.consumeClick();
				USE_WITHER_TOTEM.consumeClick();
				FLY_UP.consumeClick();
			}
		}
	}
}
