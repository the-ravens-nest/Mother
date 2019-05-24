package com.gmail.iledrome.user.pin;

import com.gmail.iledrome.MotherPlugin;
import com.gmail.iledrome.user.User;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;

public class PinListener implements Listener {

    private static MotherPlugin instance = MotherPlugin.getInstance();

    public PinListener() {
        instance.getServer().getPluginManager().registerEvents(this, instance);
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        User user = instance.getUserManager().getUser(event.getPlayer());

        if (user.getPinManager().getPin() != null) {
            user.getPlayer().sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.AQUA + "Please authenticate using " + ChatColor.GOLD + "/pin <pin>" + ChatColor.AQUA + ".");
        } else {
            user.getPlayer().sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.AQUA + "You must create a pin, to do this please type " + ChatColor.GOLD + "/pin create <pin>" + ChatColor.AQUA + ".");
        }
    }

    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent event) {
        User user = instance.getUserManager().getUser(event.getPlayer());

        if (!user.getPinManager().getPin().isAuthenticated()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        User user = instance.getUserManager().getUser(event.getPlayer());

        if (!user.getPinManager().getPin().isAuthenticated()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        User user = instance.getUserManager().getUser(event.getPlayer());

        if (!user.getPinManager().getPin().isAuthenticated()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        User user = instance.getUserManager().getUser(event.getPlayer());

        if (!user.getPinManager().getPin().isAuthenticated()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
        User user = instance.getUserManager().getUser(event.getPlayer());

        if (!user.getPinManager().getPin().isAuthenticated()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent event) {
        // InventoryOpenEvent#getPlayer() returns a HumanEntity instead of a Player.
        if (event.getPlayer() instanceof Player) {
            User user = instance.getUserManager().getUser((Player) event.getPlayer());

            if (!user.getPinManager().getPin().isAuthenticated()) {
                event.setCancelled(true);

                instance.getServer().getScheduler().scheduleSyncDelayedTask(instance, () -> event.getPlayer().closeInventory(), 1L);
            }
        }
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            User user = instance.getUserManager().getUser(((Player) event.getWhoClicked()));

            if (!user.getPinManager().getPin().isAuthenticated()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent event) {
        User user = instance.getUserManager().getUser(event.getPlayer());

        if (!user.getPinManager().getPin().isAuthenticated() && !event.getMessage().startsWith("/pin")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityPickupItemEvent(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player) {
            User user = instance.getUserManager().getUser((Player) event.getEntity());

            if (!user.getPinManager().getPin().isAuthenticated()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityDropItemEvent(EntityDropItemEvent event) {
        if (event.getEntity() instanceof Player) {
            User user = instance.getUserManager().getUser((Player) event.getEntity());

            if (!user.getPinManager().getPin().isAuthenticated()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityAirChangeEvent(EntityAirChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            User user = instance.getUserManager().getUser((Player) event.getEntity());

            if (!user.getPinManager().getPin().isAuthenticated()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            User user = instance.getUserManager().getUser((Player) event.getEntity());

            if (!user.getPinManager().getPin().isAuthenticated()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityRegainHealthEvent(EntityRegainHealthEvent event) {
        if (event.getEntity() instanceof Player) {
            User user = instance.getUserManager().getUser((Player) event.getEntity());

            if (!user.getPinManager().getPin().isAuthenticated()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityTargetEvent(EntityTargetEvent event) {
        if (event.getTarget() instanceof Player) {
            User user = instance.getUserManager().getUser((Player) event.getTarget());

            if (!user.getPinManager().getPin().isAuthenticated()) {
                event.setTarget(null);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onFoodLevelChangeEvent(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            User user = instance.getUserManager().getUser((Player) event.getEntity());

            if (!user.getPinManager().getPin().isAuthenticated()) {
                event.setCancelled(true);
            }
        }
    }

}
