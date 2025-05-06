package net.mcreator.distantworlds.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.distantworlds.DistantWorldsMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DistantWorldsModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		DistantWorldsMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.PermanentGarhennaImmunity = original.PermanentGarhennaImmunity;
			clone.ReturnRingX = original.ReturnRingX;
			clone.ReturnRingY = original.ReturnRingY;
			clone.ReturnRingZ = original.ReturnRingZ;
			clone.WitherTotemX = original.WitherTotemX;
			clone.WitherTotemY = original.WitherTotemY;
			clone.WitherTotemZ = original.WitherTotemZ;
			clone.UbriciteArmorAbility = original.UbriciteArmorAbility;
			if (!event.isWasDeath()) {
				clone.GarhennaDepletion = original.GarhennaDepletion;
				clone.GarhennaAdaptation = original.GarhennaAdaptation;
				clone.RequiredDaliteEnergyLeft = original.RequiredDaliteEnergyLeft;
				clone.DaliteEnergyTotal = original.DaliteEnergyTotal;
				clone.MaxDaliteEnergyTotal = original.MaxDaliteEnergyTotal;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("distant_worlds", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double GarhennaDepletion = 0.0;
		public double GarhennaAdaptation = 0.0;
		public double PermanentGarhennaImmunity = 0.0;
		public double ReturnRingX = 0.0;
		public double ReturnRingY = -64.0;
		public double ReturnRingZ = 0.0;
		public double WitherTotemX = 0;
		public double WitherTotemY = -64.0;
		public double WitherTotemZ = 0;
		public double UbriciteArmorAbility = 0;
		public double RequiredDaliteEnergyLeft = 0;
		public double DaliteEnergyTotal = 0;
		public double MaxDaliteEnergyTotal = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				DistantWorldsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("GarhennaDepletion", GarhennaDepletion);
			nbt.putDouble("GarhennaAdaptation", GarhennaAdaptation);
			nbt.putDouble("PermanentGarhennaImmunity", PermanentGarhennaImmunity);
			nbt.putDouble("ReturnRingX", ReturnRingX);
			nbt.putDouble("ReturnRingY", ReturnRingY);
			nbt.putDouble("ReturnRingZ", ReturnRingZ);
			nbt.putDouble("WitherTotemX", WitherTotemX);
			nbt.putDouble("WitherTotemY", WitherTotemY);
			nbt.putDouble("WitherTotemZ", WitherTotemZ);
			nbt.putDouble("UbriciteArmorAbility", UbriciteArmorAbility);
			nbt.putDouble("RequiredDaliteEnergyLeft", RequiredDaliteEnergyLeft);
			nbt.putDouble("DaliteEnergyTotal", DaliteEnergyTotal);
			nbt.putDouble("MaxDaliteEnergyTotal", MaxDaliteEnergyTotal);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			GarhennaDepletion = nbt.getDouble("GarhennaDepletion");
			GarhennaAdaptation = nbt.getDouble("GarhennaAdaptation");
			PermanentGarhennaImmunity = nbt.getDouble("PermanentGarhennaImmunity");
			ReturnRingX = nbt.getDouble("ReturnRingX");
			ReturnRingY = nbt.getDouble("ReturnRingY");
			ReturnRingZ = nbt.getDouble("ReturnRingZ");
			WitherTotemX = nbt.getDouble("WitherTotemX");
			WitherTotemY = nbt.getDouble("WitherTotemY");
			WitherTotemZ = nbt.getDouble("WitherTotemZ");
			UbriciteArmorAbility = nbt.getDouble("UbriciteArmorAbility");
			RequiredDaliteEnergyLeft = nbt.getDouble("RequiredDaliteEnergyLeft");
			DaliteEnergyTotal = nbt.getDouble("DaliteEnergyTotal");
			MaxDaliteEnergyTotal = nbt.getDouble("MaxDaliteEnergyTotal");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.GarhennaDepletion = message.data.GarhennaDepletion;
					variables.GarhennaAdaptation = message.data.GarhennaAdaptation;
					variables.PermanentGarhennaImmunity = message.data.PermanentGarhennaImmunity;
					variables.ReturnRingX = message.data.ReturnRingX;
					variables.ReturnRingY = message.data.ReturnRingY;
					variables.ReturnRingZ = message.data.ReturnRingZ;
					variables.WitherTotemX = message.data.WitherTotemX;
					variables.WitherTotemY = message.data.WitherTotemY;
					variables.WitherTotemZ = message.data.WitherTotemZ;
					variables.UbriciteArmorAbility = message.data.UbriciteArmorAbility;
					variables.RequiredDaliteEnergyLeft = message.data.RequiredDaliteEnergyLeft;
					variables.DaliteEnergyTotal = message.data.DaliteEnergyTotal;
					variables.MaxDaliteEnergyTotal = message.data.MaxDaliteEnergyTotal;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
