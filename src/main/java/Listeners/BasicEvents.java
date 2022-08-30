package Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BasicEvents implements Listener {

    private boolean glown;
    private Player player;

    @EventHandler
    public void onPlayerJoined(PlayerJoinEvent e) {

        player = (Player) e;
        System.out.println(e.getPlayer().getAddress());


        e.setJoinMessage(e.getPlayer().getDisplayName() + " Sunucuya katıldı!");

        if (!e.getPlayer().hasPlayedBefore()) {

            player.setGlowing(true);

            e.getPlayer().setLevel(10);

        }


    }

    @EventHandler
    public void WhenPlayerDead(PlayerDeathEvent event) {

        player.setGlowing(false);
    }


    @EventHandler
    public void onPlayerLeaved(PlayerQuitEvent e) {

        e.setQuitMessage(e.getPlayer() + " Sunucudan ayrıldı");

    }

}
