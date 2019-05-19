package com.gmail.iledrome.user.homes.commands;

import com.gmail.iledrome.MotherPlugin;
import com.gmail.iledrome.user.User;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomesListCommand implements CommandExecutor {

    private static MotherPlugin instance = MotherPlugin.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        User user = instance.getUserManager().getUser((Player) sender);

        user.getPlayer().sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "-----" + ChatColor.AQUA + " Homes " + ChatColor.GRAY+ "" + ChatColor.STRIKETHROUGH + "-----");
        user.getHomesManager().getHomes().forEach(home -> user.getPlayer().sendMessage(ChatColor.AQUA + home.getName() + ChatColor.GRAY + ": " + ChatColor.GOLD + home.getLocation().getX() + ", " + home.getLocation().getY() + ", " + home.getLocation().getZ()));
        user.getPlayer().sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "-----" + ChatColor.AQUA + " Homes " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "-----");

        return true;
    }
}
