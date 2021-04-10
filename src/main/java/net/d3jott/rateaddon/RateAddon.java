package net.d3jott.rateaddon;

import net.d3jott.rateaddon.commands.TopPlots;
import net.d3jott.rateaddon.events.InventoryClick;
import net.d3jott.rateaddon.placeholders.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class RateAddon extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("top").setExecutor(new TopPlots());

        Bukkit.getServer().getPluginManager().registerEvents(new InventoryClick(), this);

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI"))
            new Placeholder().register();

        System.out.println(ChatColor.GREEN + "Enabled RateAddon by #OverTeam");
    }
}
