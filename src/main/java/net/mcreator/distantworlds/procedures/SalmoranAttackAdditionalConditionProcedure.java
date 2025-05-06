package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.entity.SalmoranEntity;
import net.mcreator.distantworlds.entity.AlphaSalmoranEntity;

public class SalmoranAttackAdditionalConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		double Behavior = 0;
		double BabyAge = 0;
		if (entity instanceof AlphaSalmoranEntity) {
			Behavior = entity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Behavior) : 0;
			Behavior = 0;
		} else if (entity instanceof SalmoranEntity) {
			Behavior = entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_Behavior) : 0;
			BabyAge = entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_BabyAge) : 0;
		}
		return !(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) || Behavior != 2 && BabyAge <= 0
				&& !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof TamableAnimal _tamIsTamedBy && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt
						? _tamIsTamedBy.isOwnedBy(_livEnt)
						: false)
				&& !entity.isVehicle();
	}
}
