package net.gravitynetwork.hub;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.gravitynetwork.hub.events.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright (c) 2015-2016, Jesse.
 */
public class Main extends JavaPlugin implements Listener {

    private static Plugin plugin;

    public static Plugin getPlugin()
    {
        return plugin;
    }

    public void onEnable(){
        plugin = this;

        initCONFIG();
        initEvents();
        initWDL();


    }
    public void onDisable(){
        plugin = null;
    }
    private void initEvents(){
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new Blockbreak(), this);
        pm.registerEvents(new Blockplace(), this);
        pm.registerEvents(new Death(), this);
        pm.registerEvents(new Dropitem(), this);
        pm.registerEvents(new Explosion(), this);
        pm.registerEvents(new FoodLevelChange(), this);
        pm.registerEvents(new ItemInteract(), this);
        pm.registerEvents(new ItemPickup(), this);
        pm.registerEvents(new Join(), this);
        pm.registerEvents(new MoveForJumppads(), this);
        pm.registerEvents(new MoveItemFromInv(), this);
        pm.registerEvents(new Respawn(), this);
        pm.registerEvents(new Sneak(), this);
        pm.registerEvents(new JoinItems(), this);
        pm.registerEvents(this , this);
    }

    private void initCONFIG(){
        getConfig().addDefault("Events.Explosion", "true");
        getConfig().addDefault("Events.FoodLevelChange", "true");
        getConfig().addDefault("Events.ItemPickup", "true");

        getConfig().addDefault("Jointp.World", "world");
        getConfig().addDefault("Jointp.X", "-1201");
        getConfig().addDefault("Jointp.Y", "15");
        getConfig().addDefault("Jointp.Z", "717");
        getConfig().addDefault("Jointp.Pitch", "5");
        getConfig().addDefault("Jointp.Yaw", "5");

        getConfig().addDefault("Items.Join.RightClick", "&7(Right-Click)");

        getConfig().addDefault("Items.Join.Selector.Name", "&aServer Selector ");
        getConfig().addDefault("Items.Join.Selector.Lore", "&8Network Selector\n \n&7Right click to see all available servers");

        getConfig().addDefault("Items.Join.Website.Name", "&aWebsite ");
        getConfig().addDefault("Items.Join.Website.Lore", "&ehttps://www.GravityNetwork.net");
        getConfig().addDefault("Items.Join.Website.MSG", "&a&lWEBSITE &ehttps://www.GravityNetwork.net");
        getConfig().addDefault("Items.Join.Store.Name", "&aStore ");
        getConfig().addDefault("Items.Join.Store.Lore", "&ehttp://store.GravityNetwork.net");
        getConfig().addDefault("Items.Join.Store.MSG", "&a&lSTORE &ehttp://store.GravityNetwork.net");

        getConfig().addDefault("Events.Join.Donorfly.Permission", "gravityhub.join.donorfly");
        getConfig().addDefault("Events.Join.Donorfly.MSG", "&aThanks for donating and if you join you will get fly automatticly.");
        getConfig().addDefault("noWorldDL", "Well guys i catched a eye on %p because this player has a World DL client wich has been officially blocked onto this server!");

        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    private void initWDL(){
        final FileConfiguration config = Main.getPlugin().getConfig();
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "WDL|CONTROL");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "WDL|INIT", (s, player, bytes) -> {
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeInt(1);
            out.writeBoolean(false);
            out.writeInt(1);
            out.writeBoolean(false);
            out.writeBoolean(false);
            out.writeBoolean(false);
            out.writeBoolean(false);
            getLogger().info("Blocking WorldDownloader for " + player.getDisplayName());
            Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&',config.getString("noWorldDL").replace("%p", player.getName()) ));
            player.sendPluginMessage(this, "WDL|CONTROL", out.toByteArray());
        });
    }
    
}
