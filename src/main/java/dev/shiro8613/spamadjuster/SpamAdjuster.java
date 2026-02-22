package dev.shiro8613.spamadjuster;

import java.nio.file.Path;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpamAdjuster implements ModInitializer {
    public static final String MOD_ID = "spam-adjuster";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("spam-adjuster.properties");

    @Override
    public void onInitialize() {
        try {
            ModConfig.load(CONFIG_PATH);
        } catch (Exception e) {
            LOGGER.error("failed to load or save config", e);
        }
    }


}
