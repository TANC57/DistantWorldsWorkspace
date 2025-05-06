package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.entity.NoarhornEntity;
import net.mcreator.distantworlds.entity.ArmoredNoarhornEntity;

public class NoarhornAttackAdditionalConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		double Behavior = 0;
		double BabyAge = 0;
		if (entity instanceof NoarhornEntity) {
			Behavior = entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_Behavior) : 0;
			BabyAge = entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_BabyAge) : 0;
		} else if (entity instanceof ArmoredNoarhornEntity) {
			Behavior = entity instanceof ArmoredNoarhornEntity _datEntI ? _datEntI.getEntityData().get(ArmoredNoarhornEntity.DATA_Behavior) : 0;
			BabyAge = entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_BabyAge) : 0;
		}
		return !(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) || Behavior != 2 && BabyAge <= 0
				&& !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof TamableAnimal _tamIsTamedBy && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt
						? _tamIsTamedBy.isOwnedBy(_livEnt)
						: false)
				&& !entity.isVehicle();
	}
}
