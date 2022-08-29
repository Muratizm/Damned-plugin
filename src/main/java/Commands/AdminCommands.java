package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommands implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(command.getName().equalsIgnoreCase("invisible")){


            if(sender instanceof Player){


                Player player = (Player) sender;

                if(player.isInvisible()){

                    player.setInvisible(false);
                }
                else {
                    player.setInvisible(true);
                }




            }
        }
        else if(command.getName().equalsIgnoreCase("god")){

            if (sender instanceof Player){

                Player player = (Player) sender;

                if(player.isInvulnerable()){

                    player.setInvulnerable(false);
                }
                else {
                    player.setInvulnerable(true);
                }

            }

        }
        else if(command.getName().equalsIgnoreCase("heal")){

            if(sender instanceof Player){

                Player player = (Player) sender;

                if (player.getHealth() < 20){

                    player.setHealth(20.00);

                }

            }


        }





        return true;
    }

}
