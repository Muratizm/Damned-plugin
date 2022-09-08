package Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class MenuListener implements Listener {

    private HashMap<UUID, Long> cooldown;


    public void getEmptySpaces(HumanEntity entity) {

        ItemStack[] itemStack = entity.getInventory().getStorageContents();

        ArrayList<Integer> spacesL = new ArrayList<>();
        int amount = 0;
        int location = 0;

        for (ItemStack item : itemStack) {

            if (item == null) {

                amount++;
                spacesL.add(location);

            }
            location++;
        }

        if (spacesL.size() >= 4) {

            ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
            ItemMeta editHelmet = helmet.getItemMeta();
            editHelmet.setDisplayName(ChatColor.LIGHT_PURPLE + "Bere");
            editHelmet.addEnchant(Enchantment.DURABILITY, 10, true);
            editHelmet.addEnchant(Enchantment.OXYGEN, 5, true);
            editHelmet.addEnchant(Enchantment.MENDING, 1, true);
            helmet.setItemMeta(editHelmet);


            entity.getInventory().setItem(spacesL.get(0), helmet);
            entity.getInventory().setItem(spacesL.get(1), new ItemStack(Material.TORCH, 32));
            entity.getInventory().setItem(spacesL.get(2), new ItemStack(Material.OAK_LOG, 32));
            entity.getInventory().setItem(spacesL.get(3), new ItemStack(Material.COOKED_MUTTON, 32));
            this.cooldown.put(entity.getUniqueId(), System.currentTimeMillis());

        } else {
            entity.sendMessage("Envanterinizde en az 4 tane boş yer bulunması gerek");
        }

    }

    public MenuListener() {

        this.cooldown = new HashMap<>();

    }

    @EventHandler
    public void KitMenu(InventoryClickEvent event) {


        if (event.getView().getTitle().equals(ChatColor.DARK_PURPLE + "Ekipmanlar")) {
            event.setCancelled(true);

            HumanEntity humanEntity = event.getWhoClicked();

            if (event.getCurrentItem() == null) {
                return;
            }

            // first time writing that command
            if (!this.cooldown.containsKey(humanEntity.getUniqueId())) {

                this.cooldown.put(humanEntity.getUniqueId(), System.currentTimeMillis());


                if (event.getCurrentItem().getType() == Material.COAL) {

                    //Starter items


                    getEmptySpaces(humanEntity);


                    humanEntity.closeInventory();
                } else if (event.getCurrentItem().getType() == Material.IRON_INGOT) {


                    humanEntity.sendMessage(ChatColor.AQUA + "Eşyalar temin edildi!");
                    humanEntity.closeInventory();

                } else if (event.getCurrentItem().getType() == Material.GOLD_INGOT) {

                    humanEntity.sendMessage(ChatColor.AQUA + "Eşyalar temin edildi!");
                    humanEntity.closeInventory();


                } else if (event.getCurrentItem().getType() == Material.DIAMOND) {

                    humanEntity.sendMessage(ChatColor.AQUA + "Eşyalar temin edildi!");
                    humanEntity.closeInventory();


                } else if (event.getCurrentItem().getType() == Material.EMERALD) {

                    humanEntity.sendMessage(ChatColor.AQUA + "Eşyalar temin edildi!");
                    humanEntity.closeInventory();


                } else {
                    humanEntity.sendMessage(ChatColor.RED + "Bu ekipmanı alacak yetkiye sahip değilsiniz.");
                    humanEntity.closeInventory();

                }

            } else {
                // Already typed that command
                //difference in ms

                long timeElapsed = System.currentTimeMillis() - cooldown.get(humanEntity.getUniqueId());
                if (timeElapsed >= 10000) {


                    if (event.getCurrentItem().getType() == Material.COAL) {

                        //Starter items

                        getEmptySpaces(humanEntity);


                        humanEntity.closeInventory();


                    } else if (event.getCurrentItem().getType() == Material.IRON_INGOT) {


                        humanEntity.sendMessage(ChatColor.AQUA + "Eşyalar temin edildi!");

                    } else if (event.getCurrentItem().getType() == Material.GOLD_INGOT) {

                        humanEntity.sendMessage(ChatColor.AQUA + "Eşyalar temin edildi!");

                    } else if (event.getCurrentItem().getType() == Material.DIAMOND) {

                        humanEntity.sendMessage(ChatColor.AQUA + "Eşyalar temin edildi!");

                    } else if (event.getCurrentItem().getType() == Material.EMERALD) {

                        humanEntity.sendMessage(ChatColor.AQUA + "Eşyalar temin edildi!");

                    } else {
                        humanEntity.sendMessage(ChatColor.RED + "Bu ekipmanı alacak yetkiye sahip değilsiniz.");
                    }
                } else {                                                            // a whole day = 86.400.000 in minecraft
                    humanEntity.sendMessage(ChatColor.AQUA + "Bekleme süresinde: " + ((10000 - timeElapsed) / 1000 + " Saniye kaldı"));

                }

            }


        } else if (event.getView().getTitle().equals(ChatColor.LIGHT_PURPLE + "Yardım Menüsü")) {

            event.setCancelled(true);
            LivingEntity livingEntity = event.getWhoClicked();

            if (event.getCurrentItem() == null) {
                return;
            }

            if (event.getCurrentItem().getType() == Material.TNT) {

                livingEntity.setHealth(0.00);
                livingEntity.sendMessage(ChatColor.RED + "Kendinizi öldürdünüz.");

            } else if (event.getCurrentItem().getType() == Material.BARRIER) {

                event.getWhoClicked().closeInventory();

            }

        }


    }


}
