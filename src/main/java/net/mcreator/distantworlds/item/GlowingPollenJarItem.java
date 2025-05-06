
package net.mcreator.distantworlds.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import top.theillusivec4.curios.api.type.capability.ICurio;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import java.util.UUID;
import javax.annotation.Nonnull;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.sounds.SoundEvents;

import net.mcreator.distantworlds.procedures.GlowingPollenJarWhileBaubleIsEquippedTickProcedure;

public class GlowingPollenJarItem extends Item implements ICurioItem {
	public GlowingPollenJarItem() {
		super(new Item.Properties().durability(100).rarity(Rarity.COMMON));
	}

	@Override
	public boolean canEquipFromUse(SlotContext slot, ItemStack stack) {
    return true;
	}
	
	@Nonnull
  	@Override
  	public ICurio.SoundInfo getEquipSound(SlotContext slotContext, ItemStack stack) {
    	return new ICurio.SoundInfo(SoundEvents.ARMOR_EQUIP_CHAIN, 1.0f, 1.2f);
    }
   
    @Override
      public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();
		atts.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "armor_toughness", 1, AttributeModifier.Operation.ADDITION));
		atts.put(Attributes.LUCK, new AttributeModifier(uuid, "luck", 3, AttributeModifier.Operation.ADDITION));
        return atts;
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		GlowingPollenJarWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity().level(), slotContext.entity().getX(), slotContext.entity().getY(), slotContext.entity().getZ(), slotContext.entity(), stack);
	}
}
