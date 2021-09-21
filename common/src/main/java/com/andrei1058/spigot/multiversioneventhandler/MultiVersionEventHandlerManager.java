package com.andrei1058.spigot.multiversioneventhandler;

import org.bukkit.Bukkit;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public interface MultiVersionEventHandlerManager {

    /**
     * Register a wrapped event.
     *
     * @param plugin       your plugin instance.
     * @param wrappedEvent events from this library.
     *
     */
    void register(Plugin plugin, WrappedEvent wrappedEvent, EventPriority priority);

    /**
     * Initialize multi version library.
     *
     * @return manager instance or null if your server version is not supported.
     */
    default MultiVersionEventHandlerManager init() {
        String version = Bukkit.getServer().getClass().getName().split("\\.")[3];
        Class<?> c;
        try {
            c = Class.forName("com.andrei1058.spigot.multiversioneventhandler.Manager_" + version);
        } catch (ClassNotFoundException e) {
            //I can't run on your version
            return null;
        }
        try {
            Constructor<?> constructor = c.getConstructor();
            return (MultiVersionEventHandlerManager) constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            return null;
        }
    }
}
