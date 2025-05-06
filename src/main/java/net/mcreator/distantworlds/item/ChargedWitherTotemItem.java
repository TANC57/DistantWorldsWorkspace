package net.mcreator.distantworlds.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.client.Minecraft;

import top.theillusivec4.curios.api.SlotContext;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import java.util.UUID;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import net.mcreator.distantworlds.procedures.ChargedWitherTotemRightclickedProcedure;
import net.mcreator.distantworlds.procedures.ChargedWitherTotemMakeItemGlowProcedure;

public class ChargedWitherTotemItem extends Item implements ICurioItem {
	public ChargedWitherTotemItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		Entity entity = Minecraft.getInstance().player;
		return ChargedWitherTotemMakeItemGlowProcedure.execute(entity);
	}

	@Override
      public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();
		atts.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "armor_toughness", 1, AttributeModifier.Operation.ADDITION));
        return atts;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		ChargedWitherTotemRightclickedProcedure.execute(world, x, y, z, entity);
		return ar;
	}
}