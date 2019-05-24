package com.gmail.iledrome.user.pin.commands;

import com.gmail.iledrome.MotherPlugin;
import com.gmail.iledrome.user.User;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class PinCommand implements CommandExecutor {

    private static MotherPlugin instance = MotherPlugin.getInstance();
    private PinCreateCommand pinCreateCommand;
    private PinChangeCommand pinChangeCommand;

    public PinCommand() {
        this.pinCreateCommand = new PinCreateCommand();
        this.pinChangeCommand = new PinChangeCommand();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.AQUA + "You must be a player to perform this action!");
            return false;
        }

        if (command.getName().equalsIgnoreCase("pin")) {
            User user = instance.getUserManager().getUser((Player) sender);

            if (arguments.length == 0) {
                sender.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "-----" + ChatColor.AQUA + " Pin Help " + ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "-----");
                sender.sendMessage(ChatColor.GOLD + "/pin <pin>");
                sender.sendMessage(ChatColor.GOLD + "/pin create <pin>");
                sender.sendMessage(ChatColor.GOLD + "/pin change <pin>");
                sender.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "-----" + ChatColor.AQUA + " Pin Help " + ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "-----");
                return false;
            }

            if (arguments.length >= 1) {
                switch (arguments[0].toLowerCase()) {
                    case "create":
                        if (!user.getPinManager().doesPinExist()) {
                            this.pinCreateCommand.onCommand(sender, command, label, Arrays.copyOfRange(arguments, 1, arguments.length));
                        } else {
                            sender.sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.AQUA + "You have already created a pin, to change your pin please type " + ChatColor.GOLD + "/pin change <pin>" + ChatColor.AQUA + ".");
                        }
                        break;
                    case "change":
                        if (!user.getPinManager().doesPinExist()) {
                            sender.sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.AQUA + "You must create a pin, to do this please type " + ChatColor.GOLD + "/pin create <pin>" + ChatColor.AQUA + ".");
                        } else {
                            this.pinChangeCommand.onCommand(sender, command, label, Arrays.copyOfRange(arguments, 1, arguments.length));
                        }
                        break;
                    default:
                        if (!user.getPinManager().doesPinExist()) {
                            sender.sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.AQUA + "You must create a pin, to do this please type " + ChatColor.GOLD + "/pin create <pin>");
                            break;
                        }

                        if (user.getPinManager().getPin().authenticate(Integer.valueOf(arguments[0].replaceAll("[^0-9]", "")))) {
                            sender.sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.AQUA + "You have been authenticated. Have fun!");
                        } else {
                            sender.sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.AQUA + "The pin you entered was incorrect, please try again.");
                        }
                        break;
                }
            }
        }
        return true;
    }
    
}
