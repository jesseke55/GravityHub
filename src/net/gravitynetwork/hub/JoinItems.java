package net.gravitynetwork.hub;

import net.gravitynetwork.hub.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.PlayerInventory;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class JoinItems implements Listener {



    public void giveItems(Player p){
        final FileConfiguration config = Main.getPlugin().getConfig();
        PlayerInventory pi = p.getInventory();

        p.teleport(new Location(Bukkit.getWorld(config.getString("Jointp.World")),
                config.getDouble("Jointp.X"),
                config.getDouble("Jointp.Y"),
                config.getDouble("Jointp.Z"),
                (float) config.getDouble("Jointp.Pitch"),
                (float) config.getDouble("Jointp.Yaw")
        ));

        pi.clear();


        pi.setItem(0, new ItemBuilder(Material.COMPASS)
                .name(ChatColor.translateAlternateColorCodes('&', config.getString("Items.Join.Selector.Name") + config.getString("Items.Join.RightClick")))
                .lore(new String[] {ChatColor.translateAlternateColorCodes('&', config.getString("Items.Join.Selector.Lore")) }).getStack());

        pi.setItem(6, new ItemBuilder(Material.REDSTONE)
                .name(ChatColor.translateAlternateColorCodes('&', config.getString("Items.Join.Website.Name") + config.getString("Items.Join.RightClick")))
                .lore(new String[] {ChatColor.translateAlternateColorCodes('&', config.getString("Items.Join.Website.Lore")) }).getStack());

        pi.setItem(7, new ItemBuilder(Material.EMERALD)
                .name(ChatColor.translateAlternateColorCodes('&', config.getString("Items.Join.Store.Name") + config.getString("Items.Join.RightClick")))
                .lore(new String[] {ChatColor.translateAlternateColorCodes('&', config.getString("Items.Join.Store.Lore")) }).getStack());
    }
}
