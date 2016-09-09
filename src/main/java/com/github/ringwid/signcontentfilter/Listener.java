package com.github.ringwid.signcontentfilter;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.SignChangeEvent;

/**
 * Project SignContentFilter
 */
public class Listener implements org.bukkit.event.Listener {

    private SignContentFilter plugin;

    public Listener(SignContentFilter signContentFilter) {
        this.plugin = signContentFilter;
    }

    @EventHandler
    public void onEdit(SignChangeEvent event) {
        if (event.getPlayer().hasPermission("signcontentfilter.pass")) {
            return;
        }
        for (String s : event.getLines()) {
            String trim = s.replaceAll(" ", "").toLowerCase();
            plugin.getBannedWords().stream().filter(s1 -> trim.contains(s1.toLowerCase())).forEach(s1 -> {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getBannedMessage()));
            });
        }
    }

}
