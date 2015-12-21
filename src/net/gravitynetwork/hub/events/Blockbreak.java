package net.gravitynetwork.hub.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class Blockbreak implements Listener {



    @EventHandler
    public void onBreak(BlockBreakEvent e){

        if(!e.getPlayer().hasPermission("nobuild")){
            e.setCancelled(true);
        }
    }
}
