package Commands;

import me.muratcan.cursedplugin.CursedPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PlayerCommands implements CommandExecutor {
    private final CursedPlugin plugin;

    public PlayerCommands(CursedPlugin cursedPlugin) {
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
                player.sendMessage(ChatColor.GREEN + "Ev konumu kaydedildi");


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

                String s1 = strings[0];
                Player player1 = Bukkit.getServer().getPlayerExact(s1);
                if (player1 != null) {

                    ItemStack air = new ItemStack(Material.AIR);
                    ItemStack hand = new ItemStack(player.getInventory().getItemInMainHand());

                    System.out.println(player.getInventory().getItemInMainHand());
                 if(!hand.getData().equals(air.getData())){


                     int x = 0;
                     ItemStack[] items = player1.getInventory().getStorageContents();

                     for (ItemStack item : items) {


                         // aynı tipte iki eşyanın ilk atım stack'ı 0 (null)dan saydığı için yanyana aynı eşyadan 1 tane koyduğunda gönderdiğin an hepsini siler düzeltimesi gerek
                         // çözüm-1: belki eşyaya lore veya farklı bir isim atayarak engellenebilir enchantla bile engelleniyor
                         if (item == null) {
                             player.sendMessage();

                             ItemStack esya = player.getInventory().getItemInMainHand();

                             player.getInventory().remove(player.getInventory().getItemInMainHand());
                             player1.getInventory().setItem(x,esya);
                             player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Eşya başarıyla gönderildi.");
                             player1.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + player.getDisplayName() + " Tarafından size " + esya.getType() + " Gönderildi" );
                             break;


                         }
                         else if(x == 35){
                             break;
                         }
                         x++;

                     }
                     player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Eğer eşyanız gitmediyse gönderdiğiniz kişide boş yer yoktur.");
                 }else{
                     player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Elinizde Bir eşya tutmanız gerekiyor.");
                 }



                }
            }

        } else if (command.getName().equalsIgnoreCase("ekipmanlar")) {

            if (commandSender instanceof Player) {


                Player player = (Player) commandSender;

                //Starter pack
                ArrayList<String> lore = new ArrayList<>();
                lore.add("Bir noktadan başlamak gerek");
                Inventory inventory = Bukkit.createInventory(player, 9, ChatColor.DARK_PURPLE + "Ekipmanlar");
                ItemStack itemStack1 = new ItemStack(Material.COAL);
                ItemStack ironKit = new ItemStack(Material.IRON_INGOT);
                ItemStack goldenKit = new ItemStack(Material.GOLD_INGOT);
                ItemStack diamondKit = new ItemStack(Material.DIAMOND);
                ItemStack emeraldKit = new ItemStack(Material.EMERALD);

                ItemMeta itemMeta = itemStack1.getItemMeta();
                itemMeta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
                itemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Başlangıç Ekipmanları");
                itemMeta.setLore(lore);
                itemStack1.setItemMeta(itemMeta);


                ItemMeta ironMeta = ironKit.getItemMeta();
                ItemMeta goldenMeta = goldenKit.getItemMeta();
                ItemMeta diamondMeta = diamondKit.getItemMeta();
                ItemMeta emeraldMeta = emeraldKit.getItemMeta();

                ironMeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Gezgin Ekipmanları");
                goldenMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Maceracı Ekipmanlar");
                diamondMeta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Destansı Ekipmanlar");
                emeraldMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Efsanevi Ekipmanlar");

                ironMeta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
                goldenMeta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
                diamondMeta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
                emeraldMeta.addEnchant(Enchantment.BINDING_CURSE, 1, false);

                ArrayList<String> ironLore = new ArrayList<>();
                ArrayList<String> goldLore = new ArrayList<>();
                ArrayList<String> diamondLore = new ArrayList<>();
                ArrayList<String> emeraldLore = new ArrayList<>();

                ironLore.add("Uzun yolculuklara çıkarken yanına almak isteyeceğin eşyalar verir");
                goldLore.add("Tehlikeli maceralara için gerekenler!");
                diamondLore.add("Nam salmış kişilerce tercih edilir.");
                emeraldLore.add("Artık isimleri mitlerde geçenler içindir");

                ironMeta.setLore(ironLore);
                goldenMeta.setLore(goldLore);
                diamondMeta.setLore(diamondLore);
                emeraldMeta.setLore(emeraldLore);

                ironKit.setItemMeta(ironMeta);
                goldenKit.setItemMeta(goldenMeta);
                diamondKit.setItemMeta(diamondMeta);
                emeraldKit.setItemMeta(emeraldMeta);

                inventory.setItem(0, itemStack1);
                inventory.setItem(1, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                inventory.setItem(2, ironKit);
                inventory.setItem(3, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                inventory.setItem(4, goldenKit);
                inventory.setItem(5, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                inventory.setItem(6, diamondKit);
                inventory.setItem(7, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                inventory.setItem(8, emeraldKit);


                player.openInventory(inventory);
            }
        } else if (command.getName().equalsIgnoreCase("yardım")) {

            if (commandSender instanceof Player) {

                Player player = (Player) commandSender;

                Inventory inventory = Bukkit.createInventory(player, 9, ChatColor.LIGHT_PURPLE + "Yardım Menüsü");

                // Suicide TNT
                ItemStack tnt = new ItemStack(Material.TNT);
                ItemMeta tntMeta = tnt.getItemMeta();
                tntMeta.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "İntihar et");
                tntMeta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
                ArrayList<String> tntLore = new ArrayList<>();
                tntLore.add("Kendi canına kıymak için TNT'ye tıkla!");
                tntMeta.setLore(tntLore);
                tnt.setItemMeta(tntMeta);

                //Close GUI window

                ItemStack close = new ItemStack(Material.BARRIER);
                ItemMeta closeMeta = close.getItemMeta();
                closeMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Kapat");
                closeMeta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
                close.setItemMeta(closeMeta);


                inventory.setItem(0, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                inventory.setItem(1, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                inventory.setItem(2, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                inventory.setItem(3, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                inventory.setItem(4, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                inventory.setItem(5, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                inventory.setItem(6, tnt);
                inventory.setItem(7, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                inventory.setItem(8, close);

                player.openInventory(inventory);

            }


        }


        return true;
    }


}
