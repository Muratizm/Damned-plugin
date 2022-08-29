package Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BasicEvents implements Listener {


    @EventHandler
    public void onPlayerJoined(PlayerJoinEvent e) {


        System.out.println(e.getPlayer().getAddress());

        e.setJoinMessage(e.getPlayer().getDisplayName() + " Sunucuya katıldı!");

    }

    @EventHandler
    public void onPlayerLeaved(PlayerQuitEvent e) {

        e.setQuitMessage(e.getPlayer() + " Sunucudan ayrıldı");

    }

}
