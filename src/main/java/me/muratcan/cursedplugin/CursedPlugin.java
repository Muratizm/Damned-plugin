package me.muratcan.cursedplugin;

import Commands.AdminCommands;
import Commands.DonaterCommands;
import Commands.PlayerCommands;
import CustomEnchantment.EnchantmentManager;
import CustomEnchantment.LifeStealEnchantment;
import CustomEvents.SpecialEntityWalking;
import Listeners.BasicEvents;
import Listeners.CursedEvents;
import Listeners.MenuListener;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.A;

import java.lang.reflect.Field;
import java.util.HashMap;

public final class CursedPlugin extends JavaPlugin implements Listener {

    private static CursedPlugin plugin;
    public static LifeStealEnchantment lifeStealEnchantment;

    @Override
    public void onEnable() {

        EnchantmentManager.register();
        plugin = this;

        //Config init
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Listener Reg
        getServer().getPluginManager().registerEvents(new CursedEvents(this), this);
        getServer().getPluginManager().registerEvents(new BasicEvents(this), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);

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
        getCommand("başlangıç").setExecutor(new PlayerCommands(this));
        getCommand("sakatla").setExecutor(new AdminCommands());
        getCommand("kan").setExecutor(new AdminCommands());
        getCommand("kör").setExecutor(new AdminCommands());

    }


    public static CursedPlugin getInstance() {

        return plugin;
    }


}
