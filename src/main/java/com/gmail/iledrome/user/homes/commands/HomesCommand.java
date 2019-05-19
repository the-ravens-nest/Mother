package com.gmail.iledrome.user.homes.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class HomesCommand implements CommandExecutor {

    private HomesListCommand homesListCommand;
    private HomesAddCommand homesAddCommand;
    private HomesRemoveCommand homesRemoveCommand;
    private HomesUpdateCommand homesUpdateCommand;

    public HomesCommand() {
        this.homesListCommand = new HomesListCommand();
        this.homesAddCommand = new HomesAddCommand();
        this.homesRemoveCommand = new HomesRemoveCommand();
        this.homesUpdateCommand = new HomesUpdateCommand();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.AQUA + "You must be a player to perform this action!");
            return false;
        }

        if (arguments.length == 0) {
            sender.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "-----" + ChatColor.AQUA + " Homes Help " + ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "-----");
            sender.sendMessage(ChatColor.GOLD + "/homes list");
            sender.sendMessage(ChatColor.GOLD + "/homes add <name>");
            sender.sendMessage(ChatColor.GOLD + "/homes remove <name>");
            sender.sendMessage(ChatColor.GOLD + "/homes update <name>");
            sender.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "-----" + ChatColor.AQUA + " Homes Help " + ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "-----");
            return false;
        }

        if (arguments.length >= 1) {
            switch (arguments[0].toLowerCase()) {
                case "list":
                    this.homesListCommand.onCommand(sender, command, label, Arrays.copyOfRange(arguments, 1, arguments.length));
                    break;
                case "add":
                    this.homesAddCommand.onCommand(sender, command, label, Arrays.copyOfRange(arguments, 1, arguments.length));
                    break;
                case "remove":
                    this.homesRemoveCommand.onCommand(sender, command, label, Arrays.copyOfRange(arguments, 1, arguments.length));
                    break;
                case "update":
                    this.homesUpdateCommand.onCommand(sender, command, label, Arrays.copyOfRange(arguments, 1, arguments.length));
                default:
                    break;
            }
        }

        return true;
    }
}
