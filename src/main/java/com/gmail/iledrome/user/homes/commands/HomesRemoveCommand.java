package com.gmail.iledrome.user.homes.commands;

import com.gmail.iledrome.user.User;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.gmail.iledrome.MotherPlugin.instance;

public class HomesRemoveCommand {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {

        if (arguments.length == 0) {
            return false;
        }

        User user = instance.getUserManager().getUser((Player) sender);

        if (!user.getHomesManager().doesHomeExist(arguments[0])) {
            sender.sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "The home " + ChatColor.GOLD + arguments[0] + ChatColor.GRAY + " does not exist.");
            return false;
        }

        if (user.getHomesManager().removeHome(user.getHomesManager().getHome(arguments[0]))) {
            sender.sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "The home " + ChatColor.GOLD + arguments[0] + ChatColor.GRAY + " has been successfully removed.");
        } else {
            sender.sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "The home " + ChatColor.GOLD + arguments[0] + ChatColor.GRAY + " could not be removed. Please contact the administrator.");
            return false;
        }

        return true;
    }

}
