package com.gmail.iledrome;

import org.bukkit.plugin.java.JavaPlugin;

public class MotherPlugin extends JavaPlugin {

    public static MotherPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static MotherPlugin getInstance() {
        return instance;
    }
}
