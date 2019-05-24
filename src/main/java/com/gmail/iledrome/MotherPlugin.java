package com.gmail.iledrome;

import com.gmail.iledrome.user.UserListener;
import com.gmail.iledrome.user.UserManager;
import com.gmail.iledrome.user.homes.commands.HomesCommand;
import com.gmail.iledrome.user.pin.PinListener;
import com.gmail.iledrome.user.pin.commands.PinCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class MotherPlugin extends JavaPlugin {

    public static MotherPlugin instance;
    private UserManager userManager;

    @Override
    public void onEnable() {
        instance = this;
        this.userManager = new UserManager();

        this.getCommand("homes").setExecutor(new HomesCommand());
        this.getCommand("pin").setExecutor(new PinCommand());
        new UserListener();
        new PinListener();
    }

    @Override
    public void onDisable() {
        this.userManager.clearUsers();
        this.userManager = null;
        instance = null;
    }

    public static MotherPlugin getInstance() {
        return instance;
    }

    public UserManager getUserManager() {
        return this.userManager;
    }
}
