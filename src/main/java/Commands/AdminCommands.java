package Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommands implements CommandExecutor {

     public static Location spawnLoc;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (command.getName().equalsIgnoreCase("görünmezlik")) {


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
        } else if (command.getName().equalsIgnoreCase("tanrı")) {

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

        } else if (command.getName().equalsIgnoreCase("iyileş")) {

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


        } else if (command.getName().equalsIgnoreCase("yaratesya")) {

            Player player = (Player) sender;

            if (player.isOp()) {



            }
        } else if (command.getName().equalsIgnoreCase("uçabilir")) {

            if (sender instanceof Player) {


                Player player = (Player) sender;


                if (player.isOp()) {
                    if (args.length == 1) {

                        String oyuncu = args[0];
                        Player player1 = Bukkit.getServer().getPlayerExact(oyuncu);
                        player.sendMessage(player1.getDisplayName());

                        if (player1 != null) {

                            if (DonaterCommands.flyingPlayers.contains(player1)) {

                                DonaterCommands.flyingPlayers.remove(player1);
                                player1.sendMessage(ChatColor.RED + "Uçma yetkin " + player.getDisplayName() + " tarafından elinden alındı.");
                                player1.setAllowFlight(false);

                            } else {
                                DonaterCommands.flyingPlayers.add(player1);
                                player1.sendMessage(ChatColor.AQUA + "Uçma yetkin " + player.getDisplayName() + " tarafından verildi.");
                                player1.setAllowFlight(true);

                            }

                        } else {
                            player.sendMessage(ChatColor.RED + "Oyuncu bulunamadı");
                        }


                    }

                } else {
                    player.sendMessage(ChatColor.RED + "Oyuncunun bu komutu kullanmaya yetkisi yok");
                }

            }

        }
        else if(command.getName().equalsIgnoreCase("spawnkaydet")){


            if(sender instanceof Player){

                Player player = (Player) sender;

                if(player.isOp()){

                   spawnLoc = player.getLocation();
                  player.sendMessage(ChatColor.GREEN + "Spawn noktası kaydedildi");


                }

            }

        }


        return true;
    }

}
