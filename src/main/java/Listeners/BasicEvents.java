package Listeners;

import me.muratcan.cursedplugin.CursedPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

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
