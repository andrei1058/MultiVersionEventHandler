package com.andrei1058.spigot.multiversioneventhandler;

import com.andrei1058.multiversioneventhandler.EntityPickUp_1_12n_Above;
import org.bukkit.Bukkit;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.Plugin;

@SuppressWarnings("unused")
public class Manager_v1_12_R1 implements MultiVersionEventHandlerManager {

    @Override
    public void register(Plugin plugin, WrappedEvent wrappedEvent, EventPriority priority) {
        if (wrappedEvent instanceof WrappedPickUpEvent) {
            Bukkit.getPluginManager().registerEvents(new EntityPickUp_1_12n_Above((WrappedPickUpEvent) wrappedEvent, priority, plugin), plugin);
        }
    }
}
