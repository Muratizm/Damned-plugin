package Listeners;

import me.muratcan.cursedplugin.CursedPlugin;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class BasicEvents implements Listener {


    private final CursedPlugin plugin;

    public BasicEvents(CursedPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoined(PlayerJoinEvent e) {

        System.out.println(e.getPlayer().getAddress());


        e.setJoinMessage(e.getPlayer().getDisplayName() + " Sunucuya katıldı!");

        if (!e.getPlayer().hasPlayedBefore()) {

            PlayerInventory inventory = e.getPlayer().getInventory();
            inventory.setItemInMainHand(new ItemStack(Material.IRON_SWORD, 1));
            inventory.setItem(0,new ItemStack(Material.IRON_PICKAXE,1));
            inventory.setItem(1,new ItemStack(Material.IRON_AXE, 1));
            inventory.setItem(2, new ItemStack(Material.IRON_SHOVEL, 1));
            inventory.setItem(3,new ItemStack(Material.IRON_HELMET,1));
            inventory.setItem(4,new ItemStack(Material.IRON_CHESTPLATE,1));
            inventory.setItem(5,new ItemStack(Material.IRON_LEGGINGS,1));
            inventory.setItem(5,new ItemStack(Material.IRON_BOOTS,1));
            inventory.setItem(6,new ItemStack(Material.COOKED_MUTTON,16));
            inventory.setItem(7,new ItemStack(Material.COOKED_RABBIT,8));
            e.getPlayer().setLevel(10);


        }

    }

    @EventHandler
    public void WhenPlayerDead(PlayerDeathEvent event) {


    }


    @EventHandler
    public void onPlayerLeaved(PlayerQuitEvent e) {

        e.setQuitMessage(e.getPlayer() + " Sunucudan ayrıldı");

    }

    @EventHandler
    public void onPlayerRespawned(PlayerRespawnEvent event) {


        if (event.getPlayer().getBedSpawnLocation() == null) {

            event.setRespawnLocation(plugin.getConfig().getLocation("evkaydet"));
        } else {
            event.setRespawnLocation(event.getPlayer().getBedSpawnLocation());
        }

    }

}
