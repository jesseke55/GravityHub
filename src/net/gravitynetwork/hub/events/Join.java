package net.gravitynetwork.hub.events;

import net.gravitynetwork.hub.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class Join implements Listener {

    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        final FileConfiguration config = Main.getPlugin().getConfig();

        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Events.Join.MSG").replace("%p", p.getName())));
        if (p.hasPermission(config.getString("Events.Join.Donorfly.Permission")))
        {
            p.setAllowFlight(true);
            p.setFlying(true);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Events.Join.Donorfly.MSG")));
        }
    }
}
