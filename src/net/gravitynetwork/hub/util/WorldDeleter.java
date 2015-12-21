package net.gravitynetwork.hub.util;

import com.sun.istack.internal.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.io.File;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class WorldDeleter {

    private WorldDeleter() { }

    public static void deleteWorld(@NotNull World world) {
        File playerDataDir = new File(world.getWorldFolder(), "playerdata");
        File statsDir = new File(world.getWorldFolder(), "stats");

        if(playerDataDir.list().length > 0 || statsDir.list().length > 0) {
            for(String playerDataFilepath : playerDataDir.list()) {
                for(String statsFilepath : statsDir.list()) {
                    File playerData = new File(playerDataDir, playerDataFilepath);
                    playerData.delete();

                    File statsData = new File(statsDir, statsFilepath);
                    statsData.delete();
                }
            }
        }

        playerDataDir.delete();
        statsDir.delete();
    }

    public static void deleteAllWorlds() {
        Bukkit.getWorlds().forEach(WorldDeleter::deleteWorld);
    }
}
