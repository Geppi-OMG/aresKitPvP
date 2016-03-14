package main.incrementing.pw;

import main.incrementing.pw.listeners.ListenerManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * **************************************************************************************
 * Copyright Incrementing (c) 2014. All Right Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Incrementing. Distribution, taking snippets, or
 * claiming any contents as your own will break the terms of licence, and void any
 * agreements with you, the third party.
 * Regards Incrementing - @Incrementing - http://Incrementing.pw
 * test ~goppina
 * ***************************************************************************************
 */
public class KitPvP extends JavaPlugin {
    protected static KitPvP instance;
    protected ListenerManager lm;
    private Location spawn;

    public static KitPvP getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        lm = new ListenerManager();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public Location getSpawn() {
        return new Location(Bukkit.getWorld(getConfig().getString("spawn.world")), getConfig().getDouble("spawn.x"), getConfig().getDouble("spawn.y"), getConfig().getDouble("spawn.z"), (float) getConfig().getInt("spawn.yaw"), (float) getConfig().getInt("spawn.pitch"));
    }
}
