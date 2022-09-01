package Listeners;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTameEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.player.*;

import java.util.ArrayList;
import java.util.Random;


public class CursedEvents implements Listener {



    private ArrayList<Entity> alreadyRespawned = new ArrayList<>();

    //Cursed Sheeps
    @EventHandler
    public void onShearedSheep(PlayerShearEntityEvent e) {

        Entity entity = e.getEntity();
        if (entity.getType().equals(EntityType.SHEEP)) {

            entity.setFireTicks(10000);
            Bukkit.getServer().getWorld("World").spawnParticle(Particle.DRAGON_BREATH,e.getEntity().getLocation(),210);
            entity.playEffect(EntityEffect.WOLF_SMOKE);


        }


    }


    //Cursed DEATH give an undead entities second chance
    @EventHandler
    public void Necromancer(EntityDeathEvent deathEvent) {

        // When an undead dies, it backs to life once
        Random random = new Random();

        int a = random.nextInt(3);
        EntityType type = deathEvent.getEntityType();

        if (deathEvent.getEntity().isDead() && a == 3 && type == EntityType.ZOMBIE || type == EntityType.SKELETON) {

            alreadyRespawned.add(deathEvent.getEntity());


            Location location = deathEvent.getEntity().getLocation();

            if (type == EntityType.ZOMBIE) {
                Bukkit.getServer().getWorld("World").spawnEntity(location, EntityType.ZOMBIE);

            } else {
                Bukkit.getServer().getWorld("World").spawnEntity(location, EntityType.SKELETON);

            }
        }


    }


    // Once Night falls, some passive mobs become aggressive
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

    //Cursed Tame
    @EventHandler
    public void TamedEntity(EntityTameEvent event) {


        Location location = event.getEntity().getLocation();
        Bukkit.getServer().getWorld("World").spawnParticle(Particle.CRIMSON_SPORE,location,120);
        Bukkit.getServer().getWorld("World").strikeLightning(location);
        // causes Lightning strike pet's owner


    }

    @EventHandler
    public void BlindByEgg(PlayerEggThrowEvent eggs) {


        Location hitLoc = eggs.getEgg().getLocation();


    }


}
