package com.gmail.iledrome.user.homes.commands;

import com.gmail.iledrome.MotherPlugin;
import com.gmail.iledrome.user.User;
import com.gmail.iledrome.user.homes.Home;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomesAddCommand implements CommandExecutor {

    private static MotherPlugin instance = MotherPlugin.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {

        if (arguments.length == 0) {
            return false;
        }

        User user = instance.getUserManager().getUser((Player) sender);

        if (user.getHomesManager().doesHomeExist(arguments[0])) {
            sender.sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "A home with the name " + ChatColor.GOLD + arguments[0] + ChatColor.GRAY + " already exists.");
            return false;
        }

        if (user.getHomesManager().addHome(new Home(arguments[0], user.getPlayer().getLocation()))) {
            sender.sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "The home " + ChatColor.GOLD + arguments[0] + ChatColor.GRAY + " has successfully been added.");
        } else {
            sender.sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "The home " + ChatColor.GOLD + arguments[0] + ChatColor.GRAY + " could not be added. Please contact the administrator.");
            return false;
        }

        return true;
    }

}
