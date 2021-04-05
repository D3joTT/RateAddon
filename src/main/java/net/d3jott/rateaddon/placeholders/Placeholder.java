package net.d3jott.rateaddon.placeholders;

import com.plotsquared.core.api.PlotAPI;
import com.plotsquared.core.plot.Plot;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Placeholder extends PlaceholderExpansion {

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin(getPlugin()) != null;
    }

    @Override
    public String getIdentifier() {
        return "serca";
    }

    @Override
    public String getAuthor() {
        return "D3joTT";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    public String onPlaceholderRequest(Player player, String identifier) {

        if (identifier.equals("ilosc")) {

            PlotAPI plotAPI = new PlotAPI();

            if (Plot.getPlot(plotAPI.wrapPlayer(player.getUniqueId()).getLocation()) != null) {

                Plot plot = Plot.getPlot(plotAPI.wrapPlayer(player.getUniqueId()).getLocation());

                if (plot != null)
                    return plot.getLikes().size() + " ❤";

            }
        }

        return "❤";
    }
}
