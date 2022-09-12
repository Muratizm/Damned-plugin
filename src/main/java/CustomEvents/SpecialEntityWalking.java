package CustomEvents;

import com.sun.source.tree.WhileLoopTree;
import me.muratcan.cursedplugin.CursedPlugin;
import org.bukkit.EntityEffect;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.scheduler.BukkitRunnable;

public class SpecialEntityWalking extends Event {

  private static final HandlerList handler = new HandlerList();
  private static CursedPlugin plugin;

 private Entity entity;

  public SpecialEntityWalking(Entity entity, CursedPlugin cursedPlugin){

      plugin = cursedPlugin;

      this.entity = entity;

      new BukkitRunnable() {
          @Override
          public void run() {

              entity.playEffect(EntityEffect.ENTITY_POOF);

          }
      }.runTaskTimer(plugin,1000L,1L);

  }



    @Override
    public HandlerList getHandlers() {
        return handler;
    }

    public static HandlerList getHandler(){

        return handler;
    }
    public Entity getEntity(){

      return entity;
    }

}
