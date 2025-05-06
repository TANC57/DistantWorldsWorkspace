package net.mcreator.distantworlds;

import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.theillusivec4.curios.api.SlotTypeMessage.Builder;
import net.minecraft.resources.ResourceLocation;

@Mod.EventBusSubscriber(modid="distant_worlds", bus=Mod.EventBusSubscriber.Bus.MOD)
public class CuriosSlots {
  @SubscribeEvent
  public static void enqueue(final InterModEnqueueEvent evt) {
  	InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.HEAD.getMessageBuilder().build());
    InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.NECKLACE.getMessageBuilder().size(1).build());
    InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.CHARM.getMessageBuilder().size(1).build());
    InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.HANDS.getMessageBuilder().build());
    /*InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("wither_totem_slot").icon(new ResourceLocation("curios:slot/empty_wither_totem_slot")).size(1).build());
	InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("return_ring_slot").icon(new ResourceLocation("curios:slot/empty_return_ring_slot")).size(1).build());
	InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("dalite_storage_slot").icon(new ResourceLocation("curios:slot/empty_dalite_storage_slot")).size(1).build());*/
  }
}