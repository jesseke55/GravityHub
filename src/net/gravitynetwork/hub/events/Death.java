package net.gravitynetwork.hub.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class Death implements Listener {


    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        e.setKeepInventory(true);
        e.getDrops().clear();
        e.setDeathMessage(null);
        e.getEntity().spigot().respawn();
    }
}
