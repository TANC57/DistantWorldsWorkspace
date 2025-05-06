package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.entity.AlphaSalmoranEntity;

public class FlyUpOnKeyReleasedProcedure {
	public static void execute(LevelAccessor world, Entity entity, double pressedms) {
		if (entity == null)
			return;
		Entity TargetEntity = null;
		double Power = 0;
		double PassengersNumber = 0;
		double FlyBoost = 0;
		if (entity.isPassenger() && (entity.getVehicle()) instanceof AlphaSalmoranEntity && entity.getVehicle().getFirstPassenger() == entity) {
			TargetEntity = entity.getVehicle();
			Power = Math.round((pressedms * 15) / 1000);
			if (Power > 15) {
				Power = 15;
			}
			PassengersNumber = TargetEntity.getPassengers().size();
			if ((TargetEntity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Stamina) : 0) > 0) {
				if ((TargetEntity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Stamina) : 0) > Power * PassengersNumber) {
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						if (TargetEntity instanceof AlphaSalmoranEntity _datEntSetI)
							_datEntSetI.getEntityData().set(AlphaSalmoranEntity.DATA_Stamina,
									(int) ((TargetEntity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Stamina) : 0) - Power * PassengersNumber));
					}
					TargetEntity.getPersistentData().putDouble("FlyBoost", (Power * 0.1 * 0.75));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(TargetEntity.getX(), TargetEntity.getY(), TargetEntity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.NEUTRAL,
									(float) 0.25, (float) (0.9 + Math.random() * 0.4));
						} else {
							_level.playLocalSound((TargetEntity.getX()), (TargetEntity.getY()), (TargetEntity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.NEUTRAL, (float) 0.25,
									(float) (0.9 + Math.random() * 0.4), false);
						}
					}
				} else {
					TargetEntity.getPersistentData().putDouble("FlyBoost", ((((TargetEntity instanceof AlphaSalmoranEntity _datEntI ? _datEntI.getEntityData().get(AlphaSalmoranEntity.DATA_Stamina) : 0) * 0.1) / PassengersNumber) * 0.75));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(TargetEntity.getX(), TargetEntity.getY(), TargetEntity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.NEUTRAL,
									(float) 0.25, (float) (0.9 + Math.random() * 0.4));
						} else {
							_level.playLocalSound((TargetEntity.getX()), (TargetEntity.getY()), (TargetEntity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.NEUTRAL, (float) 0.25,
									(float) (0.9 + Math.random() * 0.4), false);
						}
					}
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						if (TargetEntity instanceof AlphaSalmoranEntity _datEntSetI)
							_datEntSetI.getEntityData().set(AlphaSalmoranEntity.DATA_Stamina, 0);
					}
				}
			}
		}
	}
}
