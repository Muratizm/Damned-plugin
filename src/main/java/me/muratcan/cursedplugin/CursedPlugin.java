package me.muratcan.cursedplugin;

import Commands.AdminCommands;
import Commands.DonaterCommands;
import Commands.PlayerCommands;
import Listeners.BasicEvents;
import Listeners.CursedEvents;
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
        getServer().getPluginManager().registerEvents(new BasicEvents(), this);

        //Command Reg
        getCommand("heal").setExecutor(new AdminCommands());
        getCommand("god").setExecutor(new AdminCommands());
        getCommand("invisible").setExecutor(new AdminCommands());
        getCommand("beslen").setExecutor(new DonaterCommands());
        getCommand("evkaydet").setExecutor(new PlayerCommands());
        getCommand("ev").setExecutor(new PlayerCommands());
        getCommand("geri").setExecutor(new PlayerCommands());


    }


}
