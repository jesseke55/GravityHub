package net.gravitynetwork.hub.events;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class MoveForJumppads implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (e.getTo().getBlock().getRelative(BlockFace.SELF).getType() == Material.IRON_PLATE)
        {
            e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(7));
            e.getPlayer().setVelocity(new Vector(e.getPlayer().getVelocity().getX(), 1.0D, e.getPlayer().getVelocity().getZ()));
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.FIRE_IGNITE, 1.0F, 1.0F);
            return;
        }
        if (e.getTo().getBlock().getRelative(BlockFace.SELF).getType() == Material.WOOD_PLATE)
        {
            e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(7));
            e.getPlayer().setVelocity(new Vector(e.getPlayer().getVelocity().getX(), 1.0D, e.getPlayer().getVelocity().getZ()));
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.FIRE_IGNITE, 1.0F, 1.0F);
            return;
        }
        if (e.getTo().getBlock().getRelative(BlockFace.SELF).getType() == Material.GOLD_PLATE)
        {
            e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(7));
            e.getPlayer().setVelocity(new Vector(e.getPlayer().getVelocity().getX(), 1.0D, e.getPlayer().getVelocity().getZ()));
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.FIRE_IGNITE, 1.0F, 1.0F);
            return;
        }
        if (e.getTo().getBlock().getRelative(BlockFace.SELF).getType() == Material.STONE_PLATE)
        {
            e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(7));
            e.getPlayer().setVelocity(new Vector(e.getPlayer().getVelocity().getX(), 1.0D, e.getPlayer().getVelocity().getZ()));
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.FIRE_IGNITE, 1.0F, 1.0F);
            return;
        }
    }
}
