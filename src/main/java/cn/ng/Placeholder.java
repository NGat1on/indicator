package cn.ng;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class Placeholder extends PlaceholderExpansion {


    private final Example plugin;

    public Placeholder(Example plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getAuthor() {
        return "念国";
    }

    @Override
    public String getIdentifier() {
        return "ind";
    }

    @Override
    public String getVersion() {
        return plugin.version;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        String string = "NULL";
        if (player == null) {
            return string;
        }
        Player p = (Player) player;
        if(params.equalsIgnoreCase("PlayerAngle")) {
            return String.valueOf(plugin.getPlayerAngle(p));
        }
        if(params.equalsIgnoreCase("PlayerDirection")) {
            return plugin.getPlayerDirection(p);
        }
        if(params.equalsIgnoreCase("Angle")) {
            return String.valueOf(plugin.getAngle(p,plugin.getNearestPlayer(p)));
        }
        if(params.equalsIgnoreCase("Direction")) {
            return Example.getDirection(p,plugin.getNearestPlayer(p));
        }
        if(params.equalsIgnoreCase("ChineseDirection")) {
            return plugin.getChineseDirection(p,plugin.getNearestPlayer(p));
        }

        return null; // Placeholder is unknown by the Expansion
    }
}