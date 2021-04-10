package net.d3jott.rateaddon.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        Player pl = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equals("Top Dzialki")) {

            e.setCancelled(true);

            ItemStack clicked = e.getCurrentItem();

            if (clicked == null
                    || clicked.getType().equals(Material.AIR)
                    || !clicked.getItemMeta().hasDisplayName()
                    || !clicked.getItemMeta().hasLore())
                return;

            String owner = clicked.getItemMeta().getLore().get(0).substring(16);

            // NEED TO CHANGE IT!!!!!

            pl.chat("/plotme visit " + owner);
        }
    }
}
