package com.gmail.iledrome.user.homes.commands;

import com.gmail.iledrome.MotherPlugin;
import com.gmail.iledrome.user.User;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomesUpdateCommand {

    private static MotherPlugin instance = MotherPlugin.getInstance();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {

        if (arguments.length == 0) {
            return false;
        }

        User user = instance.getUserManager().getUser((Player) sender);

        if (!user.getHomesManager().doesHomeExist(arguments[0])) {
            sender.sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "The home " + ChatColor.GOLD + arguments[0] + ChatColor.GRAY + " does not exist.");
            return false;
        }

        user.getHomesManager().getHome(arguments[0]).setLocation(user.getPlayer().getLocation());
        sender.sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "The home " + ChatColor.GOLD + arguments[0] + ChatColor.GRAY + " has been successfully updated.");

        return true;
    }

}
