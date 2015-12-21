package net.gravitynetwork.hub.events;

import net.gravitynetwork.hub.JoinItems;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class Respawn implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        Player p = e.getPlayer();
        p.sendMessage(ChatColor.AQUA + "test");
        new JoinItems().giveItems(p);
    }
}
