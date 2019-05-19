package com.gmail.iledrome.user;

import com.gmail.iledrome.user.homes.HomesManager;
import com.gmail.iledrome.utilities.ConfigurationFile;
import org.bukkit.entity.Player;

public class User {

    private Player player;
    private ConfigurationFile userConfigurationFile;
    private HomesManager homesManager;

    public User(Player player) {
        this.player = player;
        this.userConfigurationFile = new ConfigurationFile(this.player.getName());
        this.homesManager = new HomesManager(this.userConfigurationFile);
    }

    public void loadUserData() {
        this.userConfigurationFile.loadFromFile();
        this.homesManager.load();
    }

    public void saveUserData() {
        this.homesManager.save();
        this.userConfigurationFile.saveToFile();
    }

    public Player getPlayer() {
        return player;
    }

    public HomesManager getHomesManager() {
        return homesManager;
    }
}
