package net.mcreator.distantworlds.procedures;

import net.mcreator.distantworlds.configuration.ConfigCommonConfiguration;
import net.mcreator.distantworlds.DistantWorldsMod;

public class ConfigWarningProcedure {
	public static void execute() {
		if ((double) ConfigCommonConfiguration.RESEARCH_TIME_MODIFIER.get() < 0) {
			DistantWorldsMod.LOGGER.error(("[Distant Worlds] Your config has an incorrect value! (Location: \"distantworlds-common/research_time_modifier\") (Edited value: " + ""
					+ ((double) ConfigCommonConfiguration.RESEARCH_TIME_MODIFIER.get() + "" + (" => " + (Math.abs((double) ConfigCommonConfiguration.RESEARCH_TIME_MODIFIER.get()) + ")")))));
		}
		if ((double) ConfigCommonConfiguration.RESEARCH_EXPERIENCE_REWARD_MODIFIER.get() < 0) {
			DistantWorldsMod.LOGGER.error(("[Distant Worlds] Your config has an incorrect value! (Location: \"distantworlds-common/research_experience_reward_modifier\") (Edited value: " + ""
					+ ((double) ConfigCommonConfiguration.RESEARCH_EXPERIENCE_REWARD_MODIFIER.get() + "" + (" => " + (Math.abs((double) ConfigCommonConfiguration.RESEARCH_EXPERIENCE_REWARD_MODIFIER.get()) + ")")))));
		}
		if ((double) ConfigCommonConfiguration.REQUIRED_ENERGY_MODIFIER.get() < 0) {
			DistantWorldsMod.LOGGER.error(("[Distant Worlds] Your config has an incorrect value! (Location: \"distantworlds-common/required_energy_modifier\") (Edited value: " + ""
					+ ((double) ConfigCommonConfiguration.REQUIRED_ENERGY_MODIFIER.get() + "" + (" => " + (Math.abs((double) ConfigCommonConfiguration.REQUIRED_ENERGY_MODIFIER.get()) + ")")))));
		}
		if ((double) ConfigCommonConfiguration.REQUIRED_EXPERIENCE_MODIFIER.get() < 0) {
			DistantWorldsMod.LOGGER.error(("[Distant Worlds] Your config has an incorrect value! (Location: \"distantworlds-common/required_experience_modifier\") (Edited value: " + ""
					+ ((double) ConfigCommonConfiguration.REQUIRED_EXPERIENCE_MODIFIER.get() + "" + (" => " + (Math.abs((double) ConfigCommonConfiguration.REQUIRED_EXPERIENCE_MODIFIER.get()) + ")")))));
		}
		if ((double) ConfigCommonConfiguration.RECOVERY_MODIFIER.get() < 0) {
			DistantWorldsMod.LOGGER.error(("[Distant Worlds] Your config has an incorrect value! (Location: \"distantworlds-common/recovery_modifier\") (Edited value: " + ""
					+ ((double) ConfigCommonConfiguration.RECOVERY_MODIFIER.get() + "" + (" => " + (Math.abs((double) ConfigCommonConfiguration.RECOVERY_MODIFIER.get()) + ")")))));
		}
	}
}
