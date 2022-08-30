package Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerCommands implements CommandExecutor {

   private Location setHome;



   // evkaydet komutunda sethome galiba null kalıyor o nedenden ev komutu çalışmıyor düzeltmeye çalış

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if (command.getName().equalsIgnoreCase("evkaydet")) {

            if (commandSender instanceof Player) {

                Player player = (Player) commandSender;


                setHome = player.getLocation();
                player.sendMessage(ChatColor.GREEN + "Ev konumu kaydedildi");
                System.out.println("Kaydedilen konum: " + setHome);

            }


        } else if (command.getName().equalsIgnoreCase("ev")) {

            if (commandSender instanceof Player) {

                Player player = (Player) commandSender;


                if (setHome != null) {
                    player.teleport(setHome);

                } else {
                    player.sendMessage( ChatColor.RED + "Evinizin konumunu kaydetmediğiniz için Teleport işlemi geçersiz oldu");
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

        }


        return true;
    }
}
