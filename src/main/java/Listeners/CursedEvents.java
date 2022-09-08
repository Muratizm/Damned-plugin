package Listeners;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTameEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;


public class CursedEvents implements Listener {


    //Cursed Sheep
    @EventHandler
    public void onShearedSheep(PlayerShearEntityEvent e) {

        Entity entity = e.getEntity();
        if (entity.getType().equals(EntityType.SHEEP)) {

            entity.setFireTicks(10000);
            Bukkit.getServer().getWorld("World").spawnParticle(Particle.DRAGON_BREATH, e.getEntity().getLocation(), 210);
            entity.playEffect(EntityEffect.WOLF_SMOKE);


        }


    }


    //Cursed DEATH give an undead entities second chance
    @EventHandler
    public void Necromancer(EntityDeathEvent deathEvent) {
        // Resurrection şans etkeni ekle ama en son

        // When an undead dies, it backs to life once

        EntityType type = deathEvent.getEntityType();


        if (deathEvent.getEntity().getKiller() != null) {

            if (deathEvent.getEntity().isDead()) {


                Location location = deathEvent.getEntity().getLocation();

                switch (type) {

                    case ZOMBIE:


                        if (deathEvent.getEntity().getCustomName() == null) {
                            Bukkit.getServer().getWorld("World").playSound(location, Sound.BLOCK_PORTAL_AMBIENT, SoundCategory.AMBIENT, 500, 5000);

                            Entity entity = Bukkit.getServer().getWorld("World").spawnEntity(location, EntityType.ZOMBIE);

                            entity.playEffect(EntityEffect.TOTEM_RESURRECT);
                            entity.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + "Yeniden dönmüş");
                            entity.setCustomNameVisible(true);
                            entity.setGlowing(true);
                            Bukkit.getServer().getWorld("World").spawnParticle(Particle.ENCHANTMENT_TABLE, location, 450);

                            LivingEntity entity1 = (LivingEntity) entity;
                            entity1.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000, 2));
                            entity1.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 1000, 2));
                            entity1.setAbsorptionAmount(10);
                            entity1.setRemoveWhenFarAway(true);

                            ItemStack sword = new ItemStack(Material.GOLDEN_SWORD);
                            ItemStack chest = new ItemStack(Material.GOLDEN_CHESTPLATE);
                            ItemStack boot = new ItemStack(Material.GOLDEN_BOOTS);
                            ItemMeta swordMeta = sword.getItemMeta();
                            ItemMeta chestMeta = chest.getItemMeta();
                            ItemMeta bootMeta = boot.getItemMeta();

                            bootMeta.addEnchant(Enchantment.FROST_WALKER, 1, true);
                            bootMeta.addEnchant(Enchantment.DURABILITY, 3, true);
                            swordMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
                            chestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                            swordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                            chestMeta.addEnchant(Enchantment.DURABILITY, 1, true);

                            sword.setItemMeta(swordMeta);
                            chest.setItemMeta(chestMeta);
                            boot.setItemMeta(bootMeta);

