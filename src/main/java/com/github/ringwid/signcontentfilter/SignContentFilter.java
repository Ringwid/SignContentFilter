package com.github.ringwid.signcontentfilter;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * Project SignContentFilter
 */
public class SignContentFilter extends JavaPlugin {

    public static final String PREFIX = ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "SignContentFilter" + ChatColor.DARK_AQUA + "] " + ChatColor.RESET;

    private List<String> bannedWords;
    private String bannedMessage;

    @Override
    public void onEnable() {
        log("SignContentFilter Loading...");
        initConfig();
        getServer().getPluginManager().registerEvents(new Listener(this), this);
        log("SignContentFilter Loaded.");
    }

    private void initConfig() {
        saveDefaultConfig();

        bannedWords = getConfig().getStringList("bannedWords");
        bannedMessage = getConfig().getString("bannedMessage");
    }

    @Override
    public void onDisable() {
        log("SignContentFilter disabled.");
    }

    void log(String msg) {
        getServer().getConsoleSender().sendMessage(PREFIX + msg);
    }

    public String getBannedMessage() {
        return bannedMessage;
    }

    public List<String> getBannedWords() {
        return bannedWords;
    }

}
