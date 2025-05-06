package net.mcreator.distantworlds.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.init.DistantWorldsModEnchantments;

import java.util.concurrent.atomic.AtomicReference;

public class LithumStructureRecipeAdditionalInfoProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		ItemStack MainItem = ItemStack.EMPTY;
		String CurrentRecipe = "";
		double EnergyModifier = 0;
		double Recovery = 0;
		if (!world.isClientSide()) {
			if (!(new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "CurrentRecipe")).equals("")) {
				MainItem = (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0));
				CurrentRecipe = new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "CurrentRecipe");
				if (!((CurrentRecipe).equals("firon_sword") && MainItem.getItem() == Items.NETHERITE_SWORD || (CurrentRecipe).equals("firon_pickaxe") && MainItem.getItem() == Items.NETHERITE_PICKAXE
						|| (CurrentRecipe).equals("firon_axe") && MainItem.getItem() == Items.NETHERITE_AXE || (CurrentRecipe).equals("firon_shovel") && MainItem.getItem() == Items.NETHERITE_SHOVEL
						|| (CurrentRecipe).equals("firon_hoe") && MainItem.getItem() == Items.NETHERITE_HOE || (CurrentRecipe).equals("firon_helmet") && MainItem.getItem() == Items.NETHERITE_HELMET
						|| (CurrentRecipe).equals("firon_chestplate") && MainItem.getItem() == Items.NETHERITE_CHESTPLATE || (CurrentRecipe).equals("firon_leggings") && MainItem.getItem() == Items.NETHERITE_LEGGINGS
						|| (CurrentRecipe).equals("firon_boots") && MainItem.getItem() == Items.NETHERITE_BOOTS || (CurrentRecipe).equals("firon_multitool") && MainItem.getItem() == DistantWorldsModItems.FIRON_INGOT.get()
						|| (CurrentRecipe).equals("helyst_sword") && MainItem.getItem() == DistantWorldsModItems.LITHUM_SWORD.get() || (CurrentRecipe).equals("helyst_pickaxe") && MainItem.getItem() == DistantWorldsModItems.LITHUM_PICKAXE.get()
						|| (CurrentRecipe).equals("helyst_axe") && MainItem.getItem() == DistantWorldsModItems.LITHUM_AXE.get() || (CurrentRecipe).equals("helyst_shovel") && MainItem.getItem() == DistantWorldsModItems.LITHUM_SHOVEL.get()
						|| (CurrentRecipe).equals("helyst_hoe") && MainItem.getItem() == DistantWorldsModItems.LITHUM_HOE.get() || (CurrentRecipe).equals("helyst_helmet") && MainItem.getItem() == DistantWorldsModItems.SALMORAN_ARMOR_HELMET.get()
						|| (CurrentRecipe).equals("helyst_chestplate") && MainItem.getItem() == DistantWorldsModItems.SALMORAN_ARMOR_CHESTPLATE.get()
						|| (CurrentRecipe).equals("helyst_leggings") && MainItem.getItem() == DistantWorldsModItems.SALMORAN_ARMOR_LEGGINGS.get()
						|| (CurrentRecipe).equals("helyst_boots") && MainItem.getItem() == DistantWorldsModItems.SALMORAN_ARMOR_BOOTS.get() || (CurrentRecipe).equals("vairis_sword") && MainItem.getItem() == DistantWorldsModItems.VAIRIS_CRYSTAL.get()
						|| (CurrentRecipe).equals("vairis_helmet") && MainItem.getItem() == Items.DIAMOND_HELMET || (CurrentRecipe).equals("vairis_chestplate") && MainItem.getItem() == Items.DIAMOND_CHESTPLATE
						|| (CurrentRecipe).equals("vairis_leggings") && MainItem.getItem() == Items.DIAMOND_LEGGINGS || (CurrentRecipe).equals("vairis_boots") && MainItem.getItem() == Items.DIAMOND_BOOTS
						|| (CurrentRecipe).equals("ubricite_hammer") && MainItem.getItem() == DistantWorldsModItems.UBRICITE_INGOT.get() || (CurrentRecipe).equals("ubricite_helmet") && MainItem.getItem() == Items.IRON_HELMET
						|| (CurrentRecipe).equals("ubricite_chestplate") && MainItem.getItem() == Items.IRON_CHESTPLATE || (CurrentRecipe).equals("ubricite_leggings") && MainItem.getItem() == Items.IRON_LEGGINGS
						|| (CurrentRecipe).equals("ubricite_boots") && MainItem.getItem() == Items.IRON_BOOTS
						|| ((CurrentRecipe).equals("module_calm_flame") || (CurrentRecipe).equals("module_raging_flame") || (CurrentRecipe).equals("module_calm_spark") || (CurrentRecipe).equals("module_raging_spark")
								|| (CurrentRecipe).equals("module_increased_storage") || (CurrentRecipe).equals("module_charmed_pedestal") || (CurrentRecipe).equals("module_flow_filter") || (CurrentRecipe).equals("module_flow_amplification")
								|| (CurrentRecipe).equals("module_core_stabilization") || (CurrentRecipe).equals("module_core_destabilization")) && MainItem.getItem() == DistantWorldsModItems.MODULE_EMPTY.get()
						|| (CurrentRecipe).equals("enchantment_sharpness") && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, MainItem) != 0
						|| (CurrentRecipe).equals("enchantment_thorns") && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.THORNS, MainItem) != 0
						|| (CurrentRecipe).equals("enchantment_fire_aspect") && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_ASPECT, MainItem) != 0
						|| (CurrentRecipe).equals("enchantment_fire_protection") && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_PROTECTION, MainItem) != 0
						|| (CurrentRecipe).equals("enchantment_unbreaking") && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.UNBREAKING, MainItem) != 0
						|| (CurrentRecipe).equals("enchantment_protection") && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.ALL_DAMAGE_PROTECTION, MainItem) != 0
						|| (CurrentRecipe).equals("enchantment_salmoran_sting") && EnchantmentHelper.getItemEnchantmentLevel(DistantWorldsModEnchantments.SALMORAN_STING.get(), MainItem) != 0
						|| (CurrentRecipe).equals("enchantment_feather_falling") && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FALL_PROTECTION, MainItem) != 0
						|| (CurrentRecipe).equals("enchantment_fortune") && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, MainItem) != 0
						|| (CurrentRecipe).equals("enchantment_projectile_protection") && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PROJECTILE_PROTECTION, MainItem) != 0
						|| (CurrentRecipe).equals("enchantment_blast_protection") && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLAST_PROTECTION, MainItem) != 0)) {
					return true;
				}
			}
		}
		return false;
	}
}
