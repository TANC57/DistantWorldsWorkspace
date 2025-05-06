package net.mcreator.distantworlds.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigCommonConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GRANT_GUIDE_BOOKS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> REQUIRE_DIMENSION;
	public static final ForgeConfigSpec.ConfigValue<Double> GARHENNA_TELEPORTATION_HEIGHT;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ALLOW_PORTALS;
	public static final ForgeConfigSpec.ConfigValue<Double> RESEARCH_TIME_MODIFIER;
	public static final ForgeConfigSpec.ConfigValue<Double> RESEARCH_EXPERIENCE_REWARD_MODIFIER;
	public static final ForgeConfigSpec.ConfigValue<Double> REQUIRED_ENERGY_MODIFIER;
	public static final ForgeConfigSpec.ConfigValue<Double> REQUIRED_EXPERIENCE_MODIFIER;
	public static final ForgeConfigSpec.ConfigValue<Double> RECOVERY_MODIFIER;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DISABLE_GARHENNA_DEPLETION;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_GARHENNA_DEPLETION;
	static {
		BUILDER.push("Main");
		GRANT_GUIDE_BOOKS = BUILDER.comment("If enabled, you will receive guide books during the game").define("Grant Guide Books", true);
		BUILDER.pop();
		BUILDER.push("Teleportation");
		REQUIRE_DIMENSION = BUILDER.comment("If enabled, teleporting to mod dimensions can only be done from a certain other dimension").define("Require Dimension", true);
		GARHENNA_TELEPORTATION_HEIGHT = BUILDER.comment("Maximum height required for teleportation to Garhenna dimension (Null value allows any)").define("Garhenna Teleportation Height", (double) 6);
		ALLOW_PORTALS = BUILDER.comment("Allows players to teleport to other dimensions from the mod's dimensions").define("Allow Portals", false);
		BUILDER.pop();
		BUILDER.push("Researches");
		RESEARCH_TIME_MODIFIER = BUILDER.comment("Modifier for the time required for one research attempt").define("Research Time Modifier", (double) 1);
		RESEARCH_EXPERIENCE_REWARD_MODIFIER = BUILDER.comment("Modifier of experience gained after completing research").define("Research Experience Reward Modifier", (double) 1);
		BUILDER.pop();
		BUILDER.push("Rituals");
		REQUIRED_ENERGY_MODIFIER = BUILDER.comment("Modifier of the energy required for the ritual").define("Required Energy Modifier", (double) 1);
		REQUIRED_EXPERIENCE_MODIFIER = BUILDER.comment("Modifier for the experience levels required for the ritual").define("Required Experience Modifier", (double) 1);
		RECOVERY_MODIFIER = BUILDER.comment("Modifier of recovery after ritual").define("Recovery Modifier", (double) 1);
		BUILDER.pop();
		BUILDER.push("Garhenna");
		DISABLE_GARHENNA_DEPLETION = BUILDER.comment("Garhenna Depletion effect will not be applied to you in this dimension").define("Disable Garhenna Depletion", false);
		MAX_GARHENNA_DEPLETION = BUILDER.comment("Maximum number of Garhenna Depletion points at which player dies. Other negative effects will also be applied depending on this value").define("Max Garhenna Depletion", (double) 20000);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
