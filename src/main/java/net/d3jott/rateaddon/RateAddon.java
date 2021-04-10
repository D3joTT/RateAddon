package net.d3jott.rateaddon;

import net.d3jott.rateaddon.commands.GiveHearth;
import net.d3jott.rateaddon.commands.TopPlots;
import net.d3jott.rateaddon.events.InventoryClick;
import net.d3jott.rateaddon.placeholders.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class RateAddon extends JavaPlugin {

    @Override
    public void onEnable() {

        registerAllCommands();
        registerAllEvents();
        initDependencies();

        System.out.println(ChatColor.GREEN + "Enabled RateAddon by #OverTeam");
    }

    public void registerAllCommands() {

        this.getCommand("top").setExecutor(new TopPlots());
        this.getCommand("serce").setExecutor(new GiveHearth());
    }

    public void registerAllEvents() {

        Bukkit.getServer().getPluginManager().registerEvents(new InventoryClick(), this);
    }

    public void initDependencies() {

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI"))
            new Placeholder().register();
    }
}
