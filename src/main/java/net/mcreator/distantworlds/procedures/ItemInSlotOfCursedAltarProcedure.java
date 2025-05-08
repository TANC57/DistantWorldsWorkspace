package net.mcreator.distantworlds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

public class ItemInSlotOfCursedAltarProcedure {
	public static Entity execute(LevelAccessor world) {
		return world instanceof Level _level ? new ItemEntity(EntityType.ITEM, _level) : null;
	}
}