                            entity1.getEquipment().setItemInMainHand(sword);
                            entity1.getEquipment().setItemInOffHand(new ItemStack(Material.SHIELD));
                            entity1.getEquipment().setHelmet(new ItemStack(Material.RED_STAINED_GLASS));
                            entity1.getEquipment().setChestplate(chest);
                            entity1.getEquipment().setBoots(boot);
                        }


                        break;
                    case SKELETON:

                        if (deathEvent.getEntity().getCustomName() == null) {
                            Bukkit.getServer().getWorld("World").playSound(location, Sound.BLOCK_PORTAL_AMBIENT, SoundCategory.AMBIENT, 500, 5000);

                            Entity entity3 = Bukkit.getServer().getWorld("World").spawnEntity(location, EntityType.WITHER_SKELETON);
                            entity3.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + "Gölge İskelet");

                            LivingEntity livingEntity4 = (LivingEntity) entity3;
                            ItemStack helmet = new ItemStack(Material.GOLDEN_HELMET);
                            ItemStack chestS = new ItemStack(Material.GOLDEN_CHESTPLATE);
                            ItemMeta helmetMeta = helmet.getItemMeta();
                            ItemMeta chestMetaS = chestS.getItemMeta();
                            chestMetaS.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                            helmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                            helmet.setItemMeta(helmetMeta);
                            chestS.setItemMeta(chestMetaS);

                            livingEntity4.getEquipment().setHelmet(helmet);
                            livingEntity4.getEquipment().setChestplate(chestS);
                            livingEntity4.getEquipment().setItemInMainHand(new ItemStack(Material.STONE_AXE));
                            livingEntity4.getEquipment().setItemInOffHand(new ItemStack(Material.STONE_AXE));

                            livingEntity4.setRemoveWhenFarAway(true);
                            livingEntity4.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 1000, 2));
                            livingEntity4.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000, 1));

                            entity3.playEffect(EntityEffect.TOTEM_RESURRECT);
                            entity3.setCustomNameVisible(true);
                            entity3.setGlowing(true);
                            Bukkit.getServer().getWorld("World").spawnParticle(Particle.ENCHANTMENT_TABLE, location, 450);
                        }


                        break;
                    case CREEPER:


                        if (deathEvent.getEntity().getCustomName() == null) {
                            Bukkit.getServer().getWorld("World").playSound(location, Sound.BLOCK_PORTAL_AMBIENT, SoundCategory.AMBIENT, 500, 5000);

                            Entity entity4 = Bukkit.getServer().getWorld("World").spawnEntity(location, EntityType.CREEPER);
                            Entity stray = Bukkit.getServer().getWorld("World").spawnEntity(location, EntityType.STRAY);

                            entity4.addPassenger(stray);
                            stray.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + "Meteor Creeper");
                            stray.setCustomNameVisible(true);
                            entity4.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + "Meteor Creeper");
                            entity4.playEffect(EntityEffect.TOTEM_RESURRECT);


                            LivingEntity entitLiv = (LivingEntity) stray;
                            ItemStack chestt = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                            ItemMeta chestmeta = chestt.getItemMeta();
                            chestmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 10, true);
                            chestt.setItemMeta(chestmeta);
                            ((LivingEntity) stray).getEquipment().setChestplate(chestt);
                            entitLiv.setArrowCooldown(3);
                            entitLiv.setAbsorptionAmount(10);
                            entitLiv.setRemoveWhenFarAway(true);
                            entitLiv.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
                            entitLiv.setHealth(40);
                            entitLiv.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000, 3));

                            ((LivingEntity) entity4).addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000, 3));
                            ((LivingEntity) entity4).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000, 3));
                            ((LivingEntity) entity4).setRemoveWhenFarAway(true);

                            entity4.setVisualFire(false);
                            entity4.setGlowing(true);
                            stray.setGlowing(true);

                            Bukkit.getServer().getWorld("World").strikeLightning(location);
                            Bukkit.getServer().getWorld("World").spawnParticle(Particle.ENCHANTMENT_TABLE, location, 450);
                        }


                        break;
                    case SPIDER:


                        if (deathEvent.getEntity().getCustomName() == null) {
                            Bukkit.getServer().getWorld("World").playSound(location, Sound.BLOCK_PORTAL_AMBIENT, SoundCategory.AMBIENT, 500, 5000);

                            Creature spider = (Creature) Bukkit.getServer().getWorld("World").spawnEntity(location, EntityType.SPIDER);
                            Entity skeleton = Bukkit.getServer().getWorld("World").spawnEntity(location, EntityType.SKELETON);

                            spider.setTarget((Player) deathEvent.getEntity().getKiller());
                            spider.setCustomName("Hog Spider");
                            spider.setGlowing(true);
                            skeleton.setGlowing(true);
                            spider.playEffect(EntityEffect.TOTEM_RESURRECT);
                            spider.addPassenger(skeleton);
                            skeleton.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + "İskelet Süvari");
                            ItemStack GoldenS = new ItemStack(Material.GOLDEN_SWORD);
                            ItemStack skeH = new ItemStack(Material.JACK_O_LANTERN);
                            ItemStack chainC = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                            ItemMeta crossbowMeta = GoldenS.getItemMeta();
                            crossbowMeta.addEnchant(Enchantment.SWEEPING_EDGE, 2, true);
                            crossbowMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
                            crossbowMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                            GoldenS.setItemMeta(crossbowMeta);

                            LivingEntity skeLive = (LivingEntity) skeleton;
                            LivingEntity spiLive = (LivingEntity) spider;

                            skeLive.setRemoveWhenFarAway(true);
                            spiLive.setRemoveWhenFarAway(true);

                            spiLive.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 1000, 2));
                            spiLive.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000, 1));
                            skeLive.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000, 1));


                            skeLive.getEquipment().setItemInMainHand(GoldenS);
                            skeLive.getEquipment().setItemInOffHand(GoldenS);
                            skeLive.getEquipment().setHelmet(skeH);
                            skeLive.getEquipment().setChestplate(chainC);
                            skeleton.setCustomNameVisible(true);
                            Bukkit.getServer().getWorld("World").spawnParticle(Particle.ENCHANTMENT_TABLE, location, 450);


                        }


                        break;

                    case CAVE_SPIDER:

                        if (deathEvent.getEntity().getCustomName() == null) {
                            Bukkit.getServer().getWorld("World").playSound(location, Sound.BLOCK_PORTAL_AMBIENT, SoundCategory.AMBIENT, 500, 5000);


                            Creature sp1 = (Creature) Bukkit.getServer().getWorld("World").spawnEntity(location, EntityType.CAVE_SPIDER);
                            Creature sp2 = (Creature) Bukkit.getServer().getWorld("World").spawnEntity(location, EntityType.CAVE_SPIDER);
                            Creature sp3 = (Creature) Bukkit.getServer().getWorld("World").spawnEntity(location, EntityType.CAVE_SPIDER);


                            LivingEntity spl1 = (LivingEntity) sp1;
                            LivingEntity spl2 = (LivingEntity) sp2;
                            LivingEntity spl3 = (LivingEntity) sp3;

                            spl1.setRemoveWhenFarAway(true);
                            spl2.setRemoveWhenFarAway(true);
                            spl3.setRemoveWhenFarAway(true);


                            sp1.setTarget(deathEvent.getEntity().getKiller());
                            sp2.setTarget(deathEvent.getEntity().getKiller());
                            sp3.setTarget(deathEvent.getEntity().getKiller());


                            spl1.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000, 2));
                            spl2.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000, 2));
                            spl3.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000, 2));

                            spl1.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 7000, 1));
                            spl2.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 7000, 1));
                            spl3.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 7000, 1));


                            sp1.playEffect(EntityEffect.TOTEM_RESURRECT);
                            Bukkit.getServer().getWorld("World").spawnParticle(Particle.ENCHANTMENT_TABLE, location, 450);


                            sp1.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + "Sürü");
                            sp2.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + "Sürü");
                            sp3.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD + "Sürü");

                            sp1.setCustomNameVisible(true);
                            sp2.setCustomNameVisible(true);
                            sp3.setCustomNameVisible(true);


                        }


                        break;
                    case ENDERMAN:

                         // Bir tür bug var kontrol et

                        if (deathEvent.getEntity().getCustomName() == null) {


                            Bukkit.getServer().getWorld("World").playSound(location, Sound.BLOCK_PORTAL_AMBIENT, SoundCategory.AMBIENT, 500, 5000);
                            Creature entity = (Creature) Bukkit.getServer().getWorld("World").spawnEntity(location, EntityType.ENDERMAN);
                            entity.playEffect(EntityEffect.TOTEM_RESURRECT);


                            entity.setTarget(deathEvent.getEntity().getKiller());
                            entity.setGlowing(true);
                            entity.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "Karanlık getiren");
                            entity.setCustomNameVisible(true);
                            entity.setRemoveWhenFarAway(true);

                            deathEvent.getEntity().getKiller().addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 1000, 3));
                            deathEvent.getEntity().getKiller().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 2));

                            entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(50D);
                            entity.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK).setBaseValue(25D);
                            entity.setHealth(50D);
                        }


                        break;

                    case CHICKEN:


                        Bukkit.getServer().getWorld("World").spawnParticle(Particle.ELECTRIC_SPARK, location, 450);
                        Bukkit.getServer().getWorld("World").spawnEntity(location, EntityType.PRIMED_TNT);


                        break;


                    default:


                        break;
                }


            }

            if (deathEvent.getEntity().getCustomName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Yeniden dönmüş")) {

                deathEvent.getDrops().clear();
                deathEvent.setDroppedExp(40);
                deathEvent.getDrops().add(new ItemStack(Material.DIAMOND, 2));

                ItemStack CursedMeat = new ItemStack(Material.ROTTEN_FLESH);
                ItemMeta MeatMeta = CursedMeat.getItemMeta();
                MeatMeta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Lanetli Et Parçası");
                MeatMeta.addEnchant(Enchantment.BINDING_CURSE, 10, true);
                ArrayList<String> meat_lore = new ArrayList<>();
                meat_lore.add("Öteki taraftan gelmiş bir et");
                MeatMeta.setLore(meat_lore);
                CursedMeat.setItemMeta(MeatMeta);

                deathEvent.getDrops().add(1,CursedMeat);

            }
            else if(deathEvent.getEntity().getCustomName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Gölge İskelet")){

                deathEvent.getDrops().clear();
                deathEvent.setDroppedExp(55);
                deathEvent.getDrops().add(new ItemStack(Material.DIAMOND, 2));

                ItemStack CursedBone = new ItemStack(Material.BONE);
                ItemMeta MeatMeta = CursedBone.getItemMeta();
                MeatMeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Lanetli Bir Kemik");
                MeatMeta.addEnchant(Enchantment.BINDING_CURSE, 10, true);
                ArrayList<String> meat_lore = new ArrayList<>();
                meat_lore.add("Kararmaya başlamış, taşıyıcısından dolayı olsa");
                MeatMeta.setLore(meat_lore);
                CursedBone.setItemMeta(MeatMeta);

                deathEvent.getDrops().add(1,CursedBone);

            }
            else if(deathEvent.getEntity().getCustomName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Meteor Creeper")){

                deathEvent.getDrops().clear();
                deathEvent.setDroppedExp(45);
                deathEvent.getDrops().add(new ItemStack(Material.DIAMOND, 1));
                deathEvent.getDrops().add(new ItemStack(Material.IRON_INGOT,1));

                ItemStack CursedPowder = new ItemStack(Material.GUNPOWDER);
                ItemMeta MeatMeta = CursedPowder.getItemMeta();
                MeatMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Kül Tozu");
                MeatMeta.addEnchant(Enchantment.BINDING_CURSE, 10, true);
                ArrayList<String> meat_lore = new ArrayList<>();
                meat_lore.add("Var olmaması gereken bir şeyin külleri");
                MeatMeta.setLore(meat_lore);
                CursedPowder.setItemMeta(MeatMeta);

                deathEvent.getDrops().add(1,CursedPowder);

            }
            else if(deathEvent.getEntity().getCustomName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "İskelet Süvari")){

                deathEvent.getDrops().clear();
                deathEvent.setDroppedExp(70);
                deathEvent.getDrops().add(new ItemStack(Material.DIAMOND, 1));
                deathEvent.getDrops().add(new ItemStack(Material.IRON_INGOT,1));

                ItemStack CursedShard = new ItemStack(Material.PRISMARINE_SHARD);
                ItemMeta MeatMeta = CursedShard.getItemMeta();
                MeatMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Ölüler Diyarı Parçası");
                MeatMeta.addEnchant(Enchantment.BINDING_CURSE, 10, true);
                ArrayList<String> meat_lore = new ArrayList<>();
                meat_lore.add("Yasaklı yerlerden gelmiş bir parça");
                MeatMeta.setLore(meat_lore);
                CursedShard.setItemMeta(MeatMeta);

                deathEvent.getDrops().add(1,CursedShard);



            }
            else if(deathEvent.getEntity().getCustomName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Sürü")){

            }
            else if(deathEvent.getEntity().getCustomName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Karanlık getiren")){

            }


        }


    }


    // Once Night falls, several passive mobs become aggressive
    @EventHandler
    public void EntitiesBehavior(EntityTargetLivingEntityEvent event) {

        EntityType type = event.getEntityType();
        Entity entity = event.getEntity();

        World world = Bukkit.getServer().getWorld("World");
        if (world.getTime() > 12000 && world.getTime() < 24000) {
            if (type == EntityType.COW || type == EntityType.PIG || type == EntityType.SHEEP || type == EntityType.HORSE) {

                event.setTarget((Player) entity);

            }
        }


    }

    //Cursed Tamed
    @EventHandler
    public void TamedEntity(EntityTameEvent event) {


        Location location = event.getEntity().getLocation();
        Bukkit.getServer().getWorld("World").spawnParticle(Particle.CRIMSON_SPORE, location, 120);
        Bukkit.getServer().getWorld("World").strikeLightning(location);
        // causes Lightning strike owner's pet


    }

    @EventHandler
    public void BlindByEgg(PlayerEggThrowEvent eggs) {


        Location hitLoc = eggs.getEgg().getLocation();


    }

    @EventHandler
    public void CursedDamage(EntityDamageByEntityEvent event) {

        if (event.getDamager().getCustomName() == null) {
            return;
        }


    }
    @EventHandler
    public void onEntityMove(PlayerMoveEvent event){

            if(event.getPlayer() instanceof Zombie ){

                Zombie entity = (Zombie) event.getPlayer();

            }

    }

}
