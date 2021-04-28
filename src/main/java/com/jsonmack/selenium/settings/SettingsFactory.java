package com.jsonmack.selenium.settings;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Jason MacKeigan
 */
public class SettingsFactory {

    public SettingsFactory() {
        throw new AssertionError("Cannot instantiate, this is a factory class.");
    }

    public static Settings fromJson(Path settingsPath) throws IOException {
        try (Reader reader = Files.newBufferedReader(settingsPath)) {
            return new GsonBuilder().create().fromJson(reader, Settings.class);
        }
    }

}
