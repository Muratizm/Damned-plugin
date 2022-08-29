package me.muratcan.cursedplugin;

import Commands.AdminCommands;
import Commands.DonaterCommands;
import Listeners.BasicEvents;
import Listeners.CursedEvents;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class CursedPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        //Listener Reg
        getServer().getPluginManager().registerEvents(new CursedEvents(),this);
        getServer().getPluginManager().registerEvents(new BasicEvents(),this);

        //Command Reg
        getCommand("heal").setExecutor(new AdminCommands());
        getCommand("god").setExecutor(new AdminCommands());
        getCommand("invisible").setExecutor(new AdminCommands());
        getCommand("beslen").setExecutor(new DonaterCommands());

    }


}
