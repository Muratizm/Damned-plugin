package Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuListener implements Listener {


    @EventHandler
    public void KitMenu(InventoryClickEvent event) {


        if (event.getView().getTitle().equals(ChatColor.DARK_PURPLE + "Ekipmanlar")) {
            event.setCancelled(true);

            HumanEntity humanEntity = event.getWhoClicked();

            if(event.getCurrentItem() == null){
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals("Başlangıç Ekipmanları")) {
                humanEntity.getInventory().setItem(25, new ItemStack(Material.COOKED_MUTTON, 32));
                humanEntity.getInventory().setItem(26, new ItemStack(Material.OAK_LOG, 32));
                humanEntity.getInventory().setItem(27, new ItemStack(Material.TORCH, 32));

                humanEntity.closeInventory();
                humanEntity.sendMessage(ChatColor.AQUA + "Eşyalar temin edildi!");
            } else {
                humanEntity.sendMessage(ChatColor.RED + "Bu ekipmanı alacak yetkiye sahip değilsiniz.");
            }

        }

    }

}
