
package net.mcreator.distantworlds.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;

import net.mcreator.distantworlds.procedures.DaliteStaffShootsProcedure;
import net.mcreator.distantworlds.procedures.ReturnMaxDaliteEnergyTotalProcedure;
import net.mcreator.distantworlds.procedures.ReturnDaliteEnergyCurioProcedure;

import java.util.List;

import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;

public class DaliteStaffItem extends Item {
	float MaxEnergy = 0;
	float CurrentEnergy = 0;
	Entity cEntity = null;
	public DaliteStaffItem() {
		super(new Item.Properties().durability(800));
	}

	@Override
	public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
		return 1;
	}

	@Override
	public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
		itemstack.hurtAndBreak(1, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		itemstack.hurtAndBreak(2, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}

	@Override
	public int getEnchantmentValue() {
		return 2;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (entity.isShiftKeyDown()) {
			cEntity = entity;
			MaxEnergy = (float) ReturnMaxDaliteEnergyTotalProcedure.execute(world, entity);
			CurrentEnergy = (float) ReturnDaliteEnergyCurioProcedure.execute(world, entity);
		}
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
		if (equipmentSlot == EquipmentSlot.MAINHAND) {
			ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
			builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 2f, AttributeModifier.Operation.ADDITION));
			builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -3, AttributeModifier.Operation.ADDITION));
			return builder.build();
		}
		return super.getDefaultAttributeModifiers(equipmentSlot);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		if (retval == false) {
			DaliteStaffShootsProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		}
		return retval;
	}

	public boolean isBarVisible(ItemStack itemstack) {
		if (!(cEntity == null) && cEntity.isShiftKeyDown()) {
			return true;
		} else {
			return itemstack.isDamaged();
		}
	}

	public int getBarWidth(ItemStack itemstack) {
		if (!(cEntity == null) && cEntity.isShiftKeyDown()) {
			boolean noEnergy = CurrentEnergy == 0;
			return Math.round(CurrentEnergy * 13.0F / MaxEnergy);
		} else {
			return Math.round(13.0F - (float)itemstack.getDamageValue() * 13.0F / (float)this.getMaxDamage(itemstack));
		}
   }

	public int getBarColor(ItemStack itemstack) {
		if (!(cEntity == null) && cEntity.isShiftKeyDown()) {
			float f = Math.max(0.0F, (MaxEnergy - CurrentEnergy) / MaxEnergy);
			return Mth.hsvToRgb(0.16F - (0.13F * f), 0.7F + (0.3F * f), 1.0F - (0.1F * f));
		} else {
			float stackMaxDamage = this.getMaxDamage(itemstack);
      		float f = Math.max(0.0F, (stackMaxDamage - (float)itemstack.getDamageValue()) / stackMaxDamage);
      		return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
		}
   }
}