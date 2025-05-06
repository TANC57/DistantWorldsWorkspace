package net.mcreator.distantworlds.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;

import net.mcreator.distantworlds.init.DistantWorldsModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityAttackedWithNoarhornGlovesProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, world, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (sourceentity instanceof LivingEntity && !(entity == sourceentity) && immediatesourceentity == sourceentity) {
				if (sourceentity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(DistantWorldsModItems.NOARHORN_GLOVES.get(), lv).isPresent() : false ? true : false) {
					if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						if (sourceentity instanceof LivingEntity lv) {
							CuriosApi.getCuriosHelper().findCurios(lv, DistantWorldsModItems.NOARHORN_GLOVES.get()).forEach(item -> {
								ItemStack itemstackiterator = item.stack();
								{
									ItemStack _ist = itemstackiterator;
									if (_ist.hurt(1, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
							});
						}
					}
				}
			}
		}
	}
}
