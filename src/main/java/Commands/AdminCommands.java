package Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.awt.*;

public class AdminCommands implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (command.getName().equalsIgnoreCase("invisible")) {


            if (sender instanceof Player) {


                Player player = (Player) sender;

                if (player.isOp()) {

                    if (player.isInvisible()) {
                        player.sendMessage(ChatColor.RED + "Görünmezlik kapandı");

                        player.setInvisible(false);
                    } else {
                        player.sendMessage(ChatColor.GREEN + "Görünmezlik açıldı");

                        player.setInvisible(true);
                    }

                } else {

                    player.sendMessage(ChatColor.RED + "Bu komutu sadece yetkililer kullanabilir");

                }


            }
        } else if (command.getName().equalsIgnoreCase("god")) {

            if (sender instanceof Player) {

                Player player = (Player) sender;

                if (player.isOp()) {


                    if (player.isInvulnerable()) {
                        player.sendMessage(ChatColor.RED + "Ölümsüzlük kapandı");
                        player.setInvulnerable(false);
                    } else {
                        player.sendMessage(ChatColor.GREEN + "Ölümsüzlük açıldı");
                        player.setInvulnerable(true);
                    }

                } else {
                    player.sendMessage(ChatColor.RED + "Bu komutu sadece yetkililer kullanabilir");
                }


            }

        } else if (command.getName().equalsIgnoreCase("heal")) {

            if (sender instanceof Player) {

                Player player = (Player) sender;

                if (player.isOp()) {

                    if (player.getHealth() < 20) {


                        player.setHealth(20.00);
                        player.sendMessage(ChatColor.GREEN + "Can barınız dolduruldu");
                    }

                } else {
                    player.sendMessage(ChatColor.RED + "Bu komutu sadece yetkililer kullanabilir");
                }


            }


        }
        else if(command.getName().equalsIgnoreCase("yaratesya")){

            Player player = (Player) sender;

            if(player.isOp()){

            }
        }


        return true;
    }

}
