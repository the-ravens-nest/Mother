package com.gmail.iledrome.user.pin.commands;

import com.gmail.iledrome.MotherPlugin;
import com.gmail.iledrome.user.User;
import com.gmail.iledrome.user.pin.Pin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PinCreateCommand implements CommandExecutor {

    private static MotherPlugin instance = MotherPlugin.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {

        if (arguments.length == 0) {
            return false;
        }

        User user = instance.getUserManager().getUser((Player) sender);
        user.getPinManager().setPin(new Pin(Integer.valueOf(arguments[0].replaceAll("[^0-9]", ""))));
        user.getPinManager().getPin().authenticate(user.getPinManager().getPin().getPin());
        return true;
    }

}
