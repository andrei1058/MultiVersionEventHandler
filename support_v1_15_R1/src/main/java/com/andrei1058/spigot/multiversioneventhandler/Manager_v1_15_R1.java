package com.andrei1058.spigot.multiversioneventhandler;

import org.bukkit.Bukkit;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.Plugin;

@SuppressWarnings("unused")
public class Manager_v1_15_R1 implements MultiVersionEventHandlerManager {

    @Override
    public void register(Plugin plugin, WrappedEvent wrappedEvent, EventPriority priority) {
        if (wrappedEvent instanceof WrappedEntityPickUpEvent) {
            Bukkit.getPluginManager().registerEvents(new EntityPickUp_1_12n_Above((WrappedEntityPickUpEvent) wrappedEvent, priority, plugin), plugin);
        }
    }
}
