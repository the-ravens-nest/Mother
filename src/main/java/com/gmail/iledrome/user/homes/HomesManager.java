package com.gmail.iledrome.user.homes;

import com.gmail.iledrome.MotherPlugin;
import com.gmail.iledrome.utilities.ConfigurationFile;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class HomesManager {

    private static MotherPlugin instance = MotherPlugin.getInstance();
    private List<Home> homes;
    private ConfigurationFile configurationFile;

    public HomesManager(ConfigurationFile configurationFile) {
        this.homes = new ArrayList();
        this.configurationFile = configurationFile;
    }

    public boolean addHome(Home home) {
        return this.homes.add(home);
    }

    public boolean removeHome(Home home) {
        return this.homes.remove(home);
    }

    public void clearHomes() {
        this.homes.clear();
    }

    public Home getHome(String name) {
        return this.homes.stream().filter(home -> home.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public boolean doesHomeExist(String name) {
        return this.getHome(name) != null;
    }

    public List<Home> getHomes() {
        return this.homes;
    }

    public void load() {
        ConfigurationSection section = this.configurationFile.getConfiguration().getConfigurationSection("homes");

        if (section == null)
            return;

        section.getKeys(false).forEach(name -> {
            String path = "homes." + name + ".";
            this.homes.add(new Home(name, new Location(instance.getServer().getWorld(this.configurationFile.getConfiguration().getString(path + "world")), this.configurationFile.getConfiguration().getDouble(path + "x"), this.configurationFile.getConfiguration().getDouble(path + "y"), this.configurationFile.getConfiguration().getDouble(path + "z"), (float) this.configurationFile.getConfiguration().getDouble(path + "yaw"), (float) this.configurationFile.getConfiguration().getDouble(path + "pitch"))));
        });
    }

    public void save() {

        if (this.homes.isEmpty()) {
            return;
        }

        this.homes.forEach(home -> {
            this.configurationFile.getConfiguration().set("homes." + home.getName() + ".world", home.getLocation().getWorld().getName());
            this.configurationFile.getConfiguration().set("homes." + home.getName() + ".x", home.getLocation().getBlockX());
            this.configurationFile.getConfiguration().set("homes." + home.getName() + ".y", home.getLocation().getY());
            this.configurationFile.getConfiguration().set("homes." + home.getName() + ".z", home.getLocation().getBlockZ());
            this.configurationFile.getConfiguration().set("homes." + home.getName() + ".yaw", home.getLocation().getYaw());
            this.configurationFile.getConfiguration().set("homes." + home.getName() + ".pitch", home.getLocation().getPitch());
        });

        ConfigurationSection section = this.configurationFile.getConfiguration().getConfigurationSection("homes");
        section.getKeys(false).forEach(name -> {
            if (!doesHomeExist(name)) {
                section.set(name, null);
            }
        });

        this.clearHomes();
    }


}
