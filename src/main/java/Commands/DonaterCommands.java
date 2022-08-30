package Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DonaterCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if(command.getName().equalsIgnoreCase("beslen")){

            if (commandSender instanceof Player){

                Player player = (Player) commandSender;
                player.setFoodLevel(20);
                player.sendMessage(ChatColor.GREEN+ "Açlı barınız tazelendi");


            }

        }


        return true;
    }
}
