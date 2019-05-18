package com.gmail.iledrome.utilities;

import com.gmail.iledrome.MotherPlugin;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigurationFile {

    private static MotherPlugin instance = MotherPlugin.getInstance();

    private File configurationFile;
    private YamlConfiguration configuration;

    public ConfigurationFile(String name) {
        this.configurationFile = new File(instance.getDataFolder(), name + ".yml");

        if (!this.configurationFile.exists()) {
            this.configurationFile.getParentFile().mkdirs();
        }

        this.configuration = YamlConfiguration.loadConfiguration(this.configurationFile);
        this.saveToFile();
    }

    public void loadFromFile() {
        try {
            this.configuration.load(this.configurationFile);
        } catch (IOException | InvalidConfigurationException exception) {
            exception.printStackTrace();
        }
    }

    public void saveToFile() {
        try {
            this.configuration.save(this.configurationFile);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public YamlConfiguration getConfiguration() {
        return configuration;
    }
}
