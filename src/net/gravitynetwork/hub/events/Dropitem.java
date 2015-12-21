package net.gravitynetwork.hub.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class Dropitem implements Listener {


    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        if(!p.hasPermission("nobuild")){
            e.setCancelled(true);
        }
    }
}
