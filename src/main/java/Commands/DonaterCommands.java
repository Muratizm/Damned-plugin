package Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class DonaterCommands implements CommandExecutor {

   public static ArrayList<Player> flyingPlayers = new ArrayList();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if (command.getName().equalsIgnoreCase("beslen")) {

            if (commandSender instanceof Player) {

                Player player = (Player) commandSender;
                player.setFoodLevel(20);
                player.sendMessage(ChatColor.GREEN + "Açlık barınız tazelendi");


            }

        } else if (command.getName().equalsIgnoreCase("tamiret")) {

            if (commandSender instanceof Player) {

                Player player = (Player) commandSender;

                ItemStack itemStack = player.getInventory().getItemInMainHand();
                ItemMeta itemMeta = itemStack.getItemMeta();
                Damageable damageable = (Damageable) itemMeta;

                  if(itemStack.getType() == Material.DIAMOND_SWORD && itemStack != null){

                      damageable.setDamage(-Material.DIAMOND_SWORD.getMaxDurability());
                      itemStack.setItemMeta(itemMeta);
                      player.sendMessage(ChatColor.GREEN + "Eşya başarılı bir şekilde tamir edildi.");
                  }
                  else {
                      player.sendMessage(ChatColor.RED + "Elinizde eşya olmalı");
                  }


            }

        }
        else if(command.getName().equalsIgnoreCase("uçma")){

            if(commandSender instanceof Player){

                Player player = (Player) commandSender;

                if(player.hasPermission("Destekçi")){

                    if(flyingPlayers.contains(player)){

                        player.setAllowFlight(false);
                        player.sendMessage(ChatColor.RED + "Artık uçamazsın.");
                        flyingPlayers.remove(player);
                    }
                    else {

                        player.setAllowFlight(true);
                        player.sendMessage(ChatColor.AQUA + "Artık uçabilirsin.");
                        flyingPlayers.add(player);
                    }

                }
                else{
                    player.sendMessage(ChatColor.RED + "Bu komutu kullanacak yetkiye sahip değilsin.");
                }

            }

        }


        return true;
    }
}
