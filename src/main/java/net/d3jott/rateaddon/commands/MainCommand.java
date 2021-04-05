package net.d3jott.rateaddon.commands;

import net.d3jott.rateaddon.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    Utils utils = new Utils();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("top")) {

            if (sender instanceof Player)
                utils.topHeartsGUI((Player) sender);

            return true;
        }
        return false;
    }
}
