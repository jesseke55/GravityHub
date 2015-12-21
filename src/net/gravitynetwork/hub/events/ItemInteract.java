package net.gravitynetwork.hub.events;

import net.gravitynetwork.hub.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class ItemInteract implements Listener {

    @EventHandler
    public void interactEvent(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();
        FileConfiguration config = Main.getPlugin().getConfig();
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getItem() != null))
        {
            ItemStack i = e.getItem();
            if (i.getType() == Material.COMPASS) {
                p.performCommand("gravityservers:server");
            }
            if (i.getType() == Material.REDSTONE) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Items.Join.Website.MSG")));
            }
            if (i.getType() == Material.EMERALD) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Items.Join.Store.MSG")));
            }
        }
    }
}
