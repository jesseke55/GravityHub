package net.gravitynetwork.hub.events;

import net.gravitynetwork.hub.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class Explosion implements Listener {


    @EventHandler
    public void onExplosion(EntityExplodeEvent e){
        final FileConfiguration config = Main.getPlugin().getConfig();
        e.setCancelled(config.getBoolean("Events.Explosion"));
    }
}
