package cn.ng;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
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
            if (Example.targets.get(p)!=null){
                return String.valueOf(plugin.getAngle(p, Example.targets.get(p)));
            }else {
                return String.valueOf(plugin.getAngle(p, plugin.getNearestPlayer(p)));
            }
        }
        if (params.startsWith("Angle_")){
            Player target= Bukkit.getPlayer(params.replace("Angle_",""));
            if (target!=null){
                return String.valueOf(plugin.getAngle(p, target));
            }
        }
        if(params.equalsIgnoreCase("Direction")) {
            if (Example.targets.get(p)!=null){
                return Example.getDirection(p, Example.targets.get(p));
            }else {
                return Example.getDirection(p, plugin.getNearestPlayer(p));
            }
        }
        if (params.startsWith("Direction_")){
            Player target= Bukkit.getPlayer(params.replace("Direction_",""));
            if (target!=null){
                return Example.getDirection(p, target);
            }
        }
        if(params.equalsIgnoreCase("ChineseDirection")) {
            if (Example.targets.get(p)!=null){
                return plugin.getChineseDirection(p, Example.targets.get(p));
            }else {
                return plugin.getChineseDirection(p, plugin.getNearestPlayer(p));
            }
        }
        if (params.startsWith("ChineseDirection_")){
            Player target= Bukkit.getPlayer(params.replace("ChineseDirection_",""));
            if (target!=null){
                return plugin.getChineseDirection(p, target);
            }
        }

        return null; // Placeholder is unknown by the Expansion
    }
}