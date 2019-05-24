package com.gmail.iledrome.user.pin.commands;

import com.gmail.iledrome.MotherPlugin;
import com.gmail.iledrome.user.User;
import com.gmail.iledrome.user.pin.Pin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PinChangeCommand implements CommandExecutor {

    private static MotherPlugin instance = MotherPlugin.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {

        if (arguments.length == 0) {
            return false;
        }

        User user = instance.getUserManager().getUser((Player) sender);
        user.getPinManager().setPin(new Pin(Integer.valueOf(arguments[0].replaceAll("[^0-9]", ""))));
        sender.sendMessage(ChatColor.DARK_PURPLE + "The Ravens Nest " + ChatColor.DARK_GRAY + "> " + ChatColor.AQUA + "Your pin has been successfully changed.");
        return true;
    }
}
