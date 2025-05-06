package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.distantworlds.init.DistantWorldsModItems;
import net.mcreator.distantworlds.init.DistantWorldsModEnchantments;
import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;

import java.util.concurrent.atomic.AtomicReference;

public class LithumStructureRecipePickerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean Successful = false;
		ItemStack itemstack6 = ItemStack.EMPTY;
		ItemStack itemstack5 = ItemStack.EMPTY;
		ItemStack itemstack8 = ItemStack.EMPTY;
		ItemStack itemstack7 = ItemStack.EMPTY;
		ItemStack itemstack2 = ItemStack.EMPTY;
		ItemStack itemstack1 = ItemStack.EMPTY;
		ItemStack itemstack4 = ItemStack.EMPTY;
		ItemStack itemstack3 = ItemStack.EMPTY;
		double Loop = 0;
		double xOffset = 0;
		double EmptyItemstack = 0;
		double zOffset = 0;
		double XPLevel = 0;
		String summ = "";
		String result = "";
		if (!world.isClientSide()) {
			for (int index0 = 0; index0 < 8; index0++) {
				if (Loop == 0) {
					xOffset = -2;
					zOffset = -1;
				} else if (Loop == 1) {
					xOffset = -1;
					zOffset = -2;
				} else if (Loop == 2) {
					xOffset = 1;
					zOffset = -2;
				} else if (Loop == 3) {
					xOffset = 2;
					zOffset = -1;
				} else if (Loop == 4) {
					xOffset = 2;
					zOffset = 1;
				} else if (Loop == 5) {
					xOffset = 1;
					zOffset = 2;
				} else if (Loop == 6) {
					xOffset = -1;
					zOffset = 2;
				} else {
					xOffset = -2;
					zOffset = 1;
				}
				if (!((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0)).getItem() == ItemStack.EMPTY.getItem())) {
					if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0)).getItem() == itemstack1.getItem()) {
						itemstack1.setCount((int) (itemstack1.getCount() + 1));
					} else if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0)).getItem() == itemstack2.getItem()) {
						itemstack2.setCount((int) (itemstack2.getCount() + 1));
					} else if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0)).getItem() == itemstack3.getItem()) {
						itemstack3.setCount((int) (itemstack3.getCount() + 1));
					} else if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0)).getItem() == itemstack4.getItem()) {
						itemstack4.setCount((int) (itemstack4.getCount() + 1));
					} else if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0)).getItem() == itemstack5.getItem()) {
						itemstack5.setCount((int) (itemstack5.getCount() + 1));
					} else if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0)).getItem() == itemstack6.getItem()) {
						itemstack6.setCount((int) (itemstack6.getCount() + 1));
					} else if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0)).getItem() == itemstack7.getItem()) {
						itemstack7.setCount((int) (itemstack7.getCount() + 1));
					} else if (itemstack1.getItem() == ItemStack.EMPTY.getItem()) {
						itemstack1 = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0));
					} else if (itemstack2.getItem() == ItemStack.EMPTY.getItem()) {
						itemstack2 = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0));
					} else if (itemstack3.getItem() == ItemStack.EMPTY.getItem()) {
						itemstack3 = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0));
					} else if (itemstack4.getItem() == ItemStack.EMPTY.getItem()) {
						itemstack4 = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0));
					} else if (itemstack5.getItem() == ItemStack.EMPTY.getItem()) {
						itemstack5 = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0));
					} else if (itemstack6.getItem() == ItemStack.EMPTY.getItem()) {
						itemstack6 = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0));
					} else if (itemstack7.getItem() == ItemStack.EMPTY.getItem()) {
						itemstack7 = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0));
					} else {
						itemstack8 = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 0));
					}
				} else {
					EmptyItemstack = EmptyItemstack + 1;
				}
				Loop = Loop + 1;
			}
			if (!(itemstack1.getItem() == ItemStack.EMPTY.getItem())) {
				summ = summ + "" + (itemstack1 + " ");
			}
			if (!(itemstack2.getItem() == ItemStack.EMPTY.getItem())) {
				summ = summ + "" + (itemstack2 + " ");
			}
			if (!(itemstack3.getItem() == ItemStack.EMPTY.getItem())) {
				summ = summ + "" + (itemstack3 + " ");
			}
			if (!(itemstack4.getItem() == ItemStack.EMPTY.getItem())) {
				summ = summ + "" + (itemstack4 + " ");
			}
			if (!(itemstack5.getItem() == ItemStack.EMPTY.getItem())) {
				summ = summ + "" + (itemstack5 + " ");
			}
			if (!(itemstack6.getItem() == ItemStack.EMPTY.getItem())) {
				summ = summ + "" + (itemstack6 + " ");
			}
			if (!(itemstack7.getItem() == ItemStack.EMPTY.getItem())) {
				summ = summ + "" + (itemstack7 + " ");
			}
			if (!(itemstack8.getItem() == ItemStack.EMPTY.getItem())) {
				summ = summ + "" + (itemstack8 + " ");
			}
			if (summ.contains((new ItemStack(DistantWorldsModItems.FIRON_INGOT.get()).copy() + "").replace("1", "4")) && EmptyItemstack == 4) {
				if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.NETHERITE_SWORD) {
					result = "firon_sword";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.NETHERITE_PICKAXE) {
					result = "firon_pickaxe";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.NETHERITE_AXE) {
					result = "firon_axe";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.NETHERITE_SHOVEL) {
					result = "firon_shovel";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.NETHERITE_HOE) {
					result = "firon_hoe";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.NETHERITE_HELMET) {
					result = "firon_helmet";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.NETHERITE_CHESTPLATE) {
					result = "firon_chestplate";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.NETHERITE_LEGGINGS) {
					result = "firon_leggings";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.NETHERITE_BOOTS) {
					result = "firon_boots";
				}
			}
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.FIRON_INGOT.get()) {
				if (summ.contains(new ItemStack(DistantWorldsModItems.FIRON_SWORD.get()).copy() + "") && summ.contains(new ItemStack(DistantWorldsModItems.FIRON_PICKAXE.get()).copy() + "")
						&& summ.contains(new ItemStack(DistantWorldsModItems.FIRON_AXE.get()).copy() + "") && summ.contains(new ItemStack(DistantWorldsModItems.FIRON_SHOVEL.get()).copy() + "")
						&& summ.contains(new ItemStack(DistantWorldsModItems.FIRON_HOE.get()).copy() + "") && EmptyItemstack == 3) {
					result = "firon_multitool";
				}
			}
			if (summ.contains((new ItemStack(DistantWorldsModItems.HELYST_CRYSTAL.get()).copy() + "").replace("1", "4")) && EmptyItemstack == 4) {
				if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.LITHUM_SWORD.get()) {
					result = "helyst_sword";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.LITHUM_PICKAXE.get()) {
					result = "helyst_pickaxe";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.LITHUM_AXE.get()) {
					result = "helyst_axe";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.LITHUM_SHOVEL.get()) {
					result = "helyst_shovel";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.LITHUM_HOE.get()) {
					result = "helyst_hoe";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.SALMORAN_ARMOR_HELMET.get()) {
					result = "helyst_helmet";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.SALMORAN_ARMOR_CHESTPLATE.get()) {
					result = "helyst_chestplate";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.SALMORAN_ARMOR_LEGGINGS.get()) {
					result = "helyst_leggings";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.SALMORAN_ARMOR_BOOTS.get()) {
					result = "helyst_boots";
				}
			}
			if (summ.contains((new ItemStack(DistantWorldsModItems.VAIRIS_CRYSTAL.get()).copy() + "").replace("1", "4")) && EmptyItemstack == 4) {
				if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.DIAMOND_HELMET) {
					result = "vairis_helmet";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.DIAMOND_CHESTPLATE) {
					result = "vairis_chestplate";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.DIAMOND_LEGGINGS) {
					result = "vairis_leggings";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.DIAMOND_BOOTS) {
					result = "vairis_boots";
				}
			}
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.VAIRIS_CRYSTAL.get()) {
				if (summ.contains((new ItemStack(DistantWorldsModItems.VAIRIS_CRYSTAL.get()).copy() + "").replace("1", "3")) && summ.contains((new ItemStack(Items.STICK).copy() + "").replace("1", "2")) && EmptyItemstack == 3) {
					result = "vairis_sword";
				}
			}
			if (summ.contains((new ItemStack(DistantWorldsModItems.UBRICITE_INGOT.get()).copy() + "").replace("1", "6")) && EmptyItemstack == 2) {
				if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.IRON_HELMET) {
					result = "ubricite_helmet";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.IRON_CHESTPLATE) {
					result = "ubricite_chestplate";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.IRON_LEGGINGS) {
					result = "ubricite_leggings";
				} else if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.IRON_BOOTS) {
					result = "ubricite_boots";
				}
			}
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.UBRICITE_INGOT.get()) {
				if (summ.contains((new ItemStack(DistantWorldsModItems.UBRICITE_INGOT.get()).copy() + "").replace("1", "4")) && summ.contains((new ItemStack(Items.STICK).copy() + "").replace("1", "2")) && EmptyItemstack == 2) {
					result = "ubricite_hammer";
				}
			}
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == DistantWorldsModItems.MODULE_EMPTY.get()) {
				if (summ.contains((new ItemStack(DistantWorldsModItems.CURELITE.get()).copy() + "").replace("1", "5")) && EmptyItemstack == 2) {
					if (summ.contains(new ItemStack(Blocks.BLAST_FURNACE).copy() + "")) {
						result = "module_calm_flame";
					} else if (summ.contains(new ItemStack(Blocks.REDSTONE_BLOCK).copy() + "")) {
						result = "module_calm_spark";
					} else if (summ.contains(new ItemStack(Items.BLAZE_POWDER).copy() + "")) {
						result = "module_charmed_pedestal";
					} else if (summ.contains(new ItemStack(Items.END_CRYSTAL).copy() + "")) {
						result = "module_flow_filter";
					} else if (summ.contains(new ItemStack(Blocks.ANVIL).copy() + "")) {
						result = "module_core_stabilization";
					}
				} else if (summ.contains((new ItemStack(DistantWorldsModItems.DALITE_CRYSTAL.get()).copy() + "").replace("1", "5")) && EmptyItemstack == 2) {
					if (summ.contains(new ItemStack(Blocks.BLAST_FURNACE).copy() + "")) {
						result = "module_raging_flame";
					} else if (summ.contains(new ItemStack(Blocks.REDSTONE_BLOCK).copy() + "")) {
						result = "module_raging_spark";
					} else if (summ.contains(new ItemStack(Blocks.ENDER_CHEST).copy() + "")) {
						result = "module_increased_storage";
					} else if (summ.contains(new ItemStack(Items.END_CRYSTAL).copy() + "")) {
						result = "module_flow_amplification";
					} else if (summ.contains(new ItemStack(Blocks.ANVIL).copy() + "")) {
						result = "module_core_destabilization";
					}
				}
			}
			if (summ.contains((new ItemStack(Items.LAPIS_LAZULI).copy() + "").replace("1", "4"))) {
				if (summ.contains((new ItemStack(DistantWorldsModItems.NOARHORN_SPIKE.get()).copy() + "").replace("1", "4"))) {
					if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0))) != 0 && (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.SHARPNESS) < 7) {
						XPLevel = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.SHARPNESS) * 5 * Math.abs((double) ConfigCommonConfiguration.REQUIRED_EXPERIENCE_MODIFIER.get());
						if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= XPLevel || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(-((int) XPLevel));
							}
							result = "enchantment_sharpness";
						} else {
							result = "!NoXp";
						}
					} else if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.THORNS, (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0))) != 0 && (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.THORNS) < 5) {
						XPLevel = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.THORNS) * 5 * Math.abs((double) ConfigCommonConfiguration.REQUIRED_EXPERIENCE_MODIFIER.get());
						if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= XPLevel || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(-((int) XPLevel));
							}
							result = "enchantment_thorns";
						} else {
							result = "!NoXp";
						}
					}
				}
				if (summ.contains((new ItemStack(DistantWorldsModItems.FRALITE_HEART.get()).copy() + "").replace("1", "2")) && summ.contains((new ItemStack(DistantWorldsModItems.MOLTEN_FRALITE.get()).copy() + "").replace("1", "2"))) {
					if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_ASPECT, (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0))) != 0 && (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.FIRE_ASPECT) < 4) {
						XPLevel = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.FIRE_ASPECT) * 5 * Math.abs((double) ConfigCommonConfiguration.REQUIRED_EXPERIENCE_MODIFIER.get());
						if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= XPLevel || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(-((int) XPLevel));
							}
							result = "enchantment_fire_aspect";
						} else {
							result = "!NoXp";
						}
					} else if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_PROTECTION, (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0))) != 0 && (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.FIRE_PROTECTION) < 6) {
						XPLevel = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.FIRE_PROTECTION) * 5 * Math.abs((double) ConfigCommonConfiguration.REQUIRED_EXPERIENCE_MODIFIER.get());
						if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= XPLevel || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(-((int) XPLevel));
							}
							result = "enchantment_fire_protection";
						} else {
							result = "!NoXp";
						}
					}
				}
				if (summ.contains((new ItemStack(DistantWorldsModItems.FRALITE_BALL.get()).copy() + "").replace("1", "4"))) {
					if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PROJECTILE_PROTECTION, (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0))) != 0 && (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.PROJECTILE_PROTECTION) < 6) {
						XPLevel = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.PROJECTILE_PROTECTION) * 5 * Math.abs((double) ConfigCommonConfiguration.REQUIRED_EXPERIENCE_MODIFIER.get());
						if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= XPLevel || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(-((int) XPLevel));
							}
							result = "enchantment_projectile_protection";
						} else {
							result = "!NoXp";
						}
					} else if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLAST_PROTECTION, (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0))) != 0 && (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.BLAST_PROTECTION) < 6) {
						XPLevel = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.BLAST_PROTECTION) * 5 * Math.abs((double) ConfigCommonConfiguration.REQUIRED_EXPERIENCE_MODIFIER.get());
						if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= XPLevel || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(-((int) XPLevel));
							}
							result = "enchantment_blast_protection";
						} else {
							result = "!NoXp";
						}
					}
				}
				if (summ.contains((new ItemStack(DistantWorldsModItems.UBRICITE_INGOT.get()).copy() + "").replace("1", "4"))) {
					if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.UNBREAKING, (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0))) != 0 && (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.UNBREAKING) < 5) {
						XPLevel = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.UNBREAKING) * 5 * Math.abs((double) ConfigCommonConfiguration.REQUIRED_EXPERIENCE_MODIFIER.get());
						if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= XPLevel || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(-((int) XPLevel));
							}
							result = "enchantment_unbreaking";
						} else {
							result = "!NoXp";
						}
					} else if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.ALL_DAMAGE_PROTECTION, (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0))) != 0 && (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.ALL_DAMAGE_PROTECTION) < 6) {
						XPLevel = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.ALL_DAMAGE_PROTECTION) * 5 * Math.abs((double) ConfigCommonConfiguration.REQUIRED_EXPERIENCE_MODIFIER.get());
						if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= XPLevel || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(-((int) XPLevel));
							}
							result = "enchantment_protection";
						} else {
							result = "!NoXp";
						}
					}
				}
				if (summ.contains((new ItemStack(DistantWorldsModItems.SALMORAN_EYE.get()).copy() + "").replace("1", "2")) && summ.contains((new ItemStack(DistantWorldsModItems.SALMORAN_SCALES.get()).copy() + "").replace("1", "2"))) {
					if (EnchantmentHelper.getItemEnchantmentLevel(DistantWorldsModEnchantments.SALMORAN_STING.get(), (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0))) != 0 && (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(DistantWorldsModEnchantments.SALMORAN_STING.get()) < 5) {
						XPLevel = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(DistantWorldsModEnchantments.SALMORAN_STING.get()) * 5 * Math.abs((double) ConfigCommonConfiguration.REQUIRED_EXPERIENCE_MODIFIER.get());
						if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= XPLevel || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(-((int) XPLevel));
							}
							result = "enchantment_salmoran_sting";
						} else {
							result = "!NoXp";
						}
					}
				}
				if (summ.contains((new ItemStack(DistantWorldsModItems.GLOWING_POLLEN.get()).copy() + "").replace("1", "4"))) {
					if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0))) != 0 && (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.BLOCK_FORTUNE) < 5) {
						XPLevel = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.BLOCK_FORTUNE) * 5 * Math.abs((double) ConfigCommonConfiguration.REQUIRED_EXPERIENCE_MODIFIER.get());
						if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= XPLevel || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(-((int) XPLevel));
							}
							result = "enchantment_fortune";
						} else {
							result = "!NoXp";
						}
					} else if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FALL_PROTECTION, (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0))) != 0 && (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.FALL_PROTECTION) < 6) {
						XPLevel = (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getEnchantmentLevel(Enchantments.FALL_PROTECTION) * 5 * Math.abs((double) ConfigCommonConfiguration.REQUIRED_EXPERIENCE_MODIFIER.get());
						if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= XPLevel || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(-((int) XPLevel));
							}
							result = "enchantment_feather_falling";
						} else {
							result = "!NoXp";
						}
					}
				}
			}
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				if (result.contains("firon")) {
					if (!(entity instanceof ServerPlayer _plr286 && _plr286.level() instanceof ServerLevel
							&& _plr286.getAdvancements().getOrStartProgress(_plr286.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:incandescent_forever"))).isDone())) {
						result = "!NoAdv";
					}
				} else if (result.contains("helyst")) {
					if (!(entity instanceof ServerPlayer _plr287 && _plr287.level() instanceof ServerLevel
							&& _plr287.getAdvancements().getOrStartProgress(_plr287.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:encased_soul"))).isDone())) {
						result = "!NoAdv";
					}
				} else if (result.contains("vairis")) {
					if (!(entity instanceof ServerPlayer _plr288 && _plr288.level() instanceof ServerLevel
							&& _plr288.getAdvancements().getOrStartProgress(_plr288.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:living_metal"))).isDone())) {
						result = "!NoAdv";
					}
				} else if (result.contains("ubricite")) {
					if (!(entity instanceof ServerPlayer _plr289 && _plr289.level() instanceof ServerLevel
							&& _plr289.getAdvancements().getOrStartProgress(_plr289.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:strong_shell"))).isDone())) {
						result = "!NoAdv";
					}
				} else if (result.contains("enchantment")) {
					if (!(entity instanceof ServerPlayer _plr290 && _plr290.level() instanceof ServerLevel
							&& _plr290.getAdvancements().getOrStartProgress(_plr290.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:story/enchant_item"))).isDone())) {
						result = "!NoAdv";
					}
				}
			}
			if ((result).equals("")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.lithum_multiblock.norecipe").getString())), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			} else if (result.contains("!NoAdv")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("event.distant_worlds.lithum_multiblock.noadv").getString())), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			} else if (result.contains("!NoXp")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(((Component.translatable("event.distant_worlds.lithum_multiblock.noxp").getString()).replace("%1", new java.text.DecimalFormat("##").format(XPLevel)))), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putString("CurrentRecipe", result);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				Loop = 0;
				if (!world.isClientSide()) {
					for (int index1 = 0; index1 < 8; index1++) {
						if (Loop == 0) {
							xOffset = -2;
							zOffset = -1;
						} else if (Loop == 1) {
							xOffset = -1;
							zOffset = -2;
						} else if (Loop == 2) {
							xOffset = 1;
							zOffset = -2;
						} else if (Loop == 3) {
							xOffset = 2;
							zOffset = -1;
						} else if (Loop == 4) {
							xOffset = 2;
							zOffset = 1;
						} else if (Loop == 5) {
							xOffset = 1;
							zOffset = 2;
						} else if (Loop == 6) {
							xOffset = -1;
							zOffset = 2;
						} else {
							xOffset = -2;
							zOffset = 1;
						}
						if ((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
								return _retval.get();
							}
						}.getItemStack(world, BlockPos.containing(x + xOffset, y, z + zOffset), 1)).getItem() == DistantWorldsModItems.MODULE_CHARMED_PEDESTAL.get()) {
							if (Math.random() < 0.9) {
								{
									BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x + xOffset, y, z + zOffset));
									if (_ent != null) {
										final int _slotid = 0;
										final int _amount = 1;
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
											if (capability instanceof IItemHandlerModifiable) {
												ItemStack _stk = capability.getStackInSlot(_slotid).copy();
												_stk.shrink(_amount);
												((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
											}
										});
									}
								}
							}
						} else {
							{
								BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x + xOffset, y, z + zOffset));
								if (_ent != null) {
									final int _slotid = 0;
									final int _amount = 1;
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable) {
											ItemStack _stk = capability.getStackInSlot(_slotid).copy();
											_stk.shrink(_amount);
											((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
										}
									});
								}
							}
						}
						Loop = Loop + 1;
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.power_select")), SoundSource.BLOCKS, 1, (float) (1 + Math.random() * 0.2));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.power_select")), SoundSource.BLOCKS, 1, (float) (1 + Math.random() * 0.2), false);
					}
				}
				if (!(entity instanceof ServerPlayer _plr307 && _plr307.level() instanceof ServerLevel
						&& _plr307.getAdvancements().getOrStartProgress(_plr307.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:magic_of_stones_and_crystals"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("distant_worlds:magic_of_stones_and_crystals"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		}
	}
}
