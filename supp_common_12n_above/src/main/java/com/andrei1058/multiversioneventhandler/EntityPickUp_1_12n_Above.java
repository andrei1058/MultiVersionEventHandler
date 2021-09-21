package com.andrei1058.multiversioneventhandler;

import com.andrei1058.spigot.multiversioneventhandler.WrappedEntityPickUpEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class EntityPickUp_1_12n_Above implements Listener {

    protected WrappedEntityPickUpEvent wrappedEntityPickUpEvent;

    public EntityPickUp_1_12n_Above(WrappedEntityPickUpEvent wrappedPickUpEvent, EventPriority eventPriority, Plugin plugin) {
        this.wrappedEntityPickUpEvent = wrappedPickUpEvent;
        Listener event;
        switch (eventPriority) {
            case LOWEST:
                event = new EntityPickUpLowest();
                break;
            default:
                event = new EntityPickUpNormal();
                break;
            case HIGHEST:
                event = new EntityPickUpHighest();
                break;
            case MONITOR:
                event = new EntityPickUpMonitor();
                break;
            case LOW:
                event = new EntityPickUpLow();
                break;
            case HIGH:
                event = new EntityPickUpHigh();
                break;
        }
        Bukkit.getPluginManager().registerEvents(event, plugin);
    }

    class EntityPickUpLowest implements Listener {

        @EventHandler(priority = EventPriority.LOWEST)
        public void onEntityPickUp(EntityPickupItemEvent event) {
            handleEvent(event);
        }
    }

    class EntityPickUpNormal implements Listener {

        @EventHandler(priority = EventPriority.NORMAL)
        public void onEntityPickUp(EntityPickupItemEvent event) {
            handleEvent(event);
        }
    }

    class EntityPickUpHighest implements Listener {

        @EventHandler(priority = EventPriority.HIGHEST)
        public void onEntityPickUp(EntityPickupItemEvent event) {
            handleEvent(event);
        }
    }

    class EntityPickUpMonitor implements Listener {

        @EventHandler(priority = EventPriority.MONITOR)
        public void onEntityPickUp(EntityPickupItemEvent event) {
            handleEvent(event);
        }
    }

    class EntityPickUpLow implements Listener {

        @EventHandler(priority = EventPriority.LOW)
        public void onEntityPickUp(EntityPickupItemEvent event) {
            handleEvent(event);
        }
    }

    class EntityPickUpHigh implements Listener {

        @EventHandler(priority = EventPriority.HIGH)
        public void onEntityPickUp(EntityPickupItemEvent event) {
            handleEvent(event);
        }
    }

    private void handleEvent(@NotNull EntityPickupItemEvent event) {
        boolean cancel = EntityPickUp_1_12n_Above.this.wrappedEntityPickUpEvent.onEntityPickUpItemStack(event.getEntity(), event.getItem(), event.getRemaining());
        if (cancel) {
            event.setCancelled(true);
        }
    }
}
