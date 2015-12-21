package net.gravitynetwork.hub.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class Blockplace implements Listener {


    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        if(!e.getPlayer().hasPermission("nobuild")){
            e.setCancelled(true);
        }
    }
}
