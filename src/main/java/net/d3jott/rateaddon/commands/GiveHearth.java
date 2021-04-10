package net.d3jott.rateaddon.commands;

import com.plotsquared.core.api.PlotAPI;
import com.plotsquared.core.plot.Plot;
import com.plotsquared.core.plot.Rating;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveHearth implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("serce")) {

            if (sender instanceof Player) {

                Player pl = Bukkit.getPlayer(sender.getName());

                PlotAPI plotAPI = new PlotAPI();
                Rating rating = new Rating(10);

                Plot.getPlot(plotAPI.wrapPlayer(pl.getUniqueId()).getLocation()).addRating(pl.getUniqueId(), rating);
            }

            return true;
        }

        return false;
    }
}
