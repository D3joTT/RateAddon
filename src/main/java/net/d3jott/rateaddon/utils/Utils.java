package net.d3jott.rateaddon.utils;

import com.plotsquared.core.api.PlotAPI;
import com.plotsquared.core.plot.Plot;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;

public class Utils {

    public void topHeartsGUI(Player pl) {

        HashMap<Plot, Integer> topHearts = new HashMap<>();

        Inventory topHeartsGUI = Bukkit.createInventory(pl, 54, "Top Dzialki");

        for (Plot plot : onlinePlots()) {
            topHearts.put(plot, plot.getLikes().size());
        }

        List<Map.Entry<Plot, Integer>> plots = new LinkedList<>(topHearts.entrySet());

        plots.sort(Map.Entry.comparingByValue());

        Collections.reverse(plots);

        int i = 10;

        for (Map.Entry<Plot, Integer> plot : plots) {

            if (i==44)
                break;

            if (i==17 || i==26 || i==35)
                i+=2;

            ItemStack skull = new ItemStack(Material.PLAYER_HEAD);

            SkullMeta meta = (SkullMeta) skull.getItemMeta();

            UUID uuid = plot.getKey().getOwner();

            meta.setOwningPlayer(Bukkit.getOfflinePlayer(uuid));

            List<String> lore = new ArrayList<>();

            if (!plot.getKey().getAlias().equals(""))
                meta.setDisplayName(plot.getKey().getAlias().replaceAll("&", "§"));

            else
                meta.setDisplayName(" ");

            lore.add(ChatColor.GRAY + "Wlasciciel: " + ChatColor.GREEN + Bukkit.getOfflinePlayer(uuid).getName());
            lore.add(ChatColor.GRAY + "Serduszka: " + ChatColor.RED + plot.getValue() + " ❤");
            lore.add(ChatColor.GRAY + "Gosci: " + ChatColor.GREEN + plot.getKey().getPlayersInPlot().size());
            lore.add(" ");
            lore.add(ChatColor.YELLOW + "Kliknij aby odwiedzic!");
            meta.setLore(lore);

            skull.setItemMeta(meta);

            topHeartsGUI.setItem(i, skull);

            i++;
        }

        pl.openInventory(topHeartsGUI);
    }

    public List<Plot> onlinePlots() {

        PlotAPI plotAPI = new PlotAPI();

        List<Plot> onlinePlots = new ArrayList<>();

        for (Player pl : Bukkit.getOnlinePlayers()) {

            if (Plot.getPlot(plotAPI.wrapPlayer(pl.getUniqueId()).getLocation()) != null)
                if (Plot.getPlot(plotAPI.wrapPlayer(pl.getUniqueId()).getLocation()).hasOwner())
                    onlinePlots.add(Plot.getPlot(plotAPI.wrapPlayer(pl.getUniqueId()).getLocation()));
        }

        return onlinePlots;
    }
}
