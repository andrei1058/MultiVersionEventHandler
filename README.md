# MultiVersionEventHandler
One code, multi version support. If you are coding a plugin targeted for older and newer Minecraft versions you know how frustrating it is to write code for each NMS version on a maven based project. This library aims to bring new mc events to your source version, by this I mean if you are coding on bukkit API 1.8.8 you will be able to handle events like EntityPickUpEvent (of course it won't do anything on versions before it was really added, but will be registered for the right server versions).

# How to use
You can use the `support_shaded` containing support for all versions or a selected number of minecraft versions. If you are going for the second option you need to use and shade the `common` module as well in your maven.

Once you've done setting your dependencies start create your first wrapped listener implementing events in a class.

```java
import com.andrei1058.spigot.multiversioneventhandler.WrappedEntityPickUpEvent;

public class MyPickUpListener implements WrappedEntityPickUpEvent {
    
    @Override
    public boolean onEntityPickUpItemStack(Entity entity, Item item, int remaining){
        
        // true if you want to cancel the event
        return false;
    }
}
```

to register wrapped events we need to initialize this library first:

```java
public class MyPlugin extends JavaPlugin {
    
    private static MultiVersionEventHandlerManager eventManager;
    
    public void onEnable() {
        eventManager = MultiVersionEventHandlerManager.init();
        if (eventManager == null){
            //this server version is not supported
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }
}
```
and then we register our listener using the manager:
```java
public class MyPlugin extends JavaPlugin {

    private static MultiVersionEventHandlerManager eventManager;

    public void onEnable() {
        eventManager = MultiVersionEventHandlerManager.init();
        if (eventManager == null){
            //this server version is not supported
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        // register versioned listener
        eventManager.register(this, new MyPickUpListener(), EventPriority.NORMAL);
    }
}
```

# Supported versions
- 1.8 R3
- 1.9 R2
- 1.10 R1
- 1.11 R1
- 1.12 R1
- 1.13 R2
- 1.14 R1
- 1.15 R1
- 1.16 R3
- 1.17 R1