package net.foggies.trove.utils;

import org.bukkit.ChatColor;

public class StringUtils {

    public static String color(String input){
        return ChatColor.translateAlternateColorCodes('&', input);
    }

}
