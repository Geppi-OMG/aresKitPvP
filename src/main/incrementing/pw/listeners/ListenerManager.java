package main.incrementing.pw.listeners;

import main.incrementing.pw.KitPvP;
import org.bukkit.Bukkit;

/**
 * **************************************************************************************
 * Copyright Incrementing (c) 2014. All Right Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Incrementing. Distribution, taking snippets, or
 * claiming any contents as your own will break the terms of licence, and void any
 * agreements with you, the third party.
 * Regards Incrementing - @Incrementing - http://Incrementing.pw
 * ***************************************************************************************
 */
public class ListenerManager {

    public ListenerManager() {
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinEventHandler(), KitPvP.getInstance());
    }
}
