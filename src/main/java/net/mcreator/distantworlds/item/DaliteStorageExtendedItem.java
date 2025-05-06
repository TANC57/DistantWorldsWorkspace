
package net.mcreator.distantworlds.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;

import net.mcreator.distantworlds.procedures.DaliteStorageRightclickedProcedure;
import net.mcreator.distantworlds.procedures.DaliteStorageExtendedInInventoryTickProcedure;

import java.util.List;

public class DaliteStorageExtendedItem extends Item implements ICurioItem {
	public DaliteStorageExtendedItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		DaliteStorageRightclickedProcedure.execute(world, x, y, z, entity, itemstack);
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		DaliteStorageExtendedInInventoryTickProcedure.execute(itemstack);
	}

	public int getBarWidth(ItemStack itemstack) {
		float MaxEnergy = (float) itemstack.getOrCreateTag().getDouble("MaxEnergy");
		float CurrentEnergy = (float) itemstack.getOrCreateTag().getDouble("CurrentEnergy");
		boolean noEnergy = CurrentEnergy == 0;
		return Math.round(CurrentEnergy * 13.0F / MaxEnergy);
   }

	public boolean isBarVisible(ItemStack itemstack) {
		float MaxEnergy = (float) itemstack.getOrCreateTag().getDouble("MaxEnergy");
		float CurrentEnergy = (float) itemstack.getOrCreateTag().getDouble("CurrentEnergy");
		return (MaxEnergy > 0 && CurrentEnergy > 0);
	}

	public int getBarColor(ItemStack itemstack) {
		float MaxEnergy = (float) itemstack.getOrCreateTag().getDouble("MaxEnergy");
		float CurrentEnergy = (float) itemstack.getOrCreateTag().getDouble("CurrentEnergy");
		float f = Math.max(0.0F, (MaxEnergy - CurrentEnergy) / MaxEnergy);
		return Mth.hsvToRgb(0.16F - (0.13F * f), 0.7F + (0.3F * f), 1.0F - (0.1F * f));
   }
}
