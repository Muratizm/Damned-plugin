package me.muratcan.cursedplugin;

import Commands.AdminCommands;
import Commands.DonaterCommands;
import Commands.PlayerCommands;
import Listeners.BasicEvents;
import Listeners.CursedEvents;
import Listeners.MenuListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CursedPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        //Config init
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Listener Reg
        getServer().getPluginManager().registerEvents(new CursedEvents(), this);
        getServer().getPluginManager().registerEvents(new BasicEvents(this), this);
        getServer().getPluginManager().registerEvents(new MenuListener(),this);

        //Command Reg
        getCommand("iyileş").setExecutor(new AdminCommands());
        getCommand("tanrı").setExecutor(new AdminCommands());
        getCommand("görünmezlik").setExecutor(new AdminCommands());
        getCommand("beslen").setExecutor(new DonaterCommands());
        getCommand("evkaydet").setExecutor(new PlayerCommands(this));
        getCommand("ev").setExecutor(new PlayerCommands(this));
        getCommand("geri").setExecutor(new PlayerCommands(this));
        getCommand("esyaver").setExecutor(new PlayerCommands(this));
        getCommand("ekipmanlar").setExecutor(new PlayerCommands(this));
        getCommand("tamiret").setExecutor(new DonaterCommands());
        getCommand("uçma").setExecutor(new DonaterCommands());
        getCommand("uçabilir").setExecutor(new AdminCommands());
        getCommand("yardım").setExecutor(new PlayerCommands(this));
        getCommand("spawnkaydet").setExecutor(new AdminCommands());

    }


}
