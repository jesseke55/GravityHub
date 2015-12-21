package net.gravitynetwork.hub.events;

import net.gravitynetwork.hub.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class FoodLevelChange implements Listener {


    @EventHandler
    public void foodChange(FoodLevelChangeEvent e){

        final FileConfiguration config = Main.getPlugin().getConfig();
        e.setCancelled(config.getBoolean("Events.FoodLevelChange"));
    }
}
