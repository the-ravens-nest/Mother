package com.gmail.iledrome.user;

import com.gmail.iledrome.MotherPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class UserListener implements Listener {

    private static MotherPlugin instance = MotherPlugin.getInstance();

    public UserListener() {
        instance.getServer().getPluginManager().registerEvents(this, instance);
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        User user = new User(event.getPlayer());
        instance.getUserManager().addUser(user);
        user.loadUserData();
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        User user = instance.getUserManager().getUser(event.getPlayer());
        user.saveUserData();
        instance.getUserManager().removeUser(user);
    }

}
