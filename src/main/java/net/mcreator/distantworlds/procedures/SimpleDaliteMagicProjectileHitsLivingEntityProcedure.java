package net.mcreator.distantworlds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.distantworlds.init.DistantWorldsModParticleTypes;
import net.mcreator.distantworlds.entity.SimpleDaliteMagicEntity;

public class SimpleDaliteMagicProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		double PowerBonus = 0;
		double DistanceBonus = 0;
		double BaseDamage = 0;
		double SummaryBonus = 0;
		if (!world.isClientSide()) {
			BaseDamage = immediatesourceentity instanceof SimpleDaliteMagicEntity _datEntI ? _datEntI.getBaseDamage() : 0;
			PowerBonus = immediatesourceentity instanceof SimpleDaliteMagicEntity _datEntI ? _datEntI.getPowerBonus() : 0;
			DistanceBonus = immediatesourceentity instanceof SimpleDaliteMagicEntity _datEntI ? _datEntI.getDistanceBonus() : 0;
			SummaryBonus = BaseDamage * PowerBonus + BaseDamage * Math.max(PowerBonus, 1) * DistanceBonus;
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast_far")),
							SoundSource.AMBIENT, (float) 0.8, (float) (1.25 + Math.random() * 0.1));
				} else {
					_level.playLocalSound((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast_far")),
							SoundSource.AMBIENT, (float) 0.8, (float) (1.25 + Math.random() * 0.1), false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (DistantWorldsModParticleTypes.DALITE_ENERGY_PARTICLE.get()), (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()),
						Mth.nextInt(RandomSource.create(), 3, 5), 0.25, 0.25, 0.25, 0.1);
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("distant_worlds:dalite_magic"))), immediatesourceentity,
					sourceentity), (float) Math.floor(SummaryBonus));
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Base Damage: " + BaseDamage)), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Power: " + BaseDamage * PowerBonus)), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Distance: " + BaseDamage * Math.max(PowerBonus, 1) * DistanceBonus)), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Summary Bonus Damage: " + Math.floor(SummaryBonus))), false);
		}
	}
}
