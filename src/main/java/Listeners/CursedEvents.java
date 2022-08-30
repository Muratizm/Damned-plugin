package Listeners;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.world.WorldEvent;

public class CursedEvents implements Listener {


    @EventHandler
    public void onShearedSheep(PlayerShearEntityEvent e) {

        Entity entity = e.getEntity();
        if (entity.getType().equals(EntityType.SHEEP)) {


            entity.setFireTicks(10000);
            entity.playEffect(EntityEffect.WOLF_SMOKE);


        }


    }

    @EventHandler
    public void Necromancer(EntityDeathEvent deathEvent, WorldEvent event) {


        if (deathEvent.getEntity().isDead()) {

            Location location = deathEvent.getEntity().getLocation();


        }
        Location location = deathEvent.getEntity().getLocation();

        event.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, location, 10);
        event.getWorld().createExplosion(location, 7F);


    }


    @EventHandler
    public void BrokenBlock(BlockBreakEvent breakEvent, Player player) {

        Block block = breakEvent.getBlock();


    }


}
