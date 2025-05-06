
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.distantworlds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.distantworlds.entity.WiltumCouchRiddenEntity;
import net.mcreator.distantworlds.entity.ToranEntity;
import net.mcreator.distantworlds.entity.SimpleDaliteMagicEntity;
import net.mcreator.distantworlds.entity.ShrullotEntity;
import net.mcreator.distantworlds.entity.SalmoranEntity;
import net.mcreator.distantworlds.entity.NoarhornEntity;
import net.mcreator.distantworlds.entity.LoteressEntity;
import net.mcreator.distantworlds.entity.LithumTransmitterCrystalEntity;
import net.mcreator.distantworlds.entity.GarsaleCouchRiddenEntity;
import net.mcreator.distantworlds.entity.GarhennaResearchesBookEntity;
import net.mcreator.distantworlds.entity.FraliteBallProjectileEntity;
import net.mcreator.distantworlds.entity.DruthEntity;
import net.mcreator.distantworlds.entity.CulafiteShroomerEntity;
import net.mcreator.distantworlds.entity.CrouthilEntity;
import net.mcreator.distantworlds.entity.BooglianEntity;
import net.mcreator.distantworlds.entity.BabySalmoranEntity;
import net.mcreator.distantworlds.entity.BabyNoarhornEntity;
import net.mcreator.distantworlds.entity.ArmoredNoarhornEntity;
import net.mcreator.distantworlds.entity.AlphaSalmoranEntity;
import net.mcreator.distantworlds.DistantWorldsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DistantWorldsModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DistantWorldsMod.MODID);
	public static final RegistryObject<EntityType<DruthEntity>> DRUTH = register("druth",
			EntityType.Builder.<DruthEntity>of(DruthEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DruthEntity::new).fireImmune().sized(1f, 2.5f));
	public static final RegistryObject<EntityType<CrouthilEntity>> CROUTHIL = register("crouthil",
			EntityType.Builder.<CrouthilEntity>of(CrouthilEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CrouthilEntity::new).fireImmune().sized(0.8f, 1f));
	public static final RegistryObject<EntityType<ShrullotEntity>> SHRULLOT = register("shrullot",
			EntityType.Builder.<ShrullotEntity>of(ShrullotEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShrullotEntity::new).fireImmune().sized(0.8f, 1f));
	public static final RegistryObject<EntityType<BooglianEntity>> BOOGLIAN = register("booglian",
			EntityType.Builder.<BooglianEntity>of(BooglianEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BooglianEntity::new).fireImmune().sized(1f, 0.6f));
	public static final RegistryObject<EntityType<CulafiteShroomerEntity>> CULAFITE_SHROOMER = register("culafite_shroomer",
			EntityType.Builder.<CulafiteShroomerEntity>of(CulafiteShroomerEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CulafiteShroomerEntity::new)

					.sized(0.8f, 1f));
	public static final RegistryObject<EntityType<BabyNoarhornEntity>> BABY_NOARHORN = register("baby_noarhorn",
			EntityType.Builder.<BabyNoarhornEntity>of(BabyNoarhornEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BabyNoarhornEntity::new)

					.sized(0.6f, 0.4f));
	public static final RegistryObject<EntityType<NoarhornEntity>> NOARHORN = register("noarhorn",
			EntityType.Builder.<NoarhornEntity>of(NoarhornEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NoarhornEntity::new)

					.sized(0.9f, 0.7f));
	public static final RegistryObject<EntityType<ArmoredNoarhornEntity>> ARMORED_NOARHORN = register("armored_noarhorn",
			EntityType.Builder.<ArmoredNoarhornEntity>of(ArmoredNoarhornEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ArmoredNoarhornEntity::new)

					.sized(0.9f, 0.7f));
	public static final RegistryObject<EntityType<BabySalmoranEntity>> BABY_SALMORAN = register("baby_salmoran",
			EntityType.Builder.<BabySalmoranEntity>of(BabySalmoranEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BabySalmoranEntity::new)

					.sized(0.5f, 0.4f));
	public static final RegistryObject<EntityType<SalmoranEntity>> SALMORAN = register("salmoran",
			EntityType.Builder.<SalmoranEntity>of(SalmoranEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SalmoranEntity::new)

					.sized(0.7f, 2f));
	public static final RegistryObject<EntityType<AlphaSalmoranEntity>> ALPHA_SALMORAN = register("alpha_salmoran",
			EntityType.Builder.<AlphaSalmoranEntity>of(AlphaSalmoranEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AlphaSalmoranEntity::new)

					.sized(0.9f, 2.2f));
	public static final RegistryObject<EntityType<ToranEntity>> TORAN = register("toran",
			EntityType.Builder.<ToranEntity>of(ToranEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ToranEntity::new).fireImmune().sized(1f, 2.3f));
	public static final RegistryObject<EntityType<LoteressEntity>> LOTERESS = register("loteress",
			EntityType.Builder.<LoteressEntity>of(LoteressEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LoteressEntity::new).fireImmune().sized(0.7f, 0.8f));
	public static final RegistryObject<EntityType<GarhennaResearchesBookEntity>> GARHENNA_RESEARCHES_BOOK = register("garhenna_researches_book",
			EntityType.Builder.<GarhennaResearchesBookEntity>of(GarhennaResearchesBookEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(GarhennaResearchesBookEntity::new).fireImmune().sized(0.3f, 0.5f));
	public static final RegistryObject<EntityType<LithumTransmitterCrystalEntity>> LITHUM_TRANSMITTER_CRYSTAL = register("lithum_transmitter_crystal",
			EntityType.Builder.<LithumTransmitterCrystalEntity>of(LithumTransmitterCrystalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(LithumTransmitterCrystalEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<GarsaleCouchRiddenEntity>> GARSALE_COUCH_RIDDEN = register("garsale_couch_ridden", EntityType.Builder.<GarsaleCouchRiddenEntity>of(GarsaleCouchRiddenEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GarsaleCouchRiddenEntity::new).fireImmune().sized(0.6f, 0.3f));
	public static final RegistryObject<EntityType<WiltumCouchRiddenEntity>> WILTUM_COUCH_RIDDEN = register("wiltum_couch_ridden", EntityType.Builder.<WiltumCouchRiddenEntity>of(WiltumCouchRiddenEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WiltumCouchRiddenEntity::new).fireImmune().sized(0.1f, 1f));
	public static final RegistryObject<EntityType<FraliteBallProjectileEntity>> FRALITE_BALL_PROJECTILE = register("projectile_fralite_ball_projectile",
			EntityType.Builder.<FraliteBallProjectileEntity>of(FraliteBallProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(FraliteBallProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SimpleDaliteMagicEntity>> SIMPLE_DALITE_MAGIC = register("projectile_simple_dalite_magic", EntityType.Builder.<SimpleDaliteMagicEntity>of(SimpleDaliteMagicEntity::new, MobCategory.MISC)
			.setCustomClientFactory(SimpleDaliteMagicEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			DruthEntity.init();
			CrouthilEntity.init();
			ShrullotEntity.init();
			BooglianEntity.init();
			CulafiteShroomerEntity.init();
			BabyNoarhornEntity.init();
			NoarhornEntity.init();
			ArmoredNoarhornEntity.init();
			BabySalmoranEntity.init();
			SalmoranEntity.init();
			AlphaSalmoranEntity.init();
			ToranEntity.init();
			LoteressEntity.init();
			GarhennaResearchesBookEntity.init();
			LithumTransmitterCrystalEntity.init();
			GarsaleCouchRiddenEntity.init();
			WiltumCouchRiddenEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(DRUTH.get(), DruthEntity.createAttributes().build());
		event.put(CROUTHIL.get(), CrouthilEntity.createAttributes().build());
		event.put(SHRULLOT.get(), ShrullotEntity.createAttributes().build());
		event.put(BOOGLIAN.get(), BooglianEntity.createAttributes().build());
		event.put(CULAFITE_SHROOMER.get(), CulafiteShroomerEntity.createAttributes().build());
		event.put(BABY_NOARHORN.get(), BabyNoarhornEntity.createAttributes().build());
		event.put(NOARHORN.get(), NoarhornEntity.createAttributes().build());
		event.put(ARMORED_NOARHORN.get(), ArmoredNoarhornEntity.createAttributes().build());
		event.put(BABY_SALMORAN.get(), BabySalmoranEntity.createAttributes().build());
		event.put(SALMORAN.get(), SalmoranEntity.createAttributes().build());
		event.put(ALPHA_SALMORAN.get(), AlphaSalmoranEntity.createAttributes().build());
		event.put(TORAN.get(), ToranEntity.createAttributes().build());
		event.put(LOTERESS.get(), LoteressEntity.createAttributes().build());
		event.put(GARHENNA_RESEARCHES_BOOK.get(), GarhennaResearchesBookEntity.createAttributes().build());
		event.put(LITHUM_TRANSMITTER_CRYSTAL.get(), LithumTransmitterCrystalEntity.createAttributes().build());
		event.put(GARSALE_COUCH_RIDDEN.get(), GarsaleCouchRiddenEntity.createAttributes().build());
		event.put(WILTUM_COUCH_RIDDEN.get(), WiltumCouchRiddenEntity.createAttributes().build());
	}
}
