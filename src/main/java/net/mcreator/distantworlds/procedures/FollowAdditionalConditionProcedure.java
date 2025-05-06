package net.mcreator.distantworlds.procedures;

import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.entity.SalmoranEntity;
import net.mcreator.distantworlds.entity.NoarhornEntity;
import net.mcreator.distantworlds.entity.BabySalmoranEntity;
import net.mcreator.distantworlds.entity.BabyNoarhornEntity;
import net.mcreator.distantworlds.entity.ArmoredNoarhornEntity;
import net.mcreator.distantworlds.entity.AlphaSalmoranEntity;

public class FollowAdditionalConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		double Behavior = 0;
		if (entity instanceof BabyNoarhornEntity) {
			Behavior = entity instanceof BabyNoarhornEntity _datEntI ? _datEntI.getEntityData().get(BabyNoarhornEntity.DATA_Behavior) : 0;
		} else if (entity instanceof NoarhornEntity) {
			Behavior = entity instanceof NoarhornEntity _datEntI ? _datEntI.getEntityData().get(NoarhornEntity.DATA_Behavior) : 0;
		} else if (entity instanceof ArmoredNoarhornEntity) {
			Behavior = entity instanceof ArmoredNoarhornEntity _datEntI ? _datEntI.getEntityData().get(ArmoredNoarhornEntity.DATA_Behavior) : 0;
		} else if (entity instanceof BabySalmoranEntity) {
			Behavior = entity instanceof BabySalmoranEntity _datEntI ? _datEntI.getEntityData().get(BabySalmoranEntity.DATA_Behavior) : 0;
		} else if (entity instanceof SalmoranEntity) {
			Behavior = entity instanceof SalmoranEntity _datEntI ? _datEntI.getEntityData().get(SalmoranEntity.DATA_Behavior) : 0;
		} else if (entity instanceof AlphaSalmoranEntity) {
			Behavior = entity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Behavior) : 0;
		}
		return (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entity.isVehicle() && Behavior == 0;
	}
}
