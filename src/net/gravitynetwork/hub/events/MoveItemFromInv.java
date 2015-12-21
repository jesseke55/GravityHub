package net.gravitynetwork.hub.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class MoveItemFromInv implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent e){

        e.setCancelled(true);
    }
}
