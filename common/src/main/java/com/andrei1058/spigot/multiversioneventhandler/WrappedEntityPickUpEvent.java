package com.andrei1058.spigot.multiversioneventhandler;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;

public interface WrappedEntityPickUpEvent extends WrappedEvent {

    /** @return return true if you want to cancel the event. */
    boolean onEntityPickUpItemStack(Entity entity, Item item, int remaining);
}