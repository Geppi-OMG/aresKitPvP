package main.incrementing.pw.listeners;

import api.incrementing.pw.Player;
import main.incrementing.pw.KitPvP;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

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
public class PlayerJoinEventHandler implements Listener {

    @EventHandler
    public static void onJoin(PlayerJoinEvent e) {
        Player p = Player.initPlayer(e.getPlayer().getUniqueId());
        org.bukkit.entity.Player pl = p.bukkit();

        Location spawn = KitPvP.getInstance().getSpawn();
        if (spawn.getX() == 0 && spawn.getY() == 0 && spawn.getZ() == 0) {
            pl.teleport(Bukkit.getWorld("world").getSpawnLocation());
            pl.sendMessage("§4§l* §cWARN: No spawn point set... teleported to default location!");
        }
        else {
            pl.teleport(spawn);
        }

        pl.getInventory().clear();
        pl.getInventory().setArmorContents(null);
        for (PotionEffect potion : pl.getActivePotionEffects()) {
            pl.removePotionEffect(potion.getType());
        }
        pl.setMaxHealth(20D);
        pl.setHealth(pl.getMaxHealth());
        pl.setFoodLevel(20);
        pl.setSaturation(20L);
        pl.setExp(0);
        pl.setLevel(0);

        ItemStack menu = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta menuM = menu.getItemMeta();



    }
}
