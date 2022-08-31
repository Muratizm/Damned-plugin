package Commands;

import me.muratcan.cursedplugin.CursedPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class PlayerCommands implements CommandExecutor {
    private final CursedPlugin plugin;

    public PlayerCommands(CursedPlugin cursedPlugin){
        this.plugin = cursedPlugin;
    }


    // evkaydet komutunda sethome galiba null kalıyor o nedenden ev komutu çalışmıyor düzeltmeye çalış

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if (command.getName().equalsIgnoreCase("evkaydet")) {

            if (commandSender instanceof Player) {

                Player player = (Player) commandSender;


             plugin.getConfig().set("evkaydet", player.getPlayer().getLocation());
             plugin.saveConfig();
             player.sendMessage("Ev konumu kaydedildi");


            }


        } else if (command.getName().equalsIgnoreCase("ev")) {

            if (commandSender instanceof Player) {

                Player player = (Player) commandSender;

                Location location = plugin.getConfig().getLocation("evkaydet");

                if (location != null) {
                    player.teleport(location);

                } else {
                    player.sendMessage(ChatColor.RED + "Evinizin konumunu kaydetmediğiniz için Teleport işlemi geçersiz oldu");
                }


            }


        } else if (command.getName().equalsIgnoreCase("geri")) {

            if (commandSender instanceof Player) {

                Player player = (Player) commandSender;

                Location deathLocation = player.getLastDeathLocation();

                if (deathLocation != null) {

                    player.teleport(deathLocation);
                    player.sendMessage(ChatColor.GREEN + "Başarılıyla ışınlanırdı");


                } else {
                    player.sendMessage("en son öldüğünüz konum bulunamadı");
                }


            }

        } else if (command.getName().equalsIgnoreCase("esyaver")) {
            if (commandSender instanceof Player) {

                Player player = (Player) commandSender;

                    String s1 = strings[1];
                    Player player1 = Bukkit.getServer().getPlayerExact(s1);
                    if (player1 != null) {
                        ItemStack item = player.getInventory().getItemInMainHand();
                        player.getInventory().remove(player.getInventory().getItemInMainHand());
                        player1.getInventory().setItem(1, item);
                        player.sendMessage(ChatColor.GREEN + "Eşya başarıyla gönderildi");
                    } else {
                        player.sendMessage(ChatColor.YELLOW + "Gönderilmek istenilen oyuncu bulunamadı");
                    }





            }


        }


        return true;
    }
}
