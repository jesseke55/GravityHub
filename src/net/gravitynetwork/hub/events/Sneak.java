package net.gravitynetwork.hub.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class Sneak implements Listener {

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e)
    {
        if (!e.getPlayer().hasPermission("gravity.hub.sneak"))
        {
            e.setCancelled(true);
            e.getPlayer().sendMessage("You can`t sneak because you are not a donator!");
        }
    }
}
