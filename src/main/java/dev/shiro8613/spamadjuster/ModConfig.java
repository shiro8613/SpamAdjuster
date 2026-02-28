package dev.shiro8613.spamadjuster;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ModConfig {

    private static final String SPAM_TH = "spam-threshold";
    private static final String SPAM_IN = "spam-increment";

    private static int increment = 20;
    private static int threshold = 200;

    public static void load(Path path) throws IOException, NumberFormatException {
        final Properties properties = new Properties();
        if (Files.notExists(path)) {
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                properties.setProperty(SPAM_IN, String.valueOf(increment));
                properties.setProperty(SPAM_TH, String.valueOf(threshold));
                properties.store(writer, "SpamAdjuster config");
            }

            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            properties.load(reader);
        }

        increment = Integer.parseInt(properties.getProperty(SPAM_IN));
        threshold = Integer.parseInt(properties.getProperty(SPAM_TH));
    }

    public static int getIncrement() {
        return increment;
    }

    public static int getThreshold() {
        return threshold;
    }
}
