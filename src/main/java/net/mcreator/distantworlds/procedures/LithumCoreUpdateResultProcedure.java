package net.mcreator.distantworlds.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.init.DistantWorldsModEnchantments;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

public class LithumCoreUpdateResultProcedure {
	public static ItemStack execute(LevelAccessor world, double x, double y, double z) {
		String CurrentRecipe = "";
		ItemStack ResultItem = ItemStack.EMPTY;
		double DamageCount = 0;
		double CurrentLevel = 0;
		if (!world.isClientSide()) {
			CurrentRecipe = new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "CurrentRecipe");
			if (CurrentRecipe.contains("firon")) {
				if ((CurrentRecipe).equals("firon_multitool")) {
					return new ItemStack(DistantWorldsModItems.FIRON_MULTITOOL.get());
				}
				if ((CurrentRecipe).equals("firon_sword")) {
					ResultItem = new ItemStack(DistantWorldsModItems.FIRON_SWORD.get());
				}
				if ((CurrentRecipe).equals("firon_pickaxe")) {
					ResultItem = new ItemStack(DistantWorldsModItems.FIRON_PICKAXE.get());
				}
				if ((CurrentRecipe).equals("firon_axe")) {
					ResultItem = new ItemStack(DistantWorldsModItems.FIRON_AXE.get());
				}
				if ((CurrentRecipe).equals("firon_shovel")) {
					ResultItem = new ItemStack(DistantWorldsModItems.FIRON_SHOVEL.get());
				}
				if ((CurrentRecipe).equals("firon_hoe")) {
					ResultItem = new ItemStack(DistantWorldsModItems.FIRON_HOE.get());
				}
				if ((CurrentRecipe).equals("firon_helmet")) {
					ResultItem = new ItemStack(DistantWorldsModItems.FIRON_HELMET.get());
				}
				if ((CurrentRecipe).equals("firon_chestplate")) {
					ResultItem = new ItemStack(DistantWorldsModItems.FIRON_CHESTPLATE.get());
				}
				if ((CurrentRecipe).equals("firon_leggings")) {
					ResultItem = new ItemStack(DistantWorldsModItems.FIRON_LEGGINGS.get());
				}
				if ((CurrentRecipe).equals("firon_boots")) {
					ResultItem = new ItemStack(DistantWorldsModItems.FIRON_BOOTS.get());
				}
			}
			if (CurrentRecipe.contains("helyst")) {
				if ((CurrentRecipe).equals("helyst_sword")) {
					ResultItem = new ItemStack(DistantWorldsModItems.HELYST_SWORD.get());
				}
				if ((CurrentRecipe).equals("helyst_pickaxe")) {
					ResultItem = new ItemStack(DistantWorldsModItems.HELYST_PICKAXE.get());
				}
				if ((CurrentRecipe).equals("helyst_axe")) {
					ResultItem = new ItemStack(DistantWorldsModItems.HELYST_AXE.get());
				}
				if ((CurrentRecipe).equals("helyst_shovel")) {
					ResultItem = new ItemStack(DistantWorldsModItems.HELYST_SHOVEL.get());
				}
				if ((CurrentRecipe).equals("helyst_hoe")) {
					ResultItem = new ItemStack(DistantWorldsModItems.HELYST_HOE.get());
				}
				if ((CurrentRecipe).equals("helyst_helmet")) {
					ResultItem = new ItemStack(DistantWorldsModItems.HELYST_HELMET.get());
				}
				if ((CurrentRecipe).equals("helyst_chestplate")) {
					ResultItem = new ItemStack(DistantWorldsModItems.HELYST_CHESTPLATE.get());
				}
				if ((CurrentRecipe).equals("helyst_leggings")) {
					ResultItem = new ItemStack(DistantWorldsModItems.HELYST_LEGGINGS.get());
				}
				if ((CurrentRecipe).equals("helyst_boots")) {
					ResultItem = new ItemStack(DistantWorldsModItems.HELYST_BOOTS.get());
				}
			}
			if (CurrentRecipe.contains("vairis")) {
				if ((CurrentRecipe).equals("vairis_sword")) {
					return new ItemStack(DistantWorldsModItems.VAIRIS_SWORD.get());
				}
				if ((CurrentRecipe).equals("vairis_helmet")) {
					ResultItem = new ItemStack(DistantWorldsModItems.VAIRIS_HELMET.get());
				}
				if ((CurrentRecipe).equals("vairis_chestplate")) {
					ResultItem = new ItemStack(DistantWorldsModItems.VAIRIS_CHESTPLATE.get());
				}
				if ((CurrentRecipe).equals("vairis_leggings")) {
					ResultItem = new ItemStack(DistantWorldsModItems.VAIRIS_LEGGINGS.get());
				}
				if ((CurrentRecipe).equals("vairis_boots")) {
					ResultItem = new ItemStack(DistantWorldsModItems.VAIRIS_BOOTS.get());
				}
			}
			if (CurrentRecipe.contains("ubricite")) {
				if ((CurrentRecipe).equals("ubricite_hammer")) {
					return new ItemStack(DistantWorldsModItems.UBRICITE_HAMMER.get());
				}
				if ((CurrentRecipe).equals("ubricite_helmet")) {
					ResultItem = new ItemStack(DistantWorldsModItems.UBRICITE_ARMOR_HELMET.get());
				}
				if ((CurrentRecipe).equals("ubricite_chestplate")) {
					ResultItem = new ItemStack(DistantWorldsModItems.UBRICITE_ARMOR_CHESTPLATE.get());
				}
				if ((CurrentRecipe).equals("ubricite_leggings")) {
					ResultItem = new ItemStack(DistantWorldsModItems.UBRICITE_ARMOR_LEGGINGS.get());
				}
				if ((CurrentRecipe).equals("ubricite_boots")) {
					ResultItem = new ItemStack(DistantWorldsModItems.UBRICITE_ARMOR_BOOTS.get());
				}
			}
			if (CurrentRecipe.contains("module")) {
				if ((CurrentRecipe).equals("module_calm_flame")) {
					return new ItemStack(DistantWorldsModItems.MODULE_CALM_FLAME.get());
				}
				if ((CurrentRecipe).equals("module_raging_flame")) {
					return new ItemStack(DistantWorldsModItems.MODULE_RAGING_FLAME.get());
				}
				if ((CurrentRecipe).equals("module_calm_spark")) {
					return new ItemStack(DistantWorldsModItems.MODULE_CALM_SPARK.get());
				}
				if ((CurrentRecipe).equals("module_raging_spark")) {
					return new ItemStack(DistantWorldsModItems.MODULE_RAGING_SPARK.get());
				}
				if ((CurrentRecipe).equals("module_increased_storage")) {
					return new ItemStack(DistantWorldsModItems.MODULE_INCREASED_STORAGE.get());
				}
				if ((CurrentRecipe).equals("module_charmed_pedestal")) {
					return new ItemStack(DistantWorldsModItems.MODULE_CHARMED_PEDESTAL.get());
				}
				if ((CurrentRecipe).equals("module_flow_filter")) {
					return new ItemStack(DistantWorldsModItems.MODULE_FLOW_FILTER.get());
				}
				if ((CurrentRecipe).equals("module_flow_amplification")) {
					return new ItemStack(DistantWorldsModItems.MODULE_FLOW_AMPLIFICATION.get());
				}
				if ((CurrentRecipe).equals("module_core_stabilization")) {
					return new ItemStack(DistantWorldsModItems.MODULE_CORE_STABILIZATION.get());
				}
				if ((CurrentRecipe).equals("module_core_destabilization")) {
					return new ItemStack(DistantWorldsModItems.MODULE_CORE_DESTABILIZATION.get());
				}
			}
			if (CurrentRecipe.contains("enchantment")) {
				if ((CurrentRecipe).equals("enchantment_sharpness")) {
					ResultItem = (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0));
					CurrentLevel = ResultItem.getEnchantmentLevel(Enchantments.SHARPNESS);
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(ResultItem);
						if (_enchantments.containsKey(Enchantments.SHARPNESS)) {
							_enchantments.remove(Enchantments.SHARPNESS);
							EnchantmentHelper.setEnchantments(_enchantments, ResultItem);
						}
					}
					ResultItem.enchant(Enchantments.SHARPNESS, (int) (CurrentLevel + 1));
					return ResultItem;
				}
				if ((CurrentRecipe).equals("enchantment_thorns")) {
					ResultItem = (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0));
					CurrentLevel = ResultItem.getEnchantmentLevel(Enchantments.THORNS);
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(ResultItem);
						if (_enchantments.containsKey(Enchantments.THORNS)) {
							_enchantments.remove(Enchantments.THORNS);
							EnchantmentHelper.setEnchantments(_enchantments, ResultItem);
						}
					}
					ResultItem.enchant(Enchantments.THORNS, (int) (CurrentLevel + 1));
					return ResultItem;
				}
				if ((CurrentRecipe).equals("enchantment_fire_aspect")) {
					ResultItem = (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0));
					CurrentLevel = ResultItem.getEnchantmentLevel(Enchantments.FIRE_ASPECT);
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(ResultItem);
						if (_enchantments.containsKey(Enchantments.FIRE_ASPECT)) {
							_enchantments.remove(Enchantments.FIRE_ASPECT);
							EnchantmentHelper.setEnchantments(_enchantments, ResultItem);
						}
					}
					ResultItem.enchant(Enchantments.FIRE_ASPECT, (int) (CurrentLevel + 1));
					return ResultItem;
				}
				if ((CurrentRecipe).equals("enchantment_fire_protection")) {
					ResultItem = (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0));
					CurrentLevel = ResultItem.getEnchantmentLevel(Enchantments.FIRE_PROTECTION);
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(ResultItem);
						if (_enchantments.containsKey(Enchantments.FIRE_PROTECTION)) {
							_enchantments.remove(Enchantments.FIRE_PROTECTION);
							EnchantmentHelper.setEnchantments(_enchantments, ResultItem);
						}
					}
					ResultItem.enchant(Enchantments.FIRE_PROTECTION, (int) (CurrentLevel + 1));
					return ResultItem;
				}
				if ((CurrentRecipe).equals("enchantment_protection")) {
					ResultItem = (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0));
					CurrentLevel = ResultItem.getEnchantmentLevel(Enchantments.UNBREAKING);
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(ResultItem);
						if (_enchantments.containsKey(Enchantments.UNBREAKING)) {
							_enchantments.remove(Enchantments.UNBREAKING);
							EnchantmentHelper.setEnchantments(_enchantments, ResultItem);
						}
					}
					ResultItem.enchant(Enchantments.UNBREAKING, (int) (CurrentLevel + 1));
					return ResultItem;
				}
				if ((CurrentRecipe).equals("enchantment_protection")) {
					ResultItem = (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0));
					CurrentLevel = ResultItem.getEnchantmentLevel(Enchantments.ALL_DAMAGE_PROTECTION);
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(ResultItem);
						if (_enchantments.containsKey(Enchantments.ALL_DAMAGE_PROTECTION)) {
							_enchantments.remove(Enchantments.ALL_DAMAGE_PROTECTION);
							EnchantmentHelper.setEnchantments(_enchantments, ResultItem);
						}
					}
					ResultItem.enchant(Enchantments.ALL_DAMAGE_PROTECTION, (int) (CurrentLevel + 1));
					return ResultItem;
				}
				if ((CurrentRecipe).equals("enchantment_salmoran_sting")) {
					ResultItem = (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0));
					CurrentLevel = ResultItem.getEnchantmentLevel(DistantWorldsModEnchantments.SALMORAN_STING.get());
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(ResultItem);
						if (_enchantments.containsKey(DistantWorldsModEnchantments.SALMORAN_STING.get())) {
							_enchantments.remove(DistantWorldsModEnchantments.SALMORAN_STING.get());
							EnchantmentHelper.setEnchantments(_enchantments, ResultItem);
						}
					}
					ResultItem.enchant(DistantWorldsModEnchantments.SALMORAN_STING.get(), (int) (CurrentLevel + 1));
					return ResultItem;
				}
				if ((CurrentRecipe).equals("enchantment_feather_falling")) {
					ResultItem = (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0));
					CurrentLevel = ResultItem.getEnchantmentLevel(Enchantments.FALL_PROTECTION);
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(ResultItem);
						if (_enchantments.containsKey(Enchantments.FALL_PROTECTION)) {
							_enchantments.remove(Enchantments.FALL_PROTECTION);
							EnchantmentHelper.setEnchantments(_enchantments, ResultItem);
						}
					}
					ResultItem.enchant(Enchantments.FALL_PROTECTION, (int) (CurrentLevel + 1));
					return ResultItem;
				}
				if ((CurrentRecipe).equals("enchantment_fortune")) {
					ResultItem = (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0));
					CurrentLevel = ResultItem.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE);
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(ResultItem);
						if (_enchantments.containsKey(Enchantments.BLOCK_FORTUNE)) {
							_enchantments.remove(Enchantments.BLOCK_FORTUNE);
							EnchantmentHelper.setEnchantments(_enchantments, ResultItem);
						}
					}
					ResultItem.enchant(Enchantments.BLOCK_FORTUNE, (int) (CurrentLevel + 1));
					return ResultItem;
				}
				if ((CurrentRecipe).equals("enchantment_projectile_protection")) {
					ResultItem = (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0));
					CurrentLevel = ResultItem.getEnchantmentLevel(Enchantments.PROJECTILE_PROTECTION);
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(ResultItem);
						if (_enchantments.containsKey(Enchantments.PROJECTILE_PROTECTION)) {
							_enchantments.remove(Enchantments.PROJECTILE_PROTECTION);
							EnchantmentHelper.setEnchantments(_enchantments, ResultItem);
						}
					}
					ResultItem.enchant(Enchantments.PROJECTILE_PROTECTION, (int) (CurrentLevel + 1));
					return ResultItem;
				}
				if ((CurrentRecipe).equals("enchantment_blast_protection")) {
					ResultItem = (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0));
					CurrentLevel = ResultItem.getEnchantmentLevel(Enchantments.BLAST_PROTECTION);
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(ResultItem);
						if (_enchantments.containsKey(Enchantments.BLAST_PROTECTION)) {
							_enchantments.remove(Enchantments.BLAST_PROTECTION);
							EnchantmentHelper.setEnchantments(_enchantments, ResultItem);
						}
					}
					ResultItem.enchant(Enchantments.BLAST_PROTECTION, (int) (CurrentLevel + 1));
					return ResultItem;
				}
			}
			{
				CompoundTag _nbtTag = (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getTag();
				if (_nbtTag != null)
					ResultItem.setTag(_nbtTag.copy());
			}
			ResultItem.setDamageValue((int) Math.min(ResultItem.getMaxDamage(), (new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getDamageValue()));
			return ResultItem;
		}
		return ItemStack.EMPTY;
	}
}
